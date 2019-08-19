package controllers

import javax.inject.Inject
import org.pac4j.core.client.IndirectClient
import org.pac4j.core.credentials.Credentials
import org.pac4j.core.profile.{CommonProfile, ProfileManager}
import org.pac4j.play.PlayWebContext
import org.pac4j.play.scala.{Security, SecurityComponents}
import play.api.mvc.{RequestHeader, Session}

import scala.collection.JavaConverters._
import scala.compat.java8.OptionConverters._

class Application @Inject() (val controllerComponents: SecurityComponents) extends Security[CommonProfile] {
  private def getProfile(implicit request: RequestHeader): Option[CommonProfile] = {
    val webContext = new PlayWebContext(request, playSessionStore)
    val profileManager = new ProfileManager[CommonProfile](webContext)
    val profile = profileManager.get(true)
    profile.asScala
  }

  def index = Action { implicit request =>
    Ok(views.html.index(getProfile(request)))
  }

  def notSecret = Action { implicit request =>
    Ok(views.html.notsecret())
  }
  def secret = Secure("GitHubClient") { implicit request =>
    Ok(views.html.secret())
  }

  def login = Action { request =>
    val context: PlayWebContext = new PlayWebContext(request, playSessionStore)
    val client = config.getClients.findClient("GitHubClient").asInstanceOf[IndirectClient[Credentials,CommonProfile]]
    val location = client.getRedirectAction(context).getLocation
    val newSession = new Session(mapAsScalaMap(context.getJavaSession).toMap)
    Redirect(location).withSession(newSession)
  }
}


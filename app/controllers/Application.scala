package controllers

import javax.inject.Inject
import org.pac4j.core.client.IndirectClient
import org.pac4j.core.context.Pac4jConstants
import org.pac4j.core.credentials.Credentials
import org.pac4j.core.profile.{CommonProfile, ProfileManager}
import org.pac4j.play.PlayWebContext
import org.pac4j.play.scala.{Security, SecurityComponents}
import play.api.mvc.{RequestHeader, Session}

import scala.collection.JavaConverters._

class Application @Inject() (val controllerComponents: SecurityComponents) extends Security[CommonProfile] {
  private def getProfiles(implicit request: RequestHeader): List[CommonProfile] = {
    val webContext = new PlayWebContext(request, playSessionStore)
    val profileManager = new ProfileManager[CommonProfile](webContext)
    val profiles = profileManager.getAll(true)
    asScalaBuffer(profiles).toList
  }

  def index = Action { implicit request =>
    Ok(views.html.index(getProfiles(request)))
  }

  def login = Action { request =>
    val context: PlayWebContext = new PlayWebContext(request, playSessionStore)
    val client = config.getClients.findClient(context.getRequestParameter(Pac4jConstants.DEFAULT_CLIENT_NAME_PARAMETER)).asInstanceOf[IndirectClient[Credentials,CommonProfile]]
    val location = client.getRedirectAction(context).getLocation
    val newSession = new Session(mapAsScalaMap(context.getJavaSession).toMap)
    Redirect(location).withSession(newSession)
  }
}


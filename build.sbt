name := """scala-github-oauth-demo"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.7"

val playPac4jVersion = "8.0.0"
val pac4jVersion = "3.7.0"

libraryDependencies += guice
libraryDependencies += ehcache
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "org.pac4j" %% "play-pac4j" % playPac4jVersion
libraryDependencies += "org.pac4j" % "pac4j-oauth" % pac4jVersion

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

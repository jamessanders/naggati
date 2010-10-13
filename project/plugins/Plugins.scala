import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val twitterNest = "com.twitter" at "http://maven.twttr.com/"
  val defaultProject = "com.twitter" % "standard-project" % "0.7.10"
}

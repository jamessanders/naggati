import sbt._
import com.twitter.sbt._

class NaggatiProject(info: ProjectInfo) extends StandardProject(info) with SubversionPublisher {
  val specs     = buildScalaVersion match {
    case "2.7.7" => "org.scala-tools.testing" % "specs" % "1.6.2.1"
    case _ => "org.scala-tools.testing" %% "specs" % "1.6.5"
  }
  val xrayspecs = buildScalaVersion match {
    case "2.7.7" => "com.twitter" % "xrayspecs" % "1.0.7"
    case _ => "com.twitter" %% "xrayspecs" % "2.0"
  }
  val vscaladoc = "org.scala-tools" % "vscaladoc" % "1.1-md-3"

  val configgy  = buildScalaVersion match {
    case "2.7.7" => "net.lag" % "configgy" % "1.5.3"
    case _ => "net.lag" % "configgy" % "2.0.0"
  }
  val mina = "org.apache.mina" % "mina-core" % "2.0.0-M6"
  val slf4j_api = "org.slf4j" % "slf4j-api" % "1.5.2"
  val slf4j_jdk14 = "org.slf4j" % "slf4j-jdk14" % "1.5.2"

  val twitter_actors = "com.twitter" %% "twitteractors" % "2.0.0"

  override def pomExtra =
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>

  override def releaseBuild = true
  override def disableCrossPaths = false

  override def subversionRepository = Some("http://svn.local.twitter.com/maven-public/")
}

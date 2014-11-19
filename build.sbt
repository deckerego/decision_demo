name := """decision_demo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.drools" % "drools-core" % "6.1.0.Final",
  "org.drools" % "drools-compiler" % "6.1.0.Final"
)

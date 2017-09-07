import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "akkademy-db-scala",
    libraryDependencies ++= Seq(scalaTest % Test,
      "com.typesafe.akka" %% "akka-actor" % "2.3.3",
      "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
      "org.scalatest" %% "scalatest" % "2.1.6" % "test")
  )

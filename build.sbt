ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.battleship"


val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"


/*//TODO : rajouter tailRec
lazy val battleship = (project in file("."))
  .settings(
    name := "battleship",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"


  )*/
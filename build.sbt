name := "scala scalatest template"

version := "1.0-SNAPSHOT"

sbtVersion :="0.12.0"

scalaVersion := "2.10.2"

libraryDependencies += "io.undertow" % "undertow-core" % "1.0.0.Beta1"

mainClass in (Compile,run) := Some("rest.Rest")
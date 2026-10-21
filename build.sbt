ThisBuild / scalaVersion   := "3.10.0"
ThisBuild / organization   := "nmcb"
ThisBuild / version        := "0.0.1"
ThisBuild / fork           := true
ThisBuild / javaOptions    := Seq("-Xss1M")

ThisBuild / scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-feature",
  "-language:implicitConversions",
  "-language:existentials",
  "-language:strictEquality",
  "-unchecked",
  "-Werror",
  "-deprecation"
)

ThisBuild / Compile / run / javaOptions ++= Seq(
  "-Xmx4G",
  "-Xss1G",
  "-XX:+UseG1GC",
  "--sun-misc-unsafe-memory-access=allow",
  "--enable-native-access=ALL-UNNAMED"
)

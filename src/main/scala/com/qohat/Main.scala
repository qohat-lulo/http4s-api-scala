package com.qohat

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._

object Main extends IOApp {
  def run(args: List[String]) =
    Http4sapiServer.stream[IO].compile.drain.as(ExitCode.Success)
}
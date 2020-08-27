package com.qohat

import cats.effect.{ContextShift, ExitCode, IO, IOApp, Timer}
import org.http4s.server.blaze._

import scala.concurrent.ExecutionContext.Implicits.global


object MainApp extends IOApp {
  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  override implicit val timer: Timer[IO] = IO.timer(global)
  def run(args: List[String]) =
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(Main.helloWorldService)
      .resource
      .use(_ => IO.never)
      .as(ExitCode.Success)
}
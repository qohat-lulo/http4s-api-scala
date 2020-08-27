package com.qohat

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.implicits._

object Main {
  val helloWorldService = HttpRoutes.of[IO]{
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
  }.orNotFound
}

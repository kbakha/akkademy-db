package com.akkademy

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import org.scalatest.{FunSpecLike, Matchers}
import akka.pattern.ask

import scala.concurrent.Await
import scala.concurrent.duration._

class FuturePlaySpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)
  val pongActor = system.actorOf(Props(classOf[ScalaPongActor]))

  val future = pongActor ? "Ping"

  val result = Await.result(future.mapTo[String], 1 second)

  describe("FutureExamples") {
    import scala.concurrent.ExecutionContext.Implicits.global

    it("should print to console") {
      (pongActor ? "Ping").onSuccess({
        case x: String => println("replied with: " + x)
      })
      Thread.sleep(100)
    }
  }

}

package com.akkademy

import akka.actor.{ActorRef, ActorSystem}
import akka.testkit.{TestActor, TestActorRef}
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class StringKeeperSpec extends FunSpecLike with Matchers with BeforeAndAfterEach{
  implicit val actorSystem = ActorSystem()

  describe("given string"){
    it("should place given string to inner collections") {
      val actorRef = TestActorRef(new StringKeeper)
      val message = "formidable first string"
      val secondMessage = "second one"
      actorRef ! message
      actorRef ! secondMessage
      val akkademyDb = actorRef.underlyingActor
      akkademyDb.stringStack.pop should equal (secondMessage)
      akkademyDb.stringStack.pop should equal (message)

    }
  }

}

package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.{TestActor, TestActorRef}
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class StringKeeperSpec extends FunSpecLike with Matchers with BeforeAndAfterEach{
  implicit val actorSystem = ActorSystem

  describe("given string"){
    it("should place given string to inner collections") {
      val actorRef = TestActorRef(new StringKeeper)
      actorRef ! "formidable first string"
      val akkademyDb = actorRef.underlying
      akkademyDb.
    }
  }

}

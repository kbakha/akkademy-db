package com.akkademy

import akka.actor.{Actor, Status}

class ScalaPongActor extends Actor {

  override def receive: Receive = {
    case "Ping" => {
      Thread.sleep(995)
      sender() ! "Pong"
    }
    case _ => sender() ! Status.Failure(new Exception("unknown message"))
  }

}

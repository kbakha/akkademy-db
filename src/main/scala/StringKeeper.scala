package com.akkademy

import akka.actor.Actor
import akka.event.Logging

class StringKeeper extends Actor {
  var string = ""
  val log = Logging(context.system, this)

  override def receive = {
    case str: String => string = str
    case o => log.info("received unknown message")
  }

}

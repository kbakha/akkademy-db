package com.akkademy

import akka.actor.Actor
import akka.event.Logging

import scala.collection.mutable.Stack

class StringKeeper extends Actor {
  val stringStack = Stack[String]()
  val log = Logging(context.system, this)

  override def receive = {
    case str: String => {
      stringStack.push(str)
      sender() ! "come on"
      println(stringStack)
    }
    case o => log.info("received unknown message")
  }

}

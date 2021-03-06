/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.core.datagram

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.datagram.{PacketWritestream => JPacketWritestream}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream

/**
  * A [[WriteStream]] for sending packets to a [[SocketAddress]].
  * The stream  is called when the write fails.
  */
class PacketWritestream(private val _asJava: JPacketWritestream) 
    extends WriteStream[Buffer] {

  def asJava: JPacketWritestream = _asJava

  /**
    * Ends the stream.
    * 
    * Once the stream has ended, it cannot be used any more.
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Same as [[WriteStream#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    _asJava.end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[PacketWritestream#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): PacketWritestream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: Buffer): PacketWritestream = {
    _asJava.write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): PacketWritestream = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): PacketWritestream = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

}

object PacketWritestream {

  def apply(_asJava: JPacketWritestream): PacketWritestream =
    new PacketWritestream(_asJava)

}

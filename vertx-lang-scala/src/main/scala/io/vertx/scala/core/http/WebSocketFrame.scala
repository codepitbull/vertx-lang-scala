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

package io.vertx.scala.core.http

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer

/**
  * A WebSocket frame that represents either text or binary data.
  * 
  * A WebSocket message is composed of one or more WebSocket frames.
  * 
  * If there is a just a single frame in the message then a single text or binary frame should be created with final = true.
  * 
  * If there are more than one frames in the message, then the first frame should be a text or binary frame with
  * final = false, followed by one or more continuation frames. The last continuation frame should have final = true.
  */
class WebSocketFrame(private val _asJava: JWebSocketFrame) {

  def asJava: JWebSocketFrame = _asJava

  /**
    * @return true if it's a text frame
    */
  def isText(): Boolean = {
    _asJava.isText()
  }

  /**
    * @return true if it's a binary frame
    */
  def isBinary(): Boolean = {
    _asJava.isBinary()
  }

  /**
    * @return true if it's a continuation frame
    */
  def isContinuation(): Boolean = {
    _asJava.isContinuation()
  }

  /**
    * @return the content of this frame as a UTF-8 string and returns the converted string. Only use this for text frames.
    */
  def textData(): String = {
    if (cached_0 == null) {
      cached_0=    _asJava.textData()
    }
    cached_0
  }

  /**
    * @return the data of the frame
    */
  def binaryData(): Buffer = {
    if (cached_1 == null) {
      cached_1=    Buffer.apply(_asJava.binaryData())
    }
    cached_1
  }

  /**
    * @return true if this is the final frame.
    */
  def isFinal(): Boolean = {
    _asJava.isFinal()
  }

  private var cached_0: String = _
  private var cached_1: Buffer = _
}

object WebSocketFrame {

  def apply(_asJava: JWebSocketFrame): WebSocketFrame =
    new WebSocketFrame(_asJava)

  def binaryFrame(data: Buffer, isFinal: Boolean): WebSocketFrame = {
    WebSocketFrame.apply(io.vertx.core.http.WebSocketFrame.binaryFrame(data.asJava.asInstanceOf[JBuffer], isFinal))
  }

  def textFrame(str: String, isFinal: Boolean): WebSocketFrame = {
    WebSocketFrame.apply(io.vertx.core.http.WebSocketFrame.textFrame(str, isFinal))
  }

  def continuationFrame(data: Buffer, isFinal: Boolean): WebSocketFrame = {
    WebSocketFrame.apply(io.vertx.core.http.WebSocketFrame.continuationFrame(data.asJava.asInstanceOf[JBuffer], isFinal))
  }

}

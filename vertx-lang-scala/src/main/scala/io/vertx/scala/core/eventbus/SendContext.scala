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

package io.vertx.scala.core.eventbus

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.{Message => JMessage}

/**
  *
  * Encapsulates a message being sent from Vert.x. Used with event bus interceptors
  */
class SendContext[T](private val _asJava: JSendContext[T]) {

  def asJava: JSendContext[T] = _asJava

  /**
    * @return The message being sent
    */
  def message(): Message[T] = {
    Message.apply[T](_asJava.message())
  }

  /**
    * Call the next interceptor
    */
  def next(): Unit = {
    _asJava.next()
  }

  /**
    * @return true if the message is being sent (point to point) or False if the message is being published
    */
  def send(): Boolean = {
    _asJava.send()
  }

}

object SendContext {

  def apply[T](_asJava: JSendContext[T]): SendContext[T] =
    new SendContext(_asJava)

}

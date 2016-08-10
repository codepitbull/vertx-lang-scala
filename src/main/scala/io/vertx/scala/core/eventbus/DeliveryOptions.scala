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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Delivery options are used to configure message delivery.
  * 
  * Delivery options allow to configure delivery timeout and message codec name, and to provide any headers
  * that you wish to send with the message.
  */

class DeliveryOptions(val java: io.vertx.core.eventbus.DeliveryOptions) {
          def setCodecName(value:String) = {
          java.setCodecName(value)
          this
  }
            def getCodecName = {
    java.getCodecName()
  }
          def addHeader(key: String, value:String) = {
    java.addHeader(key, value)
    this
  }
                      def setSendTimeout(value:Long) = {
          java.setSendTimeout(value)
          this
  }
            def getSendTimeout = {
    java.getSendTimeout()
  }
  }
object DeliveryOptions {
  type DeliveryOptionsJava = io.vertx.core.eventbus.DeliveryOptions
  
  def apply(t: DeliveryOptionsJava) = {
    if(t != null)
      new DeliveryOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):DeliveryOptions = {
    if(json != null)
      new DeliveryOptions(new DeliveryOptionsJava(json))
    else
      null
  }
}
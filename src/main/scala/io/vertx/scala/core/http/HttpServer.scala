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
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.Handler

/**
  * An HTTP and WebSockets server.
  * 
  * You receive HTTP requests by providing a [[io.vertx.scala.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
  * will be called with the requests.
  * 
  * You receive WebSockets by providing a [[io.vertx.scala.core.http.HttpServer#websocketHandler]]. As WebSocket connections arrive on the server, the
  * WebSocket is passed to the handler.
  */
class HttpServer(private val _asJava: io.vertx.core.http.HttpServer) 
    extends io.vertx.scala.core.metrics.Measured {

/**
*isMetricsEnabled-0-false
*requestStream-0-false
*requestHandler-1-false
*connectionHandler-1-false
*websocketStream-0-false
*websocketHandler-1-false
*listen-0-false
*listen-2-false
*listen-3-true
*listen-1-false
*listen-2-true
*listen-1-false
*close-0-false
*close-1-false
*actualPort-0-false
*/
/**
*isMetricsEnabled
*requestStream
*requestHandler
*connectionHandler
*websocketStream
*websocketHandler
*listen
*listen
*listen
*close
*close
*actualPort
*/
  def asJava: io.vertx.core.http.HttpServer = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Return the request stream for the server. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to the stream .
    * @return the request stream
    */
  def requestStream(): io.vertx.scala.core.http.HttpServerRequestStream = {
    if(cached_0 == null) {
      cached_0=    HttpServerRequestStream.apply(_asJava.requestStream())
    }
    cached_0
  }

  /**
    * Set the request handler for the server to `requestHandler`. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to this handler.
    * @return a reference to this, so the API can be used fluently
    */
  def requestHandler(handler: io.vertx.scala.core.http.HttpServerRequest => Unit= null): io.vertx.scala.core.http.HttpServer = {
    _asJava.requestHandler(funcToMappedHandler(HttpServerRequest.apply)(handler))
    this
  }

  /**
    * Set a connection handler for the server.
    * @return a reference to this, so the API can be used fluently
    */
  def connectionHandler(handler: io.vertx.scala.core.http.HttpConnection => Unit= null): io.vertx.scala.core.http.HttpServer = {
    _asJava.connectionHandler(funcToMappedHandler(HttpConnection.apply)(handler))
    this
  }

  /**
    * Return the websocket stream for the server. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the stream .
    * @return the websocket stream
    */
  def websocketStream(): io.vertx.scala.core.http.ServerWebSocketStream = {
    if(cached_1 == null) {
      cached_1=    ServerWebSocketStream.apply(_asJava.websocketStream())
    }
    cached_1
  }

  /**
    * Set the websocket handler for the server to `wsHandler`. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the handler.
    * @return a reference to this, so the API can be used fluently
    */
  def websocketHandler(handler: io.vertx.scala.core.http.ServerWebSocket => Unit= null): io.vertx.scala.core.http.HttpServer = {
    _asJava.websocketHandler(funcToMappedHandler(ServerWebSocket.apply)(handler))
    this
  }

  /**
    * Tell the server to start listening. The server will listen on the port and host specified in the
    * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * 
    * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen()
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
    * listening (or has failed).
    * @param port the port to listen on
    * @param host the host to listen on
    * @param listenHandler the listen handler
    */
  def listen(port: Int, host: String)(implicit listenHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.http.HttpServer] => Unit= null): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen(port, host, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.http.HttpServer], io.vertx.core.AsyncResult [io.vertx.scala.core.http.HttpServer]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.http.HttpServer, io.vertx.scala.core.http.HttpServer](x,(x => if (x == null) null else HttpServer.apply(x))))(listenHandler))
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @param port the port to listen on
    * @param listenHandler the listen handler
    */
  def listen(port: Int)(implicit listenHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.http.HttpServer] => Unit= null): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen(port, funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.http.HttpServer], io.vertx.core.AsyncResult [io.vertx.scala.core.http.HttpServer]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.http.HttpServer, io.vertx.scala.core.http.HttpServer](x,(x => if (x == null) null else HttpServer.apply(x))))(listenHandler))
    this
  }

  /**
    * Close the server. Any open HTTP connections will be closed.
    * 
    * The close happens asynchronously and the server may not be closed until some time after the call has returned.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).
    * @param completionHandler the handler
    */
  def close(completionHandler: io.vertx.core.AsyncResult [Unit] => Unit= null): Unit = {
    _asJava.close(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Void], io.vertx.core.AsyncResult [Unit]](x => io.vertx.lang.scala.AsyncResult[java.lang.Void, Unit](x,(x => ())))(completionHandler))
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort(): Int = {
    _asJava.actualPort()
  }

  private var cached_0: io.vertx.scala.core.http.HttpServerRequestStream = _
  private var cached_1: io.vertx.scala.core.http.ServerWebSocketStream = _
}

object HttpServer {

  def apply(_asJava: io.vertx.core.http.HttpServer): io.vertx.scala.core.http.HttpServer =
    new io.vertx.scala.core.http.HttpServer(_asJava)

}

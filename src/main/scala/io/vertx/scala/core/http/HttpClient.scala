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
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.MultiMap
import io.vertx.core.http.WebsocketVersion
import io.vertx.core.Handler

/**
  * An asynchronous HTTP client.
  * 
  * It allows you to make requests to HTTP servers, and a single client can make requests to any server.
  * 
  * It also allows you to open WebSockets to servers.
  * 
  * The client can also pool HTTP connections.
  * 
  * For pooling to occur, keep-alive must be true on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is true).
  * In this case connections will be pooled and re-used if there are pending HTTP requests waiting to get a connection,
  * otherwise they will be closed.
  * 
  * This gives the benefits of keep alive when the client is loaded but means we don't keep connections hanging around
  * unnecessarily when there would be no benefits anyway.
  * 
  * The client also supports pipe-lining of requests. Pipe-lining means another request is sent on the same connection
  * before the response from the preceding one has returned. Pipe-lining is not appropriate for all requests.
  * 
  * To enable pipe-lining, it must be enabled on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is false).
  * 
  * When pipe-lining is enabled the connection will be automatically closed when all in-flight responses have returned
  * and there are no outstanding pending requests to write.
  * 
  * The client is designed to be reused between requests.
  */
class HttpClient(private val _asJava: io.vertx.core.http.HttpClient) 
    extends io.vertx.scala.core.metrics.Measured {

/**
*head-3-true
*websocket-5-true
*websocketStream-6-false
*options-4-true
*headNow-2-true
*postAbs-2-true
*delete-3-true
*request-4-true
*putAbs-1-false
*deleteAbs-2-true
*request-2-false
*websocketStream-3-false
*getAbs-2-true
*deleteAbs-1-false
*get-3-false
*put-1-false
*head-2-true
*options-3-true
*post-2-false
*isMetricsEnabled-0-false
*request-5-true
*delete-4-true
*requestAbs-3-true
*delete-2-true
*get-4-true
*delete-3-false
*websocket-6-true
*websocketStream-2-false
*head-1-false
*websocket-3-true
*get-1-false
*put-2-true
*get-2-true
*optionsNow-2-true
*post-2-true
*request-3-true
*getNow-2-true
*request-3-false
*post-3-false
*optionsAbs-1-false
*head-4-true
*options-3-false
*options-1-false
*websocket-2-true
*websocketStream-1-false
*post-4-true
*websocket-8-true
*optionsNow-4-true
*put-3-true
*post-1-false
*postAbs-1-false
*put-2-false
*head-2-false
*delete-2-false
*headNow-4-true
*put-4-true
*requestAbs-2-false
*getNow-4-true
*optionsNow-3-true
*websocketStream-5-false
*head-3-false
*getAbs-1-false
*getNow-3-true
*put-3-false
*headNow-3-true
*delete-1-false
*options-2-false
*close-0-false
*request-4-false
*post-3-true
*putAbs-2-true
*headAbs-2-true
*get-2-false
*options-2-true
*websocket-4-true
*headAbs-1-false
*optionsAbs-2-true
*get-3-true
*websocketStream-4-false
*websocket-7-true
*/
  def asJava: io.vertx.core.http.HttpClient = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port.
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, port, host, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port.
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, host, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestWithHandler(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestWithHandler(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port.
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestWithHandler(method: io.vertx.core.http.HttpMethod, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.requestAbs(method, absoluteURI))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestAbsWithHandler(method: io.vertx.core.http.HttpMethod, absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.requestAbs(method, absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(port, host, requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(host, requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.getAbs(absoluteURI))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getAbsWithHandler(absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.getAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Sends an HTTP GET request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNowWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.getNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP GET request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNowWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.getNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP GET request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNowWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.getNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(port, host, requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(host, requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.postAbs(absoluteURI))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postAbsWithHandler(absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.postAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(port, host, requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(host, requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.headAbs(absoluteURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headAbsWithHandler(absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.headAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Sends an HTTP HEAD request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNowWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.headNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP HEAD request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNowWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.headNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP HEAD request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNowWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.headNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(port, host, requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(host, requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.optionsAbs(absoluteURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsAbsWithHandler(absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.optionsAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Sends an HTTP OPTIONS request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNowWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.optionsNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP OPTIONS request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNowWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.optionsNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP OPTIONS request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNowWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.optionsNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(port, host, requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(host, requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.putAbs(absoluteURI))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putAbsWithHandler(absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.putAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(port, host, requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(host, requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteWithHandler(port: Int, host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteWithHandler(host: String, requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(requestURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteWithHandler(requestURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.deleteAbs(absoluteURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteAbsWithHandler(absoluteURI: String)( responseHandler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    HttpClientRequest.apply(_asJava.deleteAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the specified host,relative request UR, and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified host,relative request UR, and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String, headers: io.vertx.scala.core.MultiMap)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String, headers: io.vertx.scala.core.MultiMap)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocketWithHandler(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String)( wsConnect: io.vertx.scala.core.http.WebSocket => Unit)( failureHandler: Throwable => Unit): io.vertx.scala.core.http.HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int, host: String, requestURI: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap]))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap]))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int, host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String, headers: io.vertx.scala.core.MultiMap): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap]))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String, headers: io.vertx.scala.core.MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): io.vertx.scala.core.http.WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[io.vertx.core.MultiMap], version, subProtocols))
  }

  /**
    * Close the client. Closing will close down any pooled connections.
    * Clients should always be closed after use.
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object HttpClient {

  def apply(_asJava: io.vertx.core.http.HttpClient): io.vertx.scala.core.http.HttpClient =
    new io.vertx.scala.core.http.HttpClient(_asJava)

}

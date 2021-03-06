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
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream

/**
  * Represents an file upload from an HTML FORM.
  */
class HttpServerFileUpload(private val _asJava: JHttpServerFileUpload) 
    extends ReadStream[Buffer] {

  def asJava: JHttpServerFileUpload = _asJava

  def exceptionHandler(handler: Throwable => Unit): HttpServerFileUpload = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: Buffer => Unit): HttpServerFileUpload = {
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def endHandler(endHandler: () => Unit): HttpServerFileUpload = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  def pause(): HttpServerFileUpload = {
    _asJava.pause()
    this
  }

  def resume(): HttpServerFileUpload = {
    _asJava.resume()
    this
  }

  /**
    * Stream the content of this upload to the given file on storage.
    * @param filename the name of the file
    */
  def streamToFileSystem(filename: String): HttpServerFileUpload = {
    _asJava.streamToFileSystem(filename)
    this
  }

  /**
    * @return the filename which was used when upload the file.
    */
  def filename(): String = {
    _asJava.filename()
  }

  /**
    * @return the name of the attribute
    */
  def name(): String = {
    _asJava.name()
  }

  /**
    * @return the content type for the upload
    */
  def contentType(): String = {
    _asJava.contentType()
  }

  /**
    * @return the contentTransferEncoding for the upload
    */
  def contentTransferEncoding(): String = {
    _asJava.contentTransferEncoding()
  }

  /**
    * @return the charset for the upload
    */
  def charset(): String = {
    _asJava.charset()
  }

  /**
    * The size of the upload may not be available until it is all read.
    * Check [[HttpServerFileUpload#isSizeAvailable]] to determine this
    * @return the size of the upload (in bytes)
    */
  def size(): Long = {
    _asJava.size()
  }

  /**
    * @return true if the size of the upload can be retrieved via #size().
    */
  def isSizeAvailable(): Boolean = {
    _asJava.isSizeAvailable()
  }

}

object HttpServerFileUpload {

  def apply(_asJava: JHttpServerFileUpload): HttpServerFileUpload =
    new HttpServerFileUpload(_asJava)

}

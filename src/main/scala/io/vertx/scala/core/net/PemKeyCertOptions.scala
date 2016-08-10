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

package io.vertx.scala.core.net

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Key store options configuring a private key and its certificate based on
  * <i>Privacy-enhanced Electronic Email</i> (PEM) files.
  * 
  *
  * The key file must contain a <b>non encrypted</b> private key in <b>PKCS8</b> format wrapped in a PEM
  * block, for example:
  * 
  *
  * <pre>
  * -----BEGIN PRIVATE KEY-----
  * MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDV6zPk5WqLwS0a
  * ...
  * K5xBhtm1AhdnZjx5KfW3BecE
  * -----END PRIVATE KEY-----
  * </pre>
  *
  * The certificate file must contain an X.509 certificate wrapped in a PEM block, for example:
  * 
  *
  * <pre>
  * -----BEGIN CERTIFICATE-----
  * MIIDezCCAmOgAwIBAgIEZOI/3TANBgkqhkiG9w0BAQsFADBuMRAwDgYDVQQGEwdV
  * ...
  * +tmLSvYS39O2nqIzzAUfztkYnUlZmB0l/mKkVqbGJA==
  * -----END CERTIFICATE-----
  * </pre>
  *
  * The key and certificate can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyPath("/mykey.pem").setCertPath("/mycert.pem"));
  * </pre>
  *
  * Or directly provided as a buffer:
  *
  * <pre>
  * Buffer key = vertx.fileSystem().readFileSync("/mykey.pem");
  * Buffer cert = vertx.fileSystem().readFileSync("/mycert.pem");
  * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyValue(key).setCertValue(cert));
  * </pre>
  */

class PemKeyCertOptions(val java: io.vertx.core.net.PemKeyCertOptions) {
          def setCertPath(value:String) = {
          java.setCertPath(value)
          this
  }
            def getCertPath = {
    java.getCertPath()
  }
            def setCertValue(value:io.vertx.core.buffer.Buffer) = {
          java.setCertValue(value)
          this
  }
            def getCertValue = {
    java.getCertValue()
  }
            def setKeyPath(value:String) = {
          java.setKeyPath(value)
          this
  }
            def getKeyPath = {
    java.getKeyPath()
  }
            def setKeyValue(value:io.vertx.core.buffer.Buffer) = {
          java.setKeyValue(value)
          this
  }
            def getKeyValue = {
    java.getKeyValue()
  }
  }
object PemKeyCertOptions {
  type PemKeyCertOptionsJava = io.vertx.core.net.PemKeyCertOptions
  
  def apply(t: PemKeyCertOptionsJava) = {
    if(t != null)
      new PemKeyCertOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):PemKeyCertOptions = {
    if(json != null)
      new PemKeyCertOptions(new PemKeyCertOptionsJava(json))
    else
      null
  }
}
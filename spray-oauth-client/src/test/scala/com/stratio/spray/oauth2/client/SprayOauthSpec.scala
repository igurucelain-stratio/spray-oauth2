/**
 * Copyright (C) 2016 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.spray.oauth2.client

import akka.actor.ActorRefFactory
import akka.util.Timeout
import org.scalatest.{FlatSpec, Matchers}
import spray.http.StatusCodes._
import spray.testkit.ScalatestRouteTest

import scala.concurrent.duration._

class SprayOauthSpec extends FlatSpec with OauthClient with Matchers with ScalatestRouteTest {


  override implicit val actorRefFactory: ActorRefFactory = system


  implicit val timeout: Timeout = Timeout(30.seconds)

  implicit val _system = system


  "Login " should "return " in {
    Get("/login?code=asdfadsf") ~> login ~> check {
      status should be(Found)
    }
  }
  "Logout " should "return " in {
    Get("/logout") ~> logout ~> check {
      status should be(Found)
    }
  }
}

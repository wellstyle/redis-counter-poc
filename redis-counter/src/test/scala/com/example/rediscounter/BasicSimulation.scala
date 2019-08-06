package com.example.rediscounter

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

class BasicSimulation extends Simulation {

    val httpProtocol: HttpProtocolBuilder = http
        .baseUrl("http://localhost:8000")

    val scn: ScenarioBuilder = scenario("BasicSimulation")
        .exec(http("request_1")
            .get("/counter-api/counter")
        .check(bodyString.saveAs("responseBody")))

    setUp(
        scn.inject(atOnceUsers(600))
    ).protocols(httpProtocol)

}
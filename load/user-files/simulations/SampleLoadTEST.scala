
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SampleLoadTEST extends Simulation {

	val httpConf = http
    .baseURL("http://192.168.99.100:5000")

  val scn = scenario("SampleLoadTEST")
    .exec(http("Sample Load Test")
    .post("/"))
    .pause(2)

  setUp(
    scn.inject(atOnceUsers(100))
  ).protocols(httpConf).assertions(global.responseTime.max.lessThan(1000))

}

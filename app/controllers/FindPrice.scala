package controllers

import scala.collection.JavaConversions

import play.api._
import play.api.mvc._

import org.kie.api._;
import org.kie.api.runtime._;

class Price(var amount: Int)

case class Subscription(years: Int, level: Tier.Value)

object Tier extends Enumeration {
  type Tier = Value
  val GOLD, SILVER, BRONZE = Value
}

object FindPrice extends Controller {
  private lazy val container = KieServices.Factory.get().getKieClasspathContainer()

  def findPrice(years: Integer, level: Tier.Value): Integer = {
    var subscription = Subscription(years, level)

    val session = container.newKieSession("PricingPlanOneKS")
    session.insert(subscription)
    session.fireAllRules()

    val finalPrices = JavaConversions.iterableAsScalaIterable(session.getQueryResults("final price"))
    val finalPrice = finalPrices.head.get("finalPrice").asInstanceOf[Price]

    session.dispose()

    finalPrice.amount
  }

  import Tier._

  def index = Action {
    Ok(views.html.showPrice(findPrice(2, GOLD)))
  }

}

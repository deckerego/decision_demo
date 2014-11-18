package controllers

import play.api._
import play.api.mvc._

object FindPrice extends Controller {

  object Tier extends Enumeration {
    type Tier = Value
    val GOLD, SILVER, BRONZE = Value
  }

  case class Subscription(years: Int, level: Tier.Value)

  def findPrice(years: Int, level: Tier.Value): Integer = {
    val subscription = Subscription(years, level)

    subscription match {
      case Subscription(1, Tier.GOLD)   => 20;
      case Subscription(1, Tier.SILVER) => 18;
      case Subscription(1, _)           => 16;
      case Subscription(2, Tier.GOLD)   => 35;
      case Subscription(2, Tier.SILVER) => 30;
      case Subscription(2, _)           => 25;
      case Subscription(3, Tier.GOLD)   => 50;
      case Subscription(3, Tier.SILVER) => 40;
      case Subscription(3, _)           => 35;
    }
  }

  import Tier._

  def index = Action {
    Ok(views.html.showPrice(findPrice(2, GOLD)))
  }

}

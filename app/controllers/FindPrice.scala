package controllers

import play.api._
import play.api.mvc._

object FindPrice extends Controller {

  object Tier extends Enumeration {
    type Tier = Value
    val GOLD, SILVER, BRONZE = Value
  }

  def findPrice(years: Integer, level: Tier.Value): Integer = {
    if(years == 1)
      if(level == Tier.GOLD)   20
      else if(level == Tier.SILVER) 18
      else 16
    else if(years == 2)
      if(level == Tier.GOLD)   35
      else if(level == Tier.SILVER) 30
      else 25
    else
      if(level == Tier.GOLD)   50
      else if(level == Tier.SILVER) 40
      else 35
  }

  import Tier._

  def index = Action {
    Ok(views.html.showPrice(findPrice(2, GOLD)))
  }

}

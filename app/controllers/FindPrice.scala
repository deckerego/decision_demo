package controllers

import play.api._
import play.api.mvc._

object FindPrice extends Controller {

  object Tier extends Enumeration {
    val GOLD = 0
    val SILVER = 1
    val BRONZE = 2
  }

  def priceTable = Array(
    //    Gold, Silver, Bronze
    Array(20,   18,     16), //One Month
    Array(35,   30,     25), //One Year
    Array(50,   40,     35)  //Three Years
  )

  def index = Action {
    Ok(views.html.showPrice(priceTable(1)(Tier.GOLD)))
  }

}

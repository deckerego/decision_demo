package controllers

import play.api._
import play.api.mvc._

object DecisionTable extends Controller {

  object Tier extends Enumeration {
    val GOLD = 0
    val SILVER = 1
    val BRONZE = 2
  }

  def priceTable = Array(
    //    Gold, Silver, Bronze
    Array(20,   18,     16),   //One Month
    Array(200,  180,    160),  //One Year
    Array(500,  400,    300)   //Three Years
  )

  def index = Action {
    Ok(views.html.decisionTable(priceTable(0)(Tier.SILVER)))
  }

}

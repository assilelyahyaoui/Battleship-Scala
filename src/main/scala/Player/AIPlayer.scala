package Player
import Boats._
import Grid._

import scala.io.StdIn.readLine

/**
  * class representing one of the players, they have the following items
  * @param playerName the player's name
  * @param primaryGrid the grid where the player sets his boats
  * @param trackingGrid the grid where the player keeps track of his opponent's grid
  */


trait AIPlayer extends  Player{
  val hitList: List[(Int, Int)]
  def randomHit(): (Int,Int)
}
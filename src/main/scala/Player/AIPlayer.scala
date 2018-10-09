package Player
import Boats._
import Grid._

import scala.io.StdIn.readLine
import scala.util.Random

/**
  * The abstract ai trait
  */

trait AIPlayer extends  Player{

  val hitList: List[(Int, Int)]
  val randInt : Random
  /**
    * chooses a cell to hit
    * @return the coordinates that want to be hit
    */
  def chooseHit(): (Int,Int)
}
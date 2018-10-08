package Player
import Boats._
import Grid._

import scala.io.StdIn.readLine

/**
  * The abstract ai trait
  */

trait AIPlayer extends  Player{

  val hitList: List[(Int, Int)]

  /**
    * chooses a cell to hit
    * @return the coordinates that want to be hit
    */
  def chooseHit(): (Int,Int)
}
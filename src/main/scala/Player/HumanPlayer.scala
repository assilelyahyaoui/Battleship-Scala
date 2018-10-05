package Player
import Boats._
import Grid._

import scala.io.StdIn.readLine

/**
  * class representing on of the players, they have the following items
  * @param playerName the player's name
  * @param primaryGrid the grid where the player sets his boats
  * @param trackingGrid the grid where the player keeps track of his opponent's grid
  */


case class HumanPlayer(private val  _playerName : String, private val  _primaryGrid : Grid,
                       private val  _trackingGrid : Grid, private val _fleet : Fleet,
                       private val _isAlive : Int) extends  Player {

  def playerName: String = this._playerName

  def primaryGrid: Grid = this._primaryGrid

  def trackingGrid: Grid = this._trackingGrid

  def fleet: Fleet = this._fleet

  def isAlive: Int = this._isAlive

  def copyWithPlayerName(playerName : String) : Player = this.copy(_playerName = playerName )

  def copyWithPrimaryGrid(primaryGrid : Grid) : Player = this.copy(_primaryGrid= primaryGrid )

  def copyWithTrackingGrid(trackingGrid : Grid) : Player = this.copy(_trackingGrid = trackingGrid )

  def copyWithFleet(fleet: Fleet) : Player = this.copy(_fleet = fleet )

  /* Display functions */
  def cellNotInbound() = {
    println("the cell chosen is not in the grid , please try again")
  }
  def dirIncorrect() = {
    println("The direction chosen is inaccurate, please choose again  ")
  }


  override def chooseAndValidateX(): Int = {
    println("Enter the x coordinate (must be between 0 and 9 )")
    val x = readLine.trim.toInt
    if(x <0 | x>9){
      cellNotInbound()
      chooseAndValidateX()
    }
    else{
      return x
    }
  }

  override def chooseAndValidateY(): Int = {
    println("Enter the Y coordinate (must be between 0 and 9 )")
    val y = readLine.trim.toInt
    if(y <0 || y>9){
      cellNotInbound()
      chooseAndValidateY()
    }
    else{
      return y
    }
  }

  override def chooseDirection(): Int = {
    println("Enter the diretion of you boat ")
    var dir = readLine.trim.toInt
    if (dir ==1 || dir == 0 ){
      return dir
    }
    else {
      dirIncorrect()
      chooseDirection()
    }
  }

}

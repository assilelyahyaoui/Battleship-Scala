package Player
import Boats._
import Grid._

import scala.io.StdIn.readLine

/**
  * class representing one of the players, they have the following items
  * @param playerName the player's name
  * @param primaryGrid the grid where the player sets his boats
  * @param trackingGrid the grid where the player keeps track of his opponent's grid
  * @param _fleet the list of boats that the player has
  * @param _isAlive if the player is alive or not
  */
case class HumanPlayer(private val  _playerName : String, private val  _primaryGrid : Grid,
                       private val  _trackingGrid : Grid, private val _fleet : Fleet,
                       private val _isAlive : Int) extends  Player {


  override val playerName: String = _playerName
  override val primaryGrid: Grid = _primaryGrid
  override val trackingGrid: Grid = _trackingGrid
  override val fleet: Fleet = _fleet

  /**
    * constructor of this class, can create an instance with only the name of the player
    * @param playerName
    */
  def this(playerName : String){this(playerName,Grid(List[List[Cell]](), List[Cell]()) ,Grid(List[List[Cell]](), List[Cell]()) ,Fleet(List[Ship](), 5) , 1 )  }

  /**
    * returns if the player is alive aka has boats left
    * @return int 1 if alive, 0 if not
    */
  def isAlive: Int = this._isAlive

  /**
    * makes a copy of the instance changing its player name
    * @param playerName
    * @return a new player with the same parameters except for the name
    */
  def copyWithPlayerName(playerName: String): Player = this.copy(_playerName = playerName)
  /**
    * makes a copy of the instance changing its primary grid
    * @param playerName
    * @return a new player with the same parameters except for the primary grid
    */
  def copyWithPrimaryGrid(primaryGrid: Grid): Player = this.copy(_primaryGrid = primaryGrid)
  /**
    * makes a copy of the instance changing its tracking grid
    * @param playerName
    * @return a new player with the same parameters except for the tracking grid
    */
  def copyWithTrackingGrid(trackingGrid: Grid): Player = this.copy(_trackingGrid = trackingGrid)
  /**
    * makes a copy of the instance changing its  fleet
    * @param playerName
    * @return a new player with the same parameters except for the fleet
    */
  def copyWithFleet(fleet: Fleet): Player = this.copy(_fleet = fleet)




    /* Display functions */
  /**
    * displays that the cell is not inbound
    */
    def cellNotInbound() = {
      println("the cell chosen is not in the grid , please try again")
    }

  /**
    * display that the direction is inaccurate
    */
    def dirIncorrect() = {
      println("The direction chosen is inaccurate, please choose again  ")
    }

  /**
    * for the placement of the boats
    * makes the player chose the X coordinate, makes sure that it is inbound to the grid
    * @return an int representing the x coordinate
    *
    */
  override def chooseAndValidateX(): Int = {
      println("Enter the X coordinate (must be between 0 and 9 )")
      val x = readLine.trim.toInt
      if (x < 0 | x > 9) {
        cellNotInbound()
        println("cell Not in the grid" )
        chooseAndValidateX()
      }
      else {
        return x
      }
    }

  /**
    * for the placement of the boat
    *  makes the player chose the Y coordinate, makes sure that it is inbound to the grid
    * @return an int representing the y coordinate
    */
  override def chooseAndValidateY(): Int = {
      println("Enter the Y coordinate (must be between 0 and 9 )")
      val y = readLine.trim.toInt
      if (y < 0 || y > 9) {
        cellNotInbound()
        chooseAndValidateY()
      }
      else {
        return y
      }
    }
  /**
    * for the placement of the boats
    * makes the player chose the direction, makes sure it is either 0(horizontal ) or 1 (vertical)
    * @return an int representing the y coordinate
    */
  override def chooseDirection(): Int = {
      println("Enter the direction of you boat ")
      var dir = readLine.trim.toInt
      if (dir == 1 || dir == 0) {
        return dir
      }
      else {
        dirIncorrect()
        chooseDirection()
      }
    }


  /**
    * for the game loop
    * makes the player chose the X coordinate, makes sure that it is inbound tà the grid
    * @return an int representing the x coordinate
    *
    */
  override def chooseHitX(): Int=  {
    println("Enter the X Coordinate You Want To Hit (must be between 0 and 9 )")
    val x = readLine.trim.toInt
    if (x < 0 | x > 9) {
      cellNotInbound()
      println("Cell Not In The Grid" )
      chooseAndValidateX()
    }
    else {
      return x
    }
  }

  /**
    * for the game loop
    * makes the player chose the Y coordinate, makes sure that it is inbound to the grid
    * @return an int representing the y coordinate
    */
  override def chooseHitY(): Int= {
    println("Enter the Y Coordinate You Want To Hit (must be between 0 and 9 )")
    val y = readLine.trim.toInt
    if (y < 0 || y > 9) {
      cellNotInbound()
      chooseAndValidateY()
    }
    else {
      return y
    }
  }
  /**
    * invokes the chooseHitX and chooseHitY functions to create a tuple containing X and Y coordinates
    * @return an int representing the y coordinate
    */
  override def chooseHit() : (Int,Int)= {
    (chooseHitX(), chooseHitY())
  }

  /**
    * makes modifications after a attempt at hitting a cell, for this class, no changes are made
    * @param x the x coordinate
    * @param y the y coordinate
    * @param hit 0 if the cell is not hit , 1 otherwise
    * @return a player
    */
  override def changesAfterCellHit(x:Int , y:Int, hit :Int): Player = {this}
}

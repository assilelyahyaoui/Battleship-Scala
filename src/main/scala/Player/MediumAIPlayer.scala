
package Player
import Boats._
import Grid._
import HelpersAndConf._
import scala.util.Random
import scala.io.StdIn.readLine

/**
  * class representing one of the players, they have the following items
  * @param _playerName the player's name
  * @param _primaryGrid the grid where the player sets his boats
  * @param _trackingGrid the grid where the player keeps track of his opponent's grid
  * @param _fleet the list of boats that the player has
  * @param _isAlive if the player is alive or not
  * @param _hitList a list containing the tuples that need to be hit later on
  */
case class MediumAIPlayer(private val  _playerName : String, private val  _primaryGrid : Grid,
                       private val  _trackingGrid : Grid, private val _fleet : Fleet,
                       private val _isAlive : Int, private val _hitList : List[(Int, Int)] ) extends  AIPlayer {


  override val playerName: String = _playerName
  override val primaryGrid: Grid = _primaryGrid
  override val trackingGrid: Grid = _trackingGrid
  override val fleet: Fleet = _fleet
  override val hitList: List[(Int, Int)] = _hitList

  /**
    * constructor of this class, can create an instance with only the name of the player
    * @param playerName
    */
  def this(playerName : String){this(playerName,Grid(List[List[Cell]](), List[Cell]()) ,Grid(List[List[Cell]](), List[Cell]()) ,Fleet(List[Ship](), 5) , 1 , List[(Int, Int)]())  }
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
  def copyWithTrackingGrid(trackingGrid: Grid): Player = this.copy(_trackingGrid = trackingGrid) // add to hitList here, parcourila grid and add all instances
  /**
    * makes a copy of the instance changing its  fleet
    * @param playerName
    * @return a new player with the same parameters except for the fleet
    */
  def copyWithFleet(fleet: Fleet): Player = this.copy(_fleet = fleet)
  /**
    * makes a copy of the instance changing its hitList
    * @param playerName
    * @return a new player with the same parameters except for the hitList
    */
  def copyWithHitList(hitList: List[(Int, Int)]): Player = this.copy(_hitList = hitList )
  /**
    * invokes the random method to create a tuple containing X and Y coordinates, makes sure not to hit the same cell twice
    * @return an int representing the y coordinate
    */

  def chooseHit(): (Int,Int) = {
    //hitList = (0+ Random.nextInt(Config.gridXMax), 0+ Random.nextInt(Config.gridYMax))
    val x = 0+ Random.nextInt(Config.gridXMax)
    val y = 0+ Random.nextInt(Config.gridXMax)

    if (Grid.getCellState(trackingGrid,x, y) == 2 || Grid.getCellState(trackingGrid,x, y) == 3){
      chooseHit()
    }
    else{
      (x,y)
    }

  }
  /**
    * for the placement of the boats
    * makes the player chose the X coordinate, makes sure that it is inbound to the grid
    * @return an int representing the x coordinate
    *
    */
  override def chooseAndValidateX: Int = {
    0+ Random.nextInt(Config.gridXMax)
  }
  /**
    * for the placement of the boat
    *  makes the player chose the Y coordinate, makes sure that it is inbound to the grid
    * @return an int representing the y coordinate
    */
  override def chooseAndValidateY: Int = {
    0+ Random.nextInt(Config.gridYMax)
  }
  /**
    * for the placement of the boats
    * makes the player chose the direction, makes sure it is either 0(horizontal ) or 1 (vertical)
    * @return an int representing the y coordinate
    */
  override def chooseDirection: Int = Random.nextInt(2)
  /**
    * for the game loop
    * makes the player chose the X coordinate, by invoking the chooseHit function, makes sure that it is inbound to the grid
    * @return an int representing the x coordinate
    */
  override def chooseHitX: Int = {
    //val rh = randomHit(hitList.last._1, hitList.last._2)
    val rh = chooseHit()
    rh._1
  }
  /**
    * for the game loop
    * makes the player chose the Y coordinate, by invoking the chooseHit function, makes sure that it is inbound to the grid
    * @return an int representing the Y coordinate
    */
  override def chooseHitY: Int = {
   // val rh = randomHit(hitList.last._1, hitList.last._2)
   val rh = chooseHit()
    rh._1
  }
  /**
    * makes modifications after a attempt at hitting a cell, for this class, no changes are made
    * @param x the x coordinate
    * @param y the y coordinate
    * @param hit 0 if the cell is not hit , 1 otherwise
    * @return a player
    */
  override def changesAfterCellHit(x:Int , y:Int, hit : Int): Player = {this}


}


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

case class HighAIPlayer(private val  _playerName : String, private val  _primaryGrid : Grid,
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
    * if there is no hitlist :invokes the random method to create a tuple containing X and Y coordinates
    * if hitlist, runs through it
    * @return an int representing the y coordinate
    */
  def chooseHit(): (Int,Int) = {
    //hitList = (0+ Random.nextInt(Config.gridXMax), 0+ Random.nextInt(Config.gridYMax))
   if (hitList.isEmpty) {
     val x = 0 + Random.nextInt(Config.gridXMax)
     val y = 0 + Random.nextInt(Config.gridXMax)

     if (Grid.getCellState(trackingGrid, x, y) == 2 || Grid.getCellState(trackingGrid, x, y) == 3) {
       chooseHit()
     }
     else {
       copyWithHitList((x, y) :: hitList)
       (x, y)
     }
   }
   else {
      (hitList.tail.head._1, hitList.tail.head._2)

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
    * invokes moveandHit to find the surrounding cells on the 4 ways
    *
    * @param x the x coordinate of the cell
    * @param y the y coordinate of the cell
    * @return a list of tuple containing the cell shot at and the neighboring cells
    */
  def findSurroundingHitCells(x : Int, y:Int): List[(Int, Int)] ={
    //move right - down - left - up
    (x, y)::moveAndHit(x, y, 1) ::: moveAndHit(x, y, 2)::: moveAndHit(x, y, 3)::: moveAndHit(x, y, 4)

  }

  /**
    * gives the cells that are next the coordinates given in parameter
    * @param x the x coordinate of the cell
    * @param y the y coordinate of the cell
    * @param way the way of the neighboring cell we want. 1 : right - 2:down - 3:left - 4:up
    * @return a list of tuple containing the cell shot at and th neighboring cell
    */
  def moveAndHit(x : Int , y : Int , way : Int ): List[(Int, Int)] = {
    if (Cell.cellInbound(Cell(x, y, 0))) {

      if (Grid.getCellState(trackingGrid, x, y) != 2 && Grid.getCellState(trackingGrid, x, y) != 3) {
        way match {
          case 1 => {
            if (x + 1 < 10) {
              (x + 1, y) :: hitList
            }
            else List()

          }
          case 2 => {
            if (y + 1 < 10) {
              (x, y + 1):: hitList
            }
            else List()


          }
          case 3 => {
            if (x - 1 >= 0) {

              (x - 1, y):: hitList
            }
            else List()


          }
          case 4 => {
            if (x - 1 >= 0) {
              (x + 1, y - 1) :: hitList
            }
            else List()

          }
        } //waymatch
      }
      else List()
    }
    else List()
  }

  /**
    * makes modifications after a attempt at hitting a cell, if hit: find neighboring cell , else remove the first tuple of the hitList
    * @param x the x coordinate that was shot at
    * @param y the y coordinate that was shot at
    * @param hit 0 if the cell is not hit , 1 otherwise
    * @return a modified player, change the hitList
    */
  override def changesAfterCellHit(x:Int , y:Int, hit: Int): Player = {
    if (hitList.nonEmpty){
     // println(this.copyWithHitList( (findSurroundingHitCells(x,y)).tail))

      this.copyWithHitList( hitList.tail)

    }
   else {
    if(hit == 1){
      this.copyWithHitList((findSurroundingHitCells(x,y)).tail)

    }
      else{
      this
    }
   }

  }


}

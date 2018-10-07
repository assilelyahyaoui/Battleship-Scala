
package Player
import Boats._
import Grid._
import HelpersAndConf._
import scala.util.Random
import scala.io.StdIn.readLine

/**
  * class representing one of the players, they have the following items
  * @param playerName the player's name
  * @param primaryGrid the grid where the player sets his boats
  * @param trackingGrid the grid where the player keeps track of his opponent's grid
  */


case class LowAIPlayer(private val  _playerName : String, private val  _primaryGrid : Grid,
                       private val  _trackingGrid : Grid, private val _fleet : Fleet,
                       private val _isAlive : Int, private val _hitList : List[(Int, Int)] ) extends  AIPlayer {


  override val playerName: String = _playerName
  override val primaryGrid: Grid = _primaryGrid
  override val trackingGrid: Grid = _trackingGrid
  override val fleet: Fleet = _fleet
  override val hitList: List[(Int, Int)] = _hitList

  def this(playerName : String){this(playerName,Grid(List[List[Cell]](), List[Cell]()) ,Grid(List[List[Cell]](), List[Cell]()) ,Fleet(List[Ship](), 5) , 1 , List[(Int, Int)]())  }
  def isAlive: Int = this._isAlive

  def copyWithPlayerName(playerName: String): Player = this.copy(_playerName = playerName)

  def copyWithPrimaryGrid(primaryGrid: Grid): Player = this.copy(_primaryGrid = primaryGrid)

  def copyWithTrackingGrid(trackingGrid: Grid): Player = this.copy(_trackingGrid = trackingGrid) // add to hitList here, parcourila grid and add all instances

  def copyWithFleet(fleet: Fleet): Player = this.copy(_fleet = fleet)

  def copyWithHitList(hitList: List[(Int, Int)]): Player = this.copy(_hitList = hitList )


  def randomHit(): (Int,Int) = {
    //hitList = (0+ Random.nextInt(Config.gridXMax), 0+ Random.nextInt(Config.gridYMax))
    (0+ Random.nextInt(Config.gridXMax),0+ Random.nextInt(Config.gridYMax))
  }

  override def chooseAndValidateX: Int = {
    0+ Random.nextInt(Config.gridXMax)
  }

  override def chooseAndValidateY: Int = {
    0+ Random.nextInt(Config.gridYMax)
  }

  override def chooseDirection: Int = Random.nextInt(2)

  override def chooseHitX: Int = {
    val rh = randomHit()
    rh._1
  }

  override def chooseHitY: Int = {
    val rh = randomHit()
    rh._1
  }


}

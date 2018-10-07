package Player
import Boats._
import Grid._

/**
  * class representing on of the players, they have the following items
  * @param playerName the player's name
  * @param primaryGrid the grid where the player sets his boats
  * @param trackingGrid the grid where the player keeps track of his opponent's grid
  */
/**case class Player(private val  _playerName : String, private val  _primaryGrid : Grid, private val  _trackingGrid : Grid, private val _fleet : Fleet, private val _isAlive : Int){
  def playerName: String = this._playerName
  def primaryGrid : Grid = this._primaryGrid
  def trackingGrid: Grid = this._trackingGrid
  def fleet: Fleet = this._fleet
  def isAlive : Int = this._isAlive

  /**
    * the class cell's companion
    */

  object Player {

    def chooseAndValidateX(): Int ={

    }

  }


}*/

trait Player{
  val playerName : String
  val primaryGrid : Grid
  val trackingGrid : Grid
  val fleet : Fleet


  def copyWithPlayerName(playerName : String) : Player
  def copyWithPrimaryGrid(primaryGrid : Grid) : Player

  def copyWithTrackingGrid(trackingGrid : Grid) : Player

  def copyWithFleet(fleet: Fleet) : Player

  def chooseHit : (Int,Int)
  def chooseAndValidateX : Int
  def chooseAndValidateY : Int
  def chooseDirection : Int

  def chooseHitX : Int
  def chooseHitY : Int


}
package Boats
import Grid._
import scala.annotation.tailrec

/**
  *@param length Int the length of the boat
  *@param name String the name of the boat
  *@param firstCell Cell  the Coordinate of the first cell of the boat
  *@param numCellLeft Int  number of cells that haven't been hit
  *@param direction : Int 0, horizontal and 1 vertical
                *2 constructors : create boat by name or by cell size
 **
 @spec :
        *boat sank --> bool
        *can position ?
  */

case class Ship(private val _name : String, private val _boatCells : List[Cell], private val _length : Int,
                private val _direction : Int, private val _numCellLeft : Int ){

  def name: String = this._name
  def boatCells : List[Cell] = this._boatCells
  def length : Int = this._length
  def direction : Int = this._direction
  def numCellLeft : Int = this._numCellLeft
}

case class ShipType(private val _name : String, private val _length : Int ){

  def name: String = this._name
  def length : Int = this._length

}


object Ship {

  /**
    * checks if the boat can be placed on
    * @param boat the booat we want to position
    * @param cell the cell the boat wants to be positioned on
    * @return true if the boat can be placed on this cell or not, false otherwise
    */
  def canBePositioned(boat : Ship, cell : Cell): Boolean ={

    val cellState = cell.cellState
    val cellInGrid = Cell.cellInbound(cell)
    val boatDirection = boat.direction
    val boatLength = boat.length


    if(cellInGrid){
      cellState match {

        case 0 => {
          boatLength match {

            case 0 =>{
              return false
              }//boat length case 0

            case _ =>{
              val boat2 = boat.copy(_length = boat.length -1 )


              boatDirection match {

                case 0 =>{
                  //case horizontal
                  val cellIncrementedX = cell.copy(_cellXCoordinate = cell.cellXCoordinate +1)
                  return true && canBePositioned(boat2 , cellIncrementedX )

                } // boatDirection case 0

                case 1 =>{
                  //case vertical
                  val cellIncrementedY = cell.copy(_cellYCoordinate = cell.cellYCoordinate +1)
                  return true && canBePositioned(boat2 , cellIncrementedY )

                } // boatDirection case 1

                case _ => { return false}

              }// boatdirection
            }// boat length case _

          }//boatlength match

        } // case 0

        case 1 | 2 | _  =>{
          return false
        }// case 1 | 2

      }// match
    }// if cellInGrid
    else {return false}
  }


  /**
    * find the cells on which the boat is placed
    * have to be preceded by CanBePositioned of the Boat class
    *
    * @param boat boat that we want to put in the grid
    * @return a list containing all the cells on which the boat is placed.
    */

  def findBoatCells(boat : Ship): List[Cell] ={

    val boatDirection = boat.direction

    if (boat.numCellLeft == 0 ){ return Nil}
    else{
      if (boatDirection == 1 ){
        // finding next boat, aka boat remove
        val nextCell = Cell.nextYCell(boat.boatCells.head)
        val nextBoatNumCellLeft = boat.numCellLeft -1
        val nextBoat = boat.copy(_boatCells = List(nextCell), _numCellLeft = nextBoatNumCellLeft)
        boat.boatCells.head :: findBoatCells(nextBoat)
      }
      else {
        // case boatDirection == 0
        val nextCell = Cell.nextXCell(boat.boatCells.head)
        val nextBoatNumCellLeft = boat.numCellLeft -1
        val nextBoat = boat.copy(_boatCells = List(nextCell), _numCellLeft = nextBoatNumCellLeft)
        boat.boatCells.head :: findBoatCells(nextBoat)
      }

    }

  }

  /**
    * function that fills the list of cells of the boat
    * @param boat boat that has a list of cells constituted of 1 cell, the one entered by the player
    * @return a boat containing all its cells in boatCells
    */
  def fillBoatCellList(boat: Ship): Ship={
    boat.copy(_boatCells = findBoatCells(boat))
  }

  /**
    * Check if all the cells of the boat have been hit
    * @param boat
    * @return a boolean , true if hit, false otherwise
    */
  def boatSank(boat: Ship) : Boolean= {
    boat.numCellLeft == 0
  }


}
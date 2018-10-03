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

case class Boat (private val _name : String , private val _firstCell : Cell, private val _length : Int ,
                 private val _direction : Int, private val _numCellLeft : Int ){

  def name: String = this._name
  def firstCell : Cell = this._firstCell
  def length : Int = this._length
  def direction : Int = this._direction
  def numCellLeft : Int = this._numCellLeft
}


object Boat {

// create Boat

  def canBePositioned(boat : Boat, cell : Cell): Boolean ={

    val cellState = cell.cellState
    val cellInGrid = Cell.cellInbound(cell)
    val boatDirection = boat.direction
    val boatLength = boat.length


    if( cellInGrid){
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




}
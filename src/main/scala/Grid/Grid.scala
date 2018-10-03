package Grid

import Boats._

/**
  * class that represents the grid that the players are going to play on .
  *
  * @param _grid List[List[Cell] it is a double list
  *
  *              contains cells 10x10
  *              browseList
  *              create grid
  *              place boats on grids
  *              check if is in the grid
  *              check if no overlapping
  */
case class Grid (private val  _grid : List[List[Cell]] , private var _cellsFull : List[Cell] ){
  def grid: List[List[Cell]] = this._grid
  def cellsFull:List[Cell] = this._cellsFull

}

/**
  * the class grid's companion
  */

object Grid {
  /**
    * have to be preceeded by CanBePositioned of the Boat class
    * @param grid wich is a list of Cells
    * @param  , the boat that we want to put in the grid
    * @return
    */
 /* def addBoatToGrid(grid: Grid, boat : Boat): List[Cell] ={

      val boatDirection = boat.direction
     // val boatCoordx = boat.firstCell.cellCoordinates.x
     // val boatCoordy = boat.firstCell.cellCoordinates.copy( boat.firstCell.cellCoordinates.y + 1 )



    if (boat.numCellLeft == 0 ){ return Nil}
      /*else{
        if (boatDirection == 1 ){
          val cell =
          boat.firstCell :: addBoatToGrid(grid, boat)
        }

      }*/

  }*/

}

package Grid

/** Class representing a cell of the grid , has coordinates and a state
  * @param cellCoordinates : represent the positions on the x and y axes of the cell (x and y ). Is of type coordinates
  * @param state : represent the state of the cell O = empty ,  1 = there is a boat on it , 2 = has a boat that is hit
  * @spec
  *     - create cell
  *     - give cell state : empty , full , hit
  *     - change cell state
  *
  *  T
  */

case class Cell (private val  _cellXCoordinate : Int , private val  _cellYCoordinate : Int , _cellState : Int){
  def cellXCoordinate: Int = this._cellXCoordinate
  def cellYCoordinate: Int = this._cellYCoordinate
  def cellState : Int = this._cellState

}

case class CellType( _cellState : Int){
  def cellState : Int = this._cellState
}


/**
  * the class cell's companion
  */

object Cell {

  /**
    * checks if the cell's coordinates are in the given grid (10x10)
    * @param cell which want to see if it is in the grid
    * @return boolean true if inbound, false otherwise
    */
  def cellInbound(cell: Cell): Boolean = {
     cell.cellXCoordinate < 10 & cell.cellXCoordinate >= 0 & cell.cellYCoordinate < 10 & cell.cellYCoordinate >= 0
  }

  /**
    * gives the a cell with an incremented x coordinate
    * @param cell which we want the coordinate of the case next to it horizontally
    * @return the cell wanted
    */
  def nextXCell(cell : Cell): Cell = {
     cell.copy(_cellXCoordinate = cell.cellXCoordinate + 1 )
  }
  /**
    * gives the a cell with an incremented y coordinate
    * @param cell which we want the coordinate of the case next to it vertically
    * @return the cell wanted
    */
  def nextYCell(cell : Cell): Cell = {
    cell.copy(_cellYCoordinate = cell.cellYCoordinate + 1 )
  }

  /**
    * change the state of a given cell
    * @param cell the state of which we want to change the state
    * @param state the state we want it changed to
    * @return a cell with a state changed
    */
  def changeState(cell : Cell , state : Int): Cell = {
     cell.copy(_cellState = state )
  }

  /**
    * checks if the cell's state is empty
    * @param cell the cell of which we want to check the state
    * @return true if empty, false otherwise
    */
  def cellEmpty(cell: Cell): Boolean= {
      cell.cellState == 0
  }

  /**
    * checks if the cell's state is occupied
    * @param cell the cell of which we want to check the state
    * @return true if occupied, false otherwise
    */
  def cellOccupied(cell: Cell): Boolean= {
    cell.cellState == 1
  }

  /**
    * checks if the cell's state is hit
    * @param cell the cell of which we want to check te state
    * @return
    */
  def cellHit(cell:Cell): Boolean= {
    cell.cellState == 2
  }

}

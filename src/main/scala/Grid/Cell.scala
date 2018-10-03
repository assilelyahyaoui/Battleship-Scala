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
    return cell.cellXCoordinate < 10 & cell.cellXCoordinate > 0 & cell.cellYCoordinate < 10 & cell.cellYCoordinate > 0
  }

}

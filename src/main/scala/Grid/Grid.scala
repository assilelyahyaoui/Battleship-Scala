package Grid
import Boats._

/**
  * class that represents the grid that the players are going to play on .
  *
  * @param _gridLayout List[List[Cell] it is a double list
  * @param _cellsFull list of cells where a boat is positionned
  *
  *              contains cells 10x10
  *              browseList
  *              create grid
  *              place boats on grids
  *              check if is in the grid
  *              check if no overlapping
  */
case class Grid (private val  _gridLayout : List[List[Cell]] , private var _cellsOccup: List[Cell] ){
  def gridLayout: List[List[Cell]] = this._gridLayout
  def cellsOccup:List[Cell] = this._cellsOccup

}

/**
  * the class grid's companion
  */

object Grid {

  /**
    * returns the next cell horizontally
    * @param grid the grid containing all the cells needed
    * @param cell the cell given in parameters, we want the cell next to it
    * @return the cell next to the one given in parameters
    */
  def nextXGridCell(grid: List[List[Cell]] , cell: Cell): Option[Cell] ={

    Some((grid(cell.cellYCoordinate))(cell.cellXCoordinate +1))

  }

  /**
    * returns the next cell vertically
    * @param grid the grid containing all the cells needed
    * @param cell the cell given in parameters, we want the cell next to it
    * @return the cell next to the one given in parameters
    */
  def nextYGridCell(grid: List[List[Cell]] , cell: Cell): Option[Cell] ={

    Some((grid(cell.cellYCoordinate + 1))(cell.cellXCoordinate))

  }


  /**
    * returns a grid after adding the cells of a new boat to its cellsFull attribute
    * @param grid is the grid that need to be modified .
    * @param l2 represents the cells of the boat that need to be added to the cellsFullList
    * @return a list containing the concatenation of the two lists .
    */
  def addToCellsFull(grid: Grid, l2: List[Cell]): Grid = {
      grid.copy(_cellsOccup = grid.cellsOccup ++ l2)
  }

  /**
    * can show if a boat overlaps another one inside the grid
    * @param grid
    * @param boat the boat we want to add to the grid
    * @return boolean . true if overlaps, false otherwise
    */
  def boatOverlaps(grid: Grid , boat : Boat): Boolean ={
    boat.boatCells.map( cell => grid.cellsOccup.contains(cell) ).nonEmpty
  }

  /**
    * grid must be initialized & boat must fit
    * @param grid the grid we want to fill
    * @param boat the boat that need to be added on the grid
    * @return a grid containing the new boat
    */
  def placeBoatInGrid(grid : Grid, boat : Boat): Grid= {

    val newLayout = grid.gridLayout.map(list => list.map(cell => if(boat.boatCells.contains(cell)) Cell.changeState( cell , 1)
                                                                else cell))
    grid.copy(_gridLayout = newLayout)

  }

  def createEmptyGrid(rows : Int, cols : Int): Grid = {
      var cells = Array.ofDim[Cell](rows, cols)
      val cellMap = cells.map(cell => cell.map(c => ))
      val listCell = cellMap.toList
      val cellsOccup = List()

      val list : List[List[Cell]] = List.fill(10)(List.fill(10)())

    

      Grid(listCell, cellsOccup)
  }


}

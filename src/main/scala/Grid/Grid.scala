package Grid
import Boats._
//import HelpersAndConf._

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

    Option((grid(cell.cellYCoordinate)) (cell.cellXCoordinate + 1))

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
  def boatOverlaps(grid: Grid , boat : Ship): Boolean ={
    boat.boatCells.map( cell => grid.cellsOccup.contains(cell) ).nonEmpty
  }

  /**
    * grid must be initialized & boat must fit
    * @param grid the grid we want to fill
    * @param boat the boat that need to be added on the grid
    * @return a grid containing the new boat
    */
  def placeBoatInGrid(grid : Grid, boat : Ship): Grid= {

    val newLayout = grid.gridLayout.map(list => list.map(cell => if(boat.boatCells.contains(cell)) Cell.changeState( cell , 1)
                                                                else cell))
    grid.copy(_gridLayout = newLayout)

  }

  /**
    * creates a grid of cells usind the createColums method
    * when calling this method for the first time, row = 0
    * @param row is an index to see which row we are on
    * @return a grid containing cells
    */
  def createEmptyGrid(row: Int): List[List[Cell]] = {

    if (row<10){
      createColumns(row , 0 ) :: createEmptyGrid(row+1)
    }// if createGrid
    else{
      Nil
    }
  }//createGrid

  /**
    * creates the columns of the grid of cells
    * @param row the row of the grid we are on , the x param of the cell
    * @param col the column of the grid we are on, the y param of the cell, index to know where to stop.
    * @return a list of cells representing a row of the grid
    */

  def createColumns(row: Int , col : Int ): List[Cell] ={
    if (col < 10) {
      val cell = Cell(col, row, 0)
      cell :: createColumns(row, col+1)
    }
    else{
      Nil
    }
  }// create columns



  /**
    * changes a cell's state, the cell is in the grid
    * @param grid the grid that need to be changed
    * @param x the x coordinate targeted
    * @param y the y coordinate targeted
    * @param state the new state we want to pass to the cell
    * @return a new grid containing an updated cell
    */

  def changeGridCellState(grid: Grid, x: Int, y:Int, state:Int): Grid = {
    val cell = Cell(x, y , state)
    val gridlayout = grid.gridLayout.updated(y, grid.gridLayout(y).updated(x, cell))
    grid.copy(_gridLayout = gridlayout)
  }

  /**
    * gets the state of the cell
    * @param grid represent the grid on which the cell is situated
    * @param x the x coordinate of the cell
    * @param y the y coordinate of the cell
    * @return returns an int O = empty ,  1 = there is a boat on it , 2 = shot and hit(red) , 3 = shot and missed(white)
    */
  def getCellState(grid: Grid, x:Int, y:Int): Int ={
    grid.gridLayout(y)(x).cellState
  }

  /**
    * returns the cell wanted
    * @param grid represent the grid on which the cell is situated
    * @param x the x coordinate of the cell
    * @param y the y coordinate of the cell
    * @return an option of Cell . Some if the cell is in the grid, none otherwise
    */
  def fetchCell(grid: Grid, x:Int, y:Int): Option [Cell] ={
    Some(grid.gridLayout(y)(x))
  }


  /**
    * displays the grid on the console
    * @param grid the grid we want to display
    * @return a List of Strings
    */
  def displayGrid(grid: Grid)= {
    grid.gridLayout.map( line => {
      "|"+
      line.map(

        cell =>
            "|"+(cell.cellState match{
              case 0 => print("|"+ Console.BLUE_B+ Console.BLACK + " " + Console.RESET+"|")
              case 1 => print("|"+Console.YELLOW_B + Console.BLACK + " " + Console.RESET+"|")
              case 2 => print("|"+ Console.RED_B+ Console.BLACK + " " + Console.RESET+"|")
              case 3 => print("|"+Console.WHITE+ Console.BLACK + " " + Console.RESET+"|")

            })
      )
      println()})
  }

  /**
    * the numbers of cells containing a boat left
    * @param grid the grid we wznt to check out
    * @return an int containing the number of cells
    */
  def boatCellsLeft(grid: Grid): Int = {
    var num = 0 ;
    grid.gridLayout.map(line  => line.map( cell => if (cell.cellState == 1){num+=1}))
    num
  }

  /**
    * the numbers of cells containing a hit boat
    * @param grid the grid we wznt to check out
    * @return an int containing the number of cells
    */
  def boatCellsHit(grid: Grid): Int = {
    var num = 0 ;
    grid.gridLayout.map(line  => line.map( cell => if (cell.cellState == 2){num+=1}))
    num
  }

/*  def allCellsHit(grid: Grid): Seq[Cell] = {
    var liste = List[Cell];
    grid.gridLayout.map(line  => line.map( cell => if (cell.cellState == 2){ liste = cell:+liste }))

  }*/



}

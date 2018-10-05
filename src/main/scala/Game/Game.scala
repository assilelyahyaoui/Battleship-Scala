package Game

import Boats.{Ship, ShipType}

import scala.io.StdIn.readLine
import HelpersAndConf._
import Player._
import Grid._

case class GameState(
                      roundNumber: Int,
                      player1: Player,
                      player2: Player,


                    )

object BattleshipGame extends App {

  def chooseGameModePrompt() = {
    println("Player Mode : " + "\n" +
      " - Type HH for Human-Human interaction " + "\n" +
      " - Type AH for AI-Human interaction  " + "\n" +
      " - Type AA for AI-AI interaction ")

  }

  def chooseAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to define the level of your AI")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI  " + "\n" +
      " - Type 2 for medium level AI " + "\n" +
      " - Type 3 for high level AI ")

  }

  def chooseNamePrompt(num: Int) = {
    println("Choose your name player" + num)
  }

  def impossiblePlacement() = {
    println("It is impossible to place the boat here, please try again")
  }

  def cellNotInbound() = {
    println("the cell chosen is not in the grid , please try again")
  }

  //@tailrec
  def mainLoop(): Unit = {

    chooseGameModePrompt()
    val gameModeInput = readLine.trim.toUpperCase

    gameModeInput match {
      case "HH" => {

      } //case HH

      case "AH" => {

      } // case AH

      case "AA" => {

      } // case AA

      case _ => {

      } //case _
    } // gameModeInput match

    val grid = Grid(Grid.createEmptyGrid(0), List())
    placeFleet(grid, Config.ShipList , )
  }

  // boat creation

  /* val grid = Grid( Grid.createEmptyGrid(0), List())
   val cell = Cell(1,0,0)
   // the boat cell has to have the first cell
   val listcases = List(cell)
   val ship = Ship("b1",listcases, 3 , 0 , 3)
   val shipcells = Ship.findBoatCells(ship)
   val ship1 = ship.copy(_boatCells = shipcells)

   println(grid)
   println(shipcells)
   println("must say tt ")
   println(Ship.canBePositioned(grid, ship1, Option(cell)))
   // insert in grid
   val r = Grid.placeBoatInGrid(grid, ship1)
   println(r)
   println("lel" )



   // second boat creation

   // the cell has the coordinates given by the player
   val cell2 = r.gridLayout(0)(2)
   println("r")
   println(r.gridLayout(0)(1))
   println(Grid.getCellState(r, 1, 0))
   println(r)
   println("cell2")
   println(cell2)
   // initializing the list with the created cell , which will me in the boat
   val listcases2 = List(cell2)
   // creating the boat
   val ship2 = Ship("b2",listcases2, 4 , 1 , 4)
   // filling the cells of the boat
   val shipcells2 = Ship.findBoatCells(ship2)
   // putting the filled list in the boat
   val ship22 = ship2.copy(_boatCells = shipcells2)
   // check if the boat can be positioned in the grid

   println("must say f ")
   println(Ship.canBePositioned(r, ship22, Option(cell2)))

   // placing the boat on the grid aka changing the status of the grid
   println(Grid.placeBoatInGrid(r, ship22))


  // println(Grid.createEmptyGrid(0))
  */
  /**
    * places the ships of a player on a grid
    *
    * @param grid               the grid on which we want to place the boats
    * @param shipList           the predefined list of ships
    * @param chooseAndValidateX the x coordinate of the cell we want to place the boat on
    * @param chooseAndValidateY the y coordinate of the cell we xant to place the boat on
    * @param direction          1 for vertical, 0 for horizontal
    */
  def placeFleet(grid: Grid, shipList: List[ShipType], chooseAndValidateX: => Int, chooseAndValidateY: => Int, chooseDirection: => Int): Grid = {

    if (shipList.nonEmpty) {

      val currentShip = shipList.head
      // take the cell that the player want to hit from the grid
      if (Cell.cellInbound(Cell(chooseAndValidateX(), chooseAndValidateY(), 0))) {

        val cellToPlace = Grid.fetchCell(grid, chooseAndValidateX, chooseAndValidateY)

        // initializing the list with the created cell , which will be in the boat
        val listCells = List(cellToPlace.get)
        // create the boat
        val ship = Ship(currentShip.name, listCells, currentShip.length, chooseDirection(), currentShip.length)
        // fill the cells of the boats, here we only need the coordinates of the cells
        val shipCells = Ship.findBoatCells(ship)
        // putting the filled list in the boat
        val finalShip = ship.copy(_boatCells = shipCells)
        //check if it can be positioned

        if (Ship.canBePositioned(grid, finalShip, cellToPlace)) {
          val grid2 = Grid.placeBoatInGrid(grid, finalShip)
          // displayGrid
          placeFleet(grid2, shipList.tail, chooseAndValidateX(), chooseAndValidateY(), chooseDirection())

        }
        else {
          impossiblePlacement()
          placeFleet(grid, shipList, chooseAndValidateX(), chooseAndValidateY(), chooseDirection())
        }

      }
      else {
        // cellnotInbout
        cellNotInbound()
        placeFleet(grid, shipList, chooseAndValidateX(), chooseAndValidateY(), chooseDirection())
      }

    } // TODO check how to do it
    else {
      return grid
    }
  } //placeFleet



}
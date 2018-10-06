package Game

import Boats._

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

  def cellNotInboundPrompt() = {
    println("the cell chosen is not in the grid , please try again")
  }
  def cellisHitPrompt() = {
    println("You have hit you opponent !")
  }
  def cellisEmptyPrompt() = {
    println("This cell is empty ")
  }

  def cellPreviouslyHitPrompt() = {
    println("This cell was previously hit")
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


    val grid = Grid( Grid.createEmptyGrid(0), List())
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
    println(Grid.displayGrid(r))
    println("heya")
    //val player = new HumanPlayer("p1" , )
    //placeFleet(grid, Config.ShipList , )
  }
  mainLoop()
  // boat creation

  /*
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
    * @param fleet               putting all the added boat into a fleet to be able to save them
    * @param chooseAndValidateX the x coordinate of the cell we want to place the boat on
    * @param chooseAndValidateY the y coordinate of the cell we xant to place the boat on
    * @param direction          1 for vertical, 0 for horizontal
    */
  def placeFleet(grid: Grid, shipList: List[ShipType], fleet : Fleet ,chooseAndValidateX: => Int, chooseAndValidateY: => Int, chooseDirection: => Int): (Grid , Fleet)= {

    if (shipList.nonEmpty) {

      val currentShip = shipList.head
      // take the cell that the player want to hit from the grid
      if (Cell.cellInbound(Cell(chooseAndValidateX, chooseAndValidateY, 0))) {

        val cellToPlace = Grid.fetchCell(grid, chooseAndValidateX, chooseAndValidateY)

        // initializing the list with the created cell , which will be in the boat
        val listCells = List(cellToPlace.get)
        // create the boat
        val ship = Ship(currentShip.name, listCells, currentShip.length, chooseDirection, currentShip.length)
        // fill the cells of the boats, here we only need the coordinates of the cells
        val shipCells = Ship.findBoatCells(ship)
        // putting the filled list in the boat
        val finalShip = ship.copy(_boatCells = shipCells)
        //check if it can be positioned

        if (Ship.canBePositioned(grid, finalShip, cellToPlace)) {
          val grid2 = Grid.placeBoatInGrid(grid, finalShip)
          // adding boat to player fleet
          val finalBoatList = finalShip :: fleet.fleet
          val finalFleet = fleet.copy(finalBoatList , fleet.numberOfBoatsLeft +1)
          // displayGrid ToDo
          placeFleet(grid2, shipList.tail, finalFleet,chooseAndValidateX, chooseAndValidateY, chooseDirection)

        }
        else {
          impossiblePlacement()
          placeFleet(grid, shipList, fleet , chooseAndValidateX, chooseAndValidateY, chooseDirection)
        }

      }
      else {
        cellNotInboundPrompt()
        placeFleet(grid, shipList, fleet,chooseAndValidateX, chooseAndValidateY, chooseDirection)
      }

    }
    else {
      return (grid , fleet)
    }
  } //placeFleet



  /**
    * always the first player of the two passed in parameter hits
    * @param player1 the player that is going to hit
    * @param player2 that player that is going to be hit
    * @return
    */
  def hit(player1: Player, player2: Player): (Player , Player) = {
    // need to update the gamestate from the function above

    // player chooses the cell he wants to hit
    // check the state
    // returns the state
    // make modifications to the tracking grid and to the other player hit list
    // dont forget to sopy the grids to the players and to the game

    val x = player1.chooseAndValidateX
    val y = player1.chooseAndValidateY


    val state = Grid.getCellState(player2.primaryGrid, x, y)

    state match {
      case 0 => {
        // cell empty prompt
        cellisEmptyPrompt()
        // put on tracking grid of player one, white peg
        val newTrackingGrid = Grid.changeGridCellState(player1.trackingGrid, x, y, 3)
        // put on primary grid of player two , white peg
        val newPrimaryGrid = Grid.changeGridCellState(player2.primaryGrid, x, y, 3)

       // return the new players
        ( player1.copyWithTrackingGrid(newTrackingGrid), player2.copyWithPrimaryGrid(newPrimaryGrid) )

      }
      case 1 => {
        // cell is hit
        cellisHitPrompt()
        // put on tracking grid of player one, red peg
        val newTrackingGrid = Grid.changeGridCellState(player1.trackingGrid, x, y, 2)
        // put on primary grid of player two , red peg
        val newPrimaryGrid = Grid.changeGridCellState(player2.primaryGrid, x, y, 2)

        // return the new players
        ( player1.copyWithTrackingGrid(newTrackingGrid), player2.copyWithPrimaryGrid(newPrimaryGrid) )

      }
      case _ => {
        // cell previously hit
        cellPreviouslyHitPrompt()
        (player1, player2)
      }
    }

}

}
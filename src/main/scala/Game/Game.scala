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
      " - Type 1 for Human-Human interaction " + "\n" +
      " - Type 2 for AI-Human interaction  " + "\n" +
      " - Type 3 for AI-AI interaction ")

  }

  def chooseAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to define the level of your AI")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI  " + "\n" +
      " - Type 2 for medium level AI " + "\n" +
      " - Type 3 for high level AI ")

  }

  def chooseNamePrompt(num: Int) = {
    println("Player" + num + ", Select Your Name")
  }

  def placeBoatsPrompt(name : String)= {
    println("Start placing your boats " + name)
  }

  def placeSpecificBoatPrompt(boatName : String , boatLength : Int): Unit ={
    println("Place your " + boatName + " Which Length is "+ boatLength)
  }

  def invalidInput(): Unit ={
    println("This input is invalid, please try again")
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

  def readStringFromConsole():String= {
    readLine.toString.toUpperCase()
  }
  def readIntFromConsole():Int= {
    readLine.toInt
  }

  def startGame()= {
    println("Let's Start the Game Now ")
  }

  def playerTurn()={
    println("It's Your Turn To Play")
  }


  //@tailrec
  def mainLoop(): Unit = {

   chooseGameModePrompt()
    val gameModeInput =  readIntFromConsole()

    gameModeInput match {
      case 1 => {
        //case HH

        val player1 = playerSetup(1)
        val player2 = playerSetup(2)

        val gameState = GameState(0, player1, player2)



      }

      case 2 => {
        // case AH

      }

      case 3 => {
        // case AA

      }

      case _ => {
        invalidInput()
        mainLoop()
      } //case _
    } // gameModeInput match


  }
  mainLoop()



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
      placeSpecificBoatPrompt(currentShip.name, currentShip.length)
      val x = chooseAndValidateX
      val y = chooseAndValidateY
      // take the cell that the player want to hit from the grid
      if (Cell.cellInbound(Cell(x, y, 0))) {

        val cellToPlace = Grid.fetchCell(grid, x, y)

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
          println("in place fleet")
          println(grid2)
          println(Grid.displayGrid(grid2))
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

  /**
    * setups a player , aka give a name, a primarygrid, an empty tracking grid, a fleet and a state equal to alive
    * @param playerNum
    * @return
    */
  def playerSetup(playerNum: Int) : Player ={
    chooseNamePrompt(playerNum)
    val playerName = readStringFromConsole()

    val player = new HumanPlayer(playerName)
    // setting up the grid
    val primaryGrid = Grid.createEmptyGrid(0)
    val listCell= List[Cell]()
    val grid = Grid(primaryGrid, listCell)


    placeBoatsPrompt(playerName)
    val gridFleet = placeFleet(grid, HelpersAndConf.Config.ShipList, Fleet(List[Ship](), 5), player.chooseAndValidateX(), player.chooseAndValidateY(), player.chooseDirection())
    HumanPlayer(playerName, gridFleet._1 , grid, gridFleet._2 , 1 )

  }

}
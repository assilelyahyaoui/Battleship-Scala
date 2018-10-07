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
      " - Type 3 for AI-AI interaction "+ "\n" +
      " - Type 4 for AI-AI stats ")

  }

  def chooseAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to define the level of your AI")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI  " + "\n" +
      " - Type 2 for medium level AI " + "\n" +
      " - Type 3 for high level AI ")

  }
  def chooseAIvsAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to choose the battle")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI vs medium level AI  " + "\n" +
      " - Type 2 for low level AI vs high level AI  " + "\n" +
      " - Type 3 for medium level AI vs high level" + "\n" )

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

  def playerTurn(name: String)={
    println(name + " It's Your Turn To Play")
  }

  def gameOver(name: String): Unit ={
    println("Game Over "+ "\n"+ name+ " You Win")
  }
  def primaryGridPrompt(): Unit ={
    println(" Here is your primary grid")
  }
  def trackingGridPrompt(): Unit ={
    println(" Here is your tracking grid")
  }

  def clearScreen(): Unit = {
    print("\033[H\033[2J")
  }

  def pressEnterToContinue() = {
    println("Press Any Key Followed By Enter to Continue")
    readLine()
  }



  //@tailrec
  def mainLoop(): Unit = {

   chooseGameModePrompt()
    val gameModeInput =  readIntFromConsole()

    gameModeInput match {
      case 1 => {
        //case HH

        //Remove from commentaries  the two lines
        val player1 = playerSetup(1 , "h")
        val player2 = playerSetup(2 , "h")
        val gameState = GameState(0, player1, player2)

        //val primGridP1 = Grid(List(List(Cell(0,0,1), Cell(1,0,0), Cell(2,0,0), Cell(3,0,0), Cell(4,0,0), Cell(5,0,0), Cell(6,0,0), Cell(7,0,0), Cell(8,0,0), Cell(9,0,0)), List(Cell(0,1,0), Cell(1,1,1), Cell(2,1,0), Cell(3,1,0), Cell(4,1,0), Cell(5,1,0), Cell(6,1,0), Cell(7,1,0), Cell(8,1,0), Cell(9,1,0)), List(Cell(0,2,0), Cell(1,2,1), Cell(2,2,1), Cell(3,2,0), Cell(4,2,0), Cell(5,2,0), Cell(6,2,0), Cell(7,2,0), Cell(8,2,0), Cell(9,2,0)), List(Cell(0,3,0), Cell(1,3,1), Cell(2,3,1), Cell(3,3,1), Cell(4,3,0), Cell(5,3,0), Cell(6,3,0), Cell(7,3,0), Cell(8,3,0), Cell(9,3,0)), List(Cell(0,4,0), Cell(1,4,1), Cell(2,4,1), Cell(3,4,1), Cell(4,4,1), Cell(5,4,0), Cell(6,4,0), Cell(7,4,0), Cell(8,4,0), Cell(9,4,0)), List(Cell(0,5,0), Cell(1,5,1), Cell(2,5,1), Cell(3,5,1), Cell(4,5,1), Cell(5,5,1), Cell(6,5,0), Cell(7,5,0), Cell(8,5,0), Cell(9,5,0)), List(Cell(0,6,0), Cell(1,6,0), Cell(2,6,0), Cell(3,6,0), Cell(4,6,1), Cell(5,6,1), Cell(6,6,0), Cell(7,6,0), Cell(8,6,0), Cell(9,6,0)), List(Cell(0,7,0), Cell(1,7,0), Cell(2,7,0), Cell(3,7,0), Cell(4,7,0), Cell(5,7,0), Cell(6,7,0), Cell(7,7,0), Cell(8,7,0), Cell(9,7,0)), List(Cell(0,8,0), Cell(1,8,0), Cell(2,8,0), Cell(3,8,0), Cell(4,8,0), Cell(5,8,0), Cell(6,8,0), Cell(7,8,0), Cell(8,8,0), Cell(9,8,0)), List(Cell(0,9,0), Cell(1,9,0), Cell(2,9,0), Cell(3,9,0), Cell(4,9,0), Cell(5,9,0), Cell(6,9,0), Cell(7,9,0), Cell(8,9,0), Cell(9,9,0))),List())
        //val primGridP2 = Grid(List(List(Cell(0,0,1), Cell(1,0,0), Cell(2,0,0), Cell(3,0,0), Cell(4,0,0), Cell(5,0,0), Cell(6,0,0), Cell(7,0,0), Cell(8,0,0), Cell(9,0,0)), List(Cell(0,1,0), Cell(1,1,1), Cell(2,1,0), Cell(3,1,0), Cell(4,1,0), Cell(5,1,0), Cell(6,1,0), Cell(7,1,0), Cell(8,1,0), Cell(9,1,0)), List(Cell(0,2,0), Cell(1,2,1), Cell(2,2,1), Cell(3,2,0), Cell(4,2,0), Cell(5,2,0), Cell(6,2,0), Cell(7,2,0), Cell(8,2,0), Cell(9,2,0)), List(Cell(0,3,0), Cell(1,3,1), Cell(2,3,1), Cell(3,3,1), Cell(4,3,0), Cell(5,3,0), Cell(6,3,0), Cell(7,3,0), Cell(8,3,0), Cell(9,3,0)), List(Cell(0,4,0), Cell(1,4,1), Cell(2,4,1), Cell(3,4,1), Cell(4,4,1), Cell(5,4,0), Cell(6,4,0), Cell(7,4,0), Cell(8,4,0), Cell(9,4,0)), List(Cell(0,5,0), Cell(1,5,1), Cell(2,5,1), Cell(3,5,1), Cell(4,5,1), Cell(5,5,1), Cell(6,5,0), Cell(7,5,0), Cell(8,5,0), Cell(9,5,0)), List(Cell(0,6,0), Cell(1,6,0), Cell(2,6,0), Cell(3,6,0), Cell(4,6,1), Cell(5,6,1), Cell(6,6,0), Cell(7,6,0), Cell(8,6,0), Cell(9,6,0)), List(Cell(0,7,0), Cell(1,7,0), Cell(2,7,0), Cell(3,7,0), Cell(4,7,0), Cell(5,7,0), Cell(6,7,0), Cell(7,7,0), Cell(8,7,0), Cell(9,7,0)), List(Cell(0,8,0), Cell(1,8,0), Cell(2,8,0), Cell(3,8,0), Cell(4,8,0), Cell(5,8,0), Cell(6,8,0), Cell(7,8,0), Cell(8,8,0), Cell(9,8,0)), List(Cell(0,9,0), Cell(1,9,0), Cell(2,9,0), Cell(3,9,0), Cell(4,9,0), Cell(5,9,0), Cell(6,9,0), Cell(7,9,0), Cell(8,9,0), Cell(9,9,0))),List())
       // val p1 = HumanPlayer("one", primGridP1, Grid( Grid.createEmptyGrid(0), List()),Fleet(List[Ship](), 0), 1 )
       // val p2 = HumanPlayer("two", primGridP2, Grid( Grid.createEmptyGrid(0), List()),Fleet(List[Ship](), 0), 1 )
       // val gameState = GameState(0, p1, p2)

         gameLoop(gameState, 1)

      }

      case 2 => {
        // case AH
        chooseAIPrompt()
        val HAIType = readIntFromConsole()
        val player1 = playerSetup(1, "h")
        val ai1 = HAIPlayerTypeSetup(HAIType)
        val gameState = GameState(0, player1, ai1)
        gameLoop(gameState, 1)


      }

      case 3 => {
        // case AA
        chooseAIvsAIPrompt()
        val AIAIType = readIntFromConsole()
        val players = AIAIPlayerTypeSetup(AIAIType)
        val player1 = players._1
        val player2 = players._2
        val gameState = GameState(0, player1, player2)
        gameLoop(gameState, 1)

      }
      case 4 =>{
        chooseAIvsAIPrompt()
        val AIAIType = readIntFromConsole()
        val players = AIAIPlayerTypeSetup(AIAIType)
        val player1 = players._1
        val player2 = players._2
        val gameState = GameState(0, player1, player2)
        println(gameStats(gameState, Config.numRoundsOfTest, 0, 0))
      }

      case _ => {
        invalidInput()
        mainLoop()
      } //case _
    } // gameModeInput match


  }
  mainLoop()
 /*val grid = Grid( Grid.createEmptyGrid(0), List())
  val grid2 = Grid( Grid.createEmptyGrid(0), List())
  val fleet = new Fleet(List[Ship](), 1)

  val player = new LowAIPlayer("low", grid, grid2, fleet, 1 , List[(Int, Int)]())
  println(player.randomHit(1,1))
  println(player.chooseDirection)

*/

  /**
    * return a subtype of player , initialiwed with a name
    * @param playerType the type wanted
    * @param playerName the name given to the player
    * @return a subtype of player
    */
  def newPlayerWithType(playerType : String, playerName : String): Player={
    playerType match {
      case "h" => new HumanPlayer(playerName)
      case "mai" => new MediumAIPlayer(playerName)
      case "hai" => new HighAIPlayer(playerName)
      case _ => new LowAIPlayer(playerName)

    }
  }


  def newPlayerWithTypeAndGrid(playerType : String, playerName : String, grid: Grid , grid2 : Grid, fleet: Fleet , isAlive : Int): Player={
    playerType match {
      case "h" => new HumanPlayer(playerName, grid , grid2 , fleet, isAlive)
      case "mai" => new MediumAIPlayer(playerName , grid, grid2, fleet, isAlive, List[(Int, Int)]())
      case "hai" => new HighAIPlayer(playerName , grid, grid2, fleet, isAlive, List[(Int, Int)]())
      case _ => new LowAIPlayer(playerName , grid, grid2, fleet, isAlive, List[(Int, Int)]())

    }
  }

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
          println(Grid.displayGrid(grid2))
          //println(Grid.boatCellsLeft(grid2))
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
      (grid , fleet)
    }
      } //placeFleet



  /**
    * always the first player of the two passed in parameter hits
    * @param player1 the player that is going to hit
    * @param player2 that player that is going to be hit
    * @return the players in the same order
    */
  def hit(player1: Player, player2: Player): (Player , Player) = {
    // need to update the gamestate from the function above

    // player chooses the cell he wants to hit
    // check the state
    // returns the state
    // make modifications to the tracking grid and to the other player hit list
    // dont forget to sopy the grids to the players and to the game

    playerTurn(player1.playerName)

    //pressEnterToContinue()
    clearScreen()
    primaryGridPrompt()
    println(Grid.displayGrid(player1.primaryGrid))
    trackingGridPrompt()
    println(Grid.displayGrid(player1.trackingGrid))

    val hit = player1.chooseHit
    val x = hit._1
    val y = hit._2


    val state = Grid.getCellState(player2.primaryGrid, x, y)

    state match {
      case 0 => {
        // cell empty prompt
        cellisEmptyPrompt()
        // put on tracking grid of player one, white peg
        val newTrackingGrid = Grid.changeGridCellState(player1.trackingGrid, x, y, 3)
        println(Grid.displayGrid(newTrackingGrid))


        // put on primary grid of player two , white peg
        val newPrimaryGrid = Grid.changeGridCellState(player2.primaryGrid, x, y, 3)


        // return the new players
        val p1CellHit = player1.changesAfterCellHit(x, y, 0)

        val p1copy = p1CellHit.copyWithTrackingGrid(newTrackingGrid)
        val p2copy = player2.copyWithPrimaryGrid(newPrimaryGrid)


        ( p1copy,  p2copy)

      }
      case 1 => {
        // cell is hit
        cellisHitPrompt()
        // put on tracking grid of player one, red peg
        val newTrackingGrid = Grid.changeGridCellState(player1.trackingGrid, x, y, 2)
        println(Grid.displayGrid(newTrackingGrid))

        // put on primary grid of player two , red peg
        val newPrimaryGrid = Grid.changeGridCellState(player2.primaryGrid, x, y, 2)



        // return the new players
        val p1CellHit = player1.changesAfterCellHit(x, y,1)
        //val p2CellHit = player2.changesAfterCellHit(x, y)

        val p1copy = p1CellHit.copyWithTrackingGrid(newTrackingGrid)
        val p2copy = player2.copyWithPrimaryGrid(newPrimaryGrid)



        ( p1copy,  p2copy)

      }
      case _ => {
        // cell previously hit
        cellPreviouslyHitPrompt()
        val p1Cell = player1.changesAfterCellHit(x, y,2)

        (p1Cell, player2)
      }
    }

}

  /**
    * setups a  player , aka give a name, a primarygrid, an empty tracking grid, a fleet and a state equal to alive
    * @param playerNum
    * @return the setuped player
    */
  def playerSetup(playerNum: Int, playerType : String) : Player ={
    chooseNamePrompt(playerNum)
    val playerName = readStringFromConsole()

    val player = newPlayerWithType( playerType , playerName)
    // val player = newPlayerWithType()
    // setting up the grid
    val primaryGrid = Grid.createEmptyGrid(0)
    val listCell= List[Cell]()
    val grid = Grid(primaryGrid, listCell)


    placeBoatsPrompt(playerName)
    val gridFleet = placeFleet(grid, HelpersAndConf.Config.ShipList, Fleet(List[Ship](), 5), player.chooseAndValidateX, player.chooseAndValidateY, player.chooseDirection)

    newPlayerWithTypeAndGrid(playerType , playerName, gridFleet._1 , grid, gridFleet._2 , 1 )

  }

  /**
    * makes the players hit until one of the grids are down
    * @param gameState represent the state of the game, aka the 2 player and the round number
    * @param turn whose player's turn is to hit
    * @return the player that won
    */
  def gameLoop(gameState: GameState, turn : Int): Player ={
    val d = Grid.boatCellsLeft(gameState.player1.primaryGrid)
    val b = Grid.boatCellsLeft(gameState.player2.primaryGrid)
    if (Grid.boatCellsLeft(gameState.player1.primaryGrid) != 0 && Grid.boatCellsLeft(gameState.player2.primaryGrid) != 0 ){
      if (turn == 1 ){
        val hitResult = hit(gameState.player1, gameState.player2)
        val gs = gameState.copy(gameState.roundNumber+1 , hitResult._1 , hitResult._2)
        gameLoop(gs, 2)
      }
      else{
        val hitResult =  hit(gameState.player2, gameState.player1)
        val gs = gameState.copy(gameState.roundNumber+1 , hitResult._2 , hitResult._1)
        gameLoop(gs, 1)
      }

    }
    else {
      turn match {
        case 1 => {gameOver(gameState.player2.playerName)
                    gameState.player2}
        case 2 => {
          gameOver(gameState.player1.playerName)
          gameState.player1
        }

      }
    }
  }

  /**
    * generates a type of player by taking the game mode into consideration
    * @param AIType int, representing the game mode
    * @return a playeer of the correct type
    */
  def HAIPlayerTypeSetup(AIType : Int ): Player = {
  AIType match {
    case 2 => { // medium
      playerSetup(2 , "mai")

    }
    case 3 => { // high
      playerSetup(2 , "hai")

    }
    case _ => {
      // assume Low level
      playerSetup(2 , "lai")

    }

  }
}

  def AIAIPlayerTypeSetup(AIType : Int ): (Player,Player) = {
    AIType match {
      case 2 => { // medium
        (playerSetup(1 , "lai"), playerSetup(2 , "hai"))

      }
      case 3 => { // high
        (playerSetup(1 , "mai"), playerSetup(2 , "hai"))

      }
      case _ => {
        // assume Low level
        (playerSetup(1 , "lai"), playerSetup(2 , "mai"))

      }

    }
  }

  def gameStats(gameState: GameState, numRounds : Int, scoreP1 : Int, scoreP2 : Int):String = {

    if (numRounds>0){
      val winner = gameLoop(gameState, 1 )
      println(winner)

      if (winner == gameState.player1){
        gameStats(gameState, numRounds-1, scoreP1+1 , scoreP2)
      }
      else{
        gameStats(gameState, numRounds-1, scoreP1 , scoreP2+1)
      }

    }
    else {
      val score = "\n"+ "Score : " + "\n" + gameState.player1.playerName + "  " + scoreP1 + " wins" + "\n" + gameState.player2.playerName + "  " + scoreP2 + " wins" +"\n"
      score
    }
  }
  /*def chooseAILevel(): Player = {
    chooseAIPrompt()
    val level = readIntFromConsole()
    level match {
      //case 2 => new AIPlayer()
      //case 3 =>
      case _ => new LowAIPlayer()
    }
  }*/

}
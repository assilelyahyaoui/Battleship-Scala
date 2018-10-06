package HelpersAndConf
import Boats._

object Config {
  val ShipList = List(ShipType("Carrier", 5), ShipType("Battleship", 4 ), ShipType("Cruiser", 3), ShipType("Submarine", 3), ShipType("Destroyer", 2))
  val gridX = 10
  val gridY = 10


  /*
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

    // second boat creation

    // the cell has the coordinates given by the player
    val cell2 = r.gridLayout(7)(7)
    println("r")
    println(r.gridLayout(7)(7))
    println(Grid.getCellState(r, 7, 7))
    println(r)
    println("cell2")
    println(cell2)
    // initializing the list with the created cell , which will me in the boat
    val listcases2 = List(cell2)
    // creating the boat
    val ship2 = Ship("b2",listcases2, 2 , 1 , 2)
    // filling the cells of the boat
    val shipcells2 = Ship.findBoatCells(ship2)
    // putting the filled list in the boat
    val ship22 = ship2.copy(_boatCells = shipcells2)
    // check if the boat can be positioned in the grid

    println("must say f ")
    println(Ship.canBePositioned(r, ship22, Option(cell2)))

    // placing the boat on the grid aka changing the status of the grid
    val y = Grid.placeBoatInGrid(r, ship22)

    println(Grid.displayGrid(y))

   */
}


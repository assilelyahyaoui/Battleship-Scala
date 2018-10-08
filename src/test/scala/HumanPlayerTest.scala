import org.scalatest._
import Boats._
import Grid._
import Player._


class HumanPlayerTest extends FunSuite with DiagrammedAssertions {
  val  grid = Grid( Grid.createEmptyGrid(0), List())
  val cell = Cell(1,0,0)
  // the boat cell has to have the first cell
  val listcases = List(cell)
  val ship = Ship("b1",listcases, 3 , 0 , 3)
  val shipcells = Ship.findBoatCells(ship)
  val ship1 = ship.copy(_boatCells = shipcells)
  val fleet = Fleet(List(ship1), 1)

  // insert in grid
  val gridBoat = Grid.placeBoatInGrid(grid, ship1)

  val player = new HumanPlayer("p1" ,gridBoat , grid,fleet, 1  )


  test("Testing the HumanPlayer class : isAlive "){
    assert(player.isAlive == 1)
    assert(player.isAlive != 0)
  }

  test("Testing the HumanPlayer class : copyWithPlayerName "){
    val player1 = new HumanPlayer("bob" ,gridBoat , grid,fleet, 1  )
    val player = new HumanPlayer("lucie" ,gridBoat , grid,fleet, 1  )

    assert(player.copyWithPlayerName("bob") == player1)
    assert(player.copyWithPlayerName("lucie") != player1)
  }

  test("Testing the HumanPlayer class : copyWithPrimaryGrid "){
    val  grid1 = Grid( Grid.createEmptyGrid(0), List())

    val player1 = new HumanPlayer("p1" ,grid1 , grid,fleet, 1  )
    val player2 = new HumanPlayer("p1" ,gridBoat , grid,fleet, 1  )

    assert(player.copyWithPrimaryGrid(grid1) == player1)
    assert(player.copyWithPrimaryGrid(grid1) != player2)
  }

  test("Testing the HumanPlayer class : copyWithFleet "){
    val fleet2 = Fleet(List(ship), 1)

    val player1 = new HumanPlayer("p1" ,gridBoat , grid,fleet2, 1  )
    val player2 = new HumanPlayer("p1" ,gridBoat , grid,fleet, 1  )

    assert(player.copyWithFleet(fleet2) == player1)
    assert(player.copyWithFleet(fleet2) != player2)
  }


  }

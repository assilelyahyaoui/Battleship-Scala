import org.scalatest.{DiagrammedAssertions, FunSuite}
import Boats._
import Grid._
import HelpersAndConf._
import Player._


class MediumAIPlayerTest extends FunSuite with DiagrammedAssertions {


  val grid = Grid( Grid.createEmptyGrid(0), List())
  val cell = Cell(1,0,0)
  // the boat cell has to have the first cell
  val listcases = List(cell)
  val ship = Ship("b1",listcases, 3 , 0 , 3)
  val shipcells = Ship.findBoatCells(ship)
  val ship1 = ship.copy(_boatCells = shipcells)
  val fleet = Fleet(List(ship1), 1)
  val hitList = List()
  val hitListFull = List((3,3), (4,3), (3,4),(2,3),(3,2) )

  // insert in grid
  val gridBoat = Grid.placeBoatInGrid(grid, ship1)

  val player = new MediumAIPlayer("p1" ,gridBoat , grid,fleet, 1, hitList)
  val playerHit = new MediumAIPlayer("p1" ,gridBoat , grid,fleet, 1, hitListFull)


  test("Testing the Player class : chooseHit ") {
    assert(player.chooseHit() != (12, 24))
    assert(player.chooseHit().isInstanceOf[(Int, Int)])
  }

  test("Testing the Player class : chooseAndValidateX ") {
    assert(player.chooseAndValidateX != Config.gridXMax+1)
    assert(player.chooseAndValidateX != -1)
    assert(player.chooseAndValidateX.isInstanceOf[Int])
  }

  test("Testing the Player class : chooseAndValidateY ") {
    assert(player.chooseAndValidateX != Config.gridYMax+1)
    assert(player.chooseAndValidateX != -1)
    assert(player.chooseAndValidateX.isInstanceOf[Int])
  }

  test("Testing the Player class : chooseDirection ") {
    assert(player.chooseDirection != 3)
    assert(player.chooseDirection != -1)
    assert(player.chooseDirection == 1 || player.chooseDirection == 0)
    assert(player.chooseDirection.isInstanceOf[Int])
  }

  test("Testing the Player class : changesAfterCellHit ") {
    assert(player.changesAfterCellHit(3,3, 0) == player)
    assert(player.changesAfterCellHit(3,3, 0) != playerHit)
    assert(player.changesAfterCellHit(3,3,1 ) == player)
    assert(player.changesAfterCellHit(3,3, 0).isInstanceOf[Player])
  }

}

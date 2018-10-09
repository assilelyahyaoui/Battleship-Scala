
import Boats._
import Grid._
import HelpersAndConf._
import Player._
import org.scalatest._

class HighAIPlayerTest extends FunSuite with DiagrammedAssertions  {

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


  val cell22 = Cell(3,3,0)
  // the boat cell has to have the first cell
  val listcases22 = List(cell22)
  val ship22 = Ship("b1",listcases22, 1 , 0 , 1)
  val shipcell22s = Ship.findBoatCells(ship22)
  val ship122 = ship22.copy(_boatCells = shipcell22s)
  val fleet22 = Fleet(List(ship122), 1)

  // insert in grid
  val gridBoat = Grid.placeBoatInGrid(grid, ship1)
  val gridBoat22 = Grid.placeBoatInGrid(grid, ship122)
  val rnd = new scala.util.Random(10)


  val player =  HighAIPlayer("p1" ,gridBoat , grid,fleet, 1, hitList, rnd)
  val playerHit =  HighAIPlayer("p1" ,gridBoat , grid,fleet, 1, hitListFull,rnd)
  val player22 =  HighAIPlayer("p1" ,gridBoat22 , grid,fleet22, 1, hitList, rnd)


  val dir = player.chooseDirection
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
    assert(dir == 1 || dir == 0)
    assert(player.chooseDirection.isInstanceOf[Int])
  }

  test("Testing the Player class : moveAndHit ") {
    assert(player.moveAndHit(3,3,1) == List((4,3)))
    assert(player.moveAndHit(3,3,1) != List((3,3)))
    assert(player.moveAndHit(3,3,2) == List((3,4)))
    assert(player.moveAndHit(3,3,3) == List((2,3)))
    assert(player.moveAndHit(3,3,4) == List((3,2)))
    assert(player.moveAndHit(3,3,4).isInstanceOf[List[(Int, Int)]])
  }

  test("Testing the Player class : findSurroundingHitCells ") {
    assert(player.findSurroundingHitCells(3,3) == List((3,3), (4,3), (3,4),(2,3),(3,2) ))
    assert(player.findSurroundingHitCells(3,3) != List((3,4)))
    assert(player.findSurroundingHitCells(3,3).isInstanceOf[List[(Int, Int)]])
  }

  test("Testing the Player class : changesAfterCellHit ") {
    assert(player.changesAfterCellHit(3,3, 0) == player)
    assert(player.changesAfterCellHit(3,3, 0) != playerHit)
    assert(player.changesAfterCellHit(3,3, 0).isInstanceOf[Player])
  }


}


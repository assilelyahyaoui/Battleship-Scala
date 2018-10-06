
import Boats._
import Grid._
import org.scalatest._

class ShipTest extends FunSuite with DiagrammedAssertions{

  test("Testing the Ship class : findBoatCells "){
    // initializing a boat
    val cell = Cell(0,0,0)
    val listCases = List(cell)
    val ship = Ship("b1",listCases, 3 , 0 , 3)
    val shipFindCells = Ship.findBoatCells(ship)

    assert(shipFindCells.isInstanceOf[List[Cell]] )
    assert(shipFindCells.length == 3)
    assert(shipFindCells.length != 0)
    assert(shipFindCells.nonEmpty)

    assert(shipFindCells.head.cellXCoordinate >=0 && shipFindCells.head.cellXCoordinate<10)
    assert(shipFindCells.last.cellYCoordinate >=0 && shipFindCells.last.cellYCoordinate<10)
    assert(shipFindCells.head.cellXCoordinate >=0 && shipFindCells.head.cellXCoordinate<10)
    assert(shipFindCells.last.cellYCoordinate >=0 && shipFindCells.last.cellYCoordinate<10)

  }

  test("Testing the Ship class : fillBoatCellList"){
    val cell = Cell(0,0,0)
    val listCases = List(cell)
    val ship = Ship("b1",listCases, 3 , 0 , 3)
    val ship2 = Ship.fillBoatCellList(ship)

    assert(ship.boatCells.length == 1)
    assert(ship2.boatCells.nonEmpty)
    assert(ship2.isInstanceOf[Ship])


  }

  test("Testing the Ship class : boatSank"){
    val cell = Cell(0,0,0)
    val listCases = List(cell)
    val ship = Ship("b1",listCases, 3 , 0 , 3)
    val ship2 = Ship("b2",listCases, 3 , 0 , 0)

    assert(!Ship.boatSank(ship))
    assert(Ship.boatSank(ship2))
  }

  test("Testing the Ship class : boatCanFit"){
    val cell = Cell(0,0,0)
    val cell2 = Cell(9,0,0)
    val cell3 = Cell(0,9,0)
    val cell4 = Cell(8,0,0)
    val cell5 = Cell(0,8,0)


    val listCases = List(cell)
    val listCases2 = List(cell2)
    val listCases3 = List(cell3)
    val listCases4 = List(cell4)
    val listCases5 = List(cell5)

    val ship = Ship("b1",listCases, 5 , 0 , 3)
    val ship2 = Ship("b2",listCases2, 3 , 0 , 0)
    val ship3 = Ship("b2",listCases3, 3 , 1 , 0)
    val ship4 = Ship("b2",listCases4, 3 , 0 , 0)
    val ship5 = Ship("b2",listCases5, 3 , 1 , 0)


    assert(!Ship.boatSank(ship))
    assert(Ship.boatSank(ship2))
    assert(Ship.boatSank(ship3))
    assert(Ship.boatSank(ship4))
    assert(Ship.boatSank(ship5))

  }

}

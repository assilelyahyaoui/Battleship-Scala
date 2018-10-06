
import Boats._
import Grid._
import org.scalatest._

class CellTest extends FunSuite with DiagrammedAssertions {

  test("Testing the Cell class : cellInbound "){
    val cell = Cell(0,0,0)
    val cell3 = Cell(5,5,0)
    val cell1 = Cell(11,0,0)
    val cell2 = Cell(0,11,0)
    val cell5 = Cell(22,22,0)

    assert(Cell.cellInbound(cell))
    assert(Cell.cellInbound(cell3))
    assert(!Cell.cellInbound(cell1))
    assert(!Cell.cellInbound(cell2))
    assert(!Cell.cellInbound(cell5))


  }

  test("Testing the Cell class : nextXCell "){
    val cell = Cell(0,0,0)
    val cell3 = Cell(5,5,0)
    val cell1 = Cell(1,0,0)


    assert(Cell.nextXCell(cell) == cell1)
    assert(Cell.nextXCell(cell) != cell3)
    assert(Cell.nextXCell(cell).isInstanceOf[Cell])


  }

  test("Testing the Cell class : nextYCell "){
    val cell = Cell(0,0,0)
    val cell1 = Cell(0,1,0)
    val cell3 = Cell(5,5,0)

    assert(Cell.nextYCell(cell) == cell1)
    assert(Cell.nextYCell(cell) != cell3)
    assert(Cell.nextYCell(cell).isInstanceOf[Cell])
  }

  test("Testing the Cell class : changeState "){
    val cell = Cell(0,0,0)
    val cell1 = Cell(0,0,1)
    val cell3 = Cell(5,5,0)

    assert(Cell.changeState(cell, 1) == cell1)
    assert(Cell.changeState(cell, 1) != cell3)
    assert(Cell.changeState(cell, 1).isInstanceOf[Cell])
  }

  test("Testing the Cell class : cellEmpty "){
    val cell = Cell(0,0,0)
    val cell1 = Cell(0,0,1)

    assert(Cell.cellEmpty(cell))
    assert(!Cell.cellEmpty(cell1))
    assert(Cell.cellEmpty(cell).isInstanceOf[Boolean])
  }

  test("Testing the Cell class : cellOccupied "){
    val cell = Cell(0,0,1)
    val cell1 = Cell(0,0,0)

    assert(Cell.cellEmpty(cell))
    assert(!Cell.cellEmpty(cell1))
    assert(Cell.cellEmpty(cell).isInstanceOf[Boolean])
  }

  test("Testing the Cell class : cellHit "){
    val cell = Cell(0,0,2)
    val cell1 = Cell(0,0,1)

    assert(Cell.cellEmpty(cell))
    assert(!Cell.cellEmpty(cell1))
    assert(Cell.cellEmpty(cell).isInstanceOf[Boolean])
  }

  test("Testing the Cell class : cellMissed "){
    val cell = Cell(0,0,3)
    val cell1 = Cell(0,0,1)

    assert(Cell.cellEmpty(cell))
    assert(!Cell.cellEmpty(cell1))
    assert(Cell.cellEmpty(cell).isInstanceOf[Boolean])
  }


}

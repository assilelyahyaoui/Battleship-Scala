import org.scalatest._
import Boats._
import Grid._

class GridTest {

  class GridTest extends FunSuite with DiagrammedAssertions {

    val grid = Grid(Grid.createEmptyGrid(0), List())
    val cell00 = Cell(0, 0, 0)
    val cell10 = Cell(1, 0, 0)
    val cell01 = Cell(0, 1, 0)


    val listCell = List(cell00, cell10)
    val gridCellFull = Grid(grid.gridLayout, listCell)

    val cell001 = Cell(0, 0, 1)
    val cell101 = Cell(1, 0, 1)
    val listCellBoat = List(cell001, cell101)
    val gridCellFullBoat = Grid(grid.gridLayout, listCellBoat)
    val boat00 = Ship("ship", listCell, 2, 0, 2 )

    // case 00 state = 1
    val listCellBoatFirstCell = List(cell001)
    val gridCellFullBoatFirstCell = Grid(grid.gridLayout, listCellBoat)

    test("Testing the Grid class : nextXGridCell ") {
      assert(Grid.nextXGridCell(grid.gridLayout, cell00) == Option(cell10))
      assert(Grid.nextXGridCell(grid.gridLayout, cell00) != Option(cell01))
      assert(Grid.nextXGridCell(grid.gridLayout, cell00).isInstanceOf[Option[Cell]])

    }

    test("Testing the Grid class : nextYGridCell ") {
      assert(Grid.nextYGridCell(grid.gridLayout, cell00) != Option(cell10))
      assert(Grid.nextYGridCell(grid.gridLayout, cell00) == Option(cell01))
      assert(Grid.nextYGridCell(grid.gridLayout, cell00).isInstanceOf[Option[Cell]])
    }

    test("Testing the Grid class : addToCellsFull ") {
      assert(Grid.addToCellsFull(grid, listCell) != grid)
      assert(Grid.addToCellsFull(grid, listCell) == gridCellFull )
      assert(Grid.addToCellsFull(grid, listCell).isInstanceOf[Grid])
    }


    test("Testing the Grid class : boatOverlaps ") {
      assert(Grid.boatOverlaps(gridCellFullBoat, boat00))
      assert(! Grid.boatOverlaps(gridCellFull, boat00) )
      assert(Grid.boatOverlaps(grid, boat00).isInstanceOf[Boolean])
    }

    test("Testing the Grid class : createEmptyGrid ") {
      assert(Grid.createEmptyGrid(10).isInstanceOf[List[List[Cell]]])
    }

    test("Testing the Grid class : changeGridCellState ") {
      assert(Grid.changeGridCellState(grid, 0, 0, 1 ) == gridCellFullBoatFirstCell )
      assert(Grid.changeGridCellState(grid, 0, 0, 1 ) != gridCellFullBoat )
      assert(Grid.changeGridCellState(grid, 0, 0, 1).isInstanceOf[Grid])
    }

    test("Testing the Grid class : getCellState ") {
      assert(Grid.getCellState(grid, 0, 0) == 0 )
      assert(Grid.getCellState(grid, 0, 0) != 1 )
      assert(Grid.getCellState(grid, 0, 0).isInstanceOf[Int])
    }

    test("Testing the Grid class : fetchCell ") {
      assert(Grid.fetchCell(grid, 0, 0) == Option(cell00) )
      assert(Grid.fetchCell(grid, 0, 0) != Option(cell01) )
      assert(Grid.fetchCell(grid, 0, 0).isInstanceOf[Option[Cell]])
    }

    test("Testing the Grid class : boatCellsLeft ") {
      assert(Grid.boatCellsLeft(gridCellFullBoatFirstCell) == 1 )
      assert(Grid.boatCellsLeft(gridCellFullBoatFirstCell) != 0 )
      assert(Grid.boatCellsLeft(gridCellFullBoatFirstCell).isInstanceOf[Int])
    }


  }

}

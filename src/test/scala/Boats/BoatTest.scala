
import org.scalatest._
import Boats._

class BoatTest extends FunSuite with DiagrammedAssertions{

  test("Testing the Boat class : can be Positioned "){
   val boat =

    assert(Boat.canBePositioned())
  }

}

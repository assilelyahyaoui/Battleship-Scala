package Boats


/*
           a fleet contains a list of boats
           Spec :`
            add boat to fleet

           see if a fleet sank
           browse all boats
            */
/**
  * Contains
  * @param _fleet
  * @param _numberOfBoatsLeft
  */
case class Fleet (private val _fleet: List[Ship], private val _numberOfBoatsLeft : Int){
  def fleet: List[Ship] = this._fleet
  def numberOfBoatsLeft : Int = this._numberOfBoatsLeft

}
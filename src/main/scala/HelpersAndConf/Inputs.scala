package HelpersAndConf

import scala.io.StdIn.readLine

object Inputs {



  def readStringFromConsole(): String = {
    readLine.toString.toUpperCase()
  }

  def readIntFromConsole(): Int = {

   readLine.toInt

  }

}

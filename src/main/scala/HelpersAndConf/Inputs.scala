package HelpersAndConf

import scala.io.StdIn.readLine

object Inputs {



  def readStringFromConsole(): String = {
    readLine.toString.toUpperCase()
  }

  def readIntFromConsole(): Int = {
    try{
      readLine.toInt
    } catch {
      case e: Exception => {
        Outputs.invalidInput()
        readIntFromConsole()
      };
    }


  }

}

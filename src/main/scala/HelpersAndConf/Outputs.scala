package HelpersAndConf
import scala.io.StdIn.readLine
import java.io._

object Outputs {


  def chooseGameModePrompt() = {
    println("Player Mode : " + "\n" +
      " - Type 1 for Human-Human interaction " + "\n" +
      " - Type 2 for AI-Human interaction  " + "\n" +
      " - Type 3 for AI-AI interaction " + "\n" +
      " - Type 4 for AI-AI stats "+ "\n" +
      " - Type 5 for the 3 AI-AI stats "+ "\n")
  }

  def chooseAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to define the level of your AI")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI  " + "\n" +
      " - Type 2 for medium level AI " + "\n" +
      " - Type 3 for high level AI ")

  }

  def chooseAIvsAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to choose the battle")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI vs medium level AI  " + "\n" +
      " - Type 2 for low level AI vs high level AI  " + "\n" +
      " - Type 3 for medium level AI vs high level" + "\n")

  }

  def chooseNamePrompt(num: Int) = {
    println("Player" + num + ", Select Your Name")
  }

  def placeBoatsPrompt(name: String) = {
    println("Start placing your boats " + name)
  }

  def placeSpecificBoatPrompt(boatName: String, boatLength: Int): Unit = {
    println("Place your " + boatName + " Which Length is " + boatLength)
  }

  def invalidInput(): Unit = {
    println("This input is invalid, please try again")
  }

  def impossiblePlacement() = {
    println("It is impossible to place the boat here, please try again")
  }

  def cellNotInboundPrompt() = {
    println("the cell chosen is not in the grid , please try again")
  }

  def cellisHitPrompt() = {
    println("You have hit you opponent !")
  }

  def cellisEmptyPrompt() = {
    println("This cell is empty ")
  }

  def cellPreviouslyHitPrompt() = {
    println("This cell was previously hit")
  }


  def startGame() = {
    println("Let's Start the Game Now ")
  }

  def playerTurn(name: String) = {
    println(name + " It's Your Turn To Play")
  }

  def gameOver(name: String): Unit = {
    println("Game Over " + "\n" + name + " You Win")
  }

  def primaryGridPrompt(): Unit = {
    println(" Here Is Your Primary Grid")
  }

  def trackingGridPrompt(): Unit = {
    println(" Here is your tracking grid")
  }

  def clearScreen(): Unit = {
    print("\033[H\033[2J")
  }

  def pressEnterToContinue() = {
    println("Press Any Key Followed By Enter to Continue")
    readLine()
  }


  /**
    * Function that write into a file the content put as parameters
    * @param location: String: name and location of the file on the computer
    * @param content: String: Content to write into the file
    */
  def writeToFile(location: String, content: String): Unit = {
    val bw = new BufferedWriter(new FileWriter(location))
    bw.write(content)
    bw.flush()
    bw.close()
  }

}
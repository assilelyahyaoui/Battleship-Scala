package Game
import scala.io.StdIn.readLine
import Player._


case class GameState(
                      roundNumber : Int,
                      player1 : Player,
                      player2 : Player ,


                    )

object BattleshipGame extends App {

  def chooseGameModePrompt() = {
    println("Player Mode : " + "\n" +
      " - Type HH for Human-Human interaction " + "\n"+
      " - Type AH for AI-Human interaction  " +"\n"+
      " - Type AA for AI-AI interaction ")

  }

  def chooseAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to define the level of your AI")
    println("AI Mode : " + "\n" +
      " - Type 1 for low level AI  " + "\n"+
      " - Type 2 for medium level AI " +"\n"+
      " - Type 3 for high level AI ")

  }

  def chooseNamePrompt(num : Int)  = {
    println("Choose your name player" + num )
  }

//@tailrec
  def mainLoop(): Unit = {

    chooseGameModePrompt()
    val gameModeInput = readLine.trim.toUpperCase

    gameModeInput match {
      case "HH" =>{

      }//case HH

      case "AH" => {

      }// case AH

      case "AA" => {

      }// case AA

      case _ => {

      } //case _
    }// gameModeInput match



  }//mainloop
  mainLoop()

  }
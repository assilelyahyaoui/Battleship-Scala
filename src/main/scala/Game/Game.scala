package Game
import scala.util.Random
import scala.annotation.tailrec
import scala.io.StdIn.readLine
import Player._
import Boats._


case class GameState(
                      roundNumber : Int,
                      player1 : Player,
                      player2 : Player ,


                    )

object BattleshipGame extends App {

  def chooseGameModePrompt() = {
    println("Player Mode : type HH for Human-Human interaction and AH for AI human and AA for AI-AI")

  }

  def chooseAIPrompt() = {
    println("AI mode : type 1 , 2 or 3 to define the level of your AI")

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
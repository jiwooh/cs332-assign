package recfun
import common._

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println()
    println("balance: all true?")
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
    println(!balance(":-)".toList))
    println(!balance("())(".toList))
    println()
    println("countChange: all true?")
    println(countChange(4,List(1,2)) === 3)
    println(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
    println(countChange(301,List(5,10,20,50,100,200,500)) === 0)
    println(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def _balance(chars: List[Char], value: Int): Int = {
      if (chars.isEmpty) value
      else if (value < 0) value // return early, too many )s
      else if (chars.head == '(') _balance(chars.tail, value + 1)
      else if (chars.head == ')') _balance(chars.tail, value - 1)
      else _balance(chars.tail, value)
    }
    0 == _balance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}

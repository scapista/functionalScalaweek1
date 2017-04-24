package recfun

import scala.annotation.tailrec
import scala.collection.JavaConverters._

object Main {
  def main(args: Array[String]) {
/*    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
      print(pascal(col, row) + " ")
      println()
    }


    println("Parentheses Balancing")
    var list = "(if (zero? x) max (/ 1 x))"
    println(list)
    print(balance(list.toList))

    println("\n----------------------")
    list = "):-"
    println(list)
    print(balance(list.toList))*/

    countChange(4,List(1,2))

  }


  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r) 1 else pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def innerbalance(chars: List[Char], paren: Int): Boolean ={
        if (!chars.isEmpty && !(paren < 0) ) {
            if (chars.head == '(') innerbalance(chars.tail, paren + 1)
            else if (chars.head == ')') innerbalance(chars.tail, paren - 1)
            else innerbalance(chars.tail, paren)
        }
        else paren == 0
      }
      innerbalance(chars, 0)
    }


  
  /**
   * Exercise 3
    * 1. check if first element is greater than money
    * 2. check if fist element is fully divisable by money
    * 3. loop through all other possible elements using
    *
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money < 0 || coins.isEmpty)
      0
    else if (money == 0)
      1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }

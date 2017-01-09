object EitherLeftRightExample {
 def main(args: Array[String]): Unit = {
		/**
   * A simple method to demonstrate how to declare that a method returns an Either,
   * and code that returns a Left or Right.
   */
  def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Gak bisa dibagi oleh 0 euyy")
    else Right(x / y)
  }
  
  // a few different ways to use Either, Left, and Right
  println(divideXByY(1, 0))
  println(divideXByY(1, 1))
  divideXByY(1, 0) match {
    case Left(s) => println("Answer: " + s)
    case Right(i) => println("Answer: " + i)
  }	
	}
	
}
object ContohEitherLeftRight {
	def main(args: Array[String]): Unit = {
	 
	  
	  println(divideXByY(1, 0))
	  println(divideXByY(1, 1))
	  divideXByY(1, 0) match {
	    case Left(s) => println("Hasilnya : " + s)
	    case Right(i) => println("Hasilnya : " + i)
	  }
	}

	 def divideXByY(x: Int, y: Int): Either[String, Int] = {
	    if (y == 0) Left("Mohon maaf, bilangan tsb tidak bisa dibagi dengan 0")
	    else Right(x / y)
	  }
	
}
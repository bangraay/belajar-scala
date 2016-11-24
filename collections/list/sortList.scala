object Main {
	def main(args: Array[String]): Unit = {
		
		  val keywords = List("Apple", "Ananas", "Mango", "Banana", "Beer")
		  val result = keywords.sorted.groupBy(_.head)
		  println(result)
	}
}
		
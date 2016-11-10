object List {
	def main(args: Array[String]): Unit = {
		// List of Strings
		val fruit1: List[String] = List("apples", "oranges", "pears")

		// List of Integers
		val nums1: List[Int] = List(1, 2, 3, 4)

		// Empty List.
		val empty: List[Nothing] = List()

		// Two dimensional list
		val dim: List[List[Int]] =
		   List(
		      List(1, 0, 0),
		      List(0, 1, 0),
		      List(0, 0, 1)
		   )

		println()
		
		val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
	    val nums = Nil

	    println( "Head of fruit : " + fruit.head )
	    println( "Tail of fruit : " + fruit.tail )
	    println( "Check if fruit is empty : " + fruit.isEmpty )
	    println( "Check if nums is empty : " + nums.isEmpty )   	
	}
	
}
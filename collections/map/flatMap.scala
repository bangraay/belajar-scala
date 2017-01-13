object flatMap {
	def main(args: Array[String]): Unit = {
		val buah2an = Seq("apel", "pisang", "jambu", "jeruk")
		val res0 = buah2an.map(_.toUpperCase)
		val res1 = buah2an.flatMap(_.toUpperCase)
		val mapResult = buah2an.map(_.toUpperCase)
		val flattenResult = mapResult.flatten

		println(res0)
		println(res1)
		println(mapResult)
		println(flattenResult)
	}
	
}
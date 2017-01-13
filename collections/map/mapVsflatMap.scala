object mapVsflatMap {
	def main(args: Array[String]): Unit = {
		val strings = Seq("1", "2", "uzumaki", "3", "naruto")
		val res0 = strings.map(toInt)
		val res1 = strings.flatMap(toInt)
		val res2 = strings.flatMap(toInt).sum

		println(res0)
		println(res1)
		println(res2)

		val list = List(1,2,3,4,5)
		val res3 = list.map(x => g(x))
		val res4 = list.flatMap(x => g(x))

		println(list)
		println(res3)
		println(res4)


	}


	def toInt(s: String): Option[Int] = {
    try {
        Some(Integer.parseInt(s.trim))
    } catch {
        // catch Exception to catch null 's'
        case e: Exception => None
    }

    def g(v:Int) = List(v-1, v, v+1)

}
	
}
import scala.util.matching.Regex

object Demo {
   def main(args: Array[String]) {
      val pattern = new Regex("abl[ae]\\d+")
      val str = "ablaw is able1 and cool"
      
      println((pattern findAllIn str).mkString(","))

      println()
      // var words = 10
      // val pattern2 =  words.matches("""\d""")
      // println(pattern2)

      val numPattern = "[0-9]+".r
// numPattern: scala.util.matching.Regex = [0-9]+

	  val address = "123 Main Street Suite 101"
// address: String = 123 Main Street Suite 101

 	  // val match1 = numPattern.findFirstIn(address)
 	  val match1 = numPattern.findAllIn(address)
	 // match1: Option[String] = Some(123)

	match1.foreach { e => println(s"Found a match: $e") }

	// Testing

	 val pat = "[e3€]n[i1!|][s5$]+".r
// numPattern: scala.util.matching.Regex = [0-9]+

	  val komen = "123 Main Street Suite 101"
// address: String = 123 Main Street Suite 101

 	  // val match1 = numPattern.findFirstIn(address)
 	  val cocok = pat.findAllIn(komen)
	 // match1: Option[String] = Some(123)

	cocok.foreach { e => println(s"Found a match: $e") }

	// Kadua
	val regex = """\b[b-df-hj-np-tv-z]*[aeiou]+[b-df-hj-np-tv-z]*\b""".r

	regex.pattern.matcher("good").matches
	//res3: Boolean = true

	regex.pattern.matcher("no good deed").matches
	//res4: Boolean = false


	// Bertzi

   }


   
  def test(regexes: Seq[Regex], comment: String) = regexes.map(_.unapplySeq(comment)).map(_.isDefined).count(_ == true)
}
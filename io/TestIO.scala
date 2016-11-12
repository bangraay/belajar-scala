import java.io._

object TestIO {
   def main(args: Array[String]) {
      val writer = new PrintWriter(new File("test.txt" ))

      writer.write("Hello Scala")
      println("Writing Hallo Scala to file Done!")
      writer.close()
   }
}
import scala.io.Source

object ReadIO {
   def main(args: Array[String]) {
      println("Following is the content read:" )

      Source.fromFile("test.txt" ).foreach{ 
         print 
      }
   }
}
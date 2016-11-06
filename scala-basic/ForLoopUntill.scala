object ForLoopUntil {
   def main(args: Array[String]) {
      var a = 0;
      // for loop execution with a range
      for( a <- 1 until 10){
         println( "Value of a: " + a );
      }
   }
}
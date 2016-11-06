object Add{
	def main(args: Array[String]){
		println("Hasil Balikan : " + addInt(5,10));
	}

	def addInt(a:Int, b:Int) : Int ={
		var sum: Int = 0;
		sum = a + b;

		return sum;
	}

}
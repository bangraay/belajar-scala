// encode and decode Base64 with scala
// encode String

object DecodeFromBase64 {
	def main(args: Array[String]) = {
		println("Encode String")
		println(encode("Uzumaki Naruto"))

	}

	def encode(words: String){
		new sun.misc.BASE64Encoder().encode(words.getBytes())
	}

	def decode(words: String){
		new String(new sun.misc.BASE64Decoder().decodeBuffer(words))		
	}
	
}

 


// new String(new sun.misc.BASE64Decoder().decodeBuffer("S2x1IG9yZyBzZWx1IG51ZHVoIG1lbnVkaCB0cnMgbWF1IG11IGFwYSBrbHUgb3JnIHNsbHUgYmlraW4gcGl0bmFoIG51ZHVoIHRycyBtZW5lcnVzIGl0dSBidWthbiBtYW51c2lhIHNldGFuIGRsbSBwaWtpcmFuIG55YSBrYW4gdWRoIGJlcmtsaTIgcGVyc2lkZW4gbWVuZXJhbmdrbiBtYXUgZGkgYXBhaW4gZ2l0dS4uPz8/"))		
// https://4therecord.wordpress.com/2011/03/11/encode-and-decode-base64-with-scala/
import io.Source

def time[T](f: => T): T = {
  val start = System.nanoTime
  val r = f
  val end = System.nanoTime
  val time = (end - start)/1e6
  println("time = " + time +"ms")
  r
}

val domain = "https://en.wikipedia.org"
val startPage = "/wiki/Main_Page"
val linkRegex = """\"/wiki/[a-zA-Z\-_]+\"""".r


def getLinks(html: String): Set[String] =
  linkRegex.findAllMatchIn(html).map(_.toString.replace("\"", "")).toSet

def getHttp(url: String) = {
  val in = Source.fromURL(domain + url, "utf8")
  val response = in.getLines.mkString
  in.close()
  response
}

val links = getLinks(getHttp(startPage))
links.foreach(println)
println(links.size)

val allLinks = time(links.par.flatMap(link => getLinks(getHttp(link))))
println(allLinks.size)

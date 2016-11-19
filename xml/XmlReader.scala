import xml.XML

object XmlReader {
  def main(args: Array[String]): Unit = {
    XML.loadFile("company.xml") match {
      case <employee> { employees @ _* } </employee> => {
        for(e <- employees) {
          println("First Name: " + (e \ "firstname").text)
          println("Last Name: " + (e \ "lastname").text)
        } 
      }
    }
  }
}
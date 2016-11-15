import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date

/**
  * Created by hendisantika on 11/11/16.
  */
object Date {
  def main(args: Array[String]): Unit = {
    val dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    var submittedDateConvert = new Date()
    var submittedAt = dateFormatter.format(submittedDateConvert)
    println("submittedAt : " + submittedAt)
    println()


    //    val timestamp = new Timestamp(new java.util.Date("2016-11-15 17:38:25"))

    //    val tgl: Date = "2016-11-11 18:34:01"
    val date = new java.util.Date()
    val timestamp = new java.sql.Timestamp(date.getTime())
    println("timestamp : " + timestamp)

    val time2 = new Timestamp(new java.util.Date().getTime())
    println("time2 : " + time2)

  }
}
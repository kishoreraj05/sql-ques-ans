package expedia

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Scrap extends App {
  val map = new mutable.HashMap[String, String]()
  map.keys
  map.values
  map.clone()
  val list = new ListBuffer[String]
  list.clone()
  map.values.toSeq.distinct
  map.foreach(pair => {
    pair._1
  })
  val str = "sfaa"
  println(str.charAt(0).toString)
}

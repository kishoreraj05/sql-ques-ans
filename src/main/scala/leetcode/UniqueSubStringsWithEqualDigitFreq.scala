package leetcode

import scala.collection.mutable

/**
 * Ques. 2168
 * Given a digit string s, return the number of unique substrings of s where every digit appears the same number of times.
 *
 *
 * Example 1:
 *
 * Input: s = "1212"
 * Output: 5
 * Explanation: The substrings that meet the requirements are "1", "2", "12", "21", "1212".
 * Note that although the substring "12" appears twice, it is only counted once.
 * Example 2:
 *
 * Input: s = "12321"
 * Output: 9
 * Explanation: The substrings that meet the requirements are "1", "2", "3", "12", "23", "32", "21", "123", "321".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of digits.
 */
object UniqueSubStringsWithEqualDigitFreq extends App {
  println(s"1212 = ${if (equalDigitFrequency("1212") == 5) "pass" else "fail"}")
  println(s"12321 = ${if (equalDigitFrequency("12321") == 9) "pass" else "fail"}")
  def equalDigitFrequency(s: String): Int = {
    val sarr = s.split("")
    var i = 0
    val set = new mutable.HashSet[String]()

    while (i < sarr.length) {
      var j = i + 1
      var str = sarr(i)
      var ndcMap = new mutable.HashMap[String, Int]()
      ndcMap.put(str, 1)
      val map = new mutable.HashMap[String, mutable.HashMap[String, Int]]()
      set.add(str)
      while (j < sarr.length) {
        val ch = sarr(j)
        ndcMap = ndcMap.clone()
        if (ndcMap.contains(ch)) {
          ndcMap.put(ch, ndcMap(ch) + 1)
        } else {
          ndcMap.put(ch, 1)
        }
        str = s"$str$ch"
        map.put(str, ndcMap)
        //println(map)
        j += 1
      }
      map.foreach(pair => {
        val values = pair._2.values
        if (values.toSeq.distinct.length == 1) {
          set.add(pair._1)
        }
      })
      i += 1
    }
    //println(set)
    set.size
  }
}

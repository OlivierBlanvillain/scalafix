package scalafix.rewrite

import scalafix.Failure
import scalafix.Scalafix

class NoPredefSuite extends RewriteSuite(NoPredef) {
  check(
    "Seq",
    """
      |object Test {
      |  val s: Seq[Int] = Seq(1, 2, 3)
      |}""".stripMargin,
    """
      |object Test {
      |  val s: scala.collection.immutable.Seq[Int] = scala.collection.immutable.Seq(1, 2, 3)
      |}""".stripMargin
  )
}

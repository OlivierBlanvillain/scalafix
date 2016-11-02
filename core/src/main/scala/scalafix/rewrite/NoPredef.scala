package scalafix.rewrite

import scala.meta._
import scala.meta.tokens.Token.Comment
import scala.meta.tokens.Token.LeftBrace
import scala.meta.tokens.Token.RightBrace
import scala.meta.tokens.Token.RightParen
import scala.meta.tokens.Token.Space
import scalafix.util.Patch

case object NoPredef extends Rewrite {
  override def rewrite(ast: Tree, ctx: RewriteCtx): Seq[Patch] = {
    import ctx.tokenList._
    ast.collect {
      case a @ t"Seq" => Patch(a.tokens.head, a.tokens.last, "scala.collection.immutable.Seq")
      case a @ q"Seq" => Patch(a.tokens.head, a.tokens.last, "scala.collection.immutable.Seq")
    }
  }
}

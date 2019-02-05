package au.id.ah.doc2text

import org.htmlparser.Parser
import org.htmlparser.beans.StringBean
import org.htmlparser.lexer.Lexer

object Html2Text {
  def apply(text: String): String = {
    if (text == null || text.length == 0)
      return ""

    val stringBean = {
      val b = new StringBean
      b.setLinks(false)
      b.setReplaceNonBreakingSpaces(true)
      b.setCollapse(true)
      b
    }

    new Parser(new Lexer(text)).visitAllNodesWith(stringBean)

    val plainText = stringBean.getStrings
    if (plainText != null)
      plainText
    else
      text
  }
}

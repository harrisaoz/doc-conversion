package au.id.ah.doc2text

import com.rtfparserkit.converter.text.StringTextConverter
import com.rtfparserkit.parser.RtfStringSource

object Rtf2Text {
  private val converter = new StringTextConverter

  def apply(text: String): String = {
    val rtfToken = """{\rtf"""
    val rtfTokenLength = rtfToken.length

    if (text == null)
      ""
    else if (text.length < rtfTokenLength)
      text
    else if (!text.substring(0, rtfTokenLength).equalsIgnoreCase(rtfToken))
      text
    else {
      converter.convert(new RtfStringSource(text))
      converter.getText
    }
  }
}

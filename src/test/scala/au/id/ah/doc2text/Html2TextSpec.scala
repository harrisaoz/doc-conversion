package au.id.ah.doc2text

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Html2TextSpec extends Specification {
  "Html2Text should leave empty text as is" in {
    Html2Text("") shouldEqual ""
  }
  "Html2Text should return empty string when given null" in {
    Html2Text(null) shouldEqual ""
  }
  "Html2Text should be identity for invalid HTML" in {
    Html2Text("""<ht<stuff""") shouldEqual """<ht<stuff"""
  }
  "Html2Text should strip rtf markup from rtf document text" in {
    val text = """<html><body>This is poor HTML document text.</body></html>"""
    val plainText = Html2Text(text)
    plainText.shouldEqual("This is poor HTML document text.")
  }
}

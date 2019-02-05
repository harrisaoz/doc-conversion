package au.id.ah.doc2text

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Rtf2TextSpec extends Specification {
  "Rtf2Text should leave empty text as is" in {
    Rtf2Text("") shouldEqual ""
  }
  "Rtf2Text should return empty string when given null" in {
    Rtf2Text(null) shouldEqual ""
  }
  "Rtf2Text should be identity for text shorter than the rtf header" in {
    Rtf2Text("""{\rt""") shouldEqual """{\rt"""
  }
  "Rtf2Text should be identity for text not beginning with the rtf header" in {
    val text = """{\rtabcdef{\rtf"""
    Rtf2Text(text) shouldEqual text
  }
  "Rtf2Text should strip rtf markup from rtf document text" in {
    val text = """{\rtf1This is valid RTF document text.}"""
    val plainText = Rtf2Text(text)
    plainText.shouldEqual("This is valid RTF document text.")
  }
}

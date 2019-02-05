package au.id.ah.doc2text

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConverterSpec extends Specification {
  "Empty .html text should be converted to empty" in {
    ConverterFactory.fileExtensionBasis(".html")("").shouldEqual("")
  }
  "Empty .rtf text should be converted to empty" in {
    ConverterFactory.fileExtensionBasis(".rtf")("").shouldEqual("")
  }
  "Non-html .html text should not be converted" in {
    ConverterFactory.fileExtensionBasis(".html")(">bad#html/>").shouldEqual(">bad#html/>")
  }
  "Non-rtf .rtf text should not be converted" in {
    ConverterFactory.fileExtensionBasis(".rtf")(">bad#rtf/>").shouldEqual(">bad#rtf/>")
  }
}

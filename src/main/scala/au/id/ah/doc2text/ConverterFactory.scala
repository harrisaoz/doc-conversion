package au.id.ah.doc2text

object ConverterFactory {
  def fileExtensionBasis(fileExtension: String): String => String = fileExtension.toLowerCase match {
    case ext if List(".html", ".htm").contains(ext) =>
      Html2Text.apply
    case ext if List("", ".rtf").contains(ext) =>
      Rtf2Text.apply
    case _ =>
      identity
  }
}

import freemarker.template.Configuration
import freemarker.template.Template
import java.io.StringWriter
import java.util.*

class ApplicationFreemarkerStyle {
  companion object {
    @JvmStatic public fun main(args: Array<String>) {
      val configuration = Configuration()
      configuration.setClassForTemplateLoading(ApplicationFreemarkerStyle.javaClass, "/")

      try {
        val helloTemplate = configuration.getTemplate("hello.ftl")
        val writer = StringWriter()
        val helloMap = HashMap<String, String>()
        helloMap.putIfAbsent("name", "Pablo")

        helloTemplate.process(helloMap, writer)

        System.out.println(writer)

      } catch (e: Exception) {
        e.printStackTrace()
      }

    }
  }
}

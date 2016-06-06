import freemarker.template.Configuration
import spark.Spark
import java.io.StringWriter
import java.util.*

class ApplicationSparkFreemarkerStyle {

  companion object {
    @JvmStatic fun main(args: Array<String>) {
      val configuration = Configuration()
      configuration.setClassForTemplateLoading(ApplicationFreemarkerStyle.javaClass, "/")

      Spark.get("/", { request, response ->
        val writer = StringWriter()

        try {
          val helloTemplate = configuration.getTemplate("hello.ftl")

          val helloMap = HashMap<String, String>()
          helloMap.putIfAbsent("name", "Pablo")

          helloTemplate.process(helloMap, writer)

          System.out.println(writer)

        } catch (e: Exception) {
          e.printStackTrace()
        }

        writer
      })
    }

  }

}
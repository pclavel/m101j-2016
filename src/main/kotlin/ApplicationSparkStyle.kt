import freemarker.template.Configuration
import spark.Route
import spark.Spark

class ApplicationSparkStyle {

  companion object {
    @JvmStatic public fun main(args: Array<String>) {
      Spark.get("/", Route { request, response ->
        "Hello, World"
      })
    }

  }

}
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.ReadPreference
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Sorts

class HW2_3 {

  companion object {
    @JvmStatic fun main(args: Array<String>){
      val client = MongoClient(MongoClientURI("mongodb://localhost:27017"))

      val db = client.getDatabase("students").withReadPreference(ReadPreference.secondary())

      val col = db.getCollection("grades")

      val filters = Filters.eq("type", "homework")
      val sort = Sorts.ascending("student_id","score")

      var currentStudent_id = -1
      col.find(filters).sort(sort).forEach { document ->
        val newStudent_id = document.getInteger("student_id")
        if (currentStudent_id != newStudent_id) {
          currentStudent_id = newStudent_id
          col.deleteOne(Filters.eq("_id",document.getObjectId("_id")))
        }
      }
    }

  }
}
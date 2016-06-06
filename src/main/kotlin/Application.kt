import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.ReadPreference

class Application {

  companion object {
    @JvmStatic fun main(args: Array<String>){
      val client = MongoClient(MongoClientURI("mongodb://localhost:27017"))

      val db = client.getDatabase("test").withReadPreference(ReadPreference.secondary())

    }

  }
}
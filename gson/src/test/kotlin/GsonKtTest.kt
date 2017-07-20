import com.google.gson.Gson
import org.junit.Assert
import org.junit.Test
import java.net.URL

data class Post(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String,
        val nonExists: String
)

class GsonKtTest {
    @Test
    fun `parsing JSON`() {
        // GIVEN
        val readText = URL("https://jsonplaceholder.typicode.com/posts").readText()
        val gson = Gson()

        // WHEN
        val list = gson.fromJson<List<Post>>(readText)

        // THEN
        Assert.assertFalse(list.isEmpty())
    }
}


import com.example.learnwell.Post
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface LearnWellApi {
    @POST("/api/posts/")
    suspend fun createPost(@Body post: Post): Response<Post>
}


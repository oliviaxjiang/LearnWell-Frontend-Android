import com.example.learnwell.Course
import com.example.learnwell.Post
import com.example.learnwell.User
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface LearnWellApi {
    @GET("/api/courses/")
    suspend fun getAllCourses(): Response<List<Course>>

    @POST("/api/courses/")
    suspend fun createCourse(@Body course: Course): Response<Course>

    @POST("/api/users/")
    suspend fun createUser(@Body user: User): Response<User>

    @DELETE("/api/users/{user_id}")
    suspend fun deleteUser(@Path("user_id") userId: Int): Response<Unit>

    @POST("/api/courses/{course_id}/add/")
    suspend fun addUserToCourse(@Path("course_id") courseId: Int, @Body user: User): Response<Unit>

    @POST("/api/posts/")
    suspend fun createPost(@Body post: Post): Response<Post>
}



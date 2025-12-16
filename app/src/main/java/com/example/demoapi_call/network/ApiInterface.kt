
import com.example.demoapicall_setup.main_screen.model.DemoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun demoData(): Response<DemoResponse>
}
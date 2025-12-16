
import com.example.demoapicall_setup.main_screen.model.DemoResponse
import retrofit2.Response

class Repository {
    val mApiService = APIClient().getClient().create(ApiInterface::class.java)

    suspend fun getData(): Response<DemoResponse> {
        return mApiService.demoData()
    }
}
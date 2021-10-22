

import com.example.assignment_006.model.RS
import com.example.coroutines.api.Constant.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET


interface RealEstateAPI {
    @GET(ENDPOINT)
    suspend fun getRealEstate(

    ): Response<RS>

}
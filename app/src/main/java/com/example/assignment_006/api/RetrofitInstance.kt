

import com.example.coroutines.api.Constant.Companion.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {



    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: RealEstateAPI by lazy {
        retrofit.create(RealEstateAPI::class.java)
    }
}
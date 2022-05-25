package co.tiagoaguiar.tutorial.jokerappdev.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object HTTPClient {
    private const val  BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
    const val API_KEY = "61c09a1e-8bcd-4176-a84b-e2759d1ca480"
    private fun httpClient() : OkHttpClient {
        val logging =HttpLoggingInterceptor()
        logging.level =HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()


    }

    fun retrofit() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient())
            .build()

}
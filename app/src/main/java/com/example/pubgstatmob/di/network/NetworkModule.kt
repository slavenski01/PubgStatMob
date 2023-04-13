package com.example.pubgstatmob.di.network

import com.example.pubgstatmob.data.api.ApiConsts
import com.example.pubgstatmob.data.api.StatPlayerApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(httpLoggingInterceptor)
        okHttpBuilder.addInterceptor(Interceptor { chain ->
            val original: Request = chain.request()

            val request: Request = original.newBuilder()
                .header("Authorization", "Bearer ${ApiConsts.API_KEY}")
                .header("Accept", "application/vnd.api+json")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        })

        return Retrofit.Builder().baseUrl(ApiConsts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpBuilder.build())
            .build()
    }

    @Singleton
    @Provides
    fun providePlayerStatApi(retrofit: Retrofit): StatPlayerApi {
        return retrofit.create(StatPlayerApi::class.java)
    }
}
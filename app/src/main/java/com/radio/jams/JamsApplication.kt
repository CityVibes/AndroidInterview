package com.radio.jams

import android.app.Application
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit

@ExperimentalSerializationApi
class JamsApplication : Application() {

    private val apiModule = module {
        single<GithubApi> {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(MediaType.get("application/json")))
                .build()

            retrofit.create(GithubApi::class.java)
        }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JamsApplication)
            modules(apiModule)
        }
    }
}

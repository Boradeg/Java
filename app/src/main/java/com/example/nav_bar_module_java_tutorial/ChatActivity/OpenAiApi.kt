package com.example.nav_bar_module_java_tutorial

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiApi {
    @Headers("Content-Type: application/json", "Authorization: Bearer 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")
    @POST("chat/completions")
    fun getChatCompletion(@Body request: ChatRequest): Call<ChatResponse>
}

//git remote add origin https://github.com/Boradeg/OpenAiModule.git

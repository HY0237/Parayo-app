package com.example.parayo.api

import com.example.parayo.api.request.ProductRegistrationRequest
import com.example.parayo.api.request.SigninRequest
import com.example.parayo.api.request.SignupRequest
import com.example.parayo.api.response.ApiResponse
import com.example.parayo.api.response.ProductImageUploadResponse
import com.example.parayo.api.response.ProductListItemResponse
import com.example.parayo.api.response.SigninResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ParayoApi {

    @GET("/api/v1/hello")
    suspend fun hello(): ApiResponse<String>

    @POST("/api/v1/users")
    suspend fun signup(@Body signupRequest: SignupRequest): ApiResponse<Void>

    @POST("/api/v1/signin")
    suspend fun signin(@Body signinRequest: SigninRequest): ApiResponse<SigninResponse>

    @Multipart
    @POST("/api/v1/product_images")
    suspend fun uploadProductImages(@Part images: MultipartBody.Part): ApiResponse<ProductImageUploadResponse>

    @POST("/api/v1/products")
    suspend fun registerProduct(@Body request: ProductRegistrationRequest): ApiResponse<Response<Void>>


    @GET("/api/v1/products")
    suspend fun getProducts(
        @Query("productId") productId: Long,
        @Query("categoryId") categoryId: Int?,
        @Query("direction") direction: String, // prev,next
        @Query("keyword") keyword: String? = null
    ): ApiResponse<List<ProductListItemResponse>>


    companion object {
        val instance = ApiGenerator()
            .generate(ParayoApi::class.java)
    }
}
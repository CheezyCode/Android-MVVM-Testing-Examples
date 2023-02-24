package com.cheezycode.mvvmtest.repository

import com.cheezycode.mvvmtest.api.ProductsAPI
import com.cheezycode.mvvmtest.models.ProductListItem
import com.cheezycode.mvvmtest.utils.NetworkResult

class ProductRepository(private val productsAPI: ProductsAPI) {

    suspend fun getProducts(): NetworkResult<List<ProductListItem>> {
        val response = productsAPI.getProducts()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error("Something went wrong")
            }
        } else {
            NetworkResult.Error("Something went wrong")
        }
    }
}
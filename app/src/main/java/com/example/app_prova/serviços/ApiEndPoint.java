package com.example.app_prova.serviços;

import com.example.app_prova.entidads.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("droidcafe")
    Call<List<Product>> obterProdutos();

}

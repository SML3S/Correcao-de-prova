package com.example.app_prova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.app_prova.entidads.Product;
import com.example.app_prova.serviços.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView icecream_circle;
    private TextView donut_circle;
    private  TextView froyo_circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icecream_circle=findViewById(R.id.text_icecream_circle);
        donut_circle = findViewById(R.id.text_donut_circle);
        froyo_circle= findViewById(R.id.text_froyo_circle);
        buscaDados();

    }

    private void buscaDados() {
        RetrofitService.getServico().obterProdutos().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> lista = response.body();
                icecream_circle.setText(lista.get(0).getProduto()+" "+ lista.get(0).getDescricao()+"\n Valor:"+lista.get(0).getValor());
                donut_circle.setText(lista.get(1).getProduto()+" "+ lista.get(1).getDescricao()+"\n Valor:"+lista.get(1).getValor());
                froyo_circle.setText(lista.get(2).getProduto()+" "+ lista.get(2).getDescricao()+"\n Valor:"+lista.get(2).getValor());
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {       }
        });
    }

}

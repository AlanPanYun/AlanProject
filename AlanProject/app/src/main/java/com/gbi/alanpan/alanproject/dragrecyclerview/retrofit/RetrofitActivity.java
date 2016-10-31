package com.gbi.alanpan.alanproject.dragrecyclerview.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import com.gbi.alanpan.alanproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by alan.pan on 2016/10/31.
 */
public class RetrofitActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mWebView = (WebView) findViewById(R.id.web_view);

        initRetrofit();
    }

    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestService requestService = retrofit.create(RequestService.class);
        Call<String> call = requestService.getSearchBooks("小王子", "", 0, 3);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("alan", response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }
}

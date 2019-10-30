package com.example.moviecatalogue.api;

import com.example.moviecatalogue.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public final static String URL = BuildConfig.BASE_URL;

    public ApiService init() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl httpUrl = request.url().newBuilder()
                                .addQueryParameter("api_key", BuildConfig.API_KEY)
                                .build();
                        request = request.newBuilder().url(httpUrl).build();
                        return chain.proceed(request);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        return retrofit.create(ApiService.class);
    }


}

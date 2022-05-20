package com.example.tushudome.data;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.tushudome.data.model.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchAllBooks {
    private List<Book> books = new ArrayList<>();
    boolean flag = false;

    public SearchAllBooks(){

    }

    public List<Book> searchAllBooks(){
        String url = "http:/10.0.2.2:8080/TushuManger/book/selectAll";

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String result = response.body().string();
                books = JSON.parseObject(result,new TypeReference<ArrayList<Book>>(){});
                flag = true;
            }
        });
        while (!flag){
            System.out.println("search");
        };
        return books;
    }


    public List<Book> getBooks() {
        return books;
    }
}

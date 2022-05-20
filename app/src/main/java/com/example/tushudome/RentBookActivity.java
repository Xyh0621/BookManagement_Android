package com.example.tushudome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.tushudome.data.LoginRepository;
import com.example.tushudome.data.model.Book;
import com.example.tushudome.data.model.Borrow;
import com.example.tushudome.data.model.Reader;
import com.example.tushudome.databinding.ActivityRentBookBinding;
import com.example.tushudome.ui.BooksFragment.BooksFragment;

import java.io.IOException;
import java.text.SimpleDateFormat;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RentBookActivity extends AppCompatActivity {
    private ActivityRentBookBinding binding;
    private Book book;
    private Reader user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRentBookBinding.inflate(getLayoutInflater());
        book = (Book) getIntent().getSerializableExtra("Rentbook");
        user = LoginRepository.instance.getUser();


        final TextView bkID = binding.contentBkID;
        final TextView bkName = binding.contentBkName;
        final TextView bkAuthor = binding.contentBkAuthor;
        final TextView bkPress = binding.contentBkPress;
        final TextView bkDatePress = binding.contentBkDatePress;
        final TextView bkPages = binding.contentBkPages;
        final TextView bkPrice = binding.contentBkPrice;
        final TextView bkDateln = binding.contentBkDateln;
        final TextView bkState = binding.contentBkState;
        final TextView bkBrief = binding.contentBkBrief;
        final Button LendBook = binding.buttonlendbook;

        bkID.setText(String.valueOf(book.getBkID()));
        bkName.setText(book.getBkName());
        bkAuthor.setText(book.getBkAuthor());
        bkPress.setText(book.getBkPress());
        bkDatePress.setText(new SimpleDateFormat("yyyy-MM-dd").format(book.getBkDatePress()));
        bkPages.setText(String.valueOf(book.getBkPages()));
        bkPrice.setText(String.valueOf(book.getBkPrice()));
        bkDateln.setText(new SimpleDateFormat("yyyy-MM-dd").format(book.getBkDateln()));
        bkState.setText(String.valueOf(book.getBkStatusStr()));
        bkBrief.setText(book.getBkBrief());


        System.out.println(book);
        System.out.println(user);

        setContentView(binding.getRoot());

        LendBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Borrow borrow = new Borrow();
                borrow.setRdID(Integer.parseInt(LoginRepository.instance.getUser().getRdID()));
                borrow.setBkID(book.getBkID());
                String s = JSON.toJSONString(borrow);
                System.out.println(s);

                String url = "http:/10.0.2.2:8080/TushuManger/borrow/RentBook";
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
                Request request = new Request.Builder().post(body).url(url).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        String result = response.body().string();
                        Looper.prepare();
                        if (result.equals("success")){
                            Toast.makeText(getApplicationContext(),"还书成功",Toast.LENGTH_SHORT).show();
                        }
                        Looper.loop();
                    }
                });
                Intent intent = new Intent(RentBookActivity.this,UserActivity.class);
                intent.putExtra("fragment",2);
                startActivity(intent);
            }
        });
    }
}
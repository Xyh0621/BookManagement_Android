package com.example.tushudome.data;

import android.os.Message;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.example.tushudome.data.model.Reader;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 处理身份验证的类 w/ 登录凭据并检索用户信息。
 */
public class LoginDataSource {

    public Result<Reader> login(String username, String password) {
        final Reader[] user = new Reader[1];
        final boolean[] flag = new boolean[1];
        flag[0] = true;


        try {
            // TODO: 处理Reader身份验证
            Reader fakeUser = new Reader();
            fakeUser.setRdID(username);
            fakeUser.setRdPwd(password);

            String s = JSON.toJSONString(fakeUser);
//            System.out.println(s);

            String url = "http:/10.0.2.2:8080/TushuManger/reader/LoginUser";

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
            Request request = new Request.Builder().post(body).url(url).build();
            Call call = okHttpClient.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    System.out.println(e);
                    flag[0] = false;
                }
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String result = response.body().string();
                    result=result.substring(1,result.length()-1);
                    System.out.println(result);
                    user[0] = JSON.parseObject(result, Reader.class);
                    System.out.println(user[0]);
                    flag[0] = false;
                }
            });
            while (flag[0]);
            if (user[0] == null){
                return new Result.Error(null);
            }
            else {
                return new Result.Success(user[0]);
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: 撤销认证
    }
}
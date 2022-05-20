package com.example.tushudome.ui.login;

import androidx.annotation.Nullable;


/**
 * 登陆后用户返回的结果：成功和出现的错误信息
 */

class LoginResult {
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error){
        this.error = error;
    }

    LoginResult(@Nullable LoggedInUserView success){
        this.success =success;
    }

    @Nullable
    LoggedInUserView getSuccess(){
        return success;
    }

    @Nullable
    Integer getError(){
        return error;
    }
}

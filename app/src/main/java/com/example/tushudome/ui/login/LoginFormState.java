package com.example.tushudome.ui.login;

import androidx.annotation.Nullable;

/**
 * 登录界面的表单信息
 */

public class LoginFormState {
    @Nullable
    private Integer rdIDError;
    @Nullable
    private Integer rdPwdError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer rdIDError,@Nullable Integer rdPwdError){
        this.rdIDError = rdIDError;
        this.rdPwdError = rdPwdError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid){
        this.rdIDError = null;
        this.rdPwdError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getRdIDError(){
        return rdIDError;
    }

    @Nullable
    Integer getRdPwdError(){
        return rdPwdError;
    }

    boolean isDataValid(){
        return isDataValid;
    }
}

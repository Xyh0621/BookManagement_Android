package com.example.tushudome.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tushudome.R;
import com.example.tushudome.data.LoginRepository;
import com.example.tushudome.data.Result;
import com.example.tushudome.data.model.Reader;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState(){
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult(){
        return loginResult;
    }

    public void login(String rdID,String rdPwd) {
//        调用登录存储类的login方法完成登录
        Result<Reader> result = loginRepository.login(rdID,rdPwd);
   //根据不同的返回结果（成功或失败），得到不同的登录结果（result）
        if (result instanceof Result.Success) {
            Reader data = ((Result.Success<Reader>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getRdName())));
        }else{
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    /**
     * 判断用户名和密码是否填写正确，并且给LoginFormState返回正确的状态
     * @param rdID
     * @param rdPwd
     */
    public void loginDataChanged(String rdID,String rdPwd) {
        if(!isRdIDValid(rdID)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username,null));
        }else if (!isRdPwdValid(rdPwd)){
            loginFormState.setValue(new LoginFormState(null,R.string.invalid_password));
        }else  {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    /**
     * 判断用户名是否为9位并且不为空
     * @param rdID
     * @return
     */
    private boolean isRdIDValid(String rdID){
        return rdID!=null&&rdID.trim().length()==9;
    }

    /**
     * 判断用户密码是否为大于五位
     * @param rdPwd
     * @return
     */
    private boolean isRdPwdValid(String rdPwd){
        return rdPwd!=null&&rdPwd.trim().length()>5;
    }
}

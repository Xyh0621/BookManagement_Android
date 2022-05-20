package com.example.tushudome.ui.login;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tushudome.R;
import com.example.tushudome.UserActivity;
import com.example.tushudome.data.SearchAllBooks;
import com.example.tushudome.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel =  new ViewModelProvider(this,new LoginViewModelFactory()).get(LoginViewModel.class);

        final EditText rdIDEditText = binding.LoginRdID;
        final EditText rdPwdEditTExt = binding.LoginRdPwd;
        final Button loginButton = binding.buttonLogin;
        final Button ResigsterButton = binding.buttonResigster;
        final TextView textView = binding.textView;

        /**
         * 当表单状态发生改变时就自动执行onChanged函数告诉用户信息是否正确
         */
        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getRdIDError()!=null){
                    rdIDEditText.setError(getString(loginFormState.getRdIDError()));
                }
                if (loginFormState.getRdPwdError()!=null) {
                    rdPwdEditTExt.setError(getString(loginFormState.getRdPwdError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(LoginResult loginResult) {
                if (loginResult == null){
                    return;
                }
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());

                }
                if (loginResult.getSuccess() != null) {
                    updateUIWithUser(loginResult.getSuccess());
                    Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                    startActivity(intent);

                }
            }
        });

        /**
         * 设置输入框监听器，将rdIDEditText和rdPwdEditText添加监听器
         */
        TextWatcher afterTextChangedLister = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(rdIDEditText.getText().toString(),rdPwdEditTExt.getText().toString());
            }
        };
        rdIDEditText.addTextChangedListener(afterTextChangedLister);
        rdPwdEditTExt.addTextChangedListener(afterTextChangedLister);

        /**
         * 登录按键监听事件
         */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(rdIDEditText.getText().toString(),rdPwdEditTExt.getText().toString());
            }
        });
        
        ResigsterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SearchAllBooks searchAllBooks = new SearchAllBooks();
            }
        });
    }

    private void  updateUIWithUser(LoggedInUserView model) {
        String welcome =getString(R.string.welcome ) + model.getDisplayName();
        Toast.makeText(getApplicationContext(),welcome,Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(),errorString,Toast.LENGTH_SHORT).show();
    }

}

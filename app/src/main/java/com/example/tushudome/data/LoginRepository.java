package com.example.tushudome.data;


import com.example.tushudome.data.model.Reader;

/**
 * 从远程数据源请求身份验证和用户信息并维护登录状态和用户凭据信息的内存缓存的类。
 */
public class LoginRepository {

    public static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // 如果用户凭据将缓存在本地存储中
    // @see https://developer.android.com/training/articles/keystore
    private Reader user = null;


    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if(instance == null){
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public Reader getUser() {
        return user;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(Reader user) {
        this.user = user;
        // 用户凭据将缓存在本地存储中
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<Reader> login(String username, String password) {
        // handle login

        Result<Reader> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<Reader>) result).getData());
        }
        return result;
    }
}
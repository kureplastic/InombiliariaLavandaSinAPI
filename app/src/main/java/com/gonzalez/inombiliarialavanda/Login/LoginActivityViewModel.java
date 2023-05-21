package com.gonzalez.inombiliarialavanda.Login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.gonzalez.inombiliarialavanda.Menu.MenuActivity;
import com.gonzalez.inombiliarialavanda.modelo.Propietario;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

public class LoginActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> mutableError;
    private ApiClient api;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        mutableError = new MutableLiveData<>();
        api = ApiClient.getApi();
    }
    public MutableLiveData<String> getMutableError() {
        return mutableError;
    }

    public void login(String mail, String pass){
        Propietario user = api.login(mail,pass);
        if(user == null){
            mutableError.setValue("Corrobore usuario y/0 contraseña!");
        }
        else{
            Intent intent = new Intent(context, MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }
}

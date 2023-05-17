package com.gonzalez.inombiliarialavanda.Menu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gonzalez.inombiliarialavanda.modelo.Propietario;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

public class MenuActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> mutableUsuario;;
    public MenuActivityViewModel(@NonNull Application application) {
        super(application);
        mutableUsuario = new MutableLiveData<>();
    }
    public LiveData<Propietario> getMutableUsuario() {
        return mutableUsuario;
    }

    public void obtenerUsuario(){
        mutableUsuario.setValue(ApiClient.getApi().obtenerUsuarioActual());
    }

}

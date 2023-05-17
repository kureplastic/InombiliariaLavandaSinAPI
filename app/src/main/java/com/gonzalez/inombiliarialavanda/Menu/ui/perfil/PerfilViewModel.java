package com.gonzalez.inombiliarialavanda.Menu.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Propietario;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

public class PerfilViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Propietario> mutablePropietario;
    private MutableLiveData<String> mutableError;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        mutablePropietario = new MutableLiveData<>();
        mutableError = new MutableLiveData<>();
        llenarDatos();
    }
    public LiveData<Propietario> getMutablePropietario(){ return mutablePropietario;}
    public LiveData<String> getMutableError(){return mutableError;}
    public void llenarDatos(){
        Propietario propietario = ApiClient.getApi().obtenerUsuarioActual();
        mutablePropietario.setValue(propietario);
    }
    private boolean validarDatos(Propietario propietario){
        if(propietario.getNombre().equals("") ||
                propietario.getApellido().equals("") ||
                propietario.getEmail().equals("") ||
                propietario.getContraseña().equals("") ||
                propietario.getDni().equals(""))
        {
            return false;
        }
        return true;
    }

    public void editarPerfil(Propietario propietario){
        if(validarDatos(propietario)){
            ApiClient api = ApiClient.getApi();
            api.actualizarPerfil(propietario);
            Toast.makeText(context, "USUARIO ACTUALIZADO!", Toast.LENGTH_SHORT).show();
            mutableError.setValue("");
        }else {
            mutableError.setValue("Error, corrobore que todos los campos esten completos");
        }
    }
}
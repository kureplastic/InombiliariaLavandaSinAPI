package com.gonzalez.inombiliarialavanda.Menu.ui.inmuebles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Inmueble;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

import java.util.ArrayList;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> mutableInmuebles;
    private MutableLiveData<String> mutableAviso;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        mutableInmuebles = new MutableLiveData<>();
        mutableAviso = new MutableLiveData<>();
        cargarDatos();
    }

    public LiveData<ArrayList<Inmueble>> getMutableInmuebles(){
        return mutableInmuebles;
    }
    public LiveData<String> getMutableAviso(){
        return mutableAviso;
    }

    private void cargarDatos(){
        ArrayList<Inmueble> inmuebles = ApiClient.getApi().obtnerPropiedades();
        if(inmuebles.isEmpty()){
            mutableAviso.setValue("No dispone de inmuebles registrados");
        }
        else {
            mutableAviso.setValue("Sus inmuebles registrados:");
            mutableInmuebles.setValue(inmuebles);
        }
    }
}
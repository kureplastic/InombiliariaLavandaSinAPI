package com.gonzalez.inombiliarialavanda.Menu.ui.inquilinos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Inmueble;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

import java.util.ArrayList;

public class InquilinosViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> mutableInmueblesAlquilados;
    private MutableLiveData<String> mutableAviso;
    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        mutableAviso = new MutableLiveData<>();
        mutableInmueblesAlquilados = new MutableLiveData<>();
        cargarDatos();
    }

    public LiveData<String> getMutableAviso(){ return mutableAviso; }
    public LiveData<ArrayList<Inmueble>> getMutableInmueblesAlquilados(){ return mutableInmueblesAlquilados; }
    private void cargarDatos(){
        ArrayList<Inmueble> inmueblesAlquilados = ApiClient.getApi().obtenerPropiedadesAlquiladas();
        if(inmueblesAlquilados.isEmpty()){
            mutableAviso.setValue("No dispone de inmuebles alquilados");
        }else{
            mutableAviso.setValue("Sus inmuebles alquilados:");
            mutableInmueblesAlquilados.setValue(inmueblesAlquilados);
        }
    }

}
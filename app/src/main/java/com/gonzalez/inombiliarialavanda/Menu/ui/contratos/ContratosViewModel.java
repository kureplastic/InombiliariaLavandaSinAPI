package com.gonzalez.inombiliarialavanda.Menu.ui.contratos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Inmueble;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

import java.util.ArrayList;

public class ContratosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> mutableInmueblesContratados;
    private MutableLiveData<String> mutableAviso;
    public ContratosViewModel(@NonNull Application application) {
        super(application);
        mutableAviso = new MutableLiveData<>();
        mutableInmueblesContratados = new MutableLiveData<>();
        cargarDatos();
    }

    public LiveData<String> getMutableAviso(){ return mutableAviso; }
    public LiveData<ArrayList<Inmueble>> getMutableInmueblesContratados(){ return mutableInmueblesContratados; }
    private void cargarDatos(){
        ArrayList<Inmueble> inmueblesContratados = ApiClient.getApi().obtenerPropiedadesAlquiladas();
        if(inmueblesContratados.isEmpty()){
            mutableAviso.setValue("No dispone de inmuebles con contrato");
        }else{
            mutableAviso.setValue("Sus inmuebles contratados:");
            mutableInmueblesContratados.setValue(inmueblesContratados);
        }
    }
}
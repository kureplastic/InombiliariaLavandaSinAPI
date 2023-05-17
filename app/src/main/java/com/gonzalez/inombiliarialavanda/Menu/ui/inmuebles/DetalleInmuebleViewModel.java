package com.gonzalez.inombiliarialavanda.Menu.ui.inmuebles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Inmueble;

public class DetalleInmuebleViewModel extends AndroidViewModel {

    private MutableLiveData<Inmueble> mutableInmueble;
    public DetalleInmuebleViewModel(@NonNull Application application) {
        super(application);
        mutableInmueble = new MutableLiveData<>();
    }

    public LiveData<Inmueble> getMutableInmueble(){
        return mutableInmueble;
    }
    public void obtenerDatos(Inmueble inmuebleRecuperado){
        mutableInmueble.setValue(inmuebleRecuperado);
    }
}
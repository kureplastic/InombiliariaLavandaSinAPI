package com.gonzalez.inombiliarialavanda.Menu.ui.inquilinos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Inmueble;
import com.gonzalez.inombiliarialavanda.modelo.Inquilino;

public class DetalleInquilinoViewModel extends AndroidViewModel {
    private MutableLiveData<Inquilino> mutableInquilino;
    public DetalleInquilinoViewModel(@NonNull Application application) {
        super(application);
        mutableInquilino = new MutableLiveData<>();
    }
    public LiveData<Inquilino> getMutableInquilino(){ return mutableInquilino; }

    public void obtenerDatos(Inquilino inquilinoRecuperado){
        mutableInquilino.setValue(inquilinoRecuperado);
    }
}
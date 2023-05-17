package com.gonzalez.inombiliarialavanda.Menu.ui.contratos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gonzalez.inombiliarialavanda.modelo.Contrato;
import com.gonzalez.inombiliarialavanda.modelo.Pago;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

import java.util.ArrayList;

public class DetallePagosViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Pago>> mutablePagos;
    private MutableLiveData<String> mutableAviso;

    public DetallePagosViewModel(@NonNull Application application) {
        super(application);
        mutablePagos = new MutableLiveData<>();
        mutableAviso = new MutableLiveData<>();
    }
    public LiveData<ArrayList<Pago>> getMutablePagos(){ return mutablePagos;}
    public LiveData<String> getMutableAviso(){ return mutableAviso;}

    public void obtenerDatos(Contrato contrato){
        ArrayList<Pago> pagos = ApiClient.getApi().obtenerPagos(contrato);
        if(pagos.size()>0){
            mutablePagos.setValue(pagos);
            mutableAviso.setValue("Pagos registrados: "+ pagos.size());
        }else{
            mutableAviso.setValue("No hay pagos registrados");
        }
    }
}
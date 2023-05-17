package com.gonzalez.inombiliarialavanda.Menu.ui.contratos;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.gonzalez.inombiliarialavanda.R;
import com.gonzalez.inombiliarialavanda.modelo.Contrato;
import com.gonzalez.inombiliarialavanda.modelo.Pago;
import com.gonzalez.inombiliarialavanda.request.ApiClient;

import java.util.ArrayList;

public class DetalleContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> mutableContrato;
    private Context context;

    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
        mutableContrato = new MutableLiveData<>();
        context = application.getApplicationContext();
    }
    public LiveData<Contrato> getMutableContrato(){ return mutableContrato;}

    public void obtenerDatos(Contrato contrato){
        mutableContrato.setValue(contrato);
    }

    public void VerPagos(){
        Bundle bndl = new Bundle();
        ArrayList<Pago> pagos = ApiClient.getApi().obtenerPagos(getMutableContrato().getValue());
        bndl.putSerializable("pagos",pagos);
        Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_menu).navigate(R.id.nav_detallePagos,bndl);
    }
}
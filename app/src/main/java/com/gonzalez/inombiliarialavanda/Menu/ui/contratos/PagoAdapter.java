package com.gonzalez.inombiliarialavanda.Menu.ui.contratos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gonzalez.inombiliarialavanda.R;
import com.gonzalez.inombiliarialavanda.modelo.Inmueble;
import com.gonzalez.inombiliarialavanda.modelo.Pago;

import java.util.ArrayList;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Pago> pagos;
    public PagoAdapter(Context context,ArrayList<Pago> pagos, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
        this.pagos = pagos;
    }
    @NonNull
    @Override
    public PagoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= inflater.inflate(R.layout.item_pago,parent,false);
        return new PagoAdapter.ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull PagoAdapter.ViewHolder holder, int position) {
        //por cada item hacer lo siguiente
        holder.tvImportePago.setText("$" + pagos.get(position).getImporte());
        holder.tvFechaPago.setText(pagos.get(position).getFechaDePago());
        holder.tvNroPago.setText(pagos.get(position).getNumero() + "");
    }

    @Override
    public int getItemCount() {
        return pagos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNroPago, tvFechaPago, tvImportePago;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNroPago = itemView.findViewById(R.id.tvNroPago);
            tvFechaPago = itemView.findViewById(R.id.tvFechaPago);
            tvImportePago = itemView.findViewById(R.id.tvImportePago);
        }
    }
}

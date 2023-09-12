package br.edu.ifsp.dmo.app04sorteador.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.dmo.app04sorteador.R;

public class Adapter extends ArrayAdapter<Integer> {

    public Adapter(Context context, List<Integer> list){
        super(context, R.layout.layout_personalizado, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_personalizado, null);
        }

        ((TextView)convertView.findViewById(R.id.textview_posicao)).setText(String.valueOf(position + 1));
        ((TextView)convertView.findViewById(R.id.textview_numero_sorteado)).setText(String.valueOf(getItem(position)));
        return convertView;
    }
}

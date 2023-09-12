package br.edu.ifsp.dmo.app04sorteador.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.ifsp.dmo.app04sorteador.R;
import br.edu.ifsp.dmo.app04sorteador.model.Adapter;
import br.edu.ifsp.dmo.app04sorteador.model.Sorteio;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Sorteio sorteio;
    private Button sortearButton;
    private Button definirLimiteButton;
    private EditText limiteEditText;
    private TextView saidaTextView;
    private TextView limiteTextView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findById();
        setClick();
        sorteio = new Sorteio();
        updateUI();
    }

    @Override
    public void onClick(View v) {
        if (v == definirLimiteButton){
            int limite;
            try {
                limite = Integer.parseInt(limiteEditText.getText().toString());
            } catch (NumberFormatException e){
                limite = -1;
            }
            sorteio = limite > 1 ? new Sorteio(limite) : new Sorteio();
            updateUI();
        }else if(v == sortearButton){
            String string = String.format("%d", sorteio.getNumber());
            saidaTextView.setText(string);
            updateList();
        }
    }

    private void updateList() {
        ArrayAdapter<Integer> adapter = new Adapter(
                this, sorteio.getHistory()
        );
        listView.setAdapter(adapter);
    }

    private void updateUI() {
        String string = String.format(
                "Intervalo de 1 a %,d.", sorteio.getHighBorder()
        );
        limiteTextView.setText(string);
        limiteEditText.setText("");
        saidaTextView.setText(getString(R.string.inicie_o_sorteio));
        updateList();
    }

    private void setClick() {
        sortearButton.setOnClickListener(this);
        definirLimiteButton.setOnClickListener(this);
    }

    private void findById() {
        sortearButton = findViewById(R.id.btn_sortear);
        definirLimiteButton = findViewById(R.id.btn_usar_limite);
        limiteEditText = findViewById(R.id.edit_limit);
        saidaTextView = findViewById(R.id.textview_saida);
        limiteTextView = findViewById(R.id.textview_intervalo);
        listView = findViewById(R.id.list_sorteados);
    }
}
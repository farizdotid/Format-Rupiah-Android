package com.app.formatrupiah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etHarga;
    private Button btnFormat;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btnFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String harga = etHarga.getText().toString();
                if (TextUtils.isEmpty(harga)){
                    Toast.makeText(MainActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String resultRupiah = "Harga : " + formatRupiah(Double.parseDouble(harga));
                    tvResult.setText(resultRupiah);
                }
            }
        });
    }

    private void initComponents(){
        etHarga = findViewById(R.id.etHarga);
        btnFormat = findViewById(R.id.btnFormat);
        tvResult = findViewById(R.id.tvResult);
    }

    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }
}
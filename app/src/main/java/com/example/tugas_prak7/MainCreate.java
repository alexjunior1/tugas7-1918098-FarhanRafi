package com.example.tugas_prak7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ewarna, Eberat;
    private String Snama, Swarna, Sberat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_namabarang);
        Ewarna = (EditText) findViewById(R.id.create_warna);
        Eberat = (EditText) findViewById(R.id.create_berat);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Swarna = String.valueOf(Ewarna.getText());
                Sberat = String.valueOf(Eberat.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi warna",
                            Toast.LENGTH_SHORT).show();
                } else if (Sberat.equals("")) {
                    Eberat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi berat",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Ewarna.setText("");
                    Eberat.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateBarang (new Barang(null, Snama, Swarna, Sberat));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}


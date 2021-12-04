package com.example.tugas_prak7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Swarna, Sberat;
    private EditText Enama, Ewarna, Eberat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Swarna = i.getStringExtra("Iwarna");
        Sberat = i.getStringExtra("Iberat");

        Enama = (EditText) findViewById(R.id.updel_namabarang);
        Ewarna = (EditText) findViewById(R.id.updel_warna);
        Eberat = (EditText) findViewById(R.id.updel_berat);
        Enama.setText(Snama);
        Ewarna.setText(Swarna);
        Eberat.setText(Sberat);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Swarna = String.valueOf(Ewarna.getText());
                Sberat = String.valueOf(Eberat.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna",
                            Toast.LENGTH_SHORT).show();
                } else if (Sberat.equals("")){
                    Eberat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBarang(new Barang(Sid, Snama, Swarna, Sberat));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBarang (new Barang(Sid, Snama, Swarna, Sberat));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}


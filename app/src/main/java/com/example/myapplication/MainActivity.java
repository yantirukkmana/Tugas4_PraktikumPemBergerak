package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener {
    EditText inpNama, inpNpm;
    RadioGroup rbgrup, rbgrup1;
    RadioButton laki, perempuan, direktur, manager, programer;
    Button btnNext, btnCancel;
    String putJK, putJabatan,putGaji, nama, npm, jk, jabatan, gaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Tugas 4");

        btnNext     = (Button) findViewById(R.id.btnNext);
        btnCancel   = (Button) findViewById(R.id.btnCancel);
        inpNama     = (EditText) findViewById(R.id.inpNama);
        inpNpm      = (EditText) findViewById(R.id.inpNpm);
        laki        = (RadioButton) findViewById(R.id.laki);
        laki.setOnClickListener(null);
        perempuan   = (RadioButton) findViewById(R.id.perempuan);
        perempuan.setOnClickListener(null);
        rbgrup      = (RadioGroup) findViewById(R.id.rbgrup);
        rbgrup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        manager     = (RadioButton) findViewById(R.id.manager);
        manager.setOnClickListener(null);
        direktur    = (RadioButton) findViewById(R.id.direktur);
        direktur.setOnClickListener(null);
        programer   = (RadioButton) findViewById(R.id.programer);
        rbgrup1     = (RadioGroup) findViewById(R.id.rbgrup1);
        rbgrup1.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inpNama.setText("");
                inpNpm.setText("");
                rbgrup.clearCheck();
                rbgrup1.clearCheck();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama    = inpNama.getText().toString();
                npm     = inpNpm.getText().toString();
                jk      = putJK.toString();
                jabatan = putJabatan.toString();
                gaji    = putGaji.toString();

                if (nama.equals("") || npm.equals("") || jk.equals("") || jabatan.equals("")) {
                    Toast.makeText(MainActivity.this, "Semua Data Harus Diisi !", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(MainActivity.this, out_put.class);
                    i.putExtra("nama", nama);
                    i.putExtra("npm", npm);
                    i.putExtra("jk", jk);
                    i.putExtra("jabatan", jabatan);
                    i.putExtra("gaji", gaji);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
        if (laki.isChecked()) {
            putJK = "Pria";
        }
        if (perempuan.isChecked()) {
            putJK = "Wanita";
        }
        if (direktur.isChecked()) {
            putJabatan = "Direktur";
            putGaji = "Rp 20.000.000";
        }
        if (manager.isChecked()) {
            putJabatan = "Manager";
            putGaji = "Rp 10.000.000";
        }
        if (programer.isChecked()) {
            putJabatan = "Programer";
            putGaji = "Rp 5.000.000";
        }
    }
}

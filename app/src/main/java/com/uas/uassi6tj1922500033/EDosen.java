package com.uas.uassi6tj1922500033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import java.util.HashMap;

public class EDosen extends AppCompatActivity {
    private Button btnSimpan,btnClear;
    private EditText txtNIDN,txtNmDosen,txtJabatan,txtGolPang,txtKeahlian,txtProdi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edosen);
        txtNIDN = (EditText) findViewById(R.id.txtNIDN);
        txtNmDosen = (EditText) findViewById(R.id.txtNmDosen);
        txtJabatan = (EditText) findViewById(R.id.txtJabatan);
        txtGolPang = (EditText) findViewById(R.id.txtGolPang);
        txtKeahlian = (EditText) findViewById(R.id.txtKeahlian);
        txtProdi = (EditText) findViewById(R.id.txtProdi);

        btnSimpan=findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String Enidn = txtNIDN.getText().toString().trim();
                final String Enama_dosen = txtNmDosen.getText().toString().trim();
                final String Ejabatan = txtJabatan.getText().toString().trim();
                final String Egol_pang = txtGolPang.getText().toString().trim();
                final String Ekeahlian = txtKeahlian.getText().toString().trim();
                final String Eprogram_studi = txtProdi.getText().toString().trim();

                class tambahDosen extends AsyncTask<Void, Void, String>{
                    ProgressDialog load;
                    @Override
                    protected void onPreExecute(){
                        super.onPreExecute();
                        load = ProgressDialog.show(
                                EDosen.this, "Add...","Wait...",false,false );
                    }
                    @Override
                    protected String doInBackground(Void... v){
                        HashMap<String,String> params = new HashMap<>();
                        params.put("nidn",Enidn);
                        params.put("nama_dosen",Enama_dosen);
                        params.put("jabatan", Ejabatan);
                        params.put("gol_pang",Egol_pang);
                        params.put("keahlian",Ekeahlian);
                        params.put("program_studi",Eprogram_studi);

                        RequestHandler rh = new RequestHandler();
                        String res = rh.sendPostRequest("http://10.117.120.55/Api/tambah_dtLecturer.php",params);
                        return res;
                    }
                    @Override
                    protected void onPostExecute(String s){
                        super.onPostExecute(s);
                        load.dismiss();
                        Toast.makeText(EDosen.this,s,Toast.LENGTH_LONG).show();
                    }
                }
                tambahDosen add = new tambahDosen();
                add.execute();
            }
        });
        btnClear=findViewById(R.id.BtnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNIDN.setText("");
                txtNmDosen.setText("");
                txtJabatan.setText("");
                txtGolPang.setText("");
                txtKeahlian.setText("");
                txtProdi.setText("");
            }
        });
    }

}
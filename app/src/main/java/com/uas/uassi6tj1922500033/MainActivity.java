package com.uas.uassi6tj1922500033;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    public TextView viewDataResult;
    private FloatingActionButton floatingActionButton;
    private DosenHolderApi jsonPlaceHolderAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,EDosen.class);
                startActivity(i);
            }
        });
        viewDataResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.117.120.55/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolderAPI = retrofit.create(DosenHolderApi.class);
        getPosts();
    }



    private void getPosts(){
        Map<String, String> parameters = new HashMap<>();
        Call<List<PostDosen>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<PostDosen>>() {
            @Override
            public void onResponse(Call<List<PostDosen>> call, Response<List<PostDosen>> response){
                if(!response.isSuccessful()){
                    viewDataResult.setText("code: "+ response.code());
                    return;
                }
                List<PostDosen> posts = response.body();
                for (PostDosen post:posts){
                    String content = "";
                    content += "NIDN: " +post.get_nidn() + "\n";
                    content += "Nama: " +post.get_Nama_Dosen() + "\n";
                    content += "Jabatan: " +post.get_Jabatan() + "\n";
                    content += "Golongan Pangkat: " +post.get_Gol_Pang() + "\n";
                    content += "Keahlian: " +post.get_Keahlian() + "\n";
                    content += "Program Studi: " +post.get_Program_studi() + "\n";
                    content += "======================================\n";
                    viewDataResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<PostDosen>> call, Throwable t){
               viewDataResult.setText(t.getMessage());
            }
        });
    }
}
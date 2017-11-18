package com.example.rajesh.retrofitexmaple;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Datum> data;
    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private LinearLayoutManager linearLayoutManager;
    private InterfaceClass interfaceClass;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        dialog.setMessage("please wait......");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        interfaceClass = SeconActivity.getApiClient().create(InterfaceClass.class);

        Call<List<Datum>> call = interfaceClass.getListData();

        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {

                dialog.dismiss();
                data = response.body();
                adapterClass = new AdapterClass(MainActivity.this, data);
                recyclerView.setAdapter(adapterClass);

            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }
}

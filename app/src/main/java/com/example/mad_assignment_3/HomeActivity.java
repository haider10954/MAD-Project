package com.example.mad_assignment_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_3.API.BackendImpl;
import com.example.mad_assignment_3.model.Company;
import com.example.mad_assignment_3.model.CompanyResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Company> companyList;
    private CompanyAdapter companyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        companyList = new ArrayList<>();
        companyAdapter = new CompanyAdapter(companyList);
        RecyclerView.LayoutManager mLayoutManager = new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(companyAdapter);
        recyclerView.addOnItemTouchListener(new
                RecyclerTouchListener(getApplicationContext(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Company company = companyList.get(position);
                Intent intent = new Intent(getApplicationContext(),
                        CompanyDetails.class);
                intent.putExtra("name",
                        companyList.get(position).name);
                intent.putExtra("location",
                        companyList.get(position).phone);
                intent.putExtra("year",
                        companyList.get(position).description);
                intent.putExtra("address",
                        companyList.get(position).address);
                intent.putExtra("longitude",
                        companyList.get(position).location.getLongitude());
                intent.putExtra("latitude",
                        companyList.get(position).location.getLatitude());
                intent.putExtra("logo",
                        companyList.get(position).logo);
                startActivity(intent);
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        getCompaniesList();
    }
    private void getCompaniesList() {
        
        new Thread(() -> {
            Call<CompanyResponse> call = new BackendImpl(getApplicationContext()).companies();
            call.enqueue(new Callback<CompanyResponse>() {
                @Override
                public void onResponse(Call<CompanyResponse> call, Response<CompanyResponse> response) {
                    CompanyResponse data = response.body();
                    if (data.status) {
                        companyList.addAll(data.data);
                        companyAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<CompanyResponse> call, Throwable t) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Could not register",
                            Toast.LENGTH_LONG
                    ).show();
                }
            });
        }).start();
    }
}
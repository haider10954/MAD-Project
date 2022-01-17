package com.example.mad_assignment_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private final List<Company> companyList = new ArrayList<>();
    private CompanyAdapter companyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
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
                        companyList.get(position).getName());
                intent.putExtra("location",
                        companyList.get(position).getLocation());
                intent.putExtra("year",
                        companyList.get(position).getYear());
                startActivity(intent);
            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        prepareCompanyData();
    }
    @SuppressLint("NotifyDataSetChanged")
    private void prepareCompanyData() {
        Company company = new Company("Company 1", "HAIDER", "2015");
        companyList.add(company);
        company = new Company("Company 2", "SAIF", "2021");
        companyList.add(company);
        company = new Company("Company 3", "HAMZA", "2021");
        companyList.add(company);
        company = new Company("Company 4", "QADIR", "2021");
        companyList.add(company);
        company = new Company("Company 5", "SAHIL", "2021");
        companyList.add(company);
        company = new Company("Company 6", "AFRA", "2021");
        companyList.add(company);
        company = new Company("Company 7", "RAMEEZ", "2000");
        companyList.add(company);
        company = new Company("Company 8", "UMER", "2000");
        companyList.add(company);
        company = new Company("Company 9", "UMAIR", "2000");
        companyList.add(company);
        company = new Company("Company 10", "ALI", "2000");
        companyList.add(company);
        company = new Company("Company 11", "GOHAR", "2000");
        companyList.add(company);
        company = new Company("Company 12", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 13", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 14", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 15", "XYZ", "1990");
        companyList.add(company);
        company = new Company("Company 16", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 17", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 18", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 19", "XYZ", "2000");
        companyList.add(company);
        company = new Company("Company 20", "XYZ", "2000");
        companyList.add(company);
        companyAdapter.notifyDataSetChanged();
    }
}
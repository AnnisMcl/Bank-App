package com.example.mybankapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybankapp.Bank_Activity;
import com.example.mybankapp.User;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    private Customing adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();



        if(!new PreferenceManage(this).isUserLogedOut()) {

            startBankActivity();
        }

        Button button = (Button) findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            final EditText id_recup = (EditText) findViewById(R.id.id_submit);

            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading");
                progressDialog.show();
                GetData service = RetrofitInstance.getRetrofitInstance().create(GetData.class);

                Call<List<User>> call = service.getAllAccounts();
                call.enqueue(new Callback<List<User>>() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                        progressDialog.dismiss();



                        if (response.isSuccessful()) {

                            int i = 0;
                            User client_connect=new User();
                            for (User u : response.body()) {

                                i = i + 1;
                                String str = id_recup.getText().toString();
                                int final_id = Integer.valueOf(str);
                                if (u.getId() == final_id) {
                                    client_connect = u;
                                    saveLoginDetails(id_recup.getText().toString()); //Save the id for the next start
                                    Intent intent = new Intent(MainActivity.this, Bank_Activity.class);
                                    startActivity(intent);
                                }
                            }

                            System.out.println("You're connected as:" + client_connect.getName());

                        }
                        else {
                            System.out.println("Error :     " + response.errorBody());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!",Toast.LENGTH_SHORT).show();
                    }

                });


            }

        });
    }
    private void saveLoginDetails(String id) {
        new PreferenceManage(this).saveLoginDetails(id);
    }
    private void startBankActivity() {
        Intent intent = new Intent(MainActivity.this, Bank_Activity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.ln_20.retrofit.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ln_20.retrofit.R;
import com.example.ln_20.retrofit.adapter.MyAdapter;
import com.example.ln_20.retrofit.api.ApiFactory;
import com.example.ln_20.retrofit.api.ApiInterface;
import com.example.ln_20.retrofit.model.ApiResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    ApiResponse apiResponse;
    TextView longName, shortName;
    private final static String ADDRESS = "3rd&amp;Lindsley";
    RecyclerView recyclerView;
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longName = (TextView) findViewById(R.id.longName);
        shortName = (TextView) findViewById(R.id.shortName);

       /* if (ADDRESS.isEmpty()){
            Toast.makeText(getBaseContext(),"Nothing to display",Toast.LENGTH_SHORT)
                    .show();
        }*/

        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);

        ApiInterface apiInterface = ApiFactory.provideRestAdapter()
                .create(ApiInterface.class);

        Call<JsonObject> call = apiInterface.getResults();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                Log.d(TAG,response.body().toString());



                if (response.isSuccessful()){
                    apiResponse = new Gson().fromJson(response.body(),ApiResponse.class);
//                    List <ApiResponse.AddressComponent> results =
//                            apiResponse.getResults()
//                            .get(0)
//                            .getAddressComponents();

                    json = response.body().toString();

                    recyclerView.setAdapter(new MyAdapter(json));

//                    for(int i = 0; i < results.size() ; i++ ) {
//
//                        longName.setText(results.get(i).getLongName());
//                        shortName.setText(results.get(i).getShortName());
//
//
//                    }


//
                }else {
                    Toast.makeText(getBaseContext(),"Err",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}

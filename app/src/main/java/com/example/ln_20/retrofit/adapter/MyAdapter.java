package com.example.ln_20.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ln_20.retrofit.R;
import com.example.ln_20.retrofit.model.ApiResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ln-20 on 6/2/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String json;
    int i;
    ApiResponse apiResponse;
    StringBuilder builder;
    List<String> value;

    public MyAdapter(String json) {
        this.json = json;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_cards, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.longName.setText(apiResponse.getResults()
                .get(0)
                .getAddressComponents()
                .get(position)
                .getLongName());
        holder.shortName.setText(apiResponse.getResults()
                .get(0)
                .getAddressComponents()
                .get(position)
                .getShortName());

        value = new LinkedList<>();


        value = apiResponse.getResults()
                .get(0)
                .getAddressComponents()
                .get(position)
                .getTypes();

        Log.d("SIZE", String.valueOf(value.size()));

        for (int i = 0; i < value.size(); i++) {
            builder.append(apiResponse.getResults()
                    .get(0)
                    .getAddressComponents()
                    .get(i)
                    .getTypes());
        }

        holder.valueText.setText(builder);

        builder.delete(0, builder.length());


    }

    @Override
    public int getItemCount() {

        apiResponse = new Gson().fromJson(json, ApiResponse.class);
        builder = new StringBuilder();
        apiResponse = new Gson().fromJson(json, ApiResponse.class);
        return apiResponse.getResults().get(0).getAddressComponents().size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView longName, shortName, valueText;

        public MyViewHolder(View itemView) {
            super(itemView);

            longName = (TextView) itemView.findViewById(R.id.longName);
            shortName = (TextView) itemView.findViewById(R.id.shortName);
            valueText = (TextView) itemView.findViewById(R.id.value);
        }
    }
}

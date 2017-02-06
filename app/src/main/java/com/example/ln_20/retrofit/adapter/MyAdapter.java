package com.example.ln_20.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ln_20.retrofit.R;
import com.example.ln_20.retrofit.model.ApiResponse;
import com.google.gson.Gson;

/**
 * Created by ln-20 on 6/2/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String json;
    int i;
    ApiResponse apiResponse;

    public MyAdapter(String json) {
        this.json = json;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_cards,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.longName.setText(apiResponse.getResults()
                .get(1)
                .getAddressComponents()
                .get(position)
                .getLongName());
        holder.shortName.setText(apiResponse.getResults()
                .get(1)
                .getAddressComponents()
                .get(position)
                .getShortName());
    }

    @Override
    public int getItemCount() {

//        return apiResponse.getResults().get(0).getAddressComponents().size();
        apiResponse = new Gson().fromJson(json,ApiResponse.class);
        return apiResponse.getResults().get(1).getAddressComponents().size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView longName , shortName;

        public MyViewHolder(View itemView) {
            super(itemView);

            longName = (TextView) itemView.findViewById(R.id.longName);
            shortName = (TextView) itemView.findViewById(R.id.shortName);
        }
    }



}

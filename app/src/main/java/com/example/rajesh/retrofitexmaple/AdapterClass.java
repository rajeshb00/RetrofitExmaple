package com.example.rajesh.retrofitexmaple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajesh on 11/17/2017.
 */

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private Context context;
    private List<Datum> list = new ArrayList<>();

    public AdapterClass(Context context, List<Datum> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterClass.ViewHolder holder, int position) {

        holder.one.setText(String.valueOf(list.get(position).getUserid()));
        holder.two.setText(String.valueOf(list.get(position).getIdd()));
        holder.three.setText(list.get(position).getTitle());
        holder.four.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView one, two, three, four;

        public ViewHolder(View itemView) {
            super(itemView);

            one = (TextView) itemView.findViewById(R.id.txtUserId);
            two = (TextView) itemView.findViewById(R.id.txtId);
            three = (TextView) itemView.findViewById(R.id.txtTitle);
            four = (TextView) itemView.findViewById(R.id.txtBody);
        }
    }
}

package com.example.mayman.qahwagy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mayman.qahwagy.R;
import com.example.mayman.qahwagy.UserObjs;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mahmo on 3/3/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder>{


    private ArrayList<UserObjs> mProductsModelList;

    public DataAdapter(ArrayList<UserObjs> productsModelArrayList) {
        this.mProductsModelList = productsModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_user_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.bind(mProductsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mProductsModelList != null)
            return mProductsModelList.size();
        else
            return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV,milk,sugar,quantity,size;

        MyViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.textViewNameP);
            milk = itemView.findViewById(R.id.textViewMilk);
            sugar = itemView.findViewById(R.id.textViewSuger);
            quantity = itemView.findViewById(R.id.textViewSize);
            size = itemView.findViewById(R.id.textViewQuan);

        }

        private void bind(final UserObjs productsModel) {

            nameTV.setText(productsModel.getName());
            milk.setText(productsModel.getMilk());
            sugar.setText(productsModel.getSuger());
            size.setText(productsModel.getSize());
            quantity.setText(productsModel.getQuantity());

        }
    }
}

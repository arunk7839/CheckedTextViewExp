package com.example.lenovo.checkedtextviewapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.Toast;


public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.MyViewHolder> {

    private String[] singersName;
    Context context;


    public SingerAdapter(Context context, String[] booknames) {
        this.singersName = booknames;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CheckedTextView simpleCheckedTextView;

        public MyViewHolder(View view) {
            super(view);
            simpleCheckedTextView = (CheckedTextView) view.findViewById(R.id.simpleCheckedTextView);

        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        holder.simpleCheckedTextView.setText(singersName[position]);

        // perform on Click Event Listener on CheckedTextView
        holder.simpleCheckedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean value = holder.simpleCheckedTextView.isChecked();
                if (value) {
                    // set check mark drawable and set checked property to false

                    holder.simpleCheckedTextView.setCheckMarkDrawable(R.drawable.check_ic);
                    holder.simpleCheckedTextView.setChecked(false);
                    Toast.makeText(context, "un-Checked", Toast.LENGTH_LONG).show();
                } else {
                    // set check mark drawable and set checked property to true

                    holder.simpleCheckedTextView.setCheckMarkDrawable(R.drawable.check);
                    holder.simpleCheckedTextView.setChecked(true);
                    Toast.makeText(context, "Checked", Toast.LENGTH_LONG).show();
                }

            }
        });


    }


    @Override
    public int getItemCount() {
        return singersName.length;
    }


}


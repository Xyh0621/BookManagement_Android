package com.example.tushudome.ui.LendBookFragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tushudome.LendBookActivity;
import com.example.tushudome.RentBookActivity;
import com.example.tushudome.data.model.Book;
import com.example.tushudome.databinding.FragmentBooksBinding;

import java.util.List;

public class MyLendBooksRecyclerViewAdapter extends RecyclerView.Adapter<MyLendBooksRecyclerViewAdapter.ViewHolder> {

    private  List<Book> mValues;


    public MyLendBooksRecyclerViewAdapter(List<Book> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentBooksBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getBkID()));
        holder.mContentView.setText(mValues.get(position).getBkName());
        holder.mContentViewBkAuthor.setText(mValues.get(position).getBkAuthor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RentBookActivity.class);
                intent.putExtra("Rentbook", holder.mItem);

                v.getContext().startActivity(intent);
                System.out.println("还书");

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView mIdView;
        public  TextView mContentView;
        public  TextView mContentViewBkAuthor;
        public Book mItem;

        public ViewHolder(FragmentBooksBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            mContentViewBkAuthor = binding.contentBkAuthor;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
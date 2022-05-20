package com.example.tushudome.ui.BooksFragment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tushudome.LendBookActivity;
import com.example.tushudome.UserActivity;
import com.example.tushudome.data.model.Book;
import com.example.tushudome.databinding.FragmentBooksBinding;
import com.example.tushudome.ui.login.LoginActivity;

import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private  List<Book> mValues;


    public MyItemRecyclerViewAdapter(List<Book> items) {
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
                Intent intent = new Intent(v.getContext(), LendBookActivity.class);
                intent.putExtra("lendbook", holder.mItem);

                v.getContext().startActivity(intent);

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
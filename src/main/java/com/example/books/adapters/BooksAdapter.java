package com.example.books.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.books.BookInfoActivity;
import com.example.books.R;
import com.example.books.model.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder>  {

    private List<Book> books;
    private Context context;

    public BooksAdapter(Context context,List<Book> books) {
        this.context=context;
        this.books = books;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        LinearLayout parentlayout;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewItemCover);
            textView = itemView.findViewById(R.id.textViewItemTitle);
            parentlayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_item, parent, false);
        BookViewHolder viewHolder = new BookViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, final int position) {
        Book book = books.get(position);

        holder.imageView.setImageResource(book.getImageResourceId());
        holder.textView.setText(book.getTitle());

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, BookInfoActivity.class);
                intent.putExtra("title", books.get(position).getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}

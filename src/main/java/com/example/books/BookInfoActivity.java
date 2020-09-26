package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.model.BooksData;

public class BookInfoActivity extends AppCompatActivity {
    ImageView imageCover;
    TextView textTitle;
    TextView textAuthors;
    TextView textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        Intent intent = getIntent();
        String title=intent.getStringExtra("title");

        imageCover=findViewById(R.id.imageViewCover);
        textTitle=findViewById(R.id.textViewTitle);
        textAuthors=findViewById(R.id.textViewAuthors);
        textDescription=findViewById(R.id.textViewDescription);

        Book book= BooksData.getBookByTitle(title);
        if(book!=null) {
            imageCover.setImageResource(book.getImageResourceId());
            textTitle.setText(book.getTitle());
            textDescription.setText(book.getDescriprion());
            StringBuilder sb = new StringBuilder();
            for (Author a : book.getAuthors()) {
                sb.append(a);
                sb.append(", ");
            }
            sb.delete(sb.length()-2,sb.length());
            textAuthors.setText(sb.toString());
        }
    }
}

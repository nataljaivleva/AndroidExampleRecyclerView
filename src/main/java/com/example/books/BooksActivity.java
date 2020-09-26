package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.books.adapters.BooksAdapter;
import com.example.books.model.Book;
import com.example.books.model.BooksData;

import java.util.List;

public class BooksActivity extends AppCompatActivity {
    private ListView listViewBooks;
    private TextView textViewCategory;
    private RecyclerView recyclerViewBooks;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        Intent intent= getIntent();
        String category=intent.getStringExtra("category");
        textViewCategory=findViewById(R.id.textViewCategory);
        textViewCategory.setText(String.format(getString(R.string.category_title),category));

        final List<Book> books= BooksData.getBooksByCategory(category);

        if(books.size()>0){
            recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
            recyclerViewBooks.setHasFixedSize(true);
            adapter = new BooksAdapter(this,books);
            layoutManager = new LinearLayoutManager(this);
            recyclerViewBooks.setAdapter(adapter);
            recyclerViewBooks.setLayoutManager(layoutManager);
        } else{
            Toast.makeText(getApplicationContext(),"No books in the category "+category, Toast.LENGTH_LONG).show();
        }
    }
}

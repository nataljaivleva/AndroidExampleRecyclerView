package com.example.books.model;

import com.example.books.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooksData {
    public  static List<Book> books=new ArrayList<>();
    public  static List<Author> authors=new ArrayList<>();
    static{
        authors.add(new Author("Herbert","Schildt"));
        authors.add(new Author("Grant","Allen"));
        authors.add(new Author("Mike","Owens"));

        books.add(new Book("Java: The Complete Reference",
                "Fully updated for Java SE 11, Java: The Complete Reference, Eleventh Edition explains how to develop, compile, debug, and run Java programs. Best-selling programming author Herb Schildt covers the entire Java language, including its syntax, keywords, and fundamental programming principles.",
                "Programming", new Author[]{authors.get(0)}, R.drawable.pr0));
        books.add(new Book("C++: The Complete Reference",
                "Best-selling genius Herb Schildt covers everything from keywords, syntax, and libraries, to advanced features such as overloading, inheritance, virtual functions, namespaces, templates, and RTTI―plus, a complete description of the Standard Template Library (STL)",
                "Programming", new Author[]{authors.get(0)}, R.drawable.pr1));
        books.add(new Book("The Definitive Guide to SQLite. Second Edition",
                "That database is SQLite an embeddable database with an amazingly small footprint, yet able to handle databases of enormous size. SQLite comes equipped with an array of powerful features available through a host of programming and development environments.",
                "Database", new Author[]{authors.get(1), authors.get(2)}, R.drawable.db0));
        books.add(new Book("Beginning DB2: From Novice to Professional",
                "IBM’s DB2 Express Edition is one of the most capable of the free database platforms available in today’s marketplace. In Beginning DB2, author Grant Allen gets you started using DB2 Express Edition for web sites, desktop applications, and more.",
                "Database", new Author[]{authors.get(1)}, R.drawable.db1));
        books.add(new Book("The Definitive Guide to SQLite",
                "This is the first book to devote complete coverage to the most recent release of the popular embedded open source database SQLite.",
                "Database", new Author[]{authors.get(2)}, R.drawable.db2));

    }

    public static List<Book> getBooksByCategory(String category){
        //return books.stream().filter(b->b.getCategory().equals(category)).collect(Collectors.toList());
        List<Book> list=new ArrayList<>();
        for (Book b:books) {
            if(b.getCategory().equals(category)) list.add(b);
        }
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
               return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return list;
    }

    public static Book getBookByTitle(String title){
        for (Book b:books) {
            if(b.getTitle().equals(title)) return b;
        }
        return null;
    }
}

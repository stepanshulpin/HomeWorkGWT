package com.shulpin.server.sort;

import com.shulpin.shared.Book;

import java.util.Collections;
import java.util.List;

public class Sort {

    public static List<Book> exec(String sortedBy, List<Book> books){

        switch (sortedBy){
            case "id":
                Collections.sort(books,Comparators.idComparator);
                break;
            case "nameAuthor":
                Collections.sort(books,Comparators.authorComparator);
                break;
            case "titleBook":
                Collections.sort(books,Comparators.titleComparator);
                break;
            case "pageCount":
                Collections.sort(books,Comparators.pagesComparator);
                break;
            case "publicationYear":
                Collections.sort(books,Comparators.yearComparator);
                break;
            case "addedDate":
                Collections.sort(books,Comparators.addedDateComparator);
                break;
        }
        return books;

    }

}

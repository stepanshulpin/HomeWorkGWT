package com.shulpin.server;

import com.shulpin.server.sort.Sort;
import com.shulpin.shared.Book;
import com.shulpin.shared.ListWithSize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LibraryModel {

    private int lastId;

    public ListWithSize getAllBooks(String sortedBy, int booksOnPage, int page){
        List<Book> books = new ArrayList<>();
        try {
            new FileWriter("12021998library13121996.txt",true);
            File file = new File("12021998library13121996.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            try {
                Integer.valueOf(line);
            }
            catch (NumberFormatException ex){
                createLibrary();
            }
                books = readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortAndPaging(books,sortedBy,booksOnPage,page);

    }


    public ListWithSize deleteBook(int id, String sortedBy, int booksOnPage, int page){
        List<Book> books=readFile();
        for (Book book:books) {
            if(book.getId()==id){books.remove(book); break;}
        }
        writeFile(books);
        return sortAndPaging(books,sortedBy,booksOnPage,page);
    }

    public ListWithSize addBook(Book book, String sortedBy, int booksOnPage, int page){
        List<Book> books=readFile();
        lastId++;
        book.setId(lastId);
        books.add(book);
        writeFile(books);
        return sortAndPaging(books,sortedBy,booksOnPage,page);
    }

    private ListWithSize sortAndPaging(List<Book> books, String sortedBy, int booksOnPage, int page){
        List<Book> result;
        ListWithSize listWithSize = new ListWithSize();
        result=Sort.exec(sortedBy,books);
        listWithSize.setSize(result.size());
        if(page == 1) {
            switch (booksOnPage) {
                case 3:
                    if (result.size() > 3) result = result.subList(0, 3);
                    break;
                case 10:
                    if (result.size() > 10) result = books.subList(0, 10);
                    break;
            }
        }
        else{
            if(booksOnPage*page>result.size()){
                result=result.subList((page-1)*booksOnPage,result.size());
            }
            else{
                result=result.subList((page-1)*booksOnPage,page*booksOnPage);
            }
        }
        listWithSize.setBooks(result);
        return listWithSize;
    }

    private void createLibrary() {
        File file = new File("12021998library13121996.txt");
        FileWriter fileWriter=null;
        try {
            fileWriter = new FileWriter(file,false);
            lastId=5;
            fileWriter.write(String.valueOf(lastId));
            fileWriter.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1").append("###");
        stringBuilder.append("Erich Maria Remarque").append("###");
        stringBuilder.append("Arch of Triumph").append("###");
        stringBuilder.append("455").append("###");
        stringBuilder.append("1945").append("###");
        stringBuilder.append("2015").append("###");
        stringBuilder.append("11").append("###");
        stringBuilder.append("25");
        String data = stringBuilder.toString();
        try {
            fileWriter.write(data);
            fileWriter.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringBuilder = new StringBuilder();
        stringBuilder.append("2").append("###");
        stringBuilder.append("Gabriel Garcia Marquez").append("###");
        stringBuilder.append("One Hundred Years of Solitude").append("###");
        stringBuilder.append("231").append("###");
        stringBuilder.append("1967").append("###");
        stringBuilder.append("2014").append("###");
        stringBuilder.append("07").append("###");
        stringBuilder.append("13");
        data = stringBuilder.toString();
        try {
            fileWriter.write(data);
            fileWriter.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringBuilder = new StringBuilder();
        stringBuilder.append("3").append("###");
        stringBuilder.append("Jack London").append("###");
        stringBuilder.append("Burning Daylight").append("###");
        stringBuilder.append("342").append("###");
        stringBuilder.append("1983").append("###");
        stringBuilder.append("2015").append("###");
        stringBuilder.append("09").append("###");
        stringBuilder.append("02");
        data = stringBuilder.toString();
        try {
            fileWriter.write(data);
            fileWriter.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringBuilder = new StringBuilder();
        stringBuilder.append("4").append("###");
        stringBuilder.append("Jack London").append("###");
        stringBuilder.append("The Call of the Wild").append("###");
        stringBuilder.append("515").append("###");
        stringBuilder.append("1903").append("###");
        stringBuilder.append("2016").append("###");
        stringBuilder.append("01").append("###");
        stringBuilder.append("25");
        data = stringBuilder.toString();
        try {
            fileWriter.write(data);
            fileWriter.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        stringBuilder = new StringBuilder();
        stringBuilder.append("5").append("###");
        stringBuilder.append("Ray Bradbury").append("###");
        stringBuilder.append("Fahrenheit 451").append("###");
        stringBuilder.append("358").append("###");
        stringBuilder.append("1953").append("###");
        stringBuilder.append("2014").append("###");
        stringBuilder.append("11").append("###");
        stringBuilder.append("12");
        data = stringBuilder.toString();
        try {
            fileWriter.write(data);
            fileWriter.write('\n');
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    private void writeFile(List<Book> books) {

        try {
            File file = new File("12021998library13121996.txt");
            FileWriter fw = new FileWriter(file,false);
            fw.write(String.valueOf(lastId));
            fw.write('\n');
            for (Book book : books) {

                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(book.getId()).append("###");
                stringBuilder.append(book.getNameAuthor()).append("###");
                stringBuilder.append(book.getTitleBook()).append("###");
                stringBuilder.append(book.getPageCount()).append("###");
                stringBuilder.append(book.getPublicationYear()).append("###");
                stringBuilder.append(book.getAddedDateYear()).append("###");
                stringBuilder.append(book.getAddedDateMonth()).append("###");
                stringBuilder.append(book.getAddedDateDay());

                String data = stringBuilder.toString();
                fw.write(data);
                fw.write('\n');
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Book> readFile(){
        List<Book> books = new ArrayList<>();
        try {
            File file = new File("12021998library13121996.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            lastId = Integer.valueOf(line);
            line = reader.readLine();
            while (line != null) {
                StringTokenizer stok = new StringTokenizer(line, "###");
                books.add(new Book(Integer.valueOf(stok.nextToken()), stok.nextToken(),stok.nextToken(),Integer.valueOf(stok.nextToken()),
                        Integer.valueOf(stok.nextToken()),Integer.valueOf(stok.nextToken()),Integer.valueOf(stok.nextToken()),
                        Integer.valueOf(stok.nextToken())));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }



}

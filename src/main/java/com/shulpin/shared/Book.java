package com.shulpin.shared;

public class Book {


    private int id;
    private String nameAuthor;
    private String titleBook;
    private int pageCount;
    private int publicationYear;
    private int addedDateYear;
    private int addedDateMonth;
    private int addedDateDay;

    public Book() {
    }

    public Book(int id, String nameAuthor, String titleBook, int pageCount, int publicationYear, int addedDateYear, int addedDateMonth, int addedDateDay) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.titleBook = titleBook;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
        this.addedDateYear = addedDateYear;
        this.addedDateMonth = addedDateMonth;
        this.addedDateDay = addedDateDay;
    }

    public Book(String nameAuthor, String titleBook, Integer pageCount, Integer publicationYear, Integer addedDateYear, Integer addedDateMonth, Integer addedDateDay) {
        this.nameAuthor = nameAuthor;
        this.titleBook = titleBook;
        this.pageCount = pageCount;
        this.publicationYear = publicationYear;
        this.addedDateYear = addedDateYear;
        this.addedDateMonth = addedDateMonth;
        this.addedDateDay = addedDateDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getAddedDateYear() {
        return addedDateYear;
    }

    public void setAddedDateYear(int addedDateYear) {
        this.addedDateYear = addedDateYear;
    }

    public int getAddedDateMonth() {
        return addedDateMonth;
    }

    public void setAddedDateMonth(int addedDateMonth) {
        this.addedDateMonth = addedDateMonth;
    }

    public int getAddedDateDay() {
        return addedDateDay;
    }

    public void setAddedDateDay(int addedDateDay) {
        this.addedDateDay = addedDateDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pageCount != book.pageCount) return false;
        if (publicationYear != book.publicationYear) return false;
        if (addedDateYear != book.addedDateYear) return false;
        if (addedDateMonth != book.addedDateMonth) return false;
        if (addedDateDay != book.addedDateDay) return false;
        if (nameAuthor != null ? !nameAuthor.equals(book.nameAuthor) : book.nameAuthor != null) return false;
        return titleBook != null ? titleBook.equals(book.titleBook) : book.titleBook == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameAuthor != null ? nameAuthor.hashCode() : 0);
        result = 31 * result + (titleBook != null ? titleBook.hashCode() : 0);
        result = 31 * result + pageCount;
        result = 31 * result + publicationYear;
        result = 31 * result + addedDateYear;
        result = 31 * result + addedDateMonth;
        result = 31 * result + addedDateDay;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", titleBook='" + titleBook + '\'' +
                ", pageCount=" + pageCount +
                ", publicationYear=" + publicationYear +
                ", addedDateYear=" + addedDateYear +
                ", addedDateMonth=" + addedDateMonth +
                ", addedDateDay=" + addedDateDay +
                '}';
    }
}

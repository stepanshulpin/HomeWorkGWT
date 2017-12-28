package com.shulpin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.shulpin.shared.Book;
import com.shulpin.shared.ListWithSize;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.Date;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LibraryWithoutDB implements EntryPoint,DialogBoxOpener {

    private InputDialog dialogBox;
    private VerticalPanel mainPanel = new VerticalPanel();
    private HorizontalPanel addAndPagesPanel = new HorizontalPanel();
    private HorizontalPanel pages = new HorizontalPanel();
    private FlexTable booksFlexTable = new FlexTable();
    private Button add = new Button("add");
    private Button show3 = new Button("3");
    private Button show10 = new Button("10");
    private Button showAll = new Button("all");
    private BookService service = GWT.create(BookService.class);
    private String sortedBy="id";
    private int booksOnPage=-1;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        String root = Defaults.getServiceRoot();
        root = root.replace("LibraryWithoutDB/", "");
        Defaults.setServiceRoot(root);
        createTable();
        mainPanel.add(booksFlexTable);
        addAndPagesPanel.add(add);
        addAndPagesPanel.add(new Label("Show:"));
        show3.removeStyleName("gwt-Button");
        show3.addStyleName("numberOfPagesButton");
        addAndPagesPanel.add(show3);
        show10.removeStyleName("gwt-Button");
        show10.addStyleName("numberOfPagesButton");
        addAndPagesPanel.add(show10);
        showAll.removeStyleName("gwt-Button");
        showAll.addStyleName("numberOfPagesButton");
        addAndPagesPanel.add(showAll);
        addAndPagesPanel.add(pages);
        mainPanel.add(addAndPagesPanel);

        show3.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                booksOnPage=3;
                service.getAllBooks(sortedBy,booksOnPage,1,new PagingMethodCallBack());
            }
        });
        show10.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                booksOnPage=10;
                service.getAllBooks(sortedBy,booksOnPage,1,new PagingMethodCallBack());
            }
        });
        showAll.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                booksOnPage=-1;
                service.getAllBooks(sortedBy,booksOnPage,1,new PagingMethodCallBack());
            }
        });

        RootPanel.get("library").add(mainPanel);

        add.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                openInputDialog();

            }
        });

    }




    private void createTable(){

        service.getAllBooks(sortedBy,booksOnPage,1,new MethodCallback<ListWithSize>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("load failed");
            }

            @Override
            public void onSuccess(Method method, ListWithSize listWithSize) {
                drawTable(listWithSize);
            }
        });

    }

    private void drawTable(ListWithSize listWithSize){

        mainPanel.remove(booksFlexTable);
        mainPanel.remove(addAndPagesPanel);
        booksFlexTable=new FlexTable();
        mainPanel.add(booksFlexTable);

        addAndPagesPanel.remove(pages);
        pages=new HorizontalPanel();
        if(booksOnPage!=-1){

            if(listWithSize.getSize()!=0){
                int numberPages=listWithSize.getSize()/booksOnPage;
                if((listWithSize.getSize()%booksOnPage)!=0) numberPages++;

                for(int i=1; i<=numberPages;i++){
                    final int number=i;
                    Button page=new Button(String.valueOf(number));
                    page.removeStyleName("gwt-Button");
                    page.addStyleName("pageButton");
                    page.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent clickEvent) {
                            service.getAllBooks(sortedBy, booksOnPage, number, new MethodCallback<ListWithSize>() {
                                @Override
                                public void onFailure(Method method, Throwable throwable) {
                                    Window.alert("change page fail");
                                }

                                @Override
                                public void onSuccess(Method method, ListWithSize listWithSize) {
                                    drawTable(listWithSize);
                                }
                            });
                        }
                    });
                    pages.add(page);
                }
            }
            addAndPagesPanel.add(pages);
        }
        mainPanel.add(addAndPagesPanel);


        Button id = new Button("Id");
        id.removeStyleName("gwt-Button");
        id.addStyleName("buttonNotSort");
        if(sortedBy.equals("id")) id.addStyleName("buttonSort");
        id.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="id";
                service.getAllBooks(sortedBy,booksOnPage,1, new SortMethodCallBack());
            }
        });
        Button author = new Button("Author");
        author.removeStyleName("gwt-Button");
        author.addStyleName("buttonNotSort");
        if(sortedBy.equals("nameAuthor")) author.addStyleName("buttonSort");
        author.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="nameAuthor";
                service.getAllBooks(sortedBy,booksOnPage,1, new SortMethodCallBack());
            }
        });
        Button title = new Button("Title");
        title.removeStyleName("gwt-Button");
        title.addStyleName("buttonNotSort");
        if(sortedBy.equals("titleBook")) title.addStyleName("buttonSort");
        title.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="titleBook";
                service.getAllBooks(sortedBy,booksOnPage,1, new SortMethodCallBack());
            }
        });
        Button pages = new Button("Pages");
        pages.removeStyleName("gwt-Button");
        pages.addStyleName("buttonNotSort");
        if(sortedBy.equals("pageCount")) pages.addStyleName("buttonSort");
        pages.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="pageCount";
                service.getAllBooks(sortedBy,booksOnPage,1, new SortMethodCallBack());
            }
        });
        Button published = new Button("Published");
        published.removeStyleName("gwt-Button");
        published.addStyleName("buttonNotSort");
        if(sortedBy.equals("publicationYear")) published.addStyleName("buttonSort");
        published.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="publicationYear";
                service.getAllBooks(sortedBy,booksOnPage,1, new SortMethodCallBack());
            }
        });
        Button addDate = new Button("Add date");
        addDate.removeStyleName("gwt-Button");
        addDate.addStyleName("buttonNotSort");
        if(sortedBy.equals("addedDate")) addDate.addStyleName("buttonSort");
        addDate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sortedBy="addedDate";
                service.getAllBooks(sortedBy,booksOnPage,1, new SortMethodCallBack());
            }
        });

        booksFlexTable.setWidget(0, 0, id);
        booksFlexTable.setWidget(0, 1, author);
        booksFlexTable.setWidget(0, 2, title);
        booksFlexTable.setWidget(0, 3, pages);
        booksFlexTable.setWidget(0, 4, published);
        booksFlexTable.setWidget(0, 5, addDate);

        booksFlexTable.getRowFormatter().addStyleName(0,"header");
        booksFlexTable.addStyleName("list");

        for (Book book:listWithSize.getBooks()) {
            addRow(book);
        }

    }



    private void addRow(Book book){
        int row = booksFlexTable.getRowCount();
        booksFlexTable.setText(row,0, String.valueOf(book.getId()));
        booksFlexTable.setText(row,1, book.getNameAuthor());
        booksFlexTable.setText(row,2, book.getTitleBook());
        booksFlexTable.setText(row,3, String.valueOf(book.getPageCount()));
        booksFlexTable.setText(row,4, String.valueOf(book.getPublicationYear()));
        booksFlexTable.setText(row,5, String.valueOf(book.getAddedDateYear())+
                "-"+book.getAddedDateMonth()+"-"+book.getAddedDateDay());
        Button delete = new Button("x");
        delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                service.deleteBook(sortedBy,booksOnPage,1,book.getId(), new MethodCallback<ListWithSize>() {
                    @Override
                    public void onFailure(Method method, Throwable throwable) {
                        Window.alert("delete failed");
                    }

                    @Override
                    public void onSuccess(Method method, ListWithSize listWithSize) {
                        drawTable(listWithSize);
                    }
                });
            }
        });
        booksFlexTable.setWidget(row, 7, delete);
    }


    class PagingMethodCallBack implements MethodCallback<ListWithSize> {

        @Override
        public void onFailure(Method method, Throwable throwable) {
            Window.alert("paging failed");
        }

        @Override
        public void onSuccess(Method method, ListWithSize listWithSize) {
            drawTable(listWithSize);
        }
    }

    class SortMethodCallBack implements MethodCallback<ListWithSize> {

        @Override
        public void onFailure(Method method, Throwable throwable) {
            Window.alert("sort failed");
        }

        @Override
        public void onSuccess(Method method, ListWithSize listWithSize) {
            drawTable(listWithSize);
        }
    }

    private void openInputDialog() {
        dialogBox = new InputDialog();
        dialogBox.setOpener(this);
        dialogBox.center ();
        dialogBox.show();
    }
    @Override
    public void dialogBoxCancelled() {

        service.addBook(sortedBy,booksOnPage,1,new Book(dialogBox.getAuthor(), dialogBox.getTitle(), dialogBox.getPagesCount(), dialogBox.getPublishedYear(), new Date().getYear() + 1900, new Date().getMonth() + 1, new Date().getDate()), new MethodCallback<ListWithSize>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("add failed");
            }

            @Override
            public void onSuccess(Method method, ListWithSize listWithSize) {
                drawTable(listWithSize);
            }
        });

    }
}

package com.shulpin.server;


import com.shulpin.shared.Book;
import com.shulpin.shared.ListWithSize;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class LibraryService {

    private LibraryModel libraryModel = new LibraryModel();

    @GET
    @Path("/{sortedBy}/{booksOnPage}/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public ListWithSize getAllBooks(@PathParam("sortedBy") String sortedBy, @PathParam("booksOnPage")int booksOnPage,@PathParam("page")int page){
        return libraryModel.getAllBooks(sortedBy,booksOnPage,page);
    }

    @DELETE
    @Path("/delete/{id}/{sortedBy}/{booksOnPage}/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public ListWithSize deleteBook(@PathParam("id") int id,@PathParam("sortedBy") String sortedBy,@PathParam("booksOnPage")int booksOnPage,@PathParam("page")int page){
        return libraryModel.deleteBook(id, sortedBy,booksOnPage,page);
    }

    @POST
    @Path("/add/{sortedBy}/{booksOnPage}/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ListWithSize addBook(@PathParam("sortedBy") String sortedBy,@PathParam("booksOnPage")int booksOnPage,@PathParam("page")int page, Book book){
        return libraryModel.addBook(book, sortedBy,booksOnPage,page);
    }



}

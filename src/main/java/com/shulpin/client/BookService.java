package com.shulpin.client;

import com.shulpin.shared.Book;
import com.shulpin.shared.ListWithSize;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("lib/books")
public interface BookService extends RestService {

    @GET
    @Path("/{sortedBy}/{booksOnPage}/{page}")
    void getAllBooks(@PathParam("sortedBy") String sortedBy,@PathParam("booksOnPage")int booksOnPage,@PathParam("page")int page, MethodCallback<ListWithSize> callback);


    @DELETE
    @Path("/delete/{id}/{sortedBy}/{booksOnPage}/{page}")
    void deleteBook(@PathParam("sortedBy") String sortedBy,@PathParam("booksOnPage")int booksOnPage,@PathParam("page")int page, @PathParam("id") int id, MethodCallback<ListWithSize> callback);

    @POST
    @Path("/add/{sortedBy}/{booksOnPage}/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    void addBook(@PathParam("sortedBy") String sortedBy,@PathParam("booksOnPage")int booksOnPage,@PathParam("page")int page, Book book, MethodCallback<ListWithSize> callback);

}
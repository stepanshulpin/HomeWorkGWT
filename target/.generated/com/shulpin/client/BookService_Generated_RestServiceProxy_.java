package com.shulpin.client;

public class BookService_Generated_RestServiceProxy_ implements com.shulpin.client.BookService, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("lib/books");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void addBook(java.lang.String sortedBy, int booksOnPage, int page, com.shulpin.shared.Book book, org.fusesource.restygwt.client.MethodCallback<com.shulpin.shared.ListWithSize> callback) {
    final java.lang.String final_sortedBy = sortedBy;
    final int final_booksOnPage = booksOnPage;
    final int final_page = page;
    final com.shulpin.shared.Book final_book = book;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/add/"+(sortedBy== null? null : com.google.gwt.http.client.URL.encodePathSegment(sortedBy))+"/"+(""+booksOnPage== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+booksOnPage))+"/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, "application/json");
    __method.json(com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE.encode(book));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.shulpin.shared.ListWithSize>(__method, callback) {
        protected com.shulpin.shared.ListWithSize parseResult() throws Exception {
          try {
            return com.shulpin.shared.ListWithSize_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void deleteBook(java.lang.String sortedBy, int booksOnPage, int page, int id, org.fusesource.restygwt.client.MethodCallback<com.shulpin.shared.ListWithSize> callback) {
    final java.lang.String final_sortedBy = sortedBy;
    final int final_booksOnPage = booksOnPage;
    final int final_page = page;
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/delete/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"/"+(sortedBy== null? null : com.google.gwt.http.client.URL.encodePathSegment(sortedBy))+"/"+(""+booksOnPage== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+booksOnPage))+"/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.shulpin.shared.ListWithSize>(__method, callback) {
        protected com.shulpin.shared.ListWithSize parseResult() throws Exception {
          try {
            return com.shulpin.shared.ListWithSize_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getAllBooks(java.lang.String sortedBy, int booksOnPage, int page, org.fusesource.restygwt.client.MethodCallback<com.shulpin.shared.ListWithSize> callback) {
    final java.lang.String final_sortedBy = sortedBy;
    final int final_booksOnPage = booksOnPage;
    final int final_page = page;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(sortedBy== null? null : com.google.gwt.http.client.URL.encodePathSegment(sortedBy))+"/"+(""+booksOnPage== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+booksOnPage))+"/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.shulpin.shared.ListWithSize>(__method, callback) {
        protected com.shulpin.shared.ListWithSize parseResult() throws Exception {
          try {
            return com.shulpin.shared.ListWithSize_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}

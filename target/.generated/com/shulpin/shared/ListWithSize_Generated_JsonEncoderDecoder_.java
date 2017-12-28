package com.shulpin.shared;

public class ListWithSize_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.shulpin.shared.ListWithSize> {
  
  public static final ListWithSize_Generated_JsonEncoderDecoder_ INSTANCE = new ListWithSize_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.shulpin.shared.ListWithSize value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.shulpin.shared.ListWithSize parseValue = (com.shulpin.shared.ListWithSize)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toJSON(parseValue.getBooks(), com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE), rc, "books");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getSize()), rc, "size");
    return rc;
  }
  
  public com.shulpin.shared.ListWithSize decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.shulpin.shared.ListWithSize rc = new com.shulpin.shared.ListWithSize();
    rc.setBooks(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(object.get("books"), com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE), null));
    rc.setSize(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("size")), 0));
    return rc;
  }
  
}

package com.aytsnw.models;

public class Transaction {
    private String type;
    private Integer userId;
    private Integer bookId;
    private String timestamp;

    public void setType(String type) {this.type = type;}
    public void setUserId(Integer id){this.userId = id;}
    public void setBookId(Integer id){this.bookId = id;}
    public void setTimestamp(String timestamp) {this.timestamp = timestamp;}

    public String getType() {return type;}
    public Integer getUserId() {return userId;}
    public Integer getBookId() {return bookId;}
    public String getTimestamp() {return timestamp;}
}

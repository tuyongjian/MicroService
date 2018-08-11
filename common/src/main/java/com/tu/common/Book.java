package com.tu.common;

import java.io.Serializable;

/**
 * Created by tuyongjian on 2018/8/9.
 */
public class Book implements Serializable {

    private String name;

    private String price;

    private String author;

    private String publisher;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

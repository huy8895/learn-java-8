package com.training.java_8.reflectionvsanotation;

import java.util.List;

/**
 *  lớp chứa thông tin cửa hàng sách.
 */
@XmlRootElement(name = "bookStore", namespace = "com.training.annotation")
public class BookStore {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "location")
    private String location;

    @XmlElementWrapper(name = "bookList")
    private List<Book> bookList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}

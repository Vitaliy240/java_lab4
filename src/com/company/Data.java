package com.company;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private String title;
    private List<Phone> phones = new ArrayList<>();

    public Data() {
    }

    public Data(String title, List<Phone> phones) {
        super();
        this.title = title;
        this.phones = phones;
    }

    public void add(Phone phone){
        phones.add(phone);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Data{");
        sb.append("title='").append(title).append('\'');
        sb.append(", phones=").append(phones);
        sb.append('}');
        return sb.toString();
    }
}

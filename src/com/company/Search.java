package com.company;

public class Search {

    private boolean status;
    private Data data;

    public Search() {
    }

    public Search(boolean status, Data data) {
        super();
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Search{");
        sb.append("status=").append(status);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }

}

package com.company;

import java.util.Comparator;
public class Phone {

    private String phoneName;
    private String slug;
    private int hits;
    private String detail;

    public Phone() {
    }

    public Phone(String phoneName, String slug, int hits, String detail) {
        super();
        this.phoneName = phoneName;
        this.slug = slug;
        this.hits = hits;
        this.detail = detail;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nPhone{");
        sb.append("phoneName='").append(phoneName).append('\'');
        sb.append(", slug='").append(slug).append('\'');
        sb.append(", hits=").append(hits);
        sb.append(", detail='").append(detail).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static Comparator<Phone> byNameAsc = Comparator.comparing(o -> o.phoneName);
    public static Comparator<Phone> byNameDesc = (o1, o2) -> o2.phoneName.compareTo(o1.phoneName);
    public static Comparator<Phone> byValueAsc = (o1, o2) -> o1.hits > o2.hits ? 1 : o1.hits < o2.hits ? -1 : 0;
    public static Comparator<Phone> byValueDesc = (o1, o2) -> o1.hits < o2.hits ? 1 : o1.hits > o2.hits ? -1 : 0;

}
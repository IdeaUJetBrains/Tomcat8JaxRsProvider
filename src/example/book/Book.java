package example.book;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private BigDecimal price;
    private Calendar published;

    public void setPublished(Calendar published) {
        this.published = published;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setId(String id) {

        this.id = id;
    }

    public Calendar getPublished() {

        return published;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public String getTitle() {

        return title;
    }

    public String getId() {

        return id;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    // getter+setter..
}

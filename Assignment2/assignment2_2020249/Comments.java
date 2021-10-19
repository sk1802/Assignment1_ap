import java.util.*;
public class Comments {
    private String comments;
    private String id;
    private Date date;

    Comments(String comments,String id) {
        this.comments = comments;
        this.id = id;
        this.date = new Date();
    }


    public String getComments() {
        return this.comments;
    }

    public String getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }
}

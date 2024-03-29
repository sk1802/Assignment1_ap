public class book implements Comparable<book>
{   
    private int rnum;
    private String title;
    private String ISBN;
    private String barcode;
    
    book(String ti,String isbn,String barc){
        this.ISBN=isbn;
        this.barcode=barc;
        this.title=ti;
    }

    @Override
    public int compareTo(book o) {
        String t=this.title.concat(this.ISBN).concat(this.barcode);
        String to=o.title.concat(o.ISBN).concat(o.barcode);
        return t.compareTo(to);
    }

    public void setrnum(int rnum) {
        this.rnum=rnum;
    }

    public int getrnum() {
        return this.rnum;
    }
    public String getBarcode() {
        return barcode;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
    
}

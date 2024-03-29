import java.util.*;

public class library {
    private static ArrayList<book> allbooks=new ArrayList<>();

    public static int addbook(Object obj){
        if(obj instanceof book){
            book b=(book)obj;
        for(int i=0;i<allbooks.size();i++){
            if(allbooks.get(i).getBarcode().equals(b.getBarcode())){
                System.out.println("Two books with the same barcode can not be added");
                return 0;
            }
            // if(allbooks.get(i).getTitle().concat(allbooks.get(i).getISBN()).concat(allbooks.get(i).getBarcode()).
            // equals(b.getTitle().concat(b.getISBN()).concat(b.getBarcode()))){
            //     System.out.println("This book is already present in the library");
            //     return 0;
            // }
        }
        allbooks.add(b);
        return 1;
        }
        else
         return 0;
    }

    public static void printallbooks(int bpr){
        int racknumber=1;
        while(racknumber<=allbooks.size()/bpr){
            System.out.print("Rack number " + racknumber+" => ");
            for(int i=(racknumber-1)*bpr; i<(racknumber-1)*(bpr)+bpr;i++){
                allbooks.get(i).setrnum(racknumber);
                System.out.print(allbooks.get(i).getTitle()+", "+allbooks.get(i).getISBN()+", "+allbooks.get(i).getBarcode());
            }
            System.out.println();
            racknumber++;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books");
        int nb=Integer.parseInt(sc.nextLine());
        System.out.println("Enter number of racks");
        int racks=Integer.parseInt(sc.nextLine());
        int bpr=nb/racks;
        int in=0;
        while(in<nb){
            System.out.println("Enter title of book "+ (in+1));
            String title=sc.nextLine();

            System.out.println("Enter ISBN of book "+ (in+1));
            String ISBN=sc.nextLine();
            // if(ISBN.length()!=13){
            //     System.out.println("ISBN numbers are 13 digit numbers");
            //     continue;
            // }
            System.out.println("Enter barcode of book"+ (in+1) );
            String barcode=sc.nextLine();
            // if(barcode.length()<12){
            //     System.out.println("Barcodes are of length 12");
            //     continue;
            // }

            book b=new book(title, ISBN,barcode);
            in+=addbook(b);
        }

        // for(int i=0;i<allbooks.size();i++){
        //     System.out.println(allbooks.get(i).getTitle()+" "+allbooks.get(i).getISBN()+" "+allbooks.get(i).getBarcode());
        // }
        Collections.sort(allbooks);
        printallbooks(bpr);
        // for(int i=0;i<allbooks.size();i++){
        //     System.out.println(allbooks.get(i).getTitle()+" "+allbooks.get(i).getISBN()+" "+allbooks.get(i).getBarcode());
        // }
        while(true){
        System.out.println("Search image by following methods \n1. using name \n2. using ISBN and name \n3. using name ISBN and barcode \n4 exit ");
        int chm=Integer.parseInt(sc.nextLine());
        if(chm==1){
            System.out.println("Enter book name");
            String bname=sc.nextLine();
            for(int i=0;i<allbooks.size();i++){
                if(bname.equals(allbooks.get(i).getTitle())){
                    System.out.println("Book is placed in rack number "+ allbooks.get(i).getrnum());
                }
            }
        }
        if(chm==2){
            System.out.println("Enter book name");
            String bname=sc.nextLine();
            System.out.println("Enter ISBN number");
            String bisbn=sc.nextLine();
            for(int i=0;i<allbooks.size();i++){
                if(bname.equals(allbooks.get(i).getTitle()) && bisbn.equals(allbooks.get(i).getISBN())){
                    System.out.println("Book is placed in rack number "+ allbooks.get(i).getrnum());
                }
            }
        }
        if(chm==3){
            System.out.println("Enter book name");
            String bname=sc.nextLine();
            System.out.println("Enter ISBN number");
            String bisbn=sc.nextLine();
            System.out.println("Enter Barcode number");
            String barcode=sc.nextLine();
            for(int i=0;i<allbooks.size();i++){
                if(bname.equals(allbooks.get(i).getTitle()) && bisbn.equals(allbooks.get(i).getISBN()) && barcode.equals(allbooks.get(i).getBarcode())){
                    System.out.println("Book is placed in rack number "+ allbooks.get(i).getrnum());
                }
            }
        }
        if(chm==4){
            break;
        }
        }


        sc.close();  
    }
    
}

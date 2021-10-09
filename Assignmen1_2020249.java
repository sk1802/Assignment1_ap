import java.util.*;

public class Assignment1_2020249 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<vaccine> allvacs=new ArrayList<>();
        ArrayList<Hospital> allhosp=new ArrayList<>();
        ArrayList<Citizen> allcitizen=new ArrayList<>();
        System.out.println("CoWin Portal initialized....");
        while(true){
            System.out.println("---------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            int ch=sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Vaccine Name ");
                    String name=sc.next();
                    System.out.print("Enter Number of Doses ");
                    int doses=sc.nextInt();
                    int Gap;
                    if(doses==1){
                        Gap=0;
                    }
                    else{
                    System.out.print("Enter the Gap Between the Doses ");
                    Gap=sc.nextInt();
                    }
                    vaccine v=new vaccine(name, doses, Gap);
                    allvacs.add(v);
                    break;

                case 2:
                    System.out.print("Enter Hospital Name ");
                    String Hname=sc.next();
                    System.out.print("Enter Pincode ");
                    int Pincode=sc.nextInt();
                    Hospital h=new Hospital(Hname, Pincode);
                    allhosp.add(h);
                    break;

                case 3:
                    System.out.print("Enter Citizen Name ");
                    String cname=sc.next();
                    
                    System.out.print("Enter Age of the citizen ");
                    int age=sc.nextInt();
                    System.out.print("Enter the Uniques ID");
                    String Uid=sc.next();
                    System.out.println("Citizen name: "+cname+", age: "+age+", Unique ID: "+Uid);
                    if(age<18){
                        System.out.println("Age below 18 Not allowed");
                        break;
                    }

                    Citizen c=new Citizen(cname, age, Uid);
                    allcitizen.add(c);
                    break;
                case 4:
                    System.out.println("Enter the hospital id");
                    int hid=sc.nextInt();
                    boolean flag=false;
                    for(int i=0;i<allhosp.size();i++){
                        if(allhosp.get(i).ID()==hid){
                            flag=true;
                            System.out.println("Enter the number of slots");
                            int sl=sc.nextInt();
                            for(int j=0;j<sl;j++){
                                System.out.println("Enter day number");
                                int day=sc.nextInt();
                                System.out.println("Enter quantity");
                                int q=sc.nextInt();
                                System.out.println("Select Vaccine");
                                for(int x=0;x<allvacs.size();x++){
                                    System.out.println(x+" "+allvacs.get(x).name());
                                }
                                int Vchoice=sc.nextInt();
                                slot s=new slot(day, q, allvacs.get(Vchoice).name());
                                allhosp.get(i).addslot(s);
                                System.out.println("Slot added by hospital "+hid+" for Day: "+day+", Available quantity "+q+" of Vaccine " +allvacs.get(Vchoice).name());


                            }
                        }
                    }
                    if(!flag){
                        System.out.println("Invalid Hospital ID");
                    } 
                    break;
                case 5:
                    
                    break;
                case 6:
                    System.out.println("Enter Hospital ID");
                    int Hid=sc.nextInt();
                    boolean fl=false;
                    for(int i=0;i<allhosp.size();i++){
                        if(allhosp.get(i).ID()==Hid){
                            System.out.println("hello");
                            fl=true;
                            allhosp.get(i).allslots();
                        }
                    }
                    if(!fl){
                        System.out.println("Invald Hospital ID");
                    }
                    break;
                case 7:
                    System.out.println("Enter Citizen ID");
                    String cid=sc.next();
                    Boolean flg=false;
                    for(int i=0;i<allcitizen.size();i++){
                        if(allcitizen.get(i).UID().equals(cid)){
                            flg=true;
                            allcitizen.get(i).checkstatus();
                        }
                    }
                    if(!flg){
                        System.out.println("No Citizen with provided unique id exist in records");
                    }
                    break;
                case 8:
                    sc.close();
                    System.exit(0);
                    break;
            
                default:
                    break;
            }
        }
    }
}
class vaccine{
    private String name;
    private int doses;
    private int Gap;
    vaccine(String name,int doses,int Gap){
        this.Gap=Gap;
        this.doses=doses;
        this.name=name;
        System.out.println("Vaccine Name: "+this.name()+", Number of doses "+this.doses()+", Gap between Doses "+this.Gap());
    }
    public String name(){
        return this.name;
    }
    public int Gap(){
        return this.Gap;
    }
    public int doses(){
        return this.doses;
    }
}
class slot{
    private int daynumber;
    private int quantity;
    private String Vname;
    slot(int dn,int q,String vn){
        this.Vname=vn;
        this.daynumber=dn;
        this.quantity=q;
    }

    public int daynumber(){
        return this.daynumber;
    }

    public int quantity(){
        return this.quantity;
    }

    public String Vname(){
        return this.Vname;
    }

}





class Hospital{
    private int ID;
    private String Hname;
    private int Pincode;
    private ArrayList<slot> slots;


    Hospital(String name,int Pincode){
        this.Hname=name;
        this.Pincode=Pincode;
        this.ID=this.Genid();
        this.slots=new ArrayList<>();
        System.out.println("Hospital Name: "+this.Hname()+", Pincode "+this.Pincode()+", Unique ID "+this.ID());
    }


    private int Genid(){
        Random rand=new Random();
        String s="";
        Random rnd = new Random();
        while(s.length()<6){
            String x=String.valueOf(rnd.nextInt(9));
            if(!x.equals("0"))
                s=s+x;
            }
        return Integer.parseInt(s);
    }

    public void addslot(slot sl){
        this.slots.add(sl);
    }

    public String Hname(){
        return this.Hname;
    }

    public int Pincode(){
        return this.Pincode;
    }

    public int ID(){
        return this.ID;
    }

    public void allslots(){
        for(int i=0;i<this.slots.size();i++){
            slot s=this.slots.get(i);
            System.out.println("Day: "+s.daynumber()+" Vaccine: "+s.Vname()+" Available Qty: "+s.quantity());
        }
    }

}



class vacinfo{
    private String Vname;
    private int doses;
    private int rdoses;
    private int ldate;
    private int ndate;
    vacinfo(String Vname,int cd,int d){

        this.Vname=Vname;

    }

    public String getVname() {
        return this.Vname;
    } 

}





class Citizen{
    private String name;
    private String status;
    private String Uid;
    private int age;
    private vacinfo info;
    Citizen(String name,int age,String Uid){
        this.name=name;
        this.age=age;
        this.Uid=Uid;
        this.info=null;
        this.status="REGISTERED";
        // System.out.println("Citizen Name: "+this.name()+", age "+this.age()+", Unique ID "+this.UID());
    }

    public String name(){
        return this.name;
    }
    
    public String UID(){
        return this.Uid;
    }

    public int age(){
        return this.age;
    }

    public void checkstatus(){
        System.out.println(this.status);
        System.out.println(info);
    }
    // public void ID(){
    //     System.out.println(this.info.Vname());
        

    // }
}
/*Name SUMIT KUMAR
ROLL NO 2020249
BATCH '24
ASSINGMENT 1 ADVANCED PROGRAMMING

Assumptions : 
 1) The input given is in corret format NO EXTRA SPACES
 2) Few errors are still handled by the algorithm

Description : 
 Number of class = 5 classes + 1 public class(Assignmen1+2020249)
Classes  : 
    1) vaccine
        getters 
            name() 
            Gap() 
            doses()
        setter
            no specific fiels needs to be updates once initialised
    1) slot
        getters
            daynumber()
            quantity()
            Vname()
        setters
            updateslot()

    2) Hospital 
        getters
            Hname()
            Pincode()
            ID()
            ret()
            retslo()
        setters
            addslot()
    4)vacinfo
        getters
            getVname()
            doses()
            rdoses()
        setters
            updose()
    5)Citizen
        getters
            name()
            UID()
            age()
            ndate()
            checkstatus()
        setters
            upnd()
            addinfo()
            updateinfo()


*/
import java.util.*;


public class Assignmen1_2020249 {
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
                    int flg=0;
                    for(int g=0;g<allvacs.size();g++){
                        if(allvacs.get(g).name().equals(name)){
                            flg=1;
                        }
                    }
                    if(flg==1){
                        System.out.println("Vaccine already Registered");
                        break;}
                    System.out.print("Enter Number of Doses ");
                    int doses=sc.nextInt();
                    if(doses<1){
                        System.out.println("Vaccine with 0 doses can't be Registered");
                        break;
                    }
                    int Gap=0;
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
                    if (Pincode<100000 && Pincode>999999) {
                        break;
                    }
                    int f2=0;
                    for(int g=0;g<allhosp.size();g++){
                        if(allhosp.get(g).Hname().equals(Hname) && Pincode==allhosp.get(g).Pincode()){
                            f2=1;
                        }
                    }
                    if(f2==1){
                        System.out.println("Hospital already Registered");
                        break;}
                    Hospital h=new Hospital(Hname, Pincode);
                    allhosp.add(h);
                    break;

                case 3:
                    System.out.print("Enter Citizen Name ");
                    String cname=sc.next();
                    
                    System.out.print("Enter Age of the citizen ");
                    int age=sc.nextInt();
                    System.out.print("Enter the Uniques ID: ");
                    String Uid=sc.next();
                    System.out.println("Citizen name: "+cname+", age: "+age+", Unique ID: "+Uid);
                    int f3=0;
                    for(int g=0;g<allcitizen.size();g++){
                        if(allcitizen.get(g).UID().equals(Uid)){
                            f3=1;
                        }
                    }
                    if(f3==1){
                        System.out.println("Citizen with this Unique id already Registered");
                        break;}
                    if(age<18){
                        System.out.println("Age below 18 Not allowed");
                        break;
                    }
                    if(Uid.length()!=12){
                        System.out.println("Uid is not valid");
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
                    System.out.println("Enter unique citizen id");
                    String cid =sc.next();
                    boolean f =false;
                    for(int i=0;i<allcitizen.size();i++){
                        if(allcitizen.get(i).UID().equals(cid)){
                            f=true;
                            boolean found=false;
                            System.out.println("1 Search by pincode\n2 Search by vaccine\n3 exit");
                            int ch1=sc.nextInt();
                            if(ch1==1){
                                    System.out.println("Enter pincode");
                                    int pin=sc.nextInt();
                                    for(int j=0;j<allhosp.size();j++){
                                        if(pin==allhosp.get(j).Pincode()){
                                            found=true;
                                            System.out.println(allhosp.get(j).ID()+" "+allhosp.get(j).Hname());
                                        }
                                    }
                                    if(found){
                                        System.out.println("Enter Hospital ID");
                                        int ch_1=sc.nextInt();
                                        for(int j=0;j<allhosp.size();j++){
                                            if(ch_1==allhosp.get(j).ID()){
                                                Hospital h1=allhosp.get(j);
                                                h1.allslots();
                                                System.out.println("Enter slot");
                                                int sl=sc.nextInt();
                                                slot s=h1.ret(sl);
                                                if(allcitizen.get(i).Vacname()!=null){
                                                    if(allcitizen.get(i).Vacname().equals(s.Vname())){
                                                        System.out.println("Diffrent vaccine type not recommanded");
                                                        break;
                                                    }
                                                }
                                                if(s.quantity()>0){
                                                    s.updateSlot();
                                                    System.out.println(allcitizen.get(i).name()+" is Vaccinated with "+s.Vname());
                                                    int nd=0;
                                                    int gp=0;
                                                    for(int x=0;x<allvacs.size();x++){
                                                        if(s.Vname().equals(allvacs.get(x).name())){
                                                            nd=allvacs.get(x).doses();
                                                            gp=allvacs.get(x).Gap();
                                                        }
                                                    }
                                                    if(allcitizen.get(i).checkstatus().equals("REGISTERED")){
                                                        vacinfo info=new vacinfo(s.Vname(),nd);
                                                
                                                        allcitizen.get(i).addinfo(info,gp);
                                                    }
                                                    else{
                                                        allcitizen.get(i).updatevacinfo(gp);
                                                    }
                                                }

                                            }
                                        }
                                    }
                                    
                            }
                            else if(ch1==2){
                                    System.out.println("Enter Vaccine name: ");
                                    String vn=sc.next();
                                    for(int j=0;j<allhosp.size();j++){
                                        if(allhosp.get(j).isslot(vn)){
                                            found=true;
                                            System.out.println(allhosp.get(j).ID()+" "+allhosp.get(j).Hname());
                                        }
                                    }
                                    if(found){
                                        System.out.println("Enter the Hospital id");
                                        int hid1=sc.nextInt();
                                        int index=0;
                                        for(int k=0;k<allhosp.size();k++){
                                            if(allhosp.get(k).ID()==hid1){
                                                index=k;
                                            }
                                        }
                                        Hospital ho=allhosp.get(index);
                                        if(!ho.find(vn,allcitizen.get(i).ndate())){
                                            System.out.println("No slot available ");
                                            break;
                                        }
                                        System.out.println("Enter slot number: ");
                                        int ch2=sc.nextInt();
                                        slot s1=ho.retslo(vn,allcitizen.get(i).ndate());
                                        if(allcitizen.get(i).Vacname()!=null){
                                            if(!allcitizen.get(i).Vacname().equals(s1.Vname())){
                                                System.out.println("Diffrent vaccine type not recommanded");
                                                break;
                                            }
                                        }
                                        if(s1!=null){
                                            s1.updateSlot();
                                            System.out.println(allcitizen.get(i).name()+" is Vaccinated "+s1.Vname());
                                                    int nd=0;
                                                    int gp=0;
                                                    for(int x=0;x<allvacs.size();x++){
                                                        if(vn.equals(allvacs.get(x).name())){
                                                            nd=allvacs.get(x).doses();
                                                            gp=allvacs.get(x).Gap();
                                                        }
                                                    }
                                            if(allcitizen.get(i).checkstatus().equals("REGISTERED")){
                                                vacinfo info=new vacinfo(vn,nd);
                                                allcitizen.get(i).addinfo(info,gp);
                                            }
                                            else{
                                                allcitizen.get(i).updatevacinfo(gp);
                                            }

                                        }
                                        else{
                                            System.out.println("No slot available ");
                                        }
                                    }
                                    else{
                                        System.out.println("No slots available");
                                    }



                                    
                                }
                            else if(ch==3)
                                    break;
                            else{
                                System.out.println("Wrong input");
                            }
                        
                                
                        }
                        
                    }
                    if(!f){
                        System.out.println("ID does not exist");
                    }
                    break;
                case 6:
                    System.out.println("Enter Hospital ID");
                    int Hid=sc.nextInt();
                    boolean fl=false;
                    for(int i=0;i<allhosp.size();i++){
                        if(allhosp.get(i).ID()==Hid){
                            // System.out.println("hello");
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
                    String Cid=sc.next();
                    Boolean flg1=false;
                    for(int i=0;i<allcitizen.size();i++){
                        if(allcitizen.get(i).UID().equals(Cid)){
                            flg1=true;
                            System.out.println(allcitizen.get(i).checkstatus());
                            if(allcitizen.get(i).checkstatus()=="REGISTERED"){
                                // System.out.println(allcitizen.get(i).checkstatus());
                                break;
                            }
                            else if(allcitizen.get(i).checkstatus()=="Fully Vaccinated"){
                                allcitizen.get(i).printvac();
                            }
                            else{
                                // System.out.println(allcitizen.get(i).checkstatus());
                                allcitizen.get(i).printvac();
                                System.out.println("Next vaccine date: "+allcitizen.get(i).ndate());
                                
                            }
                        }
                    }
                    if(!flg1){
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

//class of vaccine
class vaccine{
    private String name;    //name of the vaccine
    private int doses;      //Doses 
    private int Gap;        //Number of days between doses

    //constructor
    vaccine(String name,int doses,int Gap){
        this.Gap=Gap;
        this.doses=doses;
        this.name=name;
        System.out.println("Vaccine Name: "+this.name()+", Number of doses "+this.doses()+", Gap between Doses "+this.Gap());
    }
    //returns vaccine name
    public String name(){
        return this.name;
    }
    //returns the Gap between doses
    public int Gap(){
        return this.Gap;
    }
    //returns the number of doses
    public int doses(){
        return this.doses;
    }
}

//class of slot
class slot{
    private int daynumber;          //daynumber of the slot
    private int quantity;           //quantity of the slot
    private String Vname;           //Vaccine name in the current slot

    //constructor
    slot(int dn,int q,String vn){
        this.Vname=vn;
        this.daynumber=dn;
        this.quantity=q;
    }

    //returns the day of the slot
    public int daynumber(){
        return this.daynumber;
    }

    //returns the vaccine quantity left in the slot
    public int quantity(){
        return this.quantity;
    }

    //returns vaccine name
    public String Vname(){
        return this.Vname;
    }

    //update the slot vaccine quantity (used when someone is vaccined in the current slot)
    public void updateSlot(){
        this.quantity-=1;
    }

}




//Class for Hospital data
class Hospital{
    private int ID;             //unique hospital id
    private String Hname;       //Hospital name
    private int Pincode;        //Pincode of the Hospital
    private ArrayList<slot> slots;  //arraylist maintainig hospital slots


    //Constructor
    Hospital(String name,int Pincode){
        this.Hname=name;
        this.Pincode=Pincode;
        this.ID=this.Genid();
        this.slots=new ArrayList<>();
        System.out.println("Hospital Name: "+this.Hname()+", Pincode "+this.Pincode()+", Unique ID "+this.ID());
    }

    //id generator random 6 digit (since random is used very low probablity of having the same id of 6 digits)
    private int Genid(){
        String s="";
        Random rnd = new Random();
        while(s.length()<6){
            String x=String.valueOf(rnd.nextInt(9));
            if(!x.equals("0"))
                s=s+x;
            }
        return Integer.parseInt(s);
    }

    //add slot to the hospital slot list
    public void addslot(slot sl){
        this.slots.add(sl);
    }

    //returns Hospital name
    public String Hname(){
        return this.Hname;
    }

    //returns Pincode of the hospital
    public int Pincode(){
        return this.Pincode;
    }

    //return unique id of the hospital
    public int ID(){
        return this.ID;
    }

    //print all slots 
    public void allslots(){
        for(int i=0;i<this.slots.size();i++){
            slot s=this.slots.get(i);
            System.out.println(i+ " --> Day: "+s.daynumber()+" Vaccine: "+s.Vname()+" Available Qty: "+s.quantity());
        }
    }

    //return true or flase depending on if the slot with the vaccine name and provided day or after that day exists
    public boolean find(String vname,int d){
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).Vname().equals(vname)&& d<=slots.get(i).daynumber()){
                slot s=this.slots.get(i);
                System.out.println(i+" --> Day: "+s.daynumber()+" Vaccine: "+s.Vname()+" Available Qty: "+s.quantity());
                return true;
            }
        }
        return false;
    }

    //returns the slot data of the spcified slot 
    public slot ret(int pos){
        return this.slots.get(pos);
    }

    //return slot depending on if the slot with the vaccine name and provided day or after that day exists
    public slot retslo(String Vname,int d){
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).Vname().equals(Vname) && d<=slots.get(i).daynumber()){
                return this.slots.get(i);
            }
        }
        return null;
    }

    ////return true or flase  depending on if the slot with the vaccine name exists
    public boolean isslot(String Vname){
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).Vname().equals(Vname)){
                return true;
            }
        }
        return false;
    }

}


//holds the vaccine info of a citizen
class vacinfo{
    private String Vname;           //name of the vaccine given
    private int doses;              //doses given till now 
    private int rdoses;             //total doses to be given

    //constructor
    vacinfo(String Vname,int rd){

        this.Vname=Vname;
        this.doses=1;
        this.rdoses=rd;

    }

    //returns given vaccine name
    public String getVname() {
        return this.Vname;
    } 

    //returns the number of doses given 
    public int doses(){
        return this.doses;
    }

    //returns the total doses to be given
    public int rdoses(){
        return this.rdoses;
    }

    //updates the given doses after a vaccination
    public void updose(){
        this.doses++;
    }


}





class Citizen{
    private String name;        //Citizen name
    private String status;      //Vaccination status of the person (REGISTERS/Partially or Fully vaccinated)
    private String Uid;         //Unique ID of the Citizen
    private int age;            //Age of the Citizen
    private int date;           //Date of next vaccination(1 non vaccinated user and 0 for fully vaccinated user)
    private vacinfo info;       //Vaccine info of the citizen

    //constructor
    Citizen(String name,int age,String Uid){
        this.name=name;
        this.age=age;
        this.Uid=Uid;
        this.date=1;
        this.info=null;
        this.status="REGISTERED";
    }

    //returns the name of the citizen
    public String name(){
        return this.name;
    }
    
    //returns the 12 digit unique ID of the citizen
    public String UID(){
        return this.Uid;
    }

    //returns the age of the citizen
    public int age(){
        return this.age;
    }

    //returns the next vaccination date
    public int ndate(){
        return this.date;
    }

    //return the vaccination status of the citizen
    public String checkstatus(){
        return this.status;
    }

    //Print the vaccine information
    public void printvac(){
        System.out.println("Vaccine given: "+this.info.getVname()+"\nNumber of doses: "+this.info.doses());
    }

    //update the next vaccine date 
    private void upnd(int date){
        this.date+=date;
    }

    //add the vaccine info if previously does not exist
    public void addinfo(vacinfo info,int ndate){
        if(info.doses()==info.rdoses()){
            this.status="Fully Vaccinated";
            this.upnd(-this.ndate());
        }
        else
            this.status="Partially Vaccinated";
        this.info=info;
        this.upnd(ndate);
    }

    //return the name of the vaccine if vaccinated before
    public String Vacname(){
        if(this.info==null)
        return null;
        return this.info.getVname();
    }

    //Update the vaccine information some information already exist
    public void updatevacinfo(int date){
        if(this.info!=null){
            this.info.updose();
            if(this.info.rdoses()==this.info.doses()){
                status ="Fully Vaccinated";

            }
            if(this.info.rdoses()!=this.info.doses()){
                status ="Partially Vaccinated";
                this.upnd(date);
            }
        }
    }
}
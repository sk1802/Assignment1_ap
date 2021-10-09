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
                    System.out.println("Enter unique citizen id");
                    String cid =sc.next();
                    boolean f =false;
                    for(int i=0;i<allcitizen.size();i++){
                        if(allcitizen.get(i).UID().equals(cid)){
                            f=true;
                            boolean found=false;
                            System.out.println("0 Search by pincode\n1 Search by vaccine\n2 exit");
                            int ch1=sc.nextInt();
                            if(ch1==0){
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
                                                if(s.quantity()>0){
                                                    s.updateSlot();
                                                    System.out.println(allcitizen.get(i).name()+" is Vaccinated");
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
                            else if(ch1==1){
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
                                            System.out.println("No slot found");
                                            break;
                                        }
                                        System.out.println("Enter slot number: ");
                                        int ch2=sc.nextInt();
                                        slot s1=ho.retslo(vn,allcitizen.get(i).ndate());
                                        if(s1!=null){
                                            s1.updateSlot();
                                            System.out.println(allcitizen.get(i).name()+" is Vaccinated");
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
                                            System.out.println("No slot found");
                                        }
                                    }
                                    else{
                                        System.out.println("No slots available");
                                    }



                                    
                                }
                                else
                                    break;
                            
                        
                                
                        }
                    }
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
                    String Cid=sc.next();
                    Boolean flg=false;
                    for(int i=0;i<allcitizen.size();i++){
                        if(allcitizen.get(i).UID().equals(Cid)){
                            flg=true;
                            System.out.println(allcitizen.get(i).checkstatus());
                            if(allcitizen.get(i).checkstatus()=="REGISTERED"){
                                System.out.println(allcitizen.get(i).checkstatus());
                            }
                            else if(allcitizen.get(i).checkstatus()=="Fully Vaccinated"){
                                allcitizen.get(i).printvac();
                            }
                            else{
                                // System.out.println(allcitizen.get(i).checkstatus());
                                allcitizen.get(i).printvac();
                                System.out.println(allcitizen.get(i).ndate());
                                
                            }
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

    public void updateSlot(){
        this.quantity-=1;
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
            System.out.println(i+ " --> Day: "+s.daynumber()+" Vaccine: "+s.Vname()+" Available Qty: "+s.quantity());
        }
    }

    // public void vslot(String vn){
    //     for(int i=0;i<this.slots.size();i++){
    //         slot s=this.slots.get(i);
    //         if(s.Vname().equals(vn))
    //             System.out.println("Day: "+s.daynumber()+" Vaccine: "+s.Vname()+" Available Qty: "+s.quantity());
    //     }
    // }

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

    public slot ret(int pos){
        return this.slots.get(pos);
    }
    public slot retslo(String Vname,int d){
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).Vname().equals(Vname) && d<=slots.get(i).daynumber()){
                return this.slots.get(i);
            }
        }
        return null;
    }
    public boolean isslot(String Vname){
        for(int i=0;i<slots.size();i++){
            if(slots.get(i).Vname().equals(Vname)){
                return true;
            }
        }
        return false;
    }

}



class vacinfo{
    private String Vname;
    private int doses;
    private int rdoses;
    vacinfo(String Vname,int rd){

        this.Vname=Vname;
        this.doses=1;
        this.rdoses=rd;

    }

    public String getVname() {
        return this.Vname;
    } 

    public int doses(){
        return this.doses;
    }

    public int rdoses(){
        return this.rdoses;
    }

    public void updose(){
        this.doses++;
    }


}





class Citizen{
    private String name;
    private String status;
    private String Uid;
    private int age;
    private int date;
    private vacinfo info;
    Citizen(String name,int age,String Uid){
        this.name=name;
        this.age=age;
        this.Uid=Uid;
        this.date=1;
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

    public int ndate(){
        return this.date;
    }
    public String checkstatus(){
        return this.status;
    }
    public void printvac(){
        System.out.println("Vaccine given: "+this.info.getVname()+"\n Number of doses"+this.info.doses());
    }
    private void upnd(int date){
        this.date+=date;
    }
    public void addinfo(vacinfo info,int ndate){
        if(info.doses()==info.rdoses()){
            this.status="Fully Vaccinated";
        }
        else
            this.status="Partially Vaccinated";
        this.info=info;
        this.upnd(ndate);
    }
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
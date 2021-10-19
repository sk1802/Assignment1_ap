import java.util.*;

public class Backpack {
    private static ArrayList<Student> StudentList=new ArrayList<>();
    private static ArrayList<Teacher> TeacherList=new ArrayList<>();
    private static ArrayList<ClassMaterial> MaterialList=new ArrayList<>();
    private static ArrayList<Assessments> Alist=new ArrayList<>();
    private static ArrayList<Comments> Clist=new ArrayList<>();

    public static void TeacherMenu(){
        System.out.println("1. Add class material");
        System.out.println("2. Add assessments");
        System.out.println("3. View lecture materials");
        System.out.println("4. View assessments");
        System.out.println("5. Grade assessments");
        System.out.println("6. Close assessment");
        System.out.println("7. View comments");
        System.out.println("8. Add comments");
        System.out.println("9. Logout");
    }

    public static void StudentMenu(){
        System.out.println("1. View lecture materials");
        System.out.println("2. View assessments");
        System.out.println("3. Submit assessments");
        System.out.println("4. View Grade");
        System.out.println("5. View comments");
        System.out.println("6. Add comments");
        System.out.println("7. Logout");
    }


    public static void ViewMaterial(){
        if(MaterialList.size()==0){
            System.out.println("No class material");
            return;
        }
        for(int i=0;i<MaterialList.size();i++){
            Object s=(Object)MaterialList.get(i);
            if(s instanceof LectureSlide)
                ((LectureSlide)s).getMaterial();
            else
                ((LectureVideos)s).getMaterial();
            System.out.println();
        }
    }

    public static void ViewAssessment(){
        if(Alist.size()==0){
            System.out.println("NO assessments");
            return;
        }
        for(int i=0;i<Alist.size();i++){
            System.out.print("ID "+i+" ");
            Object s=(Object)Alist.get(i);
            if(s instanceof Assignments)
                ((Assignments)s).Display();
            else
                ((Quiz)s).Display();
            System.out.println();
        }
    }

    public static void VC(){
        if(Clist.size()==0){
            System.out.println("NO comments");
            return;
        }
        for(int i=0;i<Clist.size();i++){
            System.out.println(Clist.get(i).getComments()+" - "+Clist.get(i).getId()+"\n"+Clist.get(i).getDate());
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Student s0=new Student("S0");
        Student s1=new Student("S1");
        Student s2=new Student("S2");
        StudentList.add(s0);
        StudentList.add(s1);
        StudentList.add(s2);
        Teacher t0=new Teacher("I0");
        Teacher t1=new Teacher("I1");
        TeacherList.add(t0);
        TeacherList.add(t1);

        while(true) {
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as Instructor");
            System.out.println("2. Enter as Student");
            System.out.println("3. Exit");
            int Typechoice=Integer.parseInt(sc.nextLine());
            switch (Typechoice) {
                case 1:
                    System.out.println("Instructors");
                    for(int i=0;i<TeacherList.size();i++) {
                        System.out.println(i+" "+TeacherList.get(i).getId());
                    }
                    System.out.println("Choose Id");
                    int Tid=Integer.parseInt(sc.nextLine());
                    if(Tid>=TeacherList.size()){
                        System.out.println("Invalid Instructor ID");
                        break;
                    }
                    int Mchoice1=0;
                    while(Mchoice1!=9){
                        System.out.println();
                        System.out.println("Welcome "+TeacherList.get(Tid).getId());
                        TeacherMenu();
                        Mchoice1=Integer.parseInt(sc.nextLine());
                        switch (Mchoice1) {
                            case 1:
                                System.out.println("1. Add lecture slides");
                                System.out.println("2. Add Lecture Videos");
                                int Lchoice=Integer.parseInt(sc.nextLine());
                                if(Lchoice==1){
                                    System.out.println("Enter Slide Topic: ");
                                    String Topic=sc.nextLine();
                                    System.out.println("Enter number of slides");
                                    int no_slides=Integer.parseInt(sc.nextLine());
                                    LectureSlide L=new LectureSlide(Topic,TeacherList.get(Tid).getId(),no_slides);
                                    for(int j=0;j<no_slides;j++){
                                        System.out.println("Enter slide "+(j+1)+"Content");
                                        L.addSlide(sc.nextLine());
                                    }
                                    MaterialList.add(L);
                                    System.out.println();

                                }
                                else if(Lchoice==2){
                                    System.out.println("Enter the Topic Of the Video");
                                    String Topic=sc.nextLine();
                                    System.out.println("Enter filename of the Video");
                                    String filename=sc.nextLine();
                                    if(filename.length()>4 && filename.substring(filename.length()-4).equals(".mp4")){
                                        LectureVideos Lv=new LectureVideos(Topic,filename,TeacherList.get(Tid).getId());
                                        MaterialList.add(Lv);
                                    }
                                }
                                else{
                                    System.out.println("Invalid choice");
                                }
                                break;

                            case 2:
                                    System.out.println("1. Add Assignment");
                                    System.out.println("2. Add Quiz");
                                    int Achoice=Integer.parseInt(sc.nextLine());
                                    if(Achoice==1){
                                        System.out.println("Enter problem Statement :");
                                        String Pstatement=sc.nextLine();
                                        System.out.println("Enter Max Marks :");
                                        int MM=Integer.parseInt(sc.nextLine());
                                        Assignments A=new Assignments(Pstatement,MM);
                                        Alist.add(A);
                                        System.out.println();

                                    }
                                    else if(Achoice==2){
                                        System.out.println("Enter the Quiz Question :");
                                        String QQ=sc.nextLine();
                                        Quiz Q=new Quiz(QQ);
                                        Alist.add(Q);
                                    }
                                    else{
                                        System.out.println("Invalid choice");
                                    }
                                break;
                            case 3:
                                ViewMaterial();
                                break;
                            case 4:
                                ViewAssessment();    
                                break;
                            case 5:
                                for(int j=0;j<Alist.size();j++){
                                    System.out.print("ID "+j+" ");
                                    Object s=(Object)Alist.get(j);
                                    if(s instanceof Assignments){
                                        if(((Assignments)s).getStatus().equals("Open"))
                                            ((Assignments)s).Display();
                                    }
                                    else{
                                        if(((Quiz)s).getStatus().equals("Open"))
                                            ((Quiz)s).Display();
                                    }
                                    System.out.println();
                                    
                                }
                                System.out.println("Choose Id of the assessment to view submssions");
                                int Gchoice=Integer.parseInt(sc.nextLine());
                                Object s=(Object)Alist.get(Gchoice);
                                int x=0;
                                if(s instanceof Assignments){
                                    
                                    x=((Assignments)s).viewSubmissions();
                                }
                                else{
                                    x=((Quiz)s).viewSubmissions();
                                }
                                if(x==0){
                                    System.out.println("No Submissions yet");
                                    break;
                                }
                                System.out.println("Enter the submission id");
                                int z=Integer.parseInt(sc.nextLine());
                                if(s instanceof Assignments){
                                    
                                    System.out.println(((Assignments)s).getAns(z));
                                    System.out.println("---------------------");
                                    ((Assignments)s).Gmm();
                                    System.out.println("Marks = ");
                                    int m=Integer.parseInt(sc.nextLine());
                                    ((Assignments)s).SetG(z, m,TeacherList.get(Tid).getId());
                                }
                                else{
                                    System.out.println(((Quiz)s).getAns(z));
                                    System.out.println("---------------------");
                                    ((Quiz)s).Gmm();
                                    System.out.println("Marks = ");
                                    int m=Integer.parseInt(sc.nextLine());
                                    ((Quiz)s).SetG(z, m,TeacherList.get(Tid).getId());
                                }
                                System.out.println();
                                break;
                            case 6: 
                                boolean f1=false;
                                for (int i=0;i<Alist.size();i++){
                                    if(Alist.get(i).getStatus().equals("Open")){
                                        System.out.print(i+" ");
                                        Object sx=(Object)Alist.get(i);
                                        if(sx instanceof Assignments){
                                                f1=true;
                                                ((Assignments)sx).Display();}
                                        else{
                                            f1=true;
                                            ((Quiz)sx).Display();}
                                    }
                                }
                                if(f1==false){
                                    break;
                                }
                                System.out.println("Enter ID of Assessment to be closed");
                                int aid=Integer.parseInt(sc.nextLine());
                                Alist.get(aid).upSetstatus();
                                break;
                            case 7:
                                VC();
                                break;
                            case 8:
                                System.out.println("Enter Comment");
                                String com=sc.nextLine();
                                Comments cc=new Comments(com,TeacherList.get(Tid).getId());
                                Clist.add(cc);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                
                case 2:
                    System.out.println("Students");
                    for(int i=0;i<StudentList.size();i++) {
                        System.out.println(i+" "+StudentList.get(i).getId());
                    }
                    System.out.println("Choose ID");
                    int Sid=Integer.parseInt(sc.nextLine());
                    if(Sid>=StudentList.size()){
                        System.out.println("Invalid Student ID");
                        break;
                    }
                    int Mchoice2=0;
                    while(Mchoice2!=7){
                        System.out.println();
                        System.out.println("Welcome "+ StudentList.get(Sid).getId());
                        StudentMenu();
                        Mchoice2=Integer.parseInt(sc.nextLine());
                        switch (Mchoice2) {
                            case 1:
                                ViewMaterial();
                                break;
                            case 2:
                                ViewAssessment();
                                break;
                            case 3:
                                System.out.println("Pending Submissions");
                                int f3=0;
                                for (int i=0;i<Alist.size();i++){
                                    if(Alist.get(i).getStatus().equals("Open") &&!StudentList.get(Sid).checkSubmission(i)){
                                        System.out.print("ID "+i+" ");
                                        Object s=(Object)Alist.get(i);
                                        if(s instanceof Assignments){
                                            f3=1;
                                            ((Assignments)s).Display();
                                        }
                                        else{
                                            f3=1;
                                            ((Quiz)s).Display();
                                        }
                                        System.out.println();
                                    }
                                }
                                if(f3==0){
                                    System.out.println("\nNo pending assignments");
                                    break;
                                }
                                System.out.println("Enter ID of Assessment");
                                int Aid=Integer.parseInt(sc.nextLine());
                                boolean flag=false;
                                Object s=(Object)Alist.get(Aid);
                                if(s instanceof Assignments){
                                    System.out.println("Enter filename of the Assignment");
                                    String ans=sc.nextLine();
                                    if(ans.length()>4 && ans.substring(ans.length()-4).equals(".zip")){
                                        Submissions Newsub=new Submissions(Sid,ans);
                                        Alist.get(Aid).addSubmissions(Newsub);
                                        flag=true;
                                    }
                                    else{
                                        System.out.println("Wrong file format");
                                        break;
                                    }
                                }
                                else{
                                    System.out.println(Alist.get(Aid).getProblem()+" : ");
                                    String ans=sc.nextLine();
                                    Submissions Newsub=new Submissions(Sid,ans);
                                    Alist.get(Aid).addSubmissions(Newsub);
                                    flag=true;
                                }
                                if(flag==true){
                                    StudentList.get(Sid).addSubmission(Aid);
                                }
                                    
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Graded Submissions");
                                for(int i=0;i<Alist.size();i++){
                                    if(StudentList.get(Sid).checkSubmission(i)){
                                        Alist.get(i).getG(Sid);
                                    }
                                }
                                System.out.println("Ungraded Assessments");
                                for(int i=0;i<Alist.size();i++){
                                    if(StudentList.get(Sid).checkSubmission(i)){
                                        Alist.get(i).getUG(Sid);
                                    }
                                }
                                break;
                            case 5:
                                VC();
                                break;
                            case 6:
                                System.out.println("Enter Comment");
                                String com=sc.nextLine();
                                Comments cc=new Comments(com,StudentList.get(Sid).getId());
                                Clist.add(cc);
                            
                            default:
                                break;
                        }
                    }
                   
                    
                    break;
                case 3:
                        System.out.println("Thank you for using Bakcpack");
                        sc.close();
                        System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid option");
                    break;
            }
        }


        
        
    }
}

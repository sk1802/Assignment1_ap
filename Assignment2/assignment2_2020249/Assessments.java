import java.util.*;
public class Assessments {
    private String ProblemName;
    private int Maxmarks;
    private String Status;
    private ArrayList<Submissions> AnsList;
    Assessments(String ProblemName, int Maxmarks){
        this.ProblemName = ProblemName;
        this.Maxmarks =Maxmarks;
        this.Status = "Open";
        this. AnsList = new ArrayList<Submissions>();
    }

    protected int getMmarks(){
        return this.Maxmarks;
    }

    protected String getProblem(){
        return this.ProblemName ;
    }

    protected String getStatus(){
        return this.Status;
    }
    public void upSetstatus(){
        this.Status ="Closed";
    }

    public void addSubmissions(Submissions ans) {
        this. AnsList.add(ans);

    }
    public void getG(int id) {
        System.out.println();
        for(int i=0;i< AnsList.size();i++){
            if(AnsList.get(i).getSid()==id && AnsList.get(i).getStatus().equals("Graded")){
                System.out.println("Submissions : "+AnsList.get(i).getAnswer());
                System.out.println("Marks obtained : "+AnsList.get(i).getScore());
                System.out.println("Graded By : "+AnsList.get(i).Gby());
            }
        }
    }

    public void getUG(int id){
        System.out.println();
        for(int i=0;i< AnsList.size();i++){
            if(AnsList.get(i).getSid()==id && AnsList.get(i).getStatus().equals("Ungraded")){
                System.out.println("Submissions : "+AnsList.get(i).getAnswer());
            }
        }
    }

    public int viewSubmissions(){
        if(this. AnsList.size()==0) return 0;
        for(int i=0;i<this. AnsList.size();i++){
            System.out.println(i+" S"+AnsList.get(i).getSid());
        }
        return 1;
    }




    public void SetG(int i,int score,String Gby){
         AnsList.get(i).setGrade(score,Gby);
    }

    public String getAns(int i){
        return AnsList.get(i).getAnswer();
    }


}
class Assignments extends Assessments implements AssessmentInfo{

    Assignments(String ProblemName, int Maxmarks){
        super(ProblemName, Maxmarks);
    }

    // @Override
    // public String GStatus(){
    //     return this.getStatus();
    // }

    // @Override
    // public int VSubmissions(){
    //     return this.viewSubmissions();
    // }
    @Override
    public void Setstatus() {
        super.upSetstatus();
        
    }

    @Override
    public void Display() {
     
        System.out.println("Assignment : "+this.getProblem()+" Max Marks "+this.getMmarks());
        
    }

   
//     @Override
//     public void SetGrade(int i,int score){
//         this.SetG(i, score);
//    }

   


    public void Gmm(){
        System.out.println("Max Marks "+this.getMmarks());
    }
    
}
class Quiz extends Assessments implements AssessmentInfo{
    Quiz(String ProblemName){
        super(ProblemName, 1);
    }

    

    public void Gmm(){
        System.out.println("Max Marks"+this.getMmarks());
    }

    // @Override
    // public String GStatus(){
        
    //     return this.getStatus();
    // }

    // @Override
    // public int VSubmissions(){
        
    //     return this.viewSubmissions();
    // }
    
    @Override
    public void Setstatus() {
    
        super.upSetstatus();
        
    }

    @Override
    public void Display() {
        
        System.out.println("Question : "+this.getProblem());
        
    }


//     @Override
//     public void SetGrade(int i,int score){
//         this.SetG(i, score);
//    }
}

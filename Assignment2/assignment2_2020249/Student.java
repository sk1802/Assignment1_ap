import java.util.*;
public class Student{

    private String id;
    private ArrayList<Integer> Submissions;
    Student(String id){
        this.id = id;
        this.Submissions = new ArrayList<Integer>();
    }

    public String getId(){
        return this.id;
    }

    public void addSubmission(Integer i){
        this.Submissions.add(i);
    }
   
    public boolean checkSubmission(Integer index){
        for(int i=0; i<Submissions.size(); i++){
            if(Objects.equals(this.Submissions.get(i), index)){
                return true;
            }
        }
        return false;
    }
}

import java.util.*;
public class ClassMaterial {
    private String topic;
    private Date dou;
    private String Pid;
    ClassMaterial(String topic,String Pid){
        this.topic=topic;
        this.Pid=Pid;
        this.dou=new Date();
    }

    protected String getTopic(){
        return this.topic;
    }

    protected String getPid(){
        return this.Pid;
    }

    protected Date getdate(){
        return this.dou;
    }


}

class LectureSlide extends ClassMaterial implements GetMaterial{
    private int NumberOfSlides;
    private ArrayList<String> slides_content;
    
    
    LectureSlide(String topic,String Pid,int NumberOfSlides){
        super(topic,Pid);
        this.NumberOfSlides=NumberOfSlides;
        this.slides_content=new ArrayList<String>();
    }

    public void addSlide(String slide){
        this.slides_content.add(slide);
    }

    @Override
    public void getMaterial() {
        System.out.println("Title: "+this.getTopic());
        for(int i=0;i<this.slides_content.size();i++){
            System.out.println("Content of Slide "+(i+1)+": "+this.slides_content.get(i));
        }
        System.out.println("Number of slides: "+this.NumberOfSlides);
        System.out.println("Date of Upload: "+this.getdate());
        System.out.println("Instructer Id: "+this.getPid());
        
    }

    

}

class LectureVideos extends ClassMaterial implements GetMaterial{
    private String filename;
    LectureVideos(String topic,String filename,String Pid) {
        super(topic,Pid);
        this.filename=filename;
        //TODO Auto-generated constructor stub
    }
    @Override
    public void getMaterial() {
        System.out.println("Title of the Video: "+this.getTopic());
        System.out.println("Video file: "+this.filename);
        System.out.println("Date of Upload: "+this.getdate());
        System.out.println("Instructer Id: "+this.getPid());
        
    }
    
}
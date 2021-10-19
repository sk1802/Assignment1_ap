public class Submissions {
    private final int Sid;
    private String Answer;
    private String Status;
    private int Score;
    private String Gby;
    Submissions(int sid, String Answer){
        this.Sid = sid;
        this.Answer = Answer;
        this.Status ="Ungraded";
        this.Score =0;

    }

    public int getScore(){
        return this.Score;
    }

    public String getAnswer(){
        return this.Answer;
    }

    public String getStatus(){
        return this.Status;
    }

    public int getSid(){
        return this.Sid;
    }

    public String Gby(){
        return this.Gby;
    }

    public void setGrade(int score,String Gby){
        this.Score = score;
        this.Gby = Gby;
        this.Status="Graded";
    }

}

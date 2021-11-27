import java.util.*;

public class mats {
    private static storage Images;
    public static grey_image create(int x,int y){
        int [][] xs = new int[x][y];
        Random rand = new Random();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                xs[i][j] = rand.nextInt(255);
            }
        }
        String name ="img".concat(String.valueOf(rand.nextInt(255)));
        
        return new grey_image(name,xs);
    }


    public static color_image creatcolour(int x,int y){
        int [][] rx = new int[x][y];
        Random rand = new Random();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                rx[i][j] = rand.nextInt(255);
            }
        }

        int [][] gx = new int[x][y];
        Random rand2 = new Random();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                gx[i][j] = rand2.nextInt(255);
            }
        }

        int [][] bx = new int[x][y];
        Random rand3 = new Random();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                bx[i][j] = rand3.nextInt(255);
            }
        }
        String name ="img".concat(String.valueOf(rand.nextInt(255)));
        return new color_image(name,rx,gx,bx);
    }


    public static void main(String[] args){
        Images=new storage<object>();
        System.out.println("Hello, World!");
        Scanner sc=new Scanner(System.in);

        while(true) {

            System.out.println("1: To Enter Image\n2: To create Image\n3: Update the Image\n4: Display the Image\n5: Compute Image\n6: Exit");

            int bool1=sc.nextInt();

            
            if (bool1==1) {

                System.out.println("1:Grey Image\n2:Color Image");

                int bool2=sc.nextInt();
                if (bool2==1) {
                    System.out.println("Enter the Name:");

                    String name=sc.next();


                    System.out.println("Enter the Dimensions:");
                    int size_x=sc.nextInt();
                    int size_y=sc.nextInt();

                    int[][] Martic=new int[size_x][size_y];

                    

                    System.out.println("Enter the color");

                    for (int i=0;i<size_x;i++) {
                        for(int j=0;j<size_y;j++) {
                            Martic[i][j]=sc.nextInt();
                        }
                    }

                    Images.add(new grey_image(name,Martic));

                }

                if (bool2==2) {
                    System.out.println("Enter the Name:");

                    String name=sc.next();

                    System.out.println("Enter the Dimensions:");
                    int size_x=sc.nextInt();
                    int size_y=sc.nextInt();

                    int[][] Martic_Red=new int[size_x][size_y];

                    
                    System.out.println("Enter the color For the Green");

                    for (int i=0;i<size_x;i++) {
                        for(int j=0;j<size_y;j++) {
                            Martic_Red[i][j]=sc.nextInt();
                        }
                    }


                    ////////////////////////

                    int[][] Martic_Green=new int[size_x][size_y];

                    
                    System.out.println("Enter the color For the Blue");

                    for (int i=0;i<size_x;i++) {
                        for(int j=0;j<size_y;j++) {
                            Martic_Green[i][j]=sc.nextInt();
                        }
                    }

                    


                    /////////////////////////

                    int[][] Martic_Blue=new int[size_x][size_y];

                    
                    System.out.println("Enter the color For the Red");

                    for (int i=0;i<size_x;i++) {
                        for(int j=0;j<size_y;j++) {
                            Martic_Blue[i][j]=sc.nextInt();
                        }
                    }

                    Images.add(new color_image(name,Martic_Red,Martic_Green,Martic_Blue));

                }

            }
            if(bool1==2){
                System.out.println("Enter the dimentions of image (space separated)");
                int r=sc.nextInt();
                int c=sc.nextInt();
                System.out.println("Enter type of image \n 1.grey image \n 2. color image\n");
                int ch=sc.nextInt();
                if(ch==1){
                    Images.add(create(r, c));
                    System.out.println("Image Created");
                }
                else if(ch==2){
                    Images.add(creatcolour(r, c));
                    System.out.println("Image Created");
                }
            }
            if (bool1==3) {
                System.out.println("Existing Images:");
                
                for (int i=0;i<Images.size();i++) {
                    object obj = (object)Images.get(i);

                    System.out.print(obj.get_name()+" ");

                }
                System.out.println();
                System.out.println("Enter the Image Name:");
                String s=sc.next();

                object o=null;

                for (int i=0;i<Images.size();i++) {
                    if (s.equals(((object) Images.get(i)).get_name())) {
                        o=(object)Images.get(i);
                    }
                }

                if (o instanceof grey_image) {
                    grey_image o1=(grey_image)o;
                    int[][] demo=o1.get_grey();

                    System.out.println("Update Grey Image");
                    for (int i=0; i< demo.length; i++) {
                        for (int j=0; j< demo[i].length; j++) {
                            demo[i][j]=sc.nextInt();
                        }
                        // System.out.println();
                    }

                    o1.set_grey(demo);
                }



                if (o instanceof color_image) {
                    color_image o2=(color_image)o;
                    int[][] demo1=o2.get_Red();

                    System.out.println("Update Red Image");
                    for (int i=0; i< demo1.length; i++) {
                        for (int j=0; j< demo1[i].length; j++) {
                            demo1[i][j]=sc.nextInt();
                        }
                        // System.out.println();
                    }
                    o2.set_Red(demo1);

                    int[][] demo2=o2.get_Green();

                    System.out.println("Update Green Image");
                    for (int i=0; i< demo2.length; i++) {
                        for (int j=0; j< demo2[i].length; j++) {
                            demo2[i][j]=sc.nextInt();
                        }
                        // System.out.println();
                    }

                    o2.set_Green(demo2);

                    int[][] demo3=o2.get_Blue();

                    System.out.println("Update Blue Image");
                    for (int i=0; i< demo3.length; i++) {
                        for (int j=0; j< demo3[i].length; j++) {
                            demo3[i][j]=sc.nextInt();
                        }
                        // System.out.println();
                    }

                    o2.set_Blue(demo3);

                }
            }
            if (bool1==4) {
                System.out.println("Existing Images:");
                
                for (int i=0;i<Images.size();i++) {
                    System.out.print(((object) Images.get(i)).get_name()+" ");

                }

                System.out.println();
                System.out.println("Enter the Image Name:");
                String s=sc.next();

                object o=null;

                for (int i=0;i<Images.size();i++) {
                    if (s.equals(((object) Images.get(i)).get_name())) {
                        o=(object) Images.get(i);
                    }
                }

                if (o instanceof grey_image) {
                    grey_image q1=(grey_image)o;
                    int[][] demo=q1.get_grey();

                    System.out.println("Grey Image");
                    for (int i=0; i< demo.length; i++) {
                        for (int j=0; j< demo[i].length; j++) {
                            System.out.print(demo[i][j]+" ");
                        }
                        System.out.println();
                    }
                }



                if (o instanceof color_image) {
                    color_image q2=(color_image)o;
                    int[][] demo1=q2.get_Red();

                    System.out.println("Red Image");
                    for (int i=0; i< demo1.length; i++) {
                        for (int j=0; j< demo1[i].length; j++) {
                            System.out.print(demo1[i][j]+" ");
                        }
                        System.out.println();
                    }

                    int[][] demo2=q2.get_Green();

                    System.out.println("Green Image");
                    for (int i=0; i< demo2.length; i++) {
                        for (int j=0; j< demo2[i].length; j++) {
                            System.out.print(demo2[i][j]+" ");
                        }
                        System.out.println();
                    }

                    int[][] demo3=q2.get_Blue();

                    System.out.println("Blue Image");
                    for (int i=0; i< demo3.length; i++) {
                        for (int j=0; j< demo3[i].length; j++) {
                            System.out.print(demo3[i][j]+" ");
                        }
                        System.out.println();
                    }

                }



                System.out.println();

            }
            if (bool1==5) {
                System.out.println("Existing Images:");
                
                for (int i=0;i<Images.size();i++) {
                    System.out.print(((object) Images.get(i)).get_name()+" ");

                }
                System.out.println();
                System.out.println("Enter the Image Name:");
                String s=sc.next();

                object o=null;

                for (int i=0;i<Images.size();i++) {
                    if (s.equals(((object) Images.get(i)).get_name())) {
                        o=(object) Images.get(i);
                    }
                }

                if (o instanceof grey_image) {
                    grey_image w1=(grey_image)o;
                    int[][] demo=w1.get_grey();

                    System.out.println("Grey Image");
                    for (int i=0; i< demo.length; i++) {
                        for (int j=0; j< demo[i].length; j++) {
                            System.out.print(255-demo[i][j]+" ");
                        }
                        System.out.println();
                        // System.out.println();
                    }

                    // w1.set_grey(demo);
                }



                if (o instanceof color_image) {
                    color_image w2=(color_image)o;
                    int[][] demo1=w2.get_Red();

                    // System.out.println("Red Image");
                    for (int i=0; i< demo1.length; i++) {
                        for (int j=0; j< demo1[i].length; j++) {
                            System.out.print(255-demo1[i][j]+" ");
                        }
                        System.out.println();
                    }
                    // w2.set_Red(demo1);

                    int[][] demo2=w2.get_Green();

                    // System.out.println("Green Image");
                    for (int i=0; i< demo2.length; i++) {
                        for (int j=0; j< demo2[i].length; j++) {
                            System.out.print(255-demo2[i][j]+" ");
                        }
                        System.out.println();
                    }

                    // w2.set_Green(demo2);

                    int[][] demo3=w2.get_Blue();

                    // System.out.println("Blue Image");
                    for (int i=0; i< demo3.length; i++) {
                        for (int j=0; j< demo3[i].length; j++) {
                            System.out.print(255-demo3[i][j]+" ");
                        }
                        System.out.println();
                    }

                    // w2.set_Blue(demo3);

                }

            }
            if (bool1==6) {
                break;
            }

            // System.out.println(Images);
        }


    }


}


class object {

    private String name;
    // private int[][] grey;

    // private int[][] Red;
    // private int[][] Green;
    // private int[][] Blue;
    object(String name){
        this.name=name;
    }
    public String get_name() {
        return this.name;
    }

    

}

class grey_image extends object {

    // private String name;

    private int[][] grey;

    grey_image(String name,int[][] grey) {
        super(name);
        this.grey = grey;
    }
    public int[][] get_grey() {
        return this.grey;
    }
    public void set_grey(int[][] grey) {
        this.grey=grey;
    }
    @Override
    public String get_name() {
        return super.get_name();
    }

}

class color_image extends object {

    

    private int[][] Red;
    private int[][] Green;
    private int[][] Blue;

    color_image(String name,int[][] Red,int[][] Green,int[][] Blue) {
        super(name);

        this.Red = Red;
        this.Green= Green;
        this.Blue=Blue;
    }


    public int[][] get_Red() {
        return this.Red;
    }
    
    public void set_Red(int[][] Red) {
        this.Red=Red;
    }
    
    public int[][] get_Green() {
        return this.Green;
    }
    
    public void set_Green(int[][] Green) {
        this.Green=Green;
    }
    
    public int[][] get_Blue() {
        return this.Blue;
    }
    public void set_Blue(int[][] Blue) {
        this.Blue=Blue;
    }
    @Override
    public String get_name() {
        return super.get_name();
    }
}
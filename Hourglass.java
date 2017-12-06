import java.util.*;
import java.text.DecimalFormat;

public class Hourglass extends Shape {
	Triangle tri1d, tri2u;
	int UpY, downH, upH;
	
    public Hourglass(String[] info_) {
        super(Arrays.copyOfRange(info_, 1, info_.length));
        super.setHeight(Integer.parseInt(info_[0]));
        if (getHeight()%2!=0){
        	downH = getHeight()/2+1;
        }else{
        	downH = getHeight()/2;
        }
        upH = getHeight()/2;
        String [] arrD = {Integer.toString(downH) , "DOWN", String.valueOf(getFil()), Integer.toString(getX()), Integer.toString(getY())};
        tri1d = new Triangle(arrD);
        String [] arrU = {Integer.toString(upH) , "DOWN", String.valueOf(getFil()), Integer.toString(getX()), Integer.toString(getY()+downH)};
        tri2u = new Triangle(arrU);
    }

    public void draw() {
    	char [] [] background = backdrop(); 
    	background = tri1d.drawOn(background);
    	background = tri2u.drawOn(background);
    	char[] row;
    	for (int i = 0; i < 32; i++){
    		row = background[i];
    		for(int j = 0; j< 96; j++){
    			System.out.print(row[j]);
    		}
    		System.out.println();
    	}
    	if (tri1d.outOfB() || tri2u.outOfB()){
    		System.out.println("Shape exceeds bounds of screen");
    	}
    }
    
    public char [][] backdrop(){
    	char [][] slate = new char [32][96];
    	Arrays.fill(slate[0], '*');
    	Arrays.fill(slate[31], '*');
    	for (int i = 1; i < 31; i++){
    		Arrays.fill(slate[i], ' ');
    	}
    	return slate;
    }
    
    public String dumpChar(String name) {
    	double areas_ = tri1d.getArea() + tri2u.getArea();
        DecimalFormat formateArea = new DecimalFormat("#.000000");

        String s1 = "HOURGLASS (name:"+name+") (x:"+getX()+") (y:"+getY()+")";
        String s2 = " (height:"+getHeight()+") (area:"+formateArea.format(areas_)+")";
        String s3 = " (fill:" +getFil()+") (draw_amount:"+getDrawAmt()+")";
        return s1+s2+s3;
        
    }
    public boolean doubleIt(){
        tri1d.doubleIt();
        tri2u.doubleIt();
        return false;
    }

    public void half() {
    	tri1d.half();
    	tri2u.half();
    }

    public char typeCharHere(int i, int j) {
            return ' ';
    }
    
    public String shapeType() {
            return "Hourglass";
    }

}

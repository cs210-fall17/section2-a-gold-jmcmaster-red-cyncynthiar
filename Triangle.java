import java.util.*;

public class Triangle extends Shape{
    
    public Triangle (String[] info_) {
        super(Arrays.copyOfRange(info_, 2, 5));
        setDir(info_[1]);
        setHeight(Integer.parseInt(info_[0]));
        setArea(getHeight()*getHeight());
    }
    public void Draw(){
    	char [] [] background = backdrop(); 
    	//replace indexes taken up by shape
    	background = drawOn(background);
    	char[] row;
    	for (int i = 0; i < 32; i++){
    		row = background[i];
    		for(int j = 0; j< 96; j++){
    			System.out.print(row[j]);
    		}
    		System.out.println();
    	}
    	//if exceeds bounds say it
    	if (outOfB()){
    		System.out.println("Shape exceeds bounds of screen");
    	}
    }
    
    public char [][] drawOn(char [][] ){
    	hehre
    }
    
    public boolean outOfB(){
    	int width = (getHeight()*2-1)/2;
    	return (getHeight()+getY()>=94 || width+getX()>=31);
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
    
    public boolean doubleIt(){
        setHeight(getHeight()*2);
        setArea(getHeight()*(2*getHeight()-1)/2);
        return false;
    }

    public void half() {
        setHeight(getHeight()/2);
        setArea(getHeight()*(2*getHeight()-1)/2);
    }

    public char typeCharHere(int i, int j){
        return ' ';
    }
    public String shapeType() {
        return "TRIANGLE";
    }
    
    public String dumpChar(String name) {
        String[] ret = super.dump(name);
        return ret[0]+ret[1]+" (direction:"+getDir()+")"+ret[2];
    }

}

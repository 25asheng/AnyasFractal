import processing.core.PApplet;
import java.util.Random;
import java.util.*;
import java.lang.Math;

public class Main extends PApplet {
    public static PApplet app;

    public static void main(String[] args){
        PApplet.main("Main");
    }
    public Main(){
        super();
        app = this;
    }


    public void settings(){
        size(1000,700);
    }

    public void setup(){
        background(225,100,100);
    }

    public void myFractal(float x, float y, float diameter, double proportion){
        circle(x,y,diameter);
        fill(240,160,160);
        if(diameter <= 1){
        } else {
            myFractal(x, y - (float)((diameter*(proportion+1)/2)), (float)(diameter*proportion), proportion);//circle above
            myFractal(x + (float)(diameter*(proportion+1)*sqrt(3)/4), y + (float)(diameter*(proportion+1)/4), (float)(diameter*proportion), proportion);//circle bottom right
            myFractal(x - (float)(diameter*(proportion+1)*sqrt(3)/4), y + (float)(diameter*(proportion+1)/4), (float)(diameter*proportion), proportion);//circle bottom left
        }
    }

    public void myOtherFractal(float x, float y, float diameter, double proportion){
        circle(x,y,diameter);
        if(diameter <= 1){
        } else {
            myOtherFractal(x,y,(float)(diameter*proportion), proportion);//circle inside
            myOtherFractal(x, y - (float)((diameter*(proportion+1)/2)), (float)(diameter*proportion), proportion);//circle above
            myOtherFractal(x + (float)(diameter*(proportion+1)*sqrt(3)/4), y + (float)(diameter*(proportion+1)/4), (float)(diameter*proportion), proportion);//circle bottom right
            myOtherFractal(x - (float)(diameter*(proportion+1)*sqrt(3)/4), y + (float)(diameter*(proportion+1)/4), (float)(diameter*proportion), proportion);//circle bottom left
            //System.out.println((float)(diameter*(proportion+1)/2));
        }
    }


    public void draw(){
        myFractal(200,250,100,1.0/4.0);
        myFractal(500,250,100,1.0/3.0);
        myFractal(800,250,100,1.0/2.0);
        myFractal(200,600,100,1.0/1.7);
        //myFractal(500,400,300,1.0/1.5);
        //myFractal(800,600,100,1.0/1.3);
        //myOtherFractal(500,450,300);
    }


}
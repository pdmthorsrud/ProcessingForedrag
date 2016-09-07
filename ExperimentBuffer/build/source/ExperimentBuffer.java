import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ExperimentBuffer extends PApplet {

int x = 0;
public void setup(){
  
  background(255);
}

public void draw(){ //60 FPS
  background(255, 0, 0);
  rect( x, height/2, 100, 50);
  textAlign(CENTER);
  x+=6;
}

public void keyPressed(){

}

//void mousePressed(){
//  background(random(255), random(255), random(255));
//  fill(random(255), random(255), random(255));
//  textSize(40);
//  text("Hello world!", mouseX, mouseY);
//}
  public void settings() {  size(900, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ExperimentBuffer" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

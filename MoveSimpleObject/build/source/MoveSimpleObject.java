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

public class MoveSimpleObject extends PApplet {

int x=0;
int y=0;
int xv=7;
int yv=7;
int gamestate=0;

public void setup(){
  
  background(100, 150, 170);
  fill(0, 0, 0);
  rect(x, y, 25, 30);
  textAlign(CENTER);
}

public void draw(){
  if(gamestate==0){
    background(100, 150, 170);
    rect(x, y, 25, 30);
  }

  if(x<0 || x>width-25 || y<0 || y>height-30){
    gamestate = 1;
    gameOver();
  }
}


public void keyPressed(){
  if(key=='a'){
    x -= xv;
  }else if(key=='d'){
    x += xv;
  }else if(key=='s'){
    y += yv;
  }else if(key=='w'){
    y -= yv;
  }else if(key=='t'){
    gamestate = 0;
    reset();
  }

}

public void gameOver(){
  background(0, 0, 0);
  textSize(40);
  fill(255, 0, 0);
  text("Game Over", width/2, height/2);
}

public void reset(){
  x = 0;
  y = 0;
  background(100, 150, 170);
  fill(0, 0, 0);
  rect(x, y, 25, 30);
  textAlign(CENTER);
}
  public void settings() {  size(700, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MoveSimpleObject" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

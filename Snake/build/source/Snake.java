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

public class Snake extends PApplet {

ArrayList<Integer> x = new ArrayList<Integer>(), y = new ArrayList<Integer>();
int w = 30, h = 30, bs = 20, dir = 2, applex = 12, appley = 10;
int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
boolean gameover = false;

public void setup() {
  
  x.add(5);
  y.add(5);
}

public void draw() {
  background(255);
  for(int i = 0 ; i < w; i++) line(i*bs, 0, i*bs, height); //Vertical line for grid
  for(int i = 0 ; i < h; i++) line(0, i*bs, width, i*bs); //Horizontal line for grid
  for(int i = 0 ; i < x.size(); i++) {
    fill (0,255,0);
    rect(x.get(i)*bs, y.get(i)*bs, bs, bs);
  }
  if(!gameover) {
    rect(applex*bs, appley*bs, bs, bs);
    fill(255,0,0);
    if(frameCount%5==0) {
      x.add(0,x.get(0) + dx[dir]);
      y.add(0,y.get(0) + dy[dir]);

      if(x.get(0) < 0 || y.get(0) < 0 || x.get(0) >= w || y.get(0) >= h) gameover = true;

      for(int i = 1; i < x.size(); i++) if(x.get(0) == x.get(i) &&  y.get(0) == y.get(i)) gameover = true;

      if(x.get(0)==applex && y.get(0)==appley) {
        applex = (int)random(0,w);
        appley = (int)random(0,h);
      }else {
        x.remove(x.size()-1);
        y.remove(y.size()-1);
      }
    }
  } else {
    fill(0);
    textSize(30);
    text("GAME OVER. Press Space to Play Again", 20, height/2);
    if(keyPressed && key == ' ') {
      x.clear(); //Clear array list
      y.clear(); //Clear array list
      x.add(5);
      y.add(5);
      gameover = false;
    }
  }

  if(keyPressed == true) {

  }
}

public void keyPressed(){
  int newdir = key=='s' ? 0 : (key=='w' ? 1 : (key=='d' ? 2 : (key=='a' ? 3 : -1)));
  if(newdir!= -1){
    dir = newdir;
  }
}
  public void settings() {  size(600,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Snake" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

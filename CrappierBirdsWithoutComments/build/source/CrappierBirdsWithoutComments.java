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

public class CrappierBirdsWithoutComments extends PApplet {

PImage backImg;
PImage birdImg;
PImage wallImg;
PImage startImg;

int gamestate = 1, score = 0, highScore = 0, x = 0, y=height/2, vy = 0;
int wx[] = {600, 900};
int wy[] = {300, 600};

public void setup() {
  
  fill(0);
  textSize(40);
  backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
  birdImg =loadImage("http://i.imgur.com/mw0ai3K.png");
  wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
  startImg=loadImage("http://i.imgur.com/U6KEwxe.png");
}

public void draw() { //runs 60 times a second
  if(gamestate == 0) {
    imageMode(CORNER);
    image(backImg, x, 0);
    image(backImg, x+backImg.width, 0);
    x-=6;
    if(x == -1800){
      x=0;
    }

    imageMode(CENTER);
    image(birdImg, width/2, y);
    vy+=1;
    y+=vy;

    for(int i = 0 ; i < 2; i++) {
      imageMode(CENTER);
      image(wallImg, wx[i], wy[i] - (wallImg.height/2+100));
      image(wallImg, wx[i], wy[i] + (wallImg.height/2+100));

      if(wx[i] < 0) {
        wy[i] = (int)random(200,height-200);
        wx[i] = width;
      }

      if(wx[i] == width/2){
        score++;
        highScore = max(score, highScore);
      }

      if(y>height || y<0 || (abs(width/2-wx[i])<25 && abs(y-wy[i])>100)){
        gamestate=1;
      }

      wx[i] -= 6;
      text(score, 500, 700);
    }

  }else {
    imageMode(CORNER);
    image(startImg, 0, 0);
    text("High Score: "+highScore, 50, width);
  }
}


public void mousePressed(){
  if(gamestate==0){
    vy=-17;
  }else{
    wx[0] = 600;
    wy[0] = y = height/2;
    wx[1] = 900;
    wy[1] = 600;
    x = gamestate = score = 0;
    vy=-17;
  }

}
  public void settings() {  size(600,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "CrappierBirdsWithoutComments" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

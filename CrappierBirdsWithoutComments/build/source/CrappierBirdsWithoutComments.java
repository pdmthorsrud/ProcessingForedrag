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

//credit to reddit user /u/CaptainScuttlebottom
//original thread: https://www.reddit.com/r/learnprogramming/comments/1xfrjb/java_i_was_bored_yesterday_so_i_made_a_flappy/

PImage backImg;
PImage birdImg;
PImage wallImg;
PImage startImg;

int gamestate = 1, score = 0, highScore = 0, x = 0, y, vy = 0;
int wx[] = new int[2];
int wy[] = new int[2];

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
    image(birdImg, width/2, y);

    x -= 6;
    vy += 1;
    y += vy;

    if(x == -1800){
      x = 0;
    }

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
    }
    text(""+score, width/2-15, 700);
  }else {
    imageMode(CENTER);
    image(startImg, width/2,height/2);
    text("High Score: "+highScore, 50, width);
  }
}


public void mousePressed() {
  vy = -17;
  if(gamestate==1) {
    wx[0] = 600;
    wy[0] = y = height/2;
    wx[1] = 900;
    wy[1] = 600;
    x = gamestate = score = 0;
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

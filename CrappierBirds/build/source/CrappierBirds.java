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

public class CrappierBirds extends PApplet {

//credit to reddit user /u/CaptainScuttlebottom
//original thread: https://www.reddit.com/r/learnprogramming/comments/1xfrjb/java_i_was_bored_yesterday_so_i_made_a_flappy/

//making the variables for each image
PImage backImg;
PImage birdImg;
PImage wallImg;
PImage startImg;

//gamestate used to see wether we are at startscreen or playing
//x and y is bird's position. vy is the velocity of the bird
int gamestate = 1, score = 0, highScore = 0, x = -200, y, vy = 0, wx[] = new int[2], wy[] = new int[2];
public void setup() {
  
  fill(0);
  textSize(40);
  //load all images
  backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
  birdImg =loadImage("http://i.imgur.com/mw0ai3K.png");
  wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
  startImg=loadImage("http://i.imgur.com/U6KEwxe.png");
}

public void draw() { //runs 60 times a second
  //gamestate=0 means we're playing the game.
  if(gamestate == 0) {
    //The reason we put up two of the backimg is so that it will always cover
    //the whole screen. The backimg has been drawn so that it will line up
    //perfectly
    imageMode(CORNER);
    image(backImg, x, 0);
    image(backImg, x+backImg.width, 0);

    //x -= 6 will move the background image to the left (see above, where we
    //use x to place the image). Next iteration of draw, the background image
    //will be placed 6 pixels further to the left, giving illusion of movement
    x -= 6;
    //this increases how large vy is each time. vy is how "fast" the bird drops.
    //In other words, we increase how fast the bird drops every time we call
    //draw() (which happens 60 times a second)
    vy += 1;
    //increasing y will make the bird appear at a lower point
    //because we always place the bird at x, y. The higher y is, the lower on
    //the screen it will be placed
    y += vy;

    //this if sentence checks if we're at the end of our bckimage. If we are,
    //we simply reset where the backimage is drawn
    if(x == -1800){
      x = 0;
    }

    //this draws the two walls. Notice that there's always two walls visible
    //in our game.
    for(int i = 0 ; i < 2; i++) {
      imageMode(CENTER);
      //this places two walls with a space of 200 pixels between them.
      image(wallImg, wx[i], wy[i] - (wallImg.height/2+100));
      image(wallImg, wx[i], wy[i] + (wallImg.height/2+100));

      if(wx[i] < 0) {
        wy[i] = (int)random(200,height-200);
        wx[i] = width;
      }

      if(wx[i] == width/2){
        highScore = max(++score, highScore);
      }

      if(y>height || y<0 || (abs(width/2-wx[i])<25 && abs(y-wy[i])>100)){
        gamestate=1;
      }

      wx[i] -= 6;
    }
    image(birdImg, width/2, y);
    text(""+score, width/2-15, 700);
  }
  else {
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
    String[] appletArgs = new String[] { "CrappierBirds" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

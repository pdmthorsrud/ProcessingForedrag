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

//gamestate used to see whether we are at startscreen or playing
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
    //perfectly when drawing to of them side by side
    imageMode(CORNER);
    image(backImg, x, 0);
    image(backImg, x+backImg.width, 0);

    //x -= 6 will move the background image 6 pixels to the left (see above, where we
    //use x to place the image). Next iteration of draw, the background image
    //will be placed 6 pixels further to the left, giving the illusion of movement
    x -= 6;
    //vy += 1 increases vy every time draw is called.
    //In other words, we increase how fast the bird drops every time we call
    //draw() (which happens 60 times a second). This is a simulation of gravity
    vy += 1;
    //Increasing y will make the bird appear at a lower point (bird falling)
    //because we always place the bird at x, y. The higher y is, the lower on
    //the screen it will be placed
    y += vy;

    //This if sentence checks if we're at the end of our bckimage. If we are,
    //we simply reset where the backimage is drawn.
    if(x == -1800){
      x = 0;
    }

    //This draws the two walls. Notice that there's always two walls visible
    //in our game.
    for(int i = 0 ; i < 2; i++) {
      imageMode(CENTER);
      //Places two walls with a space of 200 pixels between them.
      image(wallImg, wx[i], wy[i] - (wallImg.height/2+100));
      image(wallImg, wx[i], wy[i] + (wallImg.height/2+100));

      //When one pair of walls goes out of the picture on the left,
      //we create a new pair of walls that start at the right side
      //(wx[i] = width), and with a randomly placed hole
      //(wy[i] = (int)random(200,height-200)).
      if(wx[i] < 0) {
        wy[i] = (int)random(200,height-200);
        wx[i] = width;
      }

      //If a wall is at the middle point, it means the bird is about to
      //"pass" the wall.
      if(wx[i] == width/2){
        //We add to our score
        score++;
        //and we check if current score is higher than the highScore and set
        //the highScore variable equal to the highest of the variables score
        //and highScore
        highScore = max(score, highScore);
      }

      //If we go off the screen, or we hit one of the walls, it's gameOver,
      //and we set gamestate to 1
      if(y>height || y<0 || (abs(width/2-wx[i])<25 && abs(y-wy[i])>100)){
        gamestate=1;
      }

      //This moves the pair of walls to the left (just like bckimage)
      wx[i] -= 6;
    }

    //We draw the bird. Notice we use y here, which is the variable we change
    //with the help of vy above
    image(birdImg, width/2, y);
    //Prints the text to the screen
    text(""+score, width/2-15, 700);
  }
  //Gamestate is equal to 1, and we're not playing.
  else {
    imageMode(CENTER);
    //startimage is shown
    image(startImg, width/2,height/2);
    //highscore is shown
    text("High Score: "+highScore, 50, width);
  }
}


public void mousePressed() {
  //We set vy to be negative. When vy is positive, the bird moves down.
  //This means that when vy is negative, the bird moves up.
  //Remember that we always increase vy by one each time draw() is called,
  //which means vy will rapidly move back to positive, and the bird will start
  //dropping again.
  vy = -17;
  //if we weren't playing the game when pressing the mouse, we want to start
  //the game. We do this by reseting all the values used while playing the game
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

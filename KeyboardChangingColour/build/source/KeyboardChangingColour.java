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

public class KeyboardChangingColour extends PApplet {

public void setup(){
  
  background(0, 0, 0);
  textAlign(CENTER);
  textSize(40);
}

public void draw(){
}

//if a key is pressed, what is inside here will run
public void keyPressed(){
    //change both background and text to random colors
    background(random(0, 255), random(0, 255), random(0, 255));
    fill(random(0, 255), random(0, 255), random(0, 255));
    text("Hello World!", 450, 400);

    //if the key pressed is r, g or b, the background will be red, green or
    //blue, while textcolor is random
    //if the key pressed is R, G or B, the text will be red, green or blue,
    //while backgroundcolour is random
    if(key=='r'){
      background(255, 0, 0);
      text("Hello World!", 450, 400);
    }else if(key=='g'){
      background(0, 255, 0);
      text("Hello World!", 450, 400);
    }else if(key=='b'){
      background(0, 0, 255);
      text("Hello World!", 450, 400);
    }else if(key=='R'){
      fill(255, 0, 0);
      text("Hello World!", 450, 400);
    }else if(key=='G'){
      fill(0, 255, 0);
      text("Hello World!", 450, 400);
    }else if(key=='B'){
      fill(0, 0, 255);
      text("Hello World!", 450, 400);
    }
}
  public void settings() {  size(900, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "KeyboardChangingColour" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

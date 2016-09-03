void setup(){
  size(900, 800);
  background(0, 0, 0);
  textAlign(CENTER);
  textSize(40);
}

void draw(){
}

//if a key is pressed, what is inside here will run
void keyPressed(){
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

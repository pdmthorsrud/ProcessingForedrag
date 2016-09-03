int x=0;
int y=0;
int xv=7;
int yv=7;
int gamestate=0;

void setup(){
  size(700, 500);
  background(100, 150, 170);
  fill(0, 0, 0);
  rect(x, y, 25, 30);
  textAlign(CENTER);
}

void draw(){
  if(gamestate==0){
    background(100, 150, 170);
    rect(x, y, 25, 30);
  }

  if(x<0 || x>width-25 || y<0 || y>height-30){
    gamestate = 1;
    gameOver();
  }
}


void keyPressed(){
  if(key=='a'){
    x -= xv;
  }else if(key=='d'){
    x += xv;
  }else if(key=='s'){
    y += yv;
  }else if(key=='w'){
    y -= yv;
  }else if(key==' '){
    gamestate = 0;
    reset();
  }

}

void gameOver(){
  background(0, 0, 0);
  textSize(40);
  fill(255, 0, 0);
  text("Game Over", width/2, height/2);
}

void reset(){
  x = 0;
  y = 0;
  background(100, 150, 170);
  fill(0, 0, 0);
  rect(x, y, 25, 30);
  textAlign(CENTER);
}

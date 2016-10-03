
float x, y;
float vy;
float g;
float f;

void setup(){
  size(900, 800);
  background(255);

  x = width/2;
  y = height/2;

  vy = 3;
}

void draw(){ //60 FPS
  ellipse(x,y,r,r);

  y = y*f;
}


//void mousePressed(){
//  background(random(255), random(255), random(255));
//  fill(random(255), random(255), random(255));
//  textSize(40);
//  text("Hello world!", mouseX, mouseY);
//}

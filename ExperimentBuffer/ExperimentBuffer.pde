int x = 0;
void setup(){
  size(900, 800);
  background(255);
}

void draw(){ //60 FPS
  background(255, 0, 0);
  rect( x, height/2, 100, 50);
  textAlign(CENTER);
  x+=6;
}

void keyPressed(){

}

//void mousePressed(){
//  background(random(255), random(255), random(255));
//  fill(random(255), random(255), random(255));
//  textSize(40);
//  text("Hello world!", mouseX, mouseY);
//}

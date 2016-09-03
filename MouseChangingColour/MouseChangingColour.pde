void setup(){
  size(900, 800);
  background(0, 0, 0);
  textAlign(CENTER);
  textSize(40);
}

void draw(){
}

void mousePressed(){
    background(random(0, 255), random(0, 255), random(0, 255));
    fill(random(0, 255), random(0, 255), random(0, 255));
    text("Hello World!", mouseX, mouseY);
}

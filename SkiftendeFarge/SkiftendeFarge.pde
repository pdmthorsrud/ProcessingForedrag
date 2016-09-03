void setup(){
  size(900, 800);
  background(255, 0, 0);
  textAlign(CENTER);
}

void draw(){
  background(random(0, 255), random(0, 255), random(0, 255));
  fill(random(0, 255), random(0, 255), random(0, 255));
  textSize(40);
  text("Hello World!", 450, 400);
  delay(500);
}

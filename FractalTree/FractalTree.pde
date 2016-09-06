// Coding Rainbow
// Daniel Shiffman
// http://patreon.com/codingrainbow
// Code for: https://youtu.be/0jjeOYMjmDU

float angle = PI/6;
String myText = "";

void setup() {
  size(400, 400);
}

void draw() {
  background(23, 98, 161);
  fill(84, 255, 159);
  translate(width/2, height);
  branch(100);
  text("Angle: " + myText, 90, 80);
}

void branch(float len) {
  line(0, 0, 0, -len);
  translate(0, -len);
  if (len > 4) {
    pushMatrix();
    rotate(float(myText));
    branch(len * 0.67);
    popMatrix();
    pushMatrix();
    rotate(-float(myText));
    branch(len * 0.67);
    popMatrix();
  }
}

void keyPressed() {
  if (keyCode == BACKSPACE) {
    if (myText.length() > 0) {
      myText = myText.substring(0, myText.length()-1);
    }
  } else if (keyCode == DELETE) {
    myText = "";
  } else if (keyCode != SHIFT && keyCode != CONTROL && keyCode != ALT) {
    myText = myText + key;
  }
}

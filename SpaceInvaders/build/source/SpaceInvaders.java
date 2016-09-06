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

public class SpaceInvaders extends PApplet {

// Daniel Shiffman
// http://codingrainbow.com
// http://patreon.com/codingrainbow
// Code for: https://youtu.be/biN3v3ef-Y0

Ship ship;
Flower[] flowers = new Flower[6];
ArrayList<Drop> drops = new ArrayList<Drop>();

public void setup() {
  
  ship = new Ship();
  // drop = new Drop(width/2, height/2);
  for (int i = 0; i < flowers.length; i++) {
    flowers[i] = new Flower(i*80+80, 60);
  }
}

public void draw() {
  background(51);
  ship.show();
  ship.move();

  for (Drop d : drops) {
    d.show();
    d.move();
    for (int j = 0; j < flowers.length; j++) {
      if (d.hits(flowers[j])) {
        flowers[j].grow();
        d.evaporate();
      }
    }
  }

  boolean edge = false;

  for (int i = 0; i < flowers.length; i++) {
    flowers[i].show();
    flowers[i].move();
    if (flowers[i].x > width || flowers[i].x < 0) {
      edge = true;
    }
  }

  if (edge) {
    for (int i = 0; i < flowers.length; i++) {
      flowers[i].shiftDown();
    }
  }

  for (int i = drops.size()-1; i >= 0; i--) {
    Drop d = drops.get(i);
    if (d.toDelete) {
      drops.remove(i);
    }
  }
}

public void keyReleased() {
  if (key != ' ') {
    ship.setDir(0);
  }
}


public void keyPressed() {
  if (key == ' ') {
    Drop drop = new Drop(ship.x, height);
    drops.add(drop);
  }

  if (keyCode == RIGHT) {
    ship.setDir(1);
  } else if (keyCode == LEFT) {
    ship.setDir(-1);
  }
}
// Daniel Shiffman
// http://codingrainbow.com
// http://patreon.com/codingrainbow
// Code for: https://youtu.be/biN3v3ef-Y0

class Drop {
  float x, y, r;
  boolean toDelete;

  Drop(float x, float y) {
    this.x = x;
    this.y = y;
    this.r = 8;
    this.toDelete = false;
  }

  public void show() {
    noStroke();
    fill(150, 0, 255);
    ellipse(this.x, this.y, this.r*2, this.r*2);
  }

  public void evaporate() {
    this.toDelete = true;
  }

  public boolean hits(Flower flower) {
    float d = dist(this.x, this.y, flower.x, flower.y);
    if (d < this.r + flower.r) {
      return true;
    } else {
      return false;
    }
  }

  public void move() {
    this.y = this.y - 5;
  }
}
// Daniel Shiffman
// http://codingrainbow.com
// http://patreon.com/codingrainbow
// Code for: https://youtu.be/biN3v3ef-Y0

class Flower {
  float x, y, r, xdir;

  Flower(float x, float y) {
    this.x = x;
    this.y = y;
    this.r = 30;

    this.xdir = 1;
  }

  public void grow() {
    this.r = this.r + 2;
  }

  public void shiftDown() {
    this.xdir *= -1;
    this.y += this.r;
  }

  public void move() {
    this.x = this.x + this.xdir;
  }

  public void show() {
    noStroke();
    fill(255, 0, 200, 150);
    ellipse(this.x, this.y, this.r*2, this.r*2);
  }
}
// Daniel Shiffman
// http://codingrainbow.com
// http://patreon.com/codingrainbow
// Code for: https://youtu.be/biN3v3ef-Y0

class Ship {
  float x, xdir;

  Ship() {
    this.x = width/2;
    this.xdir = 0;
  }

  public void show() {
    fill(255);
    rectMode(CENTER);
    rect(this.x, height-20, 20, 60);
  }

  public void setDir(float dir) {
    this.xdir = dir;
  }

  public void move() {
    this.x += this.xdir*5;
  }
}
  public void settings() {  size(600, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SpaceInvaders" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

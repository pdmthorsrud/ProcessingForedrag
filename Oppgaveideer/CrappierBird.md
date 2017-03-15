# Hvordan lage flappy(crappy)bird!

## Steg for steg  

<br>
<br>
1. Før vi begynner må vi laste inn noen bilder, og sette størrelsen på skjermen vår. Bilder kan lagres i variabeltypen `PImage`. Du kan copypaste koden nedenfor. Kopier linken for å se bildene.

#### Nyttige funksjoner og tips
* Bildekode:
``` processing
PImage backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
PImage birdImg =loadImage("http://i.imgur.com/mw0ai3K.png");
PImage wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
PImage startImg=loadImage("http://i.imgur.com/U6KEwxe.png");
```
* Copypaste denne koden til å starte med. Vi skal gå gjennom hva alt brukes til.

``` processing
PImage backImg;
PImage birdImg;
PImage wallImg;
PImage startImg;

boolean gameover = true
int score = 0
int highScore = 0
int birdX = 0, 
int birdY=height/2, 
int vbirdY = 0;
int wx[] = {600, 900};
int wy[] = {300, 600};

void setup() {
  size(600,800);
  fill(0);
  textSize(40);
  backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
  birdImg =loadImage("http://i.imgur.com/mw0ai3K.png");
  wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
  startImg=loadImage("http://i.imgur.com/U6KEwxe.png");
}
```

<br>
<br>
2. Neste steg er å lage to "gamestates". En for startImg og en for når vi spiller. Bruk en boolean som representerer gameover eller ikke gameover, deretter bruk en if-setning som gjør det slik at vi enten tegner startImg eller kjører "spillkoden".  

<br>
<br>
3. La oss begynne med koden hvor vi spiller. Begynn med å tegne bakgrunnen og fuglen vår. Fuglen skal være i midten av skjermen, og vil alltid bevege 

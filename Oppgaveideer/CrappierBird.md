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
int birdY = height/2, 
int vbirdY = 0;
int imageX = 0, 
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
2. Fra nå av skal vi holde oss inne i draw-metoden vår. Første steg er å lage en if-setning som sjekker om det er gameover. Er det gameover så vil vi tegne startImg på skjermen.  

#### Nyttige funksjoner og tips
* `imageMode(CORNER)`, bildene vi tegner vil ta utgangspunkt i hjørnet av bildet når vi bruker x og y.
* `image(startImg, x-koordinat, y-koordinat)`



<br>
<br>
3. La oss starte med koden hvor vi spiller. Først tegner vi bakgrunnen og fuglen vår. Fuglen skal være i midten av skjermen, og vil alltid bevege seg opp og ned i midten. Med andre ord vil fuglen sin x-koordinat alltid være `width/2`. Å tegne bakgrunnsbildet er litt vanskeligere da vi skal få bildet til å bevege seg bortover. Trikset er å bruke `imageX` fra tidligere i koden vår. Hvis vi setter `imageMode(CORNER)` og deretter tegner bildet med `image(backImg, imageX, 0)` får vi et bilde som vil dekke skjermen vår. 

#### Nyttige funksjoner og tips
* `imageMode(CORNER)`
* `image(backImg, x-koordinat, y-koordinat)`
* `image(birdImg, x-koordinat, y-koordinat)`  

<br>
<br>
4. Bevegelse kan vi skape ved å legge til linjen `imageX = imageX-6` etter vi har tegnet bildet. Neste gang vi kjører gjennom `draw()` og kjører koden `image(backImg, imageX, 0)` vil vi tegne bildet vårt 6 pixler lenger til venstre. Neste gang 12 pixler til venstre, osv. Lar du programmet ditt nå kjøre lenge nok vil du se at bildet før eller siden slutter. Bildet vårt er derimot tegnet slik at start og slutt passer sammen, og vi kan derfor tegne et nytt bilde på enden med `image(backImg, imageX + backImg.width, 0)`. For å spare tid kan du kopiere koden nedenfor. Se om du skjønner hvorfor vi trenger if-setningen!

#### Nyttige funksjoner og tips
* Legg til etter første linjen som tegner første bildet

``` processing
image(backImg, imageX+backImg.width, 0);
imageX = imageX - 6;
if(imageX == -1800){
  imageX=0;
}
```  

<br>
<br>
5. Neste på lista er fuglen vår. Slik det er nå står den stille, men den skal jo falle. Her bruker vi samme metode som i punkt 3.  

<br>
<br>
6. Så fuglen vår faller, men den faller veldig stødig. Gravitasjon er en flott ting som også trengs i spill. Hvis vi skal oversette gravitasjon til "spillspråk" kan man si at det er en kraft som øker hastigheten til et objekt for hver gang vi kjører gjennom `void draw()` metoden vår. Vi må andre ord øke hvor "mye" fuglen faller med, for hver gang vi kjører gjennom. Se om du klarer å løse problemet, hvis ikke kan du spørre en av lærerne om hint!

<br>
<br>
7. Det vi nå mangler er hindre som vi skal komme gjennom, og en måte å få fuglen vår til å fly på. Vi begynner med hindrene. For å spare tid vil jeg her gi deg koden, men er det noe du ikke skjønner så rop på en av lærerne! Denne koden kan limes inn rett under 


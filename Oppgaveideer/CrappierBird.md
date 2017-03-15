# Hvordan lage flappy(crappy)bird!

## Steg for steg  

<br>
<br>
1. Før vi begynner må vi laste inn noen bilder som vi kommer til å bruke. Bilder kan lagres i variabeltypen `PImage`. Du kan copypaste koden nedenfor. Kopier linken for å se bildene.

#### Nyttige funksjoner og tips
* Bildekode:
``` processing
PImage backImg =loadImage("http://i.imgur.com/cXaR0vS.png");
PImage birdImg =loadImage("http://i.imgur.com/mw0ai3K.png");
PImage wallImg =loadImage("http://i.imgur.com/4SUsUuc.png");
PImage startImg=loadImage("http://i.imgur.com/U6KEwxe.png");
```
* For å tegne bildene. CENTER vil gjøre det slik at x og y koordinatene våre går ut i fra midten av bildet vårt.
``` processing
imageMode(CENTER);
image(startImg, x, y)
```

<br>
<br>
2. 

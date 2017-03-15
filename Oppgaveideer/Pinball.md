# Hvordan lage pinball!

## Steg for steg  

<br>
<br>
1. Først må vi lage et rektangel som kan følge datamusa vår (eller bevege seg når vi trykker)

#### Nyttige funksjoner og tips

* `rect(x, y, w, h)`
* variablene `mouseX` og `mouseY`

``` processing
void keyPressed(){
  if(key=='a'){

  }else if(key=='d'){

  }else if(key=='s'){

  }else if(key=='w'){

  }
}
```  

<br>
<br>
2. Flott, da har vi baren som skal slå ballen. So far so good! Neste på lista er ballen vår. For å få denne til å bevege seg må vi gjøre det slik at ballens posisjon endrer seg for hver gang vi kjører gjennom `void draw`. Begynn med å få den til å gå diagonalt over skjermen. Når dette funker kan du legge til sjekker for å se om ballen har truffet noen av veggene, og endre retning deretter.  

#### Nyttige funksjoner og tips

* `ellipse(x, y, w, h)`
* `variabelNavn += 20` (denne plusser 20 på verdien til variabelen `variabelNavn`) 

``` processing
if(posisjonen til ballen == en av sidene){
  endre ballens retning
}else if (posisjonen til ballen == en annen side){
  endre ballens retning
}
```  

<br>
<br>
3. Sweet! Nå har vi en bar som beveger seg, og vi har en ball som spretter rundt. Nå må vi lage noe som kan sjekke om ballen har truffet baren vår. 
   TIPS: Dette blir veldig likt punkt 2, men vi må passe på at vi bruker riktig posisjon for baren.  

<br>
<br>
<br>
4. Almost there. Til slutt må vi lage en "GAME OVER" screen som vises når vi taper (ballen er under baren vår). Tipset her er å lage en `boolean gameover = false`, og en if-setning som sjekker om dette er sant. Er det usant så kjører vi spillet, hvis ikke så tegner vi en "GAMEOVER" screen.  

#### Nyttige funksjoner og tips

* If-setning for gameover. Husk på at "spillkoden" kun skal kjøres om det ikke er gameover. 
* Egen metode for gameover:

``` processing
void gameover(){
  kode som tegner en gameover screen
}
```

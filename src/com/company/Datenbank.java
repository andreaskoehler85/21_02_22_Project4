package com.company;

import java.util.Arrays;
import java.util.Comparator;

import static com.company.UserInterface.hauptmenue;

public class Datenbank {
    // Instanzvariable

    private Auto[] datenbankArray;
    private int templuecke; //temporäreLücke für Lösch-Methode
    private int arraycounter; // um belegte Plätze zu ermitteln
    //Konstruktor
    public Datenbank(){
        this.datenbankArray= new Auto[50];
    }

    //Methode
    // todo Stringbuilder
    public void alleDatensaetzAusgeben() {
        leerPruefung();
        System.out.println("Id | Hersteller | Modell | Typ | Preis\n");
            for (int i = 0; i < datenbankArray.length; i++) {
                if (datenbankArray[i] != null) {
                    System.out.println(datenbankArray[i].getAutoId() + " | " + datenbankArray[i].getHersteller()
                            + " | " + datenbankArray[i].getModell() + " | " + datenbankArray[i].getTyp()
                            + " | " + datenbankArray[i].getPreis());
                }
            }
            System.out.println("Ausgabe beendet");
            }
    public void neuenDatensatzHinzufuegen(String hersteller, String modell, String typ,double preis ){
        // neues Autoobjekt erzeugen
        Auto auto = new Auto(hersteller,modell,typ, preis);
        // AutoObjekt wird in erste Tasche gespeichert
        if (arraycounter!=datenbankArray.length){   // Prüfe ob Anzahl der Einträge nicht Arraygröße überschreitet
            for (int i = 0; i<datenbankArray.length;i++){
                if(datenbankArray[i] == null){
                    // AutoObjekt wird in die erste freie Tasche des Arrays gespeichert
                    this.datenbankArray[i]=auto;
                    arraycounter++;
                    System.out.println("Datensatz wurde hinzugefügt an Stelle "+i+". Belegte Plätze: "+arraycounter);
                    break;
                }
            }
        }else{
            System.out.println("Das Array ist voll. Konnte nicht hinzugefügt werden.");
            hauptmenue();
        }
    }

    public void datensatzSuchen(String hersteller){
        int counter = 0;
        for (int i = 0; i<datenbankArray.length;i++){
            if(datenbankArray[i]!=null && datenbankArray[i].getHersteller().equals(hersteller)){
                System.out.println((counter+1)+".\t"+datenbankArray[i].getAutoId() + " | " + datenbankArray[i].getHersteller()
                        + " | " + datenbankArray[i].getModell() + " | " + datenbankArray[i].getTyp()
                        + " | " + datenbankArray[i].getPreis());
                counter++;
            }

            else if(datenbankArray[i] == null && counter == 0){
                System.out.println("Keine Übereinstimmung gefunden.");
                break;
            }
        }
        System.out.println("Anzahl der Treffer "+ counter);
        System.out.println("Suche beendet");
    }

    public void datensatzLoeschen(int zuloeschendeID){
           if(zuloeschendeID<=datenbankArray.length-1 && zuloeschendeID!=0){ //Ermitteln, ob Array überhaupt beschrieben ist, ID fängt mit 1 an
               for (int i=0; i< datenbankArray.length-1;i++){
                   if (datenbankArray[i].getAutoId() == zuloeschendeID) {//Eintrag finden und danach löschen
                       datenbankArray[i]= null;
                       arraycounter--;
                       templuecke=i;   //temporäre Variable erstellen, um sich die Position der Lücke zu merken
                       System.out.println("Eintrag wurde gelöscht. Belegte Plätze: "+arraycounter);
                       //eventuelle Lücke im Array schließen
                       if (datenbankArray[templuecke+1]!=null){ //Wenn der Datensatz in einer Lücke ist dann
                           System.out.println("Lücke gefunden");
                           for (int j=datenbankArray.length-1;j>=templuecke;j--){//Array rückwarts nach einem Eintrag durchgehen

                               if (datenbankArray[j]!=null){  //ersten Datensatz finden und ihn in die Lücke zuweisen  &&j>i
                                   //j>i, damit keine neue Lücke entsteht
                                   datenbankArray[templuecke]=datenbankArray[j];
                                   System.out.println("Lücke geschlossen");
                                   datenbankArray[j]=null; //den nun doppelten Dateneintrag löschen
                                   System.out.println("Doppelter Arrayeintrag gelöscht");
                                   hauptmenue();
                               }
                           }
                       } else{
                           System.out.println("Keine Lücke zu schließen");
                           hauptmenue();
                       }
                   }
               }
           }else{
               System.out.println("Nicht im Array vorhanden");
               hauptmenue();
           }
       }

    public void datensaetzeSortieren(){
        //fkt nicht bei null-Werten, neues Array und dann abschneiden
        //Arrays.sort(datenbankArray, Comparator.comparing(Auto::getHersteller));
        //System.out.println(Arrays.toString(a));System.out.println(Arrays.toString(b));

        System.out.println("Ausgabe des sortierten Arrays, nach Hersteller");

        Auto[] a = new Auto[arraycounter]; // Das reine Werte Array
        Auto[] b = new Auto[datenbankArray.length-a.length];
        System.arraycopy(datenbankArray,0,a,0,a.length);
        System.arraycopy(datenbankArray,a.length,b,0,b.length);

        Arrays.sort(a, Comparator.comparing(Auto::getHersteller));  //Sortieren des Werte-Arrays

        for (int i=0;i<a.length;i++){                               // Ausgabe des sortierten Werte-Arrays
            System.out.println(a[i].getAutoId() + " | " + a[i].getHersteller()
                    + " | " + a[i].getModell() + " | " + a[i].getTyp()
                    + " | " + a[i].getPreis());
        }

        System.out.println("Ausgabe beendet");
    }

    public void leerPruefung(){
        if(arraycounter ==0){
            System.out.println("Das Array hat noch keine Einträge");
            hauptmenue();
        }

    }







}

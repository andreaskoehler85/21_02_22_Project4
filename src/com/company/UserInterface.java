package com.company;


import java.util.Scanner;

public class UserInterface {

    // globale Variable
    static Scanner scan = new Scanner(System.in);
    static boolean sollweiter=true;
    // neues Datenbankobjekt
    static Datenbank db = new Datenbank();


    public static void main(String[] args) {
//	 write your code here
//        System.out.println("Hallo");
//        Auto a1 = new Auto("Opel","Combi","Benzin",15000);
//        System.out.println(a1.getHersteller());
//        System.out.println(a1.getAutoId());
//
//        Auto a2 = new Auto("Mercedes","Combi","Benzin",1500);
//        System.out.println(a2.getHersteller());
//        System.out.println(a2.getAutoId());
//
//
//
//
////        Auto a4=new Auto(herteller,modell,typ,preis);
////        System.out.println("Neuer Eintrag: "+ a4.getHersteller()+a4.getModell()+a4.getTyp()+a4.getPreis());
//
//        Auto[] datenbank = new Auto[50];
//        datenbank [0]=a1;
//        System.out.println(datenbank[0].getHersteller());
        //dummydatensaetze();

        do {
            hauptmenue();
        } while(sollweiter);
        System.out.println("Die Auto-Datenbank wurde beendet");
    }
    public static void hauptmenue(){
        System.out.println("\n*** Willkommen im Hauptmenü ***");
        System.out.println("0) \tDummydatensätze erzeugen:");//Testzwecke
        System.out.println("1) \tneues Fahrzeug eingeben:");
        System.out.println("2) \talle Fahrzeuge anzeigen");
        System.out.println("3) \tFahrzeug anhand Id löschen");
        System.out.println("4) \tFahrzeuge nach Hersteller durchsuchen");
        System.out.println("5) \tFahrzeuge nach Hersteller sortieren");
        System.out.println("6) \tProgramm beenden");
        System.out.println("Geben Sie eine Zahl ein.");

        int auswahl = scan.nextInt();
        scan.nextLine(); // verarbeitet das Enter

            if (auswahl==0){
                dummydatensaetze();
            }
            else if (auswahl==1){
                autoHinzufuegenMenue();
            }
            else if (auswahl==2){
                db.alleDatensaetzAusgeben();
            }
            else if (auswahl==3){
                autoLoeschenMenue();
            }
            else if (auswahl==4){
                autoSuchenMenue();
            }
            else if (auswahl==5){
                sortierenMenue();
            }
            else if (auswahl==6){
                sollweiter=false;
            }
            else{
                System.out.println("Falsche Eingabe");
                hauptmenue();
            }

    }
    public static void autoHinzufuegenMenue(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Den Hersteller eingeben");
        String hersteller=sc.nextLine();
        System.out.println("Das Modell eingeben");
        String modell= sc.nextLine();
        System.out.println("Den Typ eingeben");
        String typ= sc.nextLine();
        System.out.println("Den Preis eingeben");
        double preis= sc.nextDouble();
        db.neuenDatensatzHinzufuegen(hersteller, modell, typ, preis);
        hauptmenue();
    }
    public static void autoLoeschenMenue(){
        db.leerPruefung();
        System.out.println("Die Id eingeben");
        int zuloeschendeID = scan.nextInt();
        System.out.println("Lösche "+zuloeschendeID);
        db.datensatzLoeschen(zuloeschendeID);
        //hauptmenue();
    }
    public static void autoSuchenMenue(){
        db.leerPruefung();
        System.out.println("Den Hersteller eingeben");
        String suchen = scan.nextLine();
        System.out.println("Suche nach \""+suchen+"\"");
        db.datensatzSuchen(suchen);
        hauptmenue();
    }
    public static void dummydatensaetze(){
        db.neuenDatensatzHinzufuegen("Mercedes","Seville","dummy1",12000);
        db.neuenDatensatzHinzufuegen("Opel","Puma","dummy2",10000);
        db.neuenDatensatzHinzufuegen("VW","9-5 3.0","dummy3",15000);
        db.neuenDatensatzHinzufuegen("Skoda","Variant 75","dummy1",13000);
        db.neuenDatensatzHinzufuegen("Trabant","A160","dummy2",15000);
        db.neuenDatensatzHinzufuegen("BMW","Smart","dummy3",12000);
        db.neuenDatensatzHinzufuegen("Porsche","Roadster Z3","dummy1",1000);
        db.neuenDatensatzHinzufuegen("VW","Xsara","dummy2",1000);
        db.neuenDatensatzHinzufuegen("Opel","Prowler","dummy3",15000);
        db.neuenDatensatzHinzufuegen("VW","Astra","dummy1",1000);
        System.out.println("Dummy-Datensätze hinzugefügt");
        hauptmenue();
    }
    public static void sortierenMenue(){
        //db.leerPruefung();
        db.datensaetzeSortieren();


    }
}

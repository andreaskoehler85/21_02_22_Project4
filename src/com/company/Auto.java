package com.company;

public class Auto {
//    Klassenvariable an die Klasse gebunden, nicht Objekte

    private static int nextID =1;
    
//    Instanzvariablen
//    private String autoId;
    private int autoId;
    private String hersteller;
    private String modell;
    private String typ;
    private double preis;

    //    Konstruktor
//    public Auto() {
//
//    }

    public Auto( String hersteller,String modell,String typ,double preis  ){
        this.autoId= nextID;
        nextID++;
        this.hersteller=hersteller;
        this.modell=modell;
        this.typ=typ;
        this.preis=preis;
    }
//    Setter
    public void setAutoId(Integer autoId){
        this.autoId=autoId;
    }
    public void setHersteller(String hersteller){
        this.hersteller=hersteller;
    }
    public void setModell(String modell){
        this.modell=modell;
    }
    public void setTyp(String typ){
        this.typ=typ;
    }
    public void setPreis(Double preis){
        this.preis=preis;
    }
//    Getter
    public int getAutoId(){
        return this.autoId;
    }
    public String getHersteller(){
        return this.hersteller;
    }
    public String getModell(){
        return this.modell;
    }
    public String getTyp(){
        return this.typ;
    }
    public double getPreis(){
        return this.preis;
    }


}

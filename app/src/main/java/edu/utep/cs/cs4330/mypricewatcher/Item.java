package edu.utep.cs.cs4330.mypricewatcher;

public class Item {

    private String name;
    private double initialPrice;
    private double currPrice;
    private String URL;

    //Constructors
    protected Item(){

    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setInitialPrice(double initPrice){
        this.initialPrice = initPrice;
    }
    public void setCurrPrice(double currPrice){
        this.currPrice = currPrice;
    }
    public void setUrl(String Url){
        this.URL = Url;
    }

    //Getters
    public String getName(){
        return this.name;
    }
    public double getInitialPrice(){
        return this.initialPrice;
    }
    public double getCurrPrice(){
        return this.currPrice;
    }
    public String getURL(){
        return this.URL;
    }

    //Modifiers
    public double percentageChange(){
        double change = this.currPrice-this.initialPrice;
        return change*100;
    }
    public boolean isEmpty(){
        return (this.URL == null);
    }
    public boolean initIsZero(){
        return(this.initialPrice == 0);
    }
}

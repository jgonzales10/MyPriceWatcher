package edu.utep.cs.cs4330.mypricewatcher;

public class PriceFinder {

    public static double findPrice(String url){
        double price = 0.0; //for now if the price is not in database, it will return -1
        if(url.equals("potatoes.com/potato")){
            price = Math.random() * (5-3);
        }
        else if(url.equals("test.com/item")){
            price = Math.random() * (5-3);
        }
        return price;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*PART 1 PSEUDO CODE
BEGIN
DEFINE PRIVATE CLASS VARIABLES FOR STOCK CODE, NUM IN STOCK, ITEM PRICE.
CREATE CONSTRUCTER FOR THESE VARIABLES
CREATE SET METHODS FOR PRICE AND QUANTITY
CREATE GET METHODS FOR STOCK CODE, STOCK NAME, STOCK DESCRIPTION, STOCK QUANTITY, STOCK PRICE WITHOUT VAT, STOCK PRICE WITH VAT, VAT RATE
CREATE STOCK MANIPULATION METHODS FOR ADDING AND SELLING STOCK
CREATE METHOD TO PROVIDE AN OUTPUT
END
*/
package main;
/**
 *
 * @author Jacob
 */
public class StockItem {

    /**
     * @param args the command line arguments
     */
    
    private final String fixedStockCode;
    private int numInStock;
    private double itemPrice;
    
    //USED TO PROVIDE COLOURED TEXT
    String greenText = "\u001B[32m";
    String yellowText = "\u001B[33m";
    String redText = "\u001B[31m";

    //STOCK ITEM CONSTRUCTOR
    public StockItem(String stockCode, int quantityInStock, double price) {
        this.fixedStockCode = stockCode;
        this.numInStock = quantityInStock;
        this.itemPrice = price;
        System.out.println(yellowText + "Creating a stock with " + numInStock 
                + " units of unknown item, price of " + price + " each, and stock code " + fixedStockCode + "...");
    }
    
    //SETTERS
    
    /*NO SETTER FOR STOCK CODE AS IT IS FIXED*/
    
    public void setQuantity(int quantity){
        System.out.println(yellowText + "Updating quantity to new quantity of " + quantity + "...");
        numInStock = quantity;
    }
    
    public void setPrice(double price){
        System.out.println(yellowText + "Updating price to new price of " + price + "...");
        itemPrice = price;
    }
    
    //GETTERS
    public String getStockCode(){
        return fixedStockCode;
    }
    
    public String getStockName(){
        return "Unknown Stock Name";
    }
    
    public String getStockDesc(){
        return "Unknown Stock Description";
    }
    
    public int getQuantity(){
        return numInStock;
    }
    
    public double getPrice(){
        return itemPrice;
    }
    
    public double getPriceVAT(){
        return itemPrice + (itemPrice/100 * 17.5);
    }
    
    public double getVAT(){
        return 17.5;
    }
    
    //STOCK MANIPULATION METHODS
    public void addStock(int incrementAmmount){
        boolean incrementValid = true;
        boolean stockLevelValid = true;
        
        //If incremnt ammount is less than 1 set incrementValid = false 
        if (incrementAmmount < 1) {
            System.out.println(redText + "Cannot add stock, increment ammount is less than one.");
            incrementValid = false;
        }
        //If total ammount in stock plus the increment ammount is greater than 100 set stockLevelValid = false 
        if (incrementAmmount + numInStock > 100){
            System.out.println(redText + "Cannot add stock, stock level is at max capacity.");
            stockLevelValid = false;
        }
        //If incrementValid and stockLevelValid are true(i.e. none of the above if statements have been triggered) add the stock.
        if (incrementValid && stockLevelValid){
            System.out.println(yellowText + "Adding " + incrementAmmount + " units of stock...");
            setQuantity(numInStock + incrementAmmount); //Calls the setQuantity() setter method to add the stock.
        }
    }
    
    public boolean sellStock(int decrementAmmount){
        boolean decrementValid = true;
        boolean stockLevelValid = true;
        
        //If decremnt ammount is less than 1 set decrementValid = false 
        if(decrementAmmount < 1){
            System.out.println(redText + "Cannot sell stock, decrement ammount is less than one.");
            decrementValid = false;
        }
        //If the decrement ammount is greater than the ammount in stock set stockLevelValid = false.
        if(decrementAmmount > numInStock){
            System.out.println(redText + "Cannot sell stock, decrement ammount is greater than quantity in stock.");
            stockLevelValid = false;
        }
        //If decrementValid and stockLevelValid are true(i.e. none of the above if statements have been triggered) sell the stock.
        if(decrementValid && stockLevelValid){
            System.out.println(yellowText + "Sold " + decrementAmmount + " units of stock...");
            setQuantity(numInStock - decrementAmmount); //Call the setQuantity() method to decrement the stock level. 
            return true; //return the bool val of true if stock is sold as per spec. 
        }
        else{
            return false; //return bool val of false if stock is not sold.
        }
    }
    
    //OUTPUT METHOD

    public String toString(){
        String str;
        System.out.println(yellowText + "Getting stock info...");
        str = greenText + "Stock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT() 
                + greenText;
        return str;
    }
    //NavSys Stock info
    public static class NavSys extends StockItem{ //NavSYS class extending stockitem class
        //NAV SYS Constructor
        public NavSys(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price);    //using super to inherit deafult values from StockItem class    
        }     
        
        //Overiding the StockItem get methods
        @Override
        public String getStockName(){
            return "Navigation System";
        }
    
        @Override
        public String getStockDesc(){
            return "Geovision SatNav";
        }
        
        //Overiding the stock items toString method
        @Override
        public String toString(){
            String str;
            System.out.println(yellowText + "Getting stock info...");
            str = greenText + "Stock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT() 
                + greenText;
            return str;
        }
    }
    //Tires stock info
    public static class Tires extends StockItem{
        //Tire class constructor
        public Tires(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price); //using super to inherit deafult values from StockItem class             
        }       
        
        //Overiding the StockItem get methods
        @Override
        public String getStockName(){
            return "Car Tires";
        }
    
        @Override
        public String getStockDesc(){
            return "Premium car tyres suitable for most vehicles.";
        }
        //Overiding the StockItem toString methods
        @Override
        public String toString(){
            String str;
            System.out.println(yellowText + "Getting stock info...");
            str = greenText + "Stock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT() 
                + greenText;
            return str;
        }
    }
    //Exhaust stock info
    public static class Exhaust extends StockItem{
        //Exhaust constructor
        public Exhaust(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price);      //using super to inherit deafult values from StockItem class   
        }       
        
        //Overiding the StockItem get methods
        @Override
        public String getStockName(){
            return "Exhaust Pipe";
        }
    
        @Override
        public String getStockDesc(){
            return "An exhaust pipe suitable for most sedans";
        }
        //Overriding the StockItem toStringMethod 
        @Override
        public String toString(){
            String str;
            System.out.println(yellowText + "Getting stock info...");
            str = greenText + "Stock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT() 
                + greenText;
            return str;
        }
    }
    //Windows stock info
    public static class Windows extends StockItem{
        //Windows constructor
        public Windows(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price); //Inheriting the values from the stock item class          
        }
        //Overide the get methods from StockItem
        @Override
        public String getStockName(){
            return "Window";
        }
    
        @Override
        public String getStockDesc(){
            return "Car parts";
        }
        //Overide the toString Method
        @Override
        public String toString(){
            String str;
            System.out.println(yellowText + "Getting stock info...");
            str = greenText + "Stock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT() 
                + greenText;
            return str;
        }
    }
}
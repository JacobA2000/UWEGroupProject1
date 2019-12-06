/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*PART 1 PSEUDO CODE
BEGIN
IMPORT SCANNER
DEFINE PRIVATE CLASS VARIABLES FOR STOCK CODE, NUM IN STOCK, ITEM PRICE.
CREATE CONSTRUCTER FOR THESE VARIABLES
CREATE SET METHODS FOR PRICE AND QUANTITY
CREATE GET METHODS FOR STOCK CODE, STOCK NAME, STOCK DESCRIPTION, STOCK QUANTITY, STOCK PRICE WITHOUT VAT, STOCK PRICE WITH VAT, VAT RATE
CREATE STOCK MANIPULATION METHODS FOR ADDING AND SELLING STOCK
CREATE METHOD TO PROVIDE AN OUTPUT
END
*/

/*PART 2 PSEUDO CODE
BEGIN
NAV SYS CLASS EXTENDING STOCK ITEM
    NAV SYS CONSTRUCTOR
        USE SUPER TO INHERIT VALUES
    END CONSTRUCTOR
    
    GET METHODS FOR ITEM NAME AND ITEM DESCRIPTION THAT OVERIDE THE METHODS FROM STOCK ITEM
    TO STRING METHOD THAT OVERIDES THE TO STRING METHOD FROM STOCK ITEM
END CLASS
END
*/

/*PART 3 PSEUDO CODE
BEGIN
TIRES CLASS EXTENDING STOCK ITEM
    TIRES CONSTRUCTOR
        USE SUPER TO INHERIT VALUES
    END CONSTRUCTOR
    
    GET METHODS FOR ITEM NAME AND ITEM DESCRIPTION THAT OVERIDE THE METHODS FROM STOCK ITEM
    TO STRING METHOD THAT OVERIDES THE TO STRING METHOD FROM STOCK ITEM
END CLASS

EXHAUST CLASS EXTENDING STOCK ITEM
    TIRES CONSTRUCTOR
        USE SUPER TO INHERIT VALUES
    END CONSTRUCTOR
    
    GET METHODS FOR ITEM NAME AND ITEM DESCRIPTION THAT OVERIDE THE METHODS FROM STOCK ITEM
    TO STRING METHOD THAT OVERIDES THE TO STRING METHOD FROM STOCK ITEM
END CLASS

WINDOWS CLASS EXTENDING STOCK ITEM
    TIRES CONSTRUCTOR
        USE SUPER TO INHERIT VALUES
    END CONSTRUCTOR
    
    GET METHODS FOR ITEM NAME AND ITEM DESCRIPTION THAT OVERIDE THE METHODS FROM STOCK ITEM
    TO STRING METHOD THAT OVERIDES THE TO STRING METHOD FROM STOCK ITEM
END CLASS
END
*/

package main;

import java.util.Scanner;
import javax.swing.text.html.HTML;
/**
 *
 * @author Jacob
 */
public class StockItem {

    /**
     * @param args the command line arguments
     */
    
    private String fixedStockCode;
    private int numInStock;    //Stock related variables
    private double itemPrice;
    
    String greenText = "\u001B[32m";
    String purpleText = "\u001B[35m";   //Setting text colours
    String redText = "\u001B[31m";
    
    public boolean stockPositive = false;
    public boolean stockPriceValid = false;   //Declaring boolean flags used for validation
    public boolean quantityValid = false;
    
    Scanner systemInput = new Scanner(System.in);    //Creating scanner for system input
    
    //STOCK ITEM CONSTRUCTOR
    public StockItem(String stockCode, int quantityInStock, double price){
        if(quantityInStock < 1){
            System.out.println(redText + "Cannot create stock with a quantity of less than 1");
            quantityValid = false;      //if quantity is less than 1 set quantity flag to false
        }
        else if (quantityInStock >= 1){
            quantityValid = true;     //if quantity greater than or equal to 1 set quantity flag to true.
        }
        if(price <= 0.00){
            System.out.println(redText + "Cannot create stock with a set price of less than 0.01");
            stockPriceValid = false;   //if price is less than or equal to 0.00 set stock price flag to false
        }
        else if (price > 0){
            stockPriceValid = true;   //if price is greater than 0 set stock price flag to true
        }
        if(quantityValid && stockPriceValid){
            stockPositive = true;     //if both quantity and stock price flags are true, then set stockPositive flag to true and create the stock item
            this.fixedStockCode = stockCode;
            this.numInStock = quantityInStock;
            this.itemPrice = price;
            System.out.println(purpleText + "Creating a stock with " + numInStock 
                    + " units of stock, price of " + price + " each, and stock code " + fixedStockCode + "...");
        }
    }
    
    //SETTERS
    
    public void setQuantity(int quantity){
        System.out.println(purpleText + "Updating quantity to new quantity of " + quantity + "...");
        numInStock = quantity;
    }
    
    public void setPrice(){
        double price;
        System.out.println(purpleText + "Please enter the desired price: ");
        price = systemInput.nextDouble();   //Getting users input and setting it as the price
        
        if(price > 0.0){ 
            System.out.println(purpleText + "Updating price to new price of " + price + "...");
            itemPrice = price;  //if the price is greater than 0 set the price to the inputted value.
        }
        else
            System.out.println(redText + "Cannot set price less than 0.01");  //else output an error message
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
        return itemPrice + (itemPrice/100 * getVAT());  //Add VAT to the price.
    }
    
    public double getVAT(){
        return 17.5;
    }
    
    //STOCK MANIPULATION METHODS
    public void addStock(){
        int incrementAmount;
        boolean incrementValid = true;
        boolean stockLevelValid = true;
        
        System.out.println(purpleText + "Please enter an amount of stock to add: ");
        incrementAmount = systemInput.nextInt(); //get the ammount of stock the user wishes to add.
        
        if (incrementAmount < 1) {
            System.out.println(redText + "Cannot add stock, increment amount is less than one.");    
            incrementValid = false;     //if the ammount of stock to add is less than 1 set incrementValid flag to false.
        }
        if (incrementAmount + numInStock > 100){
            System.out.println(redText + "Cannot add stock, as stock level would exceed the max capacity of 100.");
            stockLevelValid = false; //if the ammount of stock would exceed 100 after adding set stockLevelValid flag to false.
        }
        if (incrementValid && stockLevelValid){
            System.out.println(purpleText + "Adding " + incrementAmount + " units of stock...");
            setQuantity(numInStock + incrementAmount);  //if both incrementValid and stockLevelValid flags are true, then update the quantity to reflect the addition of stock.
        }
    }
    
    public boolean sellStock(){
        int decrementAmount;
        boolean decrementValid = true;  
        boolean stockLevelValid = true;
        
        System.out.println(purpleText + "Please enter an amount of stock to sell: ");
        decrementAmount = systemInput.nextInt();  //get the ammount the user wishes to sell.
        
        if(decrementAmount < 1){
            System.out.println(redText + "Cannot sell stock, decrement amount is less than one.");
            decrementValid = false; //if the ammount to sell is less than 1, then set the flag decrementValid to false;
        }
        if(decrementAmount > numInStock){
            System.out.println(redText + "Cannot sell stock, decrement amount is greater than quantity in stock.");
            stockLevelValid = false; //if the ammount to sell is greater than the amount in stock, then set the flag stockLevelValid to false;
        }
        
        if(decrementValid && stockLevelValid){
            System.out.println(purpleText + "Sold " + decrementAmount + " units of stock...");
            setQuantity(numInStock - decrementAmount);  //if decrementValid and stockLevelValid flags are true then update the quantity to reflect the sale of stock.
            return true; //returns true if sale has happened
        }
        else{
            return false;  //returns false if sale has not happened
        }
    }
    
    //OUTPUT METHOD

    public String toString(){
            String str;
            System.out.println(purpleText + "Getting stock info...");
            str = greenText + "-------------------STOCK INFO-------------------"
                + greenText + "\nStock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc()                 //Use getter methods to get the relevant information to output.
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT()
                + greenText + "\n------------------------------------------------"
                + greenText;
            return str;
    }
    //NavSys Stock info
    public static class NavSys extends StockItem{                                      //Creating the NavSys class that is a subclass of StockItem
        public NavSys(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price);  //Inherrit default values from the stock item class.
            
        }       
        @Override //Overide StockItems getStockName, getStockDesc and toString method.
        public String getStockName(){
            return "Navigation System";
        }
    
        @Override
        public String getStockDesc(){
            return "Geovision SatNav";
        }
        @Override
        public String toString(){
            String str;
            System.out.println(purpleText + "Getting stock info...");
            str = greenText + "-------------------STOCK INFO-------------------"
                + greenText + "\nStock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT()
                + greenText + "\n------------------------------------------------"
                + greenText;
            return str;
        }
    }
    //Tires stock info
    public static class Tires extends StockItem{
        public Tires(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price);
            
        }       
        @Override
        public String getStockName(){
            return "Car Tires";
        }
    
        @Override
        public String getStockDesc(){
            return "Car Parts";
        }
        @Override
        public String toString(){
            String str;
            System.out.println(purpleText + "Getting stock info...");
            str = greenText + "-------------------STOCK INFO-------------------"
                + greenText + "\nStock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT()
                + greenText + "\n------------------------------------------------"
                + greenText;
            return str;
        }
    }
    //Exhaust stock info
    public static class Exhaust extends StockItem{
        public Exhaust(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price);
            
        }       
        @Override
        public String getStockName(){
            return "Exhaust Pipe";
        }
    
        @Override
        public String getStockDesc(){
            return "Car parts";
        }
        @Override
        public String toString(){
            String str;
            System.out.println(purpleText + "Getting stock info...");
            str = greenText + "-------------------STOCK INFO-------------------"
                + greenText + "\nStock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT()
                + greenText + "\n------------------------------------------------"
                + greenText;
            return str;
        }
    }
    //Windows stock info
    public static class Windows extends StockItem{
        public Windows(String stockCode, int quantityInStock, double price) {
            super(stockCode, quantityInStock, price);
            
        }       
        @Override
        public String getStockName(){
            return "Window";
        }
    
        @Override
        public String getStockDesc(){
            return "Car parts";
        }
        @Override
        public String toString(){
            String str;
            System.out.println(purpleText + "Getting stock info...");
            str = greenText + "-------------------STOCK INFO-------------------"
                + greenText + "\nStock code:     " + getStockCode() 
                + greenText + "\nStock name:     " + getStockName() 
                + greenText + "\nStock desc:     " + getStockDesc() 
                + greenText + "\nUnits in stock: " + getQuantity() 
                + greenText + "\nPrice:          " + getPrice() 
                + greenText + "\nPrice with VAT: " + getPriceVAT()
                + greenText + "\n------------------------------------------------"
                + greenText;
            return str;
        }
    }
}
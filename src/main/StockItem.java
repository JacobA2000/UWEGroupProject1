/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*PSEUDO CODE

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
        
        if (incrementAmmount < 1) {
            System.out.println(redText + "Cannot add stock, increment ammount is less than one.");
            incrementValid = false;
        }
        if (incrementAmmount + numInStock > 100){
            System.out.println(redText + "Cannot add stock, stock level is at max capacity.");
            stockLevelValid = false;
        }
        
        if (incrementValid && stockLevelValid){
            System.out.println(yellowText + "Adding " + incrementAmmount + " units of stock...");
            setQuantity(numInStock + incrementAmmount);
        }
    }
    
    public boolean sellStock(int decrementAmmount){
        boolean decrementValid = true;
        boolean stockLevelValid = true;
        
        if(decrementAmmount < 1){
            System.out.println(redText + "Cannot sell stock, decrement ammount is less than one.");
            decrementValid = false;
        }
        if(decrementAmmount > numInStock){
            System.out.println(redText + "Cannot sell stock, decrement ammount is greater than quantity in stock.");
            stockLevelValid = false;
        }
        
        if(decrementValid && stockLevelValid){
            System.out.println(yellowText + "Sold " + decrementAmmount + " units of stock...");
            setQuantity(numInStock - decrementAmmount);
            return true;
        }
        else{
            return false;
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
}

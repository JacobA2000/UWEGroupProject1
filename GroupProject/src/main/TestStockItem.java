/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Jacob
 */
public class TestStockItem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StockItem stock = new StockItem("E#404", 1, 1);
        if(stock.stockPositive == true){
            System.out.println(stock.toString());
            stock.addStock();
            System.out.println(stock.toString());
            stock.sellStock();
            System.out.println(stock.toString());
            stock.setPrice();
            System.out.println(stock.toString());
            }
        }
    
}
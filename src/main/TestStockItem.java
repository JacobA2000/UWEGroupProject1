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
        StockItem stock = new StockItem("A#134", 80, 2);
        System.out.println(stock.toString());
        stock.addStock(10);
        System.out.println(stock.toString());
        stock.sellStock(2);
        System.out.println(stock.toString());
        stock.setPrice(3);
        System.out.println(stock.toString());
        stock.addStock(0);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.StockItem.NavSys;


/**
 *
 * @author r2-pope
 */
public class TestNavSys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NavSys stock = new StockItem.NavSys("A#134", 1, 30);
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

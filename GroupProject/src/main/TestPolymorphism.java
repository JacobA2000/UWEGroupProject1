package main;
import main.StockItem.NavSys;
import main.StockItem.Tires;
import main.StockItem.Exhaust;
import main.StockItem.Windows;
/**
 *
 * @author r2-pope
 */
public class TestPolymorphism {
    public static void itemInstance(StockItem stock) {
        if(stock.stockPositive == true){
            System.out.println(stock.toString());
            stock.addStock();
            System.out.println(stock.toString());
            stock.sellStock();
            System.out.println(stock.toString());
            stock.setPrice();
            System.out.println(stock.toString());
            System.out.println(stock.redText + "END OF TESTING FOR " + stock.getStockName() + " STOCK ITEM");
        }
    }

    public static void main(String[] args) {
        Tires TiresVar = new main.StockItem.Tires("AE123", 1, 1);
        Exhaust ExhaustVar = new main.StockItem.Exhaust("BC456", 1, 2);
        Windows WindowsVar = new main.StockItem.Windows("CD423", 1, 0.01);
        StockItem[] StockArray = {TiresVar, ExhaustVar, WindowsVar};
        for(int i = 0; i < 3; i++){
            itemInstance(StockArray[i]);
        }
    }
}
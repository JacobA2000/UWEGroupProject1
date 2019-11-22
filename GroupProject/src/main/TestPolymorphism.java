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
        System.out.println(stock.toString());
        stock.addStock(10);
        System.out.println(stock.toString());
        stock.sellStock(2);
        System.out.println(stock.toString());
        stock.setPrice(3);
        System.out.println(stock.toString());
        stock.addStock(0);
    }

    public static void main(String[] args) {
        Tires TiresVar = new main.StockItem.Tires("AE123", 80, 20);
        Exhaust ExhaustVar = new main.StockItem.Exhaust("BC456", 160, 40);
        Windows WindowsVar = new main.StockItem.Windows("CD423", 75, 6);
        StockItem[] StockArray = {TiresVar, ExhaustVar, WindowsVar};
        for(int i = 0; i < 3; i++){
            itemInstance(StockArray[i]);
        }
    }
}
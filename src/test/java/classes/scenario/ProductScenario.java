package classes.scenario;

import classes.container.ProductList;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ProductScenario extends Scenario {
    private final String productName;
    private final double price;
    private final GregorianCalendar dateBestBefore;
    private final ProductList productList;

    public ProductScenario(String productName, double price, GregorianCalendar dateBestBefore) {
        this.productName = productName;
        this.price = price;
        this.dateBestBefore = dateBestBefore;
        productList = new ProductList();
    }

    @Override
    public void execute() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Cписок товаров " + productName + ":");
        System.out.println(productList.getProductsWithName(productName));
        System.out.println("Cписок товаров " + productName + ", цена которых не превосходит " + price + ":");
        System.out.println(productList.getProductsWithNameAndPrice(productName,price));
        System.out.println("Cписок товаров, срок хранения которых больше " + dateFormat.format(dateBestBefore.getTime()) + ":");
        System.out.println(productList.getProductsWithDateBestBefore(dateBestBefore));
    }
}

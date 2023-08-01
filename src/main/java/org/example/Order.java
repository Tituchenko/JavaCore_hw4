package org.example;

/**
 *  1. Написать классы заказ (объект покупатель, объект товар, целочисленное количество).
 */
public class Order {
    private Buyer buyer;
    private Product product;
    private int count;

    private static Buyer[] buyers;
    private static Product[] products;

    public static void setBuyers(Buyer[] buyers) {
        Order.buyers = buyers;
    }

    public static void setProducts(Product[] products) {
        Order.products = products;
    }

    public static Order Buy(String buyerFIO, String productName, int count){
        Order resultBuy=new Order();
        resultBuy.buyer=Order.getBuyerByName(buyerFIO);
        resultBuy.product=Order.getProductByName(productName);
        resultBuy.count=count;

        if (resultBuy.product==null) throw new ProductException(productName);
        if (resultBuy.count<1 || resultBuy.count>100) throw new AmountException(count);
        if (resultBuy.buyer==null) throw new CustomerException(buyerFIO);
        return resultBuy;
    }

    private static Buyer getBuyerByName (String name){
        for (Buyer buyer:buyers) {
            if (buyer.getFio().equals(name)) return buyer;
        }
        return null;
    }
    private static Product getProductByName (String name){
        for (Product product:products) {
            if (product.getName().equals(name)) return product;
        }
        return null;
    }

    @Override
    public String toString() {
        return  "-".repeat(80)+
                "\nПокупатель=" + buyer.getFio() +
                "\nТовар=" + product.getName() +
                "\nКоличество=" + count +
                "\nСтоимость="+product.getPrice()*count;
    }
}

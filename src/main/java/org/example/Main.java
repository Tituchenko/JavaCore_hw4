package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс «Эмуляция интернет-магазина».
 * 1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ (объект покупатель,
 * объект товар, целочисленное количество).
 * 2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов)
 * и массив заказов (пустой на 5 элементов).
 * 3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа.
 * Метод должен вернуть объект заказа.
 * 4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException,если передан
 * несуществующий товар, метод олжен выбросить исключение ProductException, если было передано отрицательное или
 * слишком больше значение количества (например, 100), метод должен выбросить исключение AmountException.
 * 5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми
 * значениями. Обработать исключения следующим образом (в заданном порядке):
 * – если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
 * – если было передано неверное количество – купить товар в количестве 1;
 * – если был передан неверный пользователь – завершить работу приложения с исключением.
 * 6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.
 */
public class Main {
    public static void main(String[] args) throws ProductException {
        Buyer[] buyers = new Buyer[2];

        buyers[0]= new Buyer("Иванов И.И.",29,"81234567");
        buyers[1]= new Buyer("Петров А.Н.",35,"123456789");

        Product[] products=new Product[5];
        products[0]=new Product("Ручка",9.5f);
        products[1]=new Product("Карандаш",11.4f);
        products[2]=new Product("Ластик",10);
        products[3]=new Product("Тетрадь 80л",15);
        products[4]=new Product("Блокнот",25.6f);



        Order[] orders=new Order[5];
        Order.setBuyers(buyers);
        Order.setProducts(products);
        int i,j;
        i=0;
        j=0;
        String[] testFIO={"Иванов И.И.","Петров А.Н.","99Иванов И.И.","Петров А.Н.","Иванов И.И."};
        String[]  testProduct={"Карандаш","Ластик","абракадабра","Тетрадь 80л","Ластик"};
        int[] testCount={10,0,200,-5,12};
        while (i<5) {
            try {
                orders[j] = Order.Buy(testFIO[i], testProduct[i], testCount[i]);
            }
            catch (ProductException e){
                e.printStackTrace();
            }
            catch (AmountException e){
                orders[j] = Order.Buy(testFIO[i], testProduct[i], 1);
            }
            catch (CustomerException e){
                e.printStackTrace();
                System.exit(1);
            }
            finally {
                i++;
                if (orders[j]!=null) j++;

            }
        }
        System.out.printf("Всего покупок: %d\n",j);
        for (Order o:orders) {
            System.out.println(o);
        }

    }
}
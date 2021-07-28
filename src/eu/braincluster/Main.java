package eu.braincluster;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args)
    {
        var names = Arrays.asList("Pistabá", "Feribá", "Béla", "Juliska");

        // for loop
        for (int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i));
        }

        System.out.println();

        // foreach loop
        for (String name : names)
        {
            System.out.println(name);
        }

        System.out.println();

        // Consumer, anonymous class
        names.forEach(new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        });

        // Lambda 1
        names.forEach((final String name) -> System.out.println(name));
        System.out.println();

        // Lambda 2
        names.forEach(name -> System.out.println(name));
        System.out.println();

        // Lambda 3
        names.forEach(name -> { System.out.println(name); });
        System.out.println();

        // Lambda 4
        names.forEach(System.out::println);
        System.out.println();
    }
}

package eu.braincluster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args)
    {
        Test1();
        Test2();
    }

    private static void Test1()
    {
        var names = Arrays.asList("Pistabá", "Feribá", "Béla", "Julis");

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

    private static void Test2()
    {
        var names = Arrays.asList("Pistabá", "Feribá", "Béla", "Julis");
        var uppercaseNames = new ArrayList<String>();

        // foreach loop
        for (var name : names)
        {
            uppercaseNames.add(name.toUpperCase());
        }

        uppercaseNames.forEach(System.out::println);
        System.out.println();

        // Lambda 1
        uppercaseNames.clear();
        names.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        uppercaseNames.forEach(System.out::println);
        System.out.println();

        // Lambda 2
        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);

        System.out.println();

        // Lambda 3
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println();
    }
}

package eu.braincluster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Test 1");
        Test1();

        System.out.println("Test 2");
        Test2();

        System.out.println("Test 3");
        Test3();
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
        names.forEach(name -> {
            System.out.println(name);
        });
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

    public static void Test3()
    {
        var names = Arrays.asList("Pistabá", "Feribá", "Béla", "Julis", "Fatime");

        // Filter 1
        names.stream()
                .filter(name -> name.startsWith("F"))
                .forEach(System.out::println);

        System.out.println();

        // Filter 2
        var startsWithF =
                names.stream()
                        .filter(name -> name.startsWith("F"))
                        .collect(Collectors.toList());

        startsWithF.stream()
                .forEach(System.out::println);

        System.out.println();

        // Filter 3 with Predicate
        Predicate<String> startsWithFCharacter = name -> name.startsWith("F");

        startsWithF =
                names.stream()
                        .filter(startsWithFCharacter)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

        startsWithF.stream()
                .forEach(System.out::println);

        System.out.println();

        // Filter 4
        Function<String, Predicate<String>> startsWithLetter =
                letter -> (name -> name.startsWith(letter));

        var startsWithP =
                names.stream()
                        .filter(startsWithLetter.apply("P"))
                        .collect(Collectors.toList());

        startsWithP.stream()
                .forEach(System.out::println);

        System.out.println();
    }
}

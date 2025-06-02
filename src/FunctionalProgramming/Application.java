package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Application implements Runnable{
    public static void printOperation(Integer value, UnaryOperator operator) {
        System.out.println(operator.operate(value));
    }

    public static void printOperation(Integer value, UnaryStringOperator operator) {
        System.out.println(operator.operate(value.toString()));
    }

    public static void printOperation(Integer a, Integer b, BinaryOperator operator) {
        System.out.println(operator.operate(a,b));
    }

    public static void printOperation(NonStaticContainer a, NonStaticContainer b, BinaryOperator3 operator) {
        System.out.println(operator.calculate(a,b));
    }

//    public static void printOperation(Integer a, Integer b, BinaryOperator2 operator) {
//        System.out.println(operator.calculate((double) a,b));
//    }

    public static void printOperation(Integer a, CustomStringOperator operator) {
        System.out.println(operator.operate(new StringClass(a.toString())));
    }

    @Override
    public void run() {
        Integer a = 10;
        Integer b = 20;
//
//        printOperation(a, new UnaryOperator() {
//            @Override
//            public Integer operate(Integer value) {
//                return a*a;
//            }
//        });
//
////        printOperation(a, x -> x*x);
//
//        printOperation(a, (Integer x) -> {
//            return x*x;
//        });

        printOperation(a, b, new BinaryOperator() {
            @Override
            public Integer operate(Integer a, Integer b) {
                return a/b;
            }
        });

//        printOperation(a, b, (Double x,Integer y) -> (int)(x/y));

        NonStaticContainer nonStaticContainer = new NonStaticContainer();
//        Integer c=300;
        printOperation(a,b,(x,y) -> x+y);
        printOperation(a,b,(x,y) -> x*y);
        printOperation(a,b,(x,y) -> Math.max(x,y));
        printOperation(a,b,Math::max);
//        printOperation(a,b,NonStaticContainer::max);
        NonStaticContainer n1=null,n2=null;
        printOperation(n1,n2,NonStaticContainer::max);
        printOperation(a, b, new BinaryOperator() {
            @Override
            public Integer operate(Integer a, Integer b) {
                return Math.max(a,b);
            }
        });
//
//        printOperation(a, StringClass::toUpper);
//        printOperation(a, StringClass::toLower);
//
//        ArrayList<Integer> intList = new ArrayList<>();
//        intList.add(1);
//        intList.add(2);
//        intList.add(4);
//        intList.add(7);
//
//        Stream<Integer> integerStream = intList.stream();
//        Stream<Integer> evenStream = integerStream.filter(x -> {
//            System.out.println(x);
//            return x%2==0;
//        });
//
//        Stream<String> thirdStream = evenStream.map(x -> x.toString()+x.toString());
//
////        evenStream.toArray();
//        thirdStream.forEach(System.out::println);
//
//        Optional<Integer> countOptional = intList.stream().filter(x -> x%2==0).map(x -> x+0.5).map(x -> 1).reduce((x, y) -> x+y);
//        System.out.println("The count is: "+countOptional.get());
//
////        Integer countClosure = 0;
//        Optional<Integer> averageOptional = intList.stream().parallel().filter(x -> x%2==0).map(x->new Pair(x,1)).reduce((x, y) -> new Pair(x.value+y.value, x.count+y.count)).map(x -> x.value/x.count);
//        System.out.println("The average is: "+averageOptional.get());
//
//        Predicate<Integer> isEven = x-> x%2==0;
//        Predicate<Integer> isNegative = x-> x<0;
//        intList.stream().allMatch(isEven.and(isNegative));
//        intList.stream().anyMatch(isEven.and(isNegative));
//        intList.stream().noneMatch(isEven.and(isNegative));
//
//        String[] stringArray = new String[]{"My name is Hossein", "This is another sentence"};
//        Arrays.stream(stringArray).flatMap(x -> Arrays.stream(x.split(" "))).distinct().forEach(System.out::println);
//
////        evenStream.reduce((x, y) -> x+y);
//
////
////        Object[] intResult = evenStream.toArray();
////        for(Object object:intResult) {
////            System.out.println(object);
////        }
////
////        Object[] intResult2 = integerStream.toArray();
    }
}

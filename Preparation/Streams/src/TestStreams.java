import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TestStreams {

    public static void main(String[] args) {
          firstPipeline();
          lazyRetrieveDataPipeline();
          beneficialOfUsingSreamsLazyOPerationPipeline();
          collectionStreams();
          mapStreams();
          streamOfExample();
          streamFromFileLines();
         infiniteStream();
         optionalStream();    //Optional<T> it replace null - If stream is empty then Optional will be empty (we do not deal with null at all)
          terminalStream();
          reduceWithoutOptionalStream();  // allways will return some value
         reduceWithOptionalStream();    // samethimes stream could be empty ( return null )
        // reduceBiFunctionAndBinaryOperatorStream();
        // mutableCollection();  // collect() - for mutable object (tłum. zmienny) mutuable object:  StringBuilder and ArrayList  collect()
        // preDefinedCollectors();
         collectingIntoMap();
          collectorsGroupingBy();
         collectorsPartitioningBy();
        // intermidiateOperationFilter();
        // intermidiateOperationDistinct();
        // intermidiateOperationLimit();
        // intermidiateOperationMap();
        // intermidiateOperationFlatMap();
        // intermidiateOperationSorted();
        // primitiveStream();
        // optional();
        // doOptionalWithNull();
        // doOptionalWithPrimitives();
        parallelStreams();
    }

    private static void parallelStreams() {
        // Parallel streams can process elements in a stream concurrently i.e. at the same time
        // Java split stream up into sub-streams and then the pipeline operations
        // are performed on the sub-stream concurrently (each sub has its own thred).
        // we use parallel(), parallelStream() methods
        // 1. parallel() - is available in Stream<T>
        // 2. parallelStream() is definied in the Collection<E> interface

        Stream<String> animalStream1 = List.of("sheep", "pigs", "horses")
                .parallelStream();   // from Collection<E> api

        Stream<String> animalStream2 = Stream.of("sheep", "pigs", "horses")
                .parallel();  // from Stream<T> api

        // Sequential stream
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                  // IntStream has the sum() method so we use
                  // the mapToInt() method to map from Stream<Integer>
                  // to an IntStream ( a stream of int primitives)
                  // IntStream mapToInt(ToIntFunction)
        // ToIntFunction is functional interface: has method int applyAsInt(T value);
                .mapToInt(n -> n.intValue())
                // OR  .mapToInt(Integer::intValue)
                // OR  .mapToInt(n -> n)
                .sum();
        System.out.println(sum);


        //IntStream mapToInt(ToIntFunction<? super T> mapper);
        //public interface ToIntFunction<T> {  has method: int applyAsInt(T value);
        ToIntFunction<Integer> function = new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer v) {
                return (int)v;
            }
        };
        // lambda
        ToIntFunction<Integer> function2 = v -> (int) v;  // OR v -> v   OR Integer::intValue

        //parallel version
        int sum2 = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum2);


    }

    private static void doOptionalWithPrimitives() {
        // public void ifPresent(DoubleConsumer action) {
        //public interface DoubleConsumer {  ma metodę :  void accept(double value);
        DoubleConsumer consumer = new DoubleConsumer() {
            @Override
            public void accept(double value) {

            }
        };
        // lambda
        DoubleConsumer lamConsumer = v -> System.out.println(v);


        OptionalDouble optAvg = IntStream.rangeClosed(1, 10)
                .average();
        optAvg.ifPresent( v-> System.out.println(v));
        System.out.println();

        //Example.2
        // public double orElseGet(DoubleSupplier supplier) {
        //public interface DoubleSupplier {  ma tetodę:  double getAsDouble();
        DoubleSupplier doubleSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Double.NaN;
            }
        };
        // lambda
        DoubleSupplier doubleSupplier2 = () -> Double.NaN;

        System.out.println(optAvg.orElseGet(() -> Double.NaN));
    }

    private static void doOptionalWithNull() {
        Optional<String> optSK = howToDealWithNull("SK");
        optSK.ifPresent(System.out::println);

        Optional<String> optSKNull = howToDealWithNull(null);
        System.out.println(
                optSKNull.orElseGet(() -> "Empty optional")
        );
    }

    private static Optional<String> howToDealWithNull(String param) {
        Optional optReturn = param == null ? Optional.empty() : Optional.of(param);
        return  optReturn;
    }

    private static void optional() {
        // Example.1
        Optional<Double> doubleV1 = calcAvg(10.1, 20.9, 21.1);
        Optional<Double> doubleVEmpty = calcAvg();
        // if optional is empty you get: NoSuchElementException: No value present
        //System.out.println(doubleVEmpty.get() + 10d);  //Exception in thread "main" java.util.NoSuchElementException: No value present
        if (doubleVEmpty.isPresent()) {
            System.out.println(doubleVEmpty.get() + 10d);
        }
        // pomijamy if
        //public void ifPresent(Consumer<? super T> action) {
        //public interface Consumer<T> {   ma metodę:   void accept(T t);
        Consumer<Double> consumer = new Consumer<Double>() {
            @Override
            public void accept(Double d) {
                System.out.println(d);
            }
        };
        // lambda
        Consumer<Double> lambConsumer = d -> System.out.println(d);

        doubleV1.ifPresent(d -> System.out.println(d + 10.11));
        // OR
        Double d = doubleV1.orElse((Double.NaN));


        Optional<Double> aptAvg2 = calcAvg();  // will return empty Optional
        System.out.println(aptAvg2.orElse(Double.NaN));
        // OR
        System.out.println(aptAvg2.orElseGet(() -> Math.random()));

        // public T orElseGet(Supplier<? extends T> supplier) {
        //public interface Supplier<T> {   ma metodę  T get();
        Supplier<Double> supplierD = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        // lambda
        Supplier<Double> supplierD2 = () -> Math.random();
    }

    private static Optional<Double> calcAvg(double ... scores) {
        if (scores.length == 0) return  Optional.empty();

        double sum = 0.0;
        for (double score : scores) sum += score;
        return Optional.of(sum / scores.length);
    }

    private static void primitiveStream() {
        // As opposed to Stream<T> where T = Integer, Double, Long
        // we could have
        // - IntStream for int
        // - DoubleStream for double
        // - LongStream for long

        // The primitive streams, besides standard Stream methods,
        // also contain specialised methods for working with numeric data
        // min() sum() average() etc.

        //Example.1
        int[] ia = {1, 2, 3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la = {1L, 2L, 3L};

        IntStream streamIa = Arrays.stream(ia);
        DoubleStream streamDa = Arrays.stream(da);
        LongStream streamLa = Arrays.stream(la);

        System.out.println(streamIa.count() + " : " + streamDa.count() + " : " + streamLa.count());

        //Example.2
        IntStream streamIa2 = IntStream.of(1, 2, 3);
        DoubleStream streamDa2 = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream streamLa2 = LongStream.of(1L, 2L, 3L);

        //Example.3
        // 1. using Stream<T> abd reduce(identity, accumulator)
        Stream<Integer> numbers = Stream.of(1, 2, 3);
        // dodawanie elementów streama
        // Integer reduce(Integer indentity, BinaryOperator accumulator)
        //  BinaryOperator extends BIFunction<T,T,T>   with method   T apply(T,T);

//        BinaryOperator  extends BiFunction
//        public interface BiFunction<T, U, R> {  and this got method T apply(T,T);

        BiFunction<Integer, Integer, Integer> accumulator = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer i1, Integer i2) {
                return i1 + i2;
            }
        };
        // lambda
        BiFunction<Integer, Integer, Integer> lambAccumulator = (n1, n2) -> n1 + n2;

        Integer i = numbers.reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(i);  //6

        // Using IntStream and sum()
        // IntStream mapToInt(ToIntFunction)
        // ToIntFunction is functional interface
        //  int applyAsInt(T t)

        ToIntFunction<Integer> function = new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        };
        // lambda
        ToIntFunction<Integer> lambdaFunction = v -> v;

        IntStream intStream1 = Stream.of(1, 2, 3)
                .mapToInt(v -> v);  // unboxing
        int myInt1 = intStream1.sum();  //6
        System.out.println(myInt1);

        IntStream intStream2 = Stream.of(1, 2, 3)
                .mapToInt(v -> v);  // unboxing
        int myInt2 = intStream2.reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(myInt2);

        //Example.4
        OptionalInt max = IntStream.of(10, 20, 30)
                .max();
        max.ifPresent(System.out::println);

        OptionalDouble min = DoubleStream.of(10.1, 20.2, 30.3)
                .min();
       System.out.println(min.orElseThrow());   // we use Optional... NoSuchElementException is thrown if no value present

        OptionalDouble average = DoubleStream.of(10.1, 20.2, 30.3)
                .average();

       // public double orElseGet(DoubleSupplier supplier) {
         //   public interface DoubleSupplier {  has method:  double getAsDouble();

        DoubleSupplier supplier1 = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        // lambda
        DoubleSupplier supplier2 = () -> Math.random();


        System.out.println(average.orElseGet(() -> Math.random()));


        //Example.5
        IntStream numbs =  IntStream.of(5, 10, 15, 20);
        IntStream empty =  IntStream.empty();

        IntSummaryStatistics intSummaryStatistics = numbs.summaryStatistics();
        int min_ = intSummaryStatistics.getMin();  //5
        int max_ = intSummaryStatistics.getMax();  // 20
        double avg = intSummaryStatistics.getAverage(); // 12.5
        long count = intSummaryStatistics.getCount(); // 4
        long sum = intSummaryStatistics.getSum(); // 50

        IntSummaryStatistics intSummaryStatisticsEmpty = empty.summaryStatistics();
        int minE = intSummaryStatisticsEmpty.getMin();   // 2147483647
        int maxE = intSummaryStatisticsEmpty.getMax();   // -2147483648
        double avgE = intSummaryStatisticsEmpty.getAverage(); // 0.0
        long countE = intSummaryStatisticsEmpty.getCount();  // 0
        long sumE = intSummaryStatisticsEmpty.getSum(); // 0
    }

    private static void intermidiateOperationSorted() {
        // sorted() returns a stream withe sorted elem.
        // Just like sorting arrays, java uses natural ordering unless we provide a comparator
        // sorted() is a stateful intermediate operation => it needs to see all of the data before it can sort it!

        // Stream<T> sorted(Comparator<T> comparator)
        //Out:  Person {name=John, age=23} Person {name=Mary, age=25}


        // Stream<T> sorted(Comparator<T> comparator);
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getAge() - p2.getAge() > 0) {
                    return 1;
                } else if (p1.getAge() - p2.getAge() < 0) {
                    return -1;
                }
                return 0;
            }
        };

        Comparator<Person> ageComparator = (p1, p2) -> {
            int ageDifference = p1.getAge() - p2.getAge();
            return Integer.compare(ageDifference, 0);
        };


        // Example.1
        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);
        Stream<Person> stream = Stream.of(mary, john)
                .sorted((p1, p2) -> {
                    int ageDifference = p1.getAge() - p2.getAge();
                    return Integer.compare(ageDifference, 0);
                });
        stream.forEach(System.out::println);

        Function<Person, Integer> function = new Function<Person, Integer>() {
            @Override
            public Integer apply(Person p) {
                return p.getAge();
            }
        };
        // lambda
        Function<Person, Integer> function2 =   p -> p.getAge();

        // Example.2
        Stream<Person> stream2 = Stream.of(mary, john)
                .sorted(Comparator.comparing(p -> p.getAge()));
                // OR .sorted(Comparator.comparing(Person::getAge));
        stream2.forEach(System.out::println);

        //Example.3
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(n -> System.out.println(" 0."+ n ))  //"Tim", "Jim", "Peter", "Ann", "Mary"
                .filter(n -> n.length() == 3)
                .peek(n -> System.out.println(" 1."+ n ))  //"Tim", "Jim",   "Ann"
                .sorted()                                  // "Ann"  "Jim"      "Tim" - juz nie wejdzie ze wzgledu na limit(2)
                .peek(n -> System.out.println(" 2."+ n ))  // "Ann"  "Jim"      "Tim" - juz nie wejdzie ze wzgledu na limit(2)
                .limit(2)
                .forEach(n -> System.out.println(" 3." + n));  // "Ann"  "Jim"

    }

    private static void intermidiateOperationFlatMap() {
        // flatMat() takes each element in the stream e.g. Stream<List<String>>
        // and makes any elements it contains top-level elements
        // in a single stream e.g.  Stream<String>

        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("mary", "ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        // flatMap(Function(T, R))  IN:T  OUT:R
        //   flatMap(List<String>, Stream<String)



        Function<List<String>, Stream<String>> function = new Function<List<String>, Stream<String>>() {
            @Override
            public Stream<String> apply(List<String> list) {
                return list.stream();
            }
        };
        //lambda
        Function<List<String>, Stream<String>> lambda = l -> l.stream();

        //  <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

        Stream<String> stream = streamOfLists
                 .flatMap(l -> l.stream());
        stream.forEach(System.out::print);

    }

    private static void intermidiateOperationMap() {
        // map() create a one-to-one mapping between elements in
        //   the stream and elements in the next stage of the stream
        // map() is for transforming dara.
        //   <R> Stream<R> map (Function<T, R> mapper
                  //   Function"s functional method:  R apply(T t);

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        // lambda
        Function<String, Integer> lambda = s -> s.length();

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        // lambda
        Consumer<Integer> lambConsumer = i -> System.out.println(i);


        // Example.1
        // transformation of Stream of String's to the Stream of Integer's
        Stream<Integer> streamI = Stream.of("book", "pen", "ruler")
                .map(s -> s.length())
                ;
        streamI.forEach(i -> System.out.println(i));                   // void forEach(Consumer<? super T> action);
        
    }

    private static void intermidiateOperationLimit() {
        // limit()  short-circuiting stateful intermidiate operation
        // Stream<T> limit(long maxSize)
        // lazy evaluation, are not streamed as they are not needed

        // Example.1
        Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99)
               // .peek(n -> System.out.println(" A - " + n))
                .filter(n-> n > 40)
               // .peek(n -> System.out.println(" B - " + n))
                .limit(2)
                .forEach(n -> System.out.println(" C - " + n));  //44, 55
    }

    private static void intermidiateOperationDistinct() {
        // distinct() returns a stream with removed duplicate values  (equals() is used)

        // Stream<T> distinct()
        // distinct() is a stateful intermidiate operation


        // Example.1
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.println(" 1." + s))
                .distinct()
                .forEach(s -> System.out.println(" 2." + s));
        //1.eagle
        //2.eagle
        //1.eagle
        //1.EAGLE
        //2.EAGLE
    }

    private static void intermidiateOperationFilter() {
        // intermidiate opertion produces a stream as a result
        // Stream<T> filter(Predicate)
        // filter return a Stream with element matching given Predicate

        Stream<String> stream = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter")
                .filter(s -> s.length() > 3);
        stream.forEach(System.out::println);

        //
    }

    private static void collectorsPartitioningBy() {
        // Partitioning is a special case of grouping where there are only two possible groups - true and false
        // key will be booleans true and false

        /*
            Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
                                                                                                    return partitioningBy(predicate, toList());
                                                                                                   }
         */

        // Example.1
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(s -> s.startsWith("T"))
                );
        System.out.println(map);

        // Example.2
        Stream<String> names2 = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map2 =
                names2.collect(
                        // pass in Predicate
                        Collectors.partitioningBy(s -> s.length() > 4)
                );
        System.out.println(map2);

        // Example.3  we want Set
        Stream<String> names3 = Stream.of("Thomas", "Teresa", "Mike", "Thomas", "Peter");
        Map<Boolean, Set<String>> map3 =
                names3.collect(
                        Collectors.partitioningBy(
                                s -> s.length() > 4, // Predicat
                                Collectors.toSet()
                         )
                );
        System.out.println(map3);
    }

    private static void collectorsGroupingBy() {
        // groupingBy() tells collector to group all elements into Map
        // groupingBy() takes Function Interface which determines the key in the Map
        // Each value is a List of all entries that match the key. The List is a default, which can be changed

        /*
            public static <T, K> Collector<T, ?, Map<K, List<T>>>
                  groupingBy(Function<? super T, ? extends K> classifier) {
                                                                           return groupingBy(classifier, toList());
                                                                           }


              public interface Function<T, R> {   R apply(T t);   }


        */

        // Example.1
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map =
                names.collect(
                // passing in a Function that determines the key in Map
                        Collectors.groupingBy(s -> s.length())   // OR String::length
        );
        System.out.println(map);

        // Example.2   we want Set instead of List as the value in the map (Set will remove duplication of "Tom")

        /*
            public static <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                          Collector<? super T, A, D> downstream) {
                                                                                  return groupingBy(classifier, HashMap::new, downstream);
                                                                                    }
        */

        Stream<String> names2 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, Set<String>> map2 =
                names2.collect(
                        Collectors.groupingBy(
                                String::length,  // key function   Function<? super T, ? extends K> classifier
                                Collectors.toSet() // what to do with the values
                        )
                );
        System.out.println(map2);

        // Example.3
        // We want to TreeMap but leave the values as a List.
        // We must then use Optional map Suppier while passing down the toList() collector.

        Stream<String> names3 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        TreeMap<Integer, List<String>> map3 =
                names3.collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,   //map type Supplier
                                Collectors.toList()  // downstream collector
                        )
                );
        System.out.println(map3);
        System.out.println(map3.getClass());
    }

    private static void collectingIntoMap() {
        // We will required two function
        // 1. tell collector how to create the key
        // 2. tell collector how to create the value

        //Example - we want to map: dessert name -> number of chars in deseret name
        // Output:  {biscuit=8, cake=4, appletarrt=10}

        Function<String, String> keyMapper1 = new Function<>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        //lambda
        Function<String, String> keyMapper2 = s -> s;
        String  key = keyMapper2.apply("cake");

        Function<String, Integer> keyValueMapper = new Function<>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        //lambda
        Function<String, Integer> keyValueMapper2 = s -> s.length();
        Integer keyValue = keyValueMapper2.apply("cake");


        // Example.1
        Map<String, Integer> map = Stream.of("cake", "biscuit", "tart")
                .collect(Collectors.toMap(
                        s -> s,           //key:       input String, return String
                        s -> s.length()   //keyValue:  input String, return Integer
                ));
        System.out.println(map);



        BinaryOperator<String> merge = new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + ", " + s2;
            }
        };
        // lambda
        BinaryOperator<String> merge2 = (s1, s2) -> s1 + ", " + s2;
        String mergedStrings = merge2.apply("kaka1", "kaka12");



        // Example.2
        /*
        Returns a Collector that accumulates elements into a Map whose keys and values are the result
        of applying the provided mapping functions to the input elements.
If the mapped keys contain duplicates (according to Object.equals(Object)), the value mapping function
is applied to each equal element, and the results are merged using the provided merging function.
Params:
keyMapper     – a mapping function to produce keys
valueMapper   – a mapping function to produce values
mergeFunction – a merge function, used to resolve collisions between values associated with the same key,
                as supplied to Map.merge(Object, Object, BiFunction)
        */

        Map<Integer, String> map2 = Stream.of("cake", "biscuit", "tart", "tart", "tart", "tart", "tart")
                .collect(
                        Collectors.toMap(
                                s -> s.length(), //key is the lenght
                                s -> s,  //value is the String
                                (s1, s2) -> s1 + ", " + s2)  //Merge function - what to do if we have duplicate keys
                                                             // - append the values
                );
        System.out.println(map2);



        // Example.3
        // The maps returned are HashMaps. If we want to have a TreeMap (values will be sorted automaticly)
        TreeMap<String, Integer> treeMap = Stream.of("cake", "biscuit", "tart")
                .collect(
                        Collectors.toMap(
                                s -> s,   //key is the String
                                s -> s.length(),  //value is the length of the String
                                (len1, len2) -> len1 + len2,  //want to do if we have duplicate keys -- add the value
                                () -> new TreeMap<>()   //TreeMp::new  not works!!!  TreeMap is not part of Collector and Map
                                                        // nie imlementują interfejsu Collection<E>
                        )
                );

        /*
            Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper,
                             Function<? super T, ? extends U> valueMapper,
                             BinaryOperator<U> mergeFunction,
                             Supplier<M> mapFactory) {
        */

    }

    private static void preDefinedCollectors() {
      // Access these collectors via static methods on the Collector  interface
      // It is important to pass the Collector to collect() method. Collector do not do anything
        // It helps collect elements

        String s = Stream.of("cake", "biscuit", "alle tart")
                .collect(Collectors.joining(", "));
        System.out.println(s);


        //  averagingInt(ToIntFunction<? super T> mapper)    functional method is:
        //    int applyAsInt(T value);
        ToIntFunction<String> toIntFunc = new ToIntFunction<>() {
            @Override
            public int applyAsInt(String s) {
                return s.length();
            }
        };
        // lambda
        ToIntFunction<String> lambda = f -> f.length();

        Double avg = Stream.of("cake", "biscuit", "alle tart")
                .collect(Collectors.averagingInt(f -> f.length()));
        System.out.println(avg);
    }

    private static void mutableCollection() {
        // mutuable object:  StringBuilder and ArrayList
        // we use the same mutable (zmienny)object while accumulating
        // this make more efficient then regular reductions
        // Useful method when let us get data out of streams and put into Map, List, Set

        //  StringBuilder collect (Supplier<StringBuilder> supplier,
        //                       BiConsumer<StringBuilder, String> accumulator,
        //                       BiConsumer<StringBuilder, StringBuilder> combiner)
        // help us control over how collecting should work.
        // Accumulator adds an element to the collection - next String to StringBuilder
        // Combiner takes two collections and merge them. It is usefull in pararell processing.

        Supplier<StringBuilder> supplier = new Supplier<>() {
            @Override
            public StringBuilder get() {
                return new StringBuilder();
            }
        };
        // lambda(s)
        Supplier<StringBuilder> supplier2a = () -> new StringBuilder();
            //lub
        Supplier<StringBuilder> supplier2b = StringBuilder::new;

        BiConsumer<StringBuilder, String> consumer = new BiConsumer<StringBuilder, String>() {
                @Override
                public void accept(StringBuilder sb, String s) {
                    sb.append(s);
                }
        };
        // lambda
        BiConsumer<StringBuilder, String> consumer1 = (sb, s) -> sb.append(s);

        BiConsumer<StringBuilder, StringBuilder> consumer2 = new BiConsumer<StringBuilder, StringBuilder>() {
                @Override
                public void accept(StringBuilder sb1, StringBuilder sb2) {
                    sb1.append(sb2);
                }
        };
        //lambda
        BiConsumer<StringBuilder, StringBuilder> consumer3 = (sb1, sb2) -> sb1.append(sb2);

        //Example
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                    .collect(StringBuilder::new,
                            (sb, s) -> sb.append(s),
                            (sb1, sb2) -> sb1.append(sb2)
                    );
        System.out.println(word);

    }

    private static void reduceBiFunctionAndBinaryOperatorStream() {
        /*
        <U> U reduce (U identity,
                      BiFunction accumulator,
                      BinaryOperator combiner)
         We use it when dealing with differennt types,
         allow to create intermediate reductions  (pośrednie redukcje) and finaly combine themm at end
         Useful when working with parallel streams. Streams can be decomposed and reassembled by separate
         treads.
         "car" and "bus" is taken as first thread  - it gives 6
         "train" and "aeroplane" is taken as second thread  - it gives 14
         then it goes to combiner and gives 6+14=20
         */
        Stream<String> stream = Stream.of("car", "bus", "train", "train", "aeroplane");
        int lenghtOfAllLetters = stream
                .reduce(0,
                        (n, str) -> n + str.length(),   //accumulator give two treads: one 6 letters  second 14 letters
                        (n1, n2) -> n1 + n2);   // na samym końcu uruchamia się,zlicza wartości pośrednie
                                                // z wątków pośrednich zliczających iloci znaków
                                                // combiner give 20
        System.out.println(lenghtOfAllLetters);

        BiFunction<Integer, String, Integer> accumulator = new BiFunction<Integer, String, Integer>() {
            @Override
            public Integer apply(Integer n, String s) {
                return n + s.length();
            }
        };
        // lambda
        BiFunction<Integer, String, Integer> lambda = (n, s) -> n + s.length();

        BinaryOperator<Integer> combiner = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        };
        BinaryOperator<Integer> combLambda = (n1, n2) -> n1 + n2;
    }

    private static void reduceWithOptionalStream() {
        // Optional<T> reduce (BinaryOperator<T> accumulator)
        // When leave out the identity parameter,  an Optional is
        // returned because there may not be any data (all elements may be filtered earlier).
        // We have 3 possibilities:
        // 1. empty stream => empty Optional returned
        // 2. one element in stream => that element is returned
        // 3. multiple elements in strem=> accumulator is applied

        BinaryOperator<Integer> op = (a,b)-> a + b;

        Stream<Integer> empty = Stream.empty();
        empty.reduce(op).ifPresent(System.out::println);  // null => empty

        Stream<Integer> oneElement = Stream.of(6);
        oneElement.reduce(op).ifPresent(System.out::println);  //6

        Stream<Integer> multipleElements = Stream.of(3, 4, 5);
        multipleElements.reduce(op).ifPresent(System.out::println);  // 12

        Integer val = Stream.of(1, 1, 1)
                .filter(i -> i > 1115)  // nie będzie żadnych elementów po tym filtrze, jednak reduce() i tak bierze te elementy
                .reduce(1, (a, b) -> a);  //
        System.out.println(val);

        // step1:  1  wzięta z identity
        // step2:  1
        // step3:  1
        // step4:  1
        //final: 1

        Stream<Integer> sval = Stream.of(1, 1, 1)
                .filter(i -> i > 5);  // nie będzie żadnych elementów
        sval.forEach(System.out::println);
        // Integer i = sval.reduce(1, (a, b) -> a);  //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or clos
        // System.out.println(i);

        Collection<Integer> cval = Stream.of(1, 1, 1)
                .filter(i -> i > 5)
                .collect(Collectors.toList());
        System.out.println(cval);

    }

    private static void reduceWithoutOptionalStream() {
        // The reduce() method combine stream into a single object.
        // Reducing it process all elements
        // starts with initial value and keep merging it with the next value and etc
        // T reduce(T identity, BinaryOperator<T> accumulator)
        //
        //             BinaryOperator<T> functionl method:  T apply(T, T);

        //   T identity   - is the initial value of the reduction and alse what is returned if stream is empty.
        // Acumulator combined the current result with the curr value in the stream.

        BinaryOperator<String> stringBinaryOperator = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return null;
            }
        } ;
        //as lambda
        BinaryOperator<String> aslambda = (s1, s2) -> s1+s2;

        // Example of reduction

        String combineLetters = Stream.of("s", "e", "a", "n")
               // .filter(s -> s.length() > 2)
               // .reduce("nothing", (s, c) -> s + c);
                        .reduce("", (s, c) -> s + c);

        // step1:  ""+s        initial value is empty
        // step2:  s+e         accumulating
        // step3:  se+a         accumulating
        // step4:  sea+n         accumulating
        // finish:  sean
        System.out.println(combineLetters);  // sean



        String combineLetters2 = Stream.of("s", "e", "a", "n")
          .filter(s -> s.length() > 2)   // to nam wszysko wyklucza
         .reduce("nothing", (s, c) -> s + c);    // i zostanie tylko initial
        System.out.println(combineLetters2);   // nothing

        Integer i = Stream.of(1, 2, 3)
                .reduce(1, (a,b) -> a * b);
         // step1: 1*1 =1
         // step2: 1*2 =2
         // step3: 2*3 =6
        System.out.println(i);   // 6

    }

    private static void terminalStream() {
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = n -> n.startsWith("A");
        System.out.println(names.stream().allMatch(pred));
        System.out.println(names.stream().noneMatch(pred));

        // bo
//        Predicate<String> pred1 = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        };
//        Predicate<String> pred2 = s -> s.startsWith("A");

        Stream<String> names2 = Stream.of("Cathy", "Pauline", "Zoe");
        names2.forEach(System.out::println);
    }

    private static void optionalStream() {

        /*
        min(Comparator<? super String> comparator)
        Comparator<? super Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
        Comparator<? super String> comparator2 = (a, b) -> a.length() - b.length();

         */



        Optional<String> min = Stream.of("deer", "horse", "pig", "cat")
                .min((s1, s2) -> s1.length() - s2.length());  // min(Comparator<? super String> comparator)
        min.ifPresent(System.out::println);

        // lub
        Optional<String> min2 = Stream.of("deer", "horse", "pig", "cat")
                .min(Comparator.comparingInt(String::length));  // min(Comparator<? super String> comparator)
        min2.ifPresent(System.out::println);




        Optional<Integer> max = Stream.of(4, 6, 2, 12, 9)
                .max(Comparator.comparingInt(i -> i));
        max.ifPresent(System.out::println);
        // lub
        Optional<Integer> max2 = Stream.of(4, 6, 2, 12, 9)
                .max(Comparator.comparingInt(i -> i));
        max2.ifPresent(System.out::println);


        Optional<String> any = Stream.of("John", "Paul")
                .findAny();
        any.ifPresent(System.out::println);  //John usually :)

        Optional<String> first = Stream.of("John", "Paul")
                .findFirst();
        first.ifPresent(System.out::println);  //John
    }



    private static void infiniteStream() {
        // infinite stream of random unordered numbers
        // between 0 ... 9
        // Stream<T> generate(Supplier<T> s)
        // Supplier :    has method  T get();

        Stream<Integer> infStream = Stream
                .generate(
                    () -> (int) (Math.random() * 10)
                )
                .limit(10);
        //  infinite call  - to stop Ctrl+Z
         infStream.forEach(System.out::println);

        /*
        UnaryOperator<Integer> integerUnaryOperator1 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n) {    //R apply(T t);
                return n+1;
            }
        };
        //lub lambda
        UnaryOperator<Integer> integerUnaryOperator = n -> n+1;

         */

        Stream<Integer> infStream2 = Stream.iterate(2, n -> n+1)         //   pierwsze raz(2, 3)   drugi (3, 4)  trzeci (4, 5)  etc
                .limit(10);

        infStream2.forEach(System.out::println);
    }

    private static void streamFromFileLines() {
        String fileName = "src/example.txt"; // Assuming example.txt exists in the current directory

        List<String> items = new ArrayList<>();


        try (Stream<String> linesStream = Files.lines(Paths.get(fileName))) {
            linesStream.forEach( line -> {
                        String[] itemsArray = line.split("/");
                        items.add(itemsArray[0]);
                    });
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
        items.forEach(System.out::println);
    }


    private static void streamOfExample() {
        Stream<Integer> streamI = Stream.of(1, 2, 3);
        System.out.println(streamI.count());

        Stream<String> streamS = Stream.of("sss", "rrr", "oooo");
        System.out.println(streamS.count());

        Stream<Dog> streamO = Stream.of(new Dog(), new Dog(), new Dog(), new Dog(), new Dog(), new Dog());
        System.out.println(streamO.count());
    }

    private static void mapStreams() {
        //Map
        // Mapy nie imlementują wprawdzie interfejsu Collection<E>, ale są także częścią Java Collections API.
        // Mapy<K, V> i Collection<E> łączymy za pomocą metod Map  entrySet() to return a Set view of the Ma:  Set<Map.Entry<K, V>> entrySet();  bo public interface Set<E> extends Collection<E> {
        // Set<E> is Collection
        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);
        namesToAges.put("David", 11);
        namesToAges.put("Tom", 44);

        Long ile = namesToAges
                .entrySet()    // first convert MAp to Set<E> whis implement stream() method because it inherited from Collectoion<E> interface  (Set<E> extende Collection<E>)
                .stream()    // stream() is default method in Collection<E>
                .count();
        System.out.println(ile);
    }

    private static void collectionStreams() {
        //Collection
        List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");
        // using stream() method, which is defalt method in Collection Interface
        // and therefore is inherited by all classes that implement Collection.
        Stream<String> straemOfNames = names.stream();
        System.out.println(straemOfNames.count());
    }

    private static void beneficialOfUsingSreamsLazyOPerationPipeline() {
        Stream.of("Alex", "David", "April", "Edward")
                .map(s -> {
                    System.out.println("map: " + s);  // intermediate operation (pośrednia operacja)
                    return s.toUpperCase();
                })
                .anyMatch(s -> {  // ends when first true is returned (Alex)
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });


        List<String> names = Arrays.asList("April", "Ben", "Charlie", "David", "Benildus", "Christian");
        names.stream()
                .peek(System.out::println)
                .filter(s -> {
                    System.out.println("filter1: " + s);
                    return s.startsWith("B") || s.startsWith("C");
                })
                .filter(s -> {
                    System.out.println("filter2: " + s);
                    return s.length() > 3;
                })
                .limit(1)  // intermediate operation (pośrednia operacja)  Stream<T> limit(long)
                .forEach(System.out::println);  // terminate operation

    }

    private static void lazyRetrieveDataPipeline() {
        Stream.of("Alex", "David", "April", "Edward")
                .filter(s -> {
                            System.out.println("filter: " + s);
                            return true;
                        }
                )
                .forEach(s -> System.out.println("forEach: " + s));   // forEach is terminal operation
    }

    private static void firstPipeline() {
        List<Double> temps = Arrays.asList(99.9, 100.2, 89.88, 102.91);

        Long howManyTempsGreaterThen100Degr =
                temps
                        .stream()
                        // .peek(System.out::println)
                        .filter(t -> t > 100)
                        .peek(System.out::println)
                        .count();
        System.out.println("wynik: " + howManyTempsGreaterThen100Degr);
    }
}





















































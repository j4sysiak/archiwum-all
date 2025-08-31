package com.company.szkolenie3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StremMethods {

    public static final List<Car> cars1 = Arrays.asList(new Car("Toyota", 2018));
    public static final List<Car> cars2 = Arrays.asList(new Car("Kamaz", 2019));
    public static final List<Car> cars3 = Arrays.asList(new Car("Porsche", 2020), new Car("Lancia", 2026), new Car("Audi", 2025));
    public static final List<Car> cars4 = Arrays.asList(new Car("Prawi", 2021), new Car("Beta", 2027));
    public static final List<Car> cars5 = Arrays.asList(new Car("Lewi", 2022), new Car("Gamma", 2028));
    public static final List<Car> cars6 = Arrays.asList(new Car("Magia", 2023), new Car("Zaporożec", 2028));

//    public static final Person PERSON_1 = new Person("Buckingham", "Banglesnatch", 19, BigDecimal.valueOf(7000), cars1);
//    public static final Person PERSON_2 = new Person("Bourgeoisie", "Capitalist", 22, BigDecimal.valueOf(8900), cars2);
//    public static final Person PERSON_3 = new Person("Bodybuild", "Creamsicle", 33, BigDecimal.valueOf(1000), cars3);
//    public static final Person PERSON_4 = new Person("Rumblesacka", "Concubine", 44, BigDecimal.valueOf(6655), cars4);
//    public static final Person PERSON_5 = new Person("Congleton", "Carrotpatch", 55, BigDecimal.valueOf(2345), cars5);
//    public static final Person PERSON_6 = new Person("Liverswort", "Creamsicle", 66, BigDecimal.valueOf(8877), cars6);

    // lub

    public static final Person PERSON_1 = new Person("Buckingham", "Banglesnatch", 19, BigDecimal.valueOf(7000), List.of(new Car("Toyota", 2018)));
    public static final Person PERSON_2 = new Person("Bourgeoisie", "Capitalist", 19, BigDecimal.valueOf(8900), List.of(new Car("Toyota", 2018)));
    public static final Person PERSON_3 = new Person("Bodybuild", "Creamsicle", 19, BigDecimal.valueOf(1000), List.of(new Car("Toyota", 2018), new Car("Lancia", 2026), new Car("Audi", 2025)));
    public static final Person PERSON_4 = new Person("Rumblesacka", "Concubine", 11, BigDecimal.valueOf(6655), List.of(new Car("Prawi", 2021), new Car("Beta", 2027)));
    public static final Person PERSON_5 = new Person("Congleton", "Carrotpatch", 55, BigDecimal.valueOf(2345), List.of(new Car("Lewi", 2022), new Car("Gamma", 2028)));
    public static final Person PERSON_6 = new Person("Liverswort", "Creamsicle", 66, BigDecimal.valueOf(8877), List.of(new Car("Magia", 2023), new Car("Zaporożec", 2028)));

    Stream<Person> getPersonStream() {
        return Stream.of(PERSON_1, PERSON_2, PERSON_3, PERSON_4, PERSON_5, PERSON_6);
    };
}

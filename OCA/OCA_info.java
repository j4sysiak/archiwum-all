/*
class Employee {
    public int salary;
    void empl(){}
    void whoIam(){
        System.out.println("Employee");
    }
}

class Manager extends com.udayan.oca.Employee {
    public int budget;
    void manag(){}
    void whoIam(){
        System.out.println("Manager");
    }
}

class Director extends com.udayan.oca.Manager {
    public int stockOpt;
    void direc(){}
    void whoIam(){
        System.out.println("Director");
    }
}

public class Test {
    public static void main (String[] args) {
        com.udayan.oca.Employee e = new com.udayan.oca.Employee();
        com.udayan.oca.Manager m = new com.udayan.oca.Manager();
        com.udayan.oca.Director d = new com.udayan.oca.Director();

        // Employee em = new Manager();
        //  e = (Employee) em;

        e.empl();
        e.whoIam();
        System.out.println(e.salary);


        System.out.println("");
    }
}
*/


//i=2
//---------------------------------------------------------
//new Double(5/4) = 1.0
//---------------------------------------------------------
/*
interface I {
    public void displayI();
}

class Base {
    public void displayC2() {
        System.out.println("Base");
    }
}

class Derived extends Base implements I {
    @Override
    public void displayI() {
        System.out.println("Derived");
    }
}

public class Test {

    public static void main(String[] args) {

        Derived d = new Derived();
        I di = (Derived) d;

        //------- 1
        Base b1 = new Base();
        b1=  d;
        b1= (Base) di;

  //      d = (Derived) b1;  //ERROR: Exception in thread "main" java.lang.ClassCastException: com.udayan.oca.Base cannot be cast to com.udayan.oca.Derived


        //--------- 2
        Base b2 = new Derived();
        b2= d;
        b2 = (Base) di;

        d=(Derived) b2;  // OK bez RuntimeExceptiona

        System.out.println("");
    }
}
*/





/*
        Widening Casting (automatically) - converting a smaller type to a larger type size
        byte -> short -> char -> int -> long -> float -> double
        int a=10;
        double b = a;  // Automatic casting: using an int as a double  (w doubla wpierdolić int - czyli w większe wpierdolić mniejsze)

        Derived1 -> Derived2 -> Derived3 -> Derived4 -> Base
        Derived2 d = new Derived2();
        Base b = (Base) d;  // rzutowanie opcjonalne   (w Base wpierdolić Derived)



        Narrowing Casting (manually) - converting a larger type to a smaller size type
        double -> float -> long -> int -> char -> short -> byte

        double d=10;
        int a = (int) d; // Manual casting: using a double as an int  (w int wpierdolić doubla - czyli w mniejsze wpierdolić większe)

        Base -> Derived4 -> Derived3 -> Derived2 -> Derived1
        Base b = new Base();
        Derived2 d = (Derived2) b;  // MUSI być jawne rzutowannie,  bez błedu kompilacji, ALE błąd RuntimeExc: (ClassCastException)

        żeby nie było błędu typu (ClassCastException):
        Base b = new Derived2();
        Derived2 d = (Derived2) b;
*/


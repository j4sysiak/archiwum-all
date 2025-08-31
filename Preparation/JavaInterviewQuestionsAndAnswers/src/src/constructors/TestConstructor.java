package src.constructors;
class Animal {
    String	name;
    public Animal()	{
        this("Default	Name");
    }
    //	This	is	called	a	one	argument	constructor.
    public Animal(String	name)	{
        this.name =	name;
    }
}
public class TestConstructor {
    public static void main(String[]	args)	{
        Animal animal =	new Animal();
        System.out.println(animal);
    }
}

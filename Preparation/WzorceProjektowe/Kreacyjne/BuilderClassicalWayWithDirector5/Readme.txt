
################################## Computer
https://www.digitalocean.com/community/tutorials/IMotocycleBuilder-design-pattern-in-java


Builder Design Pattern in Java
Let’s see how we can implement IMotocycleBuilder design pattern in java.

1. First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class.
We should follow the naming convention and if the class name is Computer then IMotocycleBuilder class should be named as ComputerBuilder.

2. Java Builder class should have a public constructor with all the required attributes as parameters.

3. Java Builder class should have methods to set the optional parameters and it should return the same Builder object after setting the optional attribute.

4. The final step is to provide a build() method in the IMotocycleBuilder class that will return the Object needed by client program. For this we need to have a private constructor in the Class with Builder class as argument.


##############################  Auto
https://www.youtube.com/watch?v=MaY_MDdWkQw
package playground;

public class JavaPlayground {

    public static void main(String[] args) {
        System.out.println("Hello, java!");
        System.out.println(Person.N_EYES);
    }
}

class Person {
    // a class-wide constant in Java
    public static final int N_EYES = 2;
}

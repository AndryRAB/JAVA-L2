import java.util.function.BinaryOperator;

public class Exercice1 {

    @FunctionalInterface
    interface Operation {
        int appliquer(int a, int b);
    }

    public static void main(String[] args) {
        Operation addition = (a, b) -> a + b;
        Operation soustraction = (a, b) -> a - b;
        Operation multiplication = (a, b) -> a * b;
        Operation maximum = (a, b) -> Math.max(a, b);

        int a = 7;
        int b = 3;

        System.out.println("addition       : " + addition.appliquer(a, b));
        System.out.println("soustraction   : " + soustraction.appliquer(a, b));
        System.out.println("multiplication : " + multiplication.appliquer(a, b));
        System.out.println("maximum        : " + maximum.appliquer(a, b));
    }
}

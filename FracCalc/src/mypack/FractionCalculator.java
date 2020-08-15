package mypack;

public class FractionCalculator {
    public static void main(String[] args) {
        HelperMethods.intro();

        while (....) {
            String operation = HelperMethods.getOperation();
            Fraction frac1 = HelperMethods.getFraction();
            Fraction frac2 = HelperMethods.getFraction();

            if (operation.equals("=")) {
                System.out.println(frac1 + " " + operation + " " + frac2 + " is " + frac1.equals(frac2));
            } else {
                if (operation.equals("+")) {
                    frac1.add(frac2);
                } else if (operation.equals("-")) {
                    frac1.subtract(frac2);
                } else if (operation.equals("/")) {
                    if (frac2.getNum() == 0) {
                        throw new IllegalArgumentException("Undefined. Denominator cannot be zero");
                    } else {
                        frac1.divide(frac2);
                    }
                } else if (operation.equals("*")) {
                    if (frac2.getNum() == 0) {
                        System.out.println("0");
                    } else {
                        frac1.multiply(frac2);
                    }
                }
            }

        }
    }
}
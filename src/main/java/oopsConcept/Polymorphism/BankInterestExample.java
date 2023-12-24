package oopsConcept.Polymorphism;

public class BankInterestExample {

    public static void main(String[] args) {
        // Create instances of different banks
        RBI rbi = new RBI();
        AxisBank axisBank = new AxisBank();
        CITIBank citiBank = new CITIBank();
        SBI sbi = new SBI();

        // Display interest rates
        System.out.println("RBI Interest Rate: " + rbi.getInterestRate() + "%");
        System.out.println("Axis Bank Interest Rate: " + axisBank.getInterestRate() + "%");
        System.out.println("CITI Bank Interest Rate: " + citiBank.getInterestRate() + "%");
        System.out.println("SBI Interest Rate: " + sbi.getInterestRate() + "%");
    }

    static class RBI {
        // Default interest rate for RBI
        public double getInterestRate() {
            return 10.50;
        }
    }

    static class AxisBank extends RBI {
        // Overriding the getInterestRate method for Axis Bank
        @Override
        public double getInterestRate() {
            return 12.25;
        }
    }

    static class CITIBank extends RBI {
        // Overriding the getInterestRate method for CITI Bank
        @Override
        public double getInterestRate() {
            return 12.50;
        }
    }

    static class SBI extends RBI {
        // Overriding the getInterestRate method for SBI
        @Override
        public double getInterestRate() {
            return 11.25;
        }
    }
}

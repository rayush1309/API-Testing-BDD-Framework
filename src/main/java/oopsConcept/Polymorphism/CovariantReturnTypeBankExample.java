package oopsConcept.Polymorphism;

public class CovariantReturnTypeBankExample {
    public static void main(String[] args) {
        // Create instances of different banks
        Bank genericBank = new Bank();
        AxisBank axisBank = new AxisBank();
        HDFCBank hdfcBank = new HDFCBank();
        SBIBank sbiBank = new SBIBank();

        // Get and display interest rates for each bank
        System.out.println("Generic Bank Interest Rate: " + genericBank.getInterestRate() + "%");
        System.out.println("Axis Bank Interest Rate: " + axisBank.getInterestRate() + "%");
        System.out.println("HDFC Bank Interest Rate: " + hdfcBank.getInterestRate() + "%");
        System.out.println("SBI Bank Interest Rate: " + sbiBank.getInterestRate() + "%");
    }

    // Base class representing a generic bank
    static class Bank {
        // Method to get the interest rate set by the bank
        Number getInterestRate() {
            return 5.0; // A generic interest rate
        }
    }

    // Subclass representing Axis Bank
    static class AxisBank extends Bank {
        // Overriding the getInterestRate method with a more specific return type
        @Override
        Double getInterestRate() {
            return 6.75; // Specific interest rate for Axis Bank
        }
    }

    // Subclass representing HDFC Bank
    static class HDFCBank extends Bank {
        // Overriding the getInterestRate method with a more specific return type
        @Override
        Double getInterestRate() {
            return 7.0; // Specific interest rate for HDFC Bank
        }
    }

    // Subclass representing SBI (State Bank of India)
    static class SBIBank extends Bank {
        // Overriding the getInterestRate method with a more specific return type
        @Override
         Integer getInterestRate() {

            return 6; // Specific interest rate for SBI
        }
    }
}

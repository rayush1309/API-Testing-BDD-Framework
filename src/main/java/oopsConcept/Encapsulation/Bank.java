package oopsConcept.Encapsulation;

public class Bank {
    public int accountNumber = 123456;
    private int pinNumber = 1234;
    public double balanceAmount = 100000;

    public void withdrawAmount(int acNo, int pin, double amount) {
        if (acNo == accountNumber && pin == pinNumber) {
            if (amount <= balanceAmount) {
                balanceAmount = balanceAmount - amount;
                System.out.println("Amount withdrawal: " + amount);
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("Invalid Details!!");
        }
    }

    public void updatePin(int acNo, int oldPin, int newPin) {
        if (acNo == accountNumber && oldPin == pinNumber) {
            pinNumber = newPin;
            System.out.println("PIN updated successfully");
        } else {
            System.out.println("Invalid credentials");
        }
    }
    public double depositCash(int acNo, int pin, double amount){
        if (acNo==accountNumber && pin ==pinNumber){
            balanceAmount= balanceAmount+amount;
            return balanceAmount;
        }else {
            System.out.println("Invalid credentials");
            return  balanceAmount;
        }
    }
}

package oopsConcept.Encapsulation;

public class ATM {
    public static void main(String[] args) {
        Bank bank = new Bank();
       // bank.pinNumber=2093;
        //bank.accountNumber=299239;
       // bank.withdrawAmount(299239, 2093, 9000);

        bank.updatePin(123456,1234,8005);
        bank.withdrawAmount(123456, 8005, 9000);

    }


}

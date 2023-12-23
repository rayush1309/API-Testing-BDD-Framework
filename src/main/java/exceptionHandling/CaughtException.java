package exceptionHandling;

public class CaughtException {

        public static void main(String[] args) throws InterruptedException {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // to avoid multiple time try catch we can throws declaration at class level: add exception at Method signature
            Thread.sleep(4000);
        }
}

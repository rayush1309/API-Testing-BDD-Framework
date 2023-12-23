package exceptionHandling;

public class ThrowableSuperClass {
        public static void main(String[] args) {
            try {
                // Some code that may throw a Throwable, Error, or Exception
                throw new OutOfMemoryError("Memory is exhausted");
            } catch (Throwable t) {
                // This catch block will handle any Throwable, including Error and Exception
                System.out.println("Caught a Throwable: " + t.getMessage());
            }

            try {
                // Some code that may throw an Error
                throw new StackOverflowError("Stack overflow occurred");
            } catch (Error e) {
                // This catch block will handle only Errors, not regular Exceptions
                System.out.println("Caught an Error: " + e.getMessage());
            }

            try {
                // Some code that may throw an Exception
                throw new NullPointerException("Attempted to access null reference");
            } catch (Exception ex) {
                // This catch block will handle only Exceptions, not Errors
                System.out.println("Caught an Exception: " + ex.getMessage());
            }
        

    }

}

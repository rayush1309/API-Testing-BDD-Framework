
    // Overriding: Run Time Poly Morphism: dynamic Binding
    /*
    ----> different classes (where Inheritance is Applied)
    ---> Method Overriding : Methods with same Name and Signature ;

Method Overriding in Java:

In Java, method overriding is a key concept related to polymorphism,
specifically dynamic polymorphism. This feature allows a subclass to provide a specific implementation for a method that is
already defined in its superclass. Method overriding occurs when a subclass provides a method with the same name and signature
as its superclass.

Key Points:
1. Inheritance and Different Classes:

Method overriding is relevant in the context of inheritance, where different classes are involved.
It typically occurs when a subclass extends a superclass.

2.Same Name and Signature:

To perform method overriding, the overridden method in the subclass must have the same name as the method in the superclass.
Additionally, the method in the subclass must have the same method signature, which includes the method name, return type,
and parameter types.

 */
package oopsConcept.Polymorphism;

    // Base class representing a generic automation test
    class AutomationTest {
        // Method to execute the test
        void executeTest() {
            System.out.println("Executing a generic automation test");
        }
    }

    // Subclass representing a test for the login page
    class LoginPageTest extends AutomationTest {
        // Overriding the executeTest method for login page testing
        @Override
        void executeTest() {
            System.out.println("Executing login page test");
            // Additional login page testing logic goes here
        }
    }

    // Subclass representing a test for the home page
    class HomePageTest extends AutomationTest {
        // Overriding the executeTest method for home page testing
        @Override
        void executeTest() {
            System.out.println("Executing home page test");
            // Additional home page testing logic goes here
        }
    }

    // Main class to demonstrate method overriding in automation tests
    public class IntroMethodOverriding {
        public static void main(String[] args) {
            // Create an instance of the base class
            AutomationTest genericTest = new AutomationTest();

            // Execute the generic test
            genericTest.executeTest();

            // Create an instance of the LoginPageTest class
            LoginPageTest loginPageTest = new LoginPageTest();

            // Execute the login page test (method overridden in the subclass)
            loginPageTest.executeTest();

            // Create an instance of the HomePageTest class
            HomePageTest homePageTest = new HomePageTest();

            // Execute the home page test (method overridden in the subclass)
            homePageTest.executeTest();
        }
    }

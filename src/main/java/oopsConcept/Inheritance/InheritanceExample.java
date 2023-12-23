package oopsConcept.Inheritance;

public class InheritanceExample {
    /*
    * Types of Inheritance:
    * Single
    * Multiple Inheritance--> child having multiple Parents-> child inhertaing property of two parents--> jvm
    * will confuse here which parents should I call--> compile time error
    * MultiLevel ---> Not achieve via class --> it can be achieve via Interface
    * Hybrid ---> This also can not be achieve at class level
    * Hierarchical
    *
    *        inheriting                        inheriting
    * class ---------------> class / Interface ---------->   Interface --> extends(Keyword)
    *  class---------------> Interface --> implements(keyword) we are using
    *
    * why Multiple Interface is not possible in Java; is there any way we can achieve in java?
    *
1. Single Inheritance:
A class can inherit from only one superclass.

2.Multiple Inheritance:

In the context of Java, multiple inheritance refers to a class inheriting properties from more than one class.
While it's achievable in some programming languages, Java does not support multiple inheritance for classes
(i.e., a class cannot extend more than one class).
This is because it can lead to ambiguity in cases where the compiler is unsure which parent class's method to invoke.
3. MultiLevel Inheritance:

Inheritance can be achieved through a chain of classes.
*  For example, Class A extends Class B, and then Class C extends Class A.
* This creates a multi-level inheritance relationship.Hybrid Inheritance:

4.Hybrid inheritance involves a combination of different types of inheritance.
In Java, achieving hybrid inheritance at the class level (combining multiple and multi-level inheritance) is not directly supported.
5. Hierarchical Inheritance:

Inheritance where multiple classes inherit from a single superclass.
Inheriting from Class/Interface:

A class can inherit from another class or an interface using the extends keyword.
A class can implement one or more interfaces using the implements keyword.
Why Multiple Interface Inheritance is Not Possible in Java:

In Java, a class can implement multiple interfaces, but it can extend only one class.
This decision was made to avoid the complexities and ambiguities associated with multiple inheritance at the class level.
Achieving Multiple Interface Inheritance in Java:

While a class cannot directly extend multiple classes, it can implement multiple interfaces.
This allows a class to inherit method signatures from multiple interfaces, effectively achieving a form of multiple inheritance through interfaces.
Example:
*
*
*/
    interface A {
        void methodA();
    }

    interface B {
        void methodB();
    }

    class MyClass implements A, B {
        @Override
        public void methodA() {
            // Implementation for methodA
        }

        @Override
        public void methodB() {
            // Implementation for methodB
        }
    }



}

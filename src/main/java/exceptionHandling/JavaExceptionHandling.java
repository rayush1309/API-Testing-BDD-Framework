package exceptionHandling;

public class JavaExceptionHandling {
        public static void main(String[] args) {

            System.out.println("Before Writing code");

            try {
                System.out.println("Beginning");
                int a = 10 / 0;
                System.out.println(a);
            }catch (Exception e){
                System.out.println("Error Occured");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("Thank You");
            arrayException();

        }
        public static void arrayException(){
            System.out.println("Welcome to Array World");
            int [] arr = new int[4];
            try {
                arr[5] = 900;
            } catch (Exception e)    {
                System.out.println("Error Occured");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("Thanks!!");
        }

    

}

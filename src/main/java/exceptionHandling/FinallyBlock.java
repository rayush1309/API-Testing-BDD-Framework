package exceptionHandling;

public class FinallyBlock {
        public static void main(String[] args) {

            int [] arr= new int [4];
            try {
                //DB connection Sucessfully
                //Executing some queries
                //validating the data and Comappring from websites
                //closing the Connection
                arr[5]=100;
                System.out.println("close the Connection");

            }catch (Exception e){
                System.out.println("Error Ocurred");
                e.printStackTrace();

            }
            finally {
                System.out.println("closing the DB connection in Finally block");
            }

        }
        public static void finalTest(){
            final int x =100;
            //  x=1000; // // The following line will result in a compilation error
            // because you cannot reassign a value to a final variable.
            // x = 1000;
        }
    }

    /*

     */


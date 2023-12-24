package apiTesting.Basetest;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.coursePrice());
        //Print No of courses returned by API
      int countNoOfCourses=   js.getInt("courses.size()");
      System.out.println(countNoOfCourses);
      //.Print Purchase Amount
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        //Print Title of the first course and 3rd course
        //String title= js.getString("courses[0.title");//or
        String firstCourseTitle= js.get("courses[0].title");//or
        System.out.println(firstCourseTitle);
        String thirdCourseTitle= js.get("courses[2].title");//or
        System.out.println(thirdCourseTitle);
        System.out.println("*****************************************");

        //Print All course titles and their respective Prices
        for (int i = 0; i < countNoOfCourses; i++) {
            String courseTitles=js.get("courses["+i+"].title");
            int price= js.getInt("courses["+i+"].price");
            System.out.println(courseTitles+": "+ price);


        }
        //Print no of copies sold by Rest Api Course
        System.out.println("<-Print no of copies sold by Rest Api Course->");
        for (int i = 0; i < countNoOfCourses; i++) {
            String courseTitles=js.get("courses["+i+"].title");
            if (courseTitles.equalsIgnoreCase("REST API")){
                //copies sold
               int copy=js.get("courses["+i+"].copies");
                System.out.println(copy);
                break;
            }

            }







    }
    @Test
    public void SumOfCoursesValidation(){
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count=   js.getInt("courses.size()");
        int sum=0;
        for (int i = 0; i <count ; i++) {
            int prices=js.getInt("courses["+i+"].price");
            int copies=js.getInt("courses["+i+"].copies");
            int amount =prices*copies;
            System.out.println(amount);
            sum+=amount;
        }
        System.out.println("Total calculated Amount : "+sum);
        int purchaseAmount= js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,purchaseAmount);



    }



}

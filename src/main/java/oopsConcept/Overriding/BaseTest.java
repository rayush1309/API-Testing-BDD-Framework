package oopsConcept.Overriding;

public class BaseTest {
    public WebDriver getBrowserInstance(String browserName){

        if (browserName.equals("FireFox")){
            return new FirefoxDriver();
        } else if (browserName.equals("Chrome")) {
            return new ChromeDriver();

        }else {
            return new ChromeDriver();
        }

    }
}

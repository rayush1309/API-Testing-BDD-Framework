package oopsConcept.Overriding;

public class TestCase1  extends BaseTest{
    String browserName="Chrome";
    public static void main(String[] args) {
        /*
        FirefoxDriver driver =new FirefoxDriver();
        driver.click();
       driver.sendKeys();
        driver.getTitle();
        ChromeDriver driver1= new ChromeDriver();
        driver1.click();
        driver1.sedKeys();
        driver1.getTitle();

*/
        TestCase1 tc1=new TestCase1();
        tc1.initBrowser();

    }
    public void initBrowser(){
        WebDriver driver=getBrowserInstance(browserName);
        driver.click();
        driver.sendKeys();
        driver.getTitle();

    }

}

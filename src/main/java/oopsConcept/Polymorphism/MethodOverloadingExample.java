package oopsConcept.Polymorphism;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

    public class MethodOverloadingExample {

        private WebDriver driver;

        public MethodOverloadingExample() {
            // Set the path to your ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Initialize the ChromeDriver
            this.driver = new ChromeDriver();
        }

        // Method to search on Walmart by providing a search term
        public void search(String searchTerm) {
            WebElement searchBox = driver.findElement(By.id("global-search-input"));
            searchBox.sendKeys(searchTerm);
            searchBox.sendKeys(Keys.RETURN);
        }

        // Overloaded method to search with an additional filter
        public void search(String searchTerm, String filter) {
            // Perform a basic search
            search(searchTerm);

            // Apply the additional filter logic
            WebElement filterCheckbox = driver.findElement(By.id(filter));
            filterCheckbox.click();
        }

        // Overloaded method to search with both additional filter and sorting option
        public void search(String searchTerm, String filter, String sortOption) {
            // Perform a basic search
            search(searchTerm, filter);

            // Apply the additional sorting logic
            WebElement sortDropdown = driver.findElement(By.id("sort-dropdown"));
            sortDropdown.sendKeys(sortOption);
            sortDropdown.sendKeys(Keys.RETURN);
        }

        public static void main(String[] args) {
            MethodOverloadingExample walmartAutomation = new MethodOverloadingExample();

            // Example 1: Basic search
            walmartAutomation.search("laptops");

            // Example 2: Search with an additional filter
            walmartAutomation.search("smartphones", "filter-by-brand");

            // Example 3: Search with both additional filter and sorting option
            walmartAutomation.search("televisions", "filter-by-brand", "price-high-to-low");
        }
    }




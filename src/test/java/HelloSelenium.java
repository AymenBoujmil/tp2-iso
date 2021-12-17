import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HelloSelenium {
    public static void main(String[] args)  throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        driver.get("https://www.tunisianet.com.tn/");
        Thread.sleep(3000);

        // go to the authentification link
        driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#_desktop_user_info > ul > li > a")).click();
        Thread.sleep(2000);

        // fill the authentification form
        // enter your email
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ISOSelenium@gmail.com");
        Thread.sleep(2000);
        // enter your password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("tpiso");
        Thread.sleep(2000);
        // click the submit button
        WebElement submitButton =driver.findElement(By.id("submit-login"));
        submitButton.click();
        Thread.sleep(2000);

        // search for PC portable MacBook M1 13.3
        // enter  PC portable MacBook M1 13.3  in the search bar
        WebElement searchBarInput = driver.findElement(By.className("search_query"));
        searchBarInput.sendKeys(" PC portable MacBook M1 13.3 ");
        Thread.sleep(2000);
        // click the search button
        WebElement searchButton = driver.findElement(By.cssSelector("#sp-btn-search > button"));
        searchButton.click();
        Thread.sleep(2000);

        // select the first result
        List<WebElement> searchResult = driver.findElements(By.className("product-title"));
        searchResult.get(0).click();
        Thread.sleep(2000);

        // add the product to the cart
        WebElement addToCartButton = driver.findElement(By.className("add-to-cart"));
        addToCartButton.click();
        Thread.sleep(2000);

        // command the product
        WebElement firstCommandButton = driver.findElement(By.cssSelector("#blockcart-modal > div > div > div > div.col-xs-12.cart-content > div > div > a"));
        firstCommandButton.click();
        Thread.sleep(2000);
        WebElement secondCommandButton = driver.findElement(By.cssSelector("#main > div > div > div.checkout.cart-detailed-actions.card-block > div > a"));
        secondCommandButton.click();
        Thread.sleep(2000);





    }
}

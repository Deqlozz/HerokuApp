import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

@Test
public  void drop(){
    driver.get("http://the-internet.herokuapp.com/dropdown");
    Select select = new Select(driver.findElement(By.id("dropdown")));
    List<WebElement> options = select.getOptions();
    options.size();
    driver.findElement(By.id("dropdown")).click();
    select.selectByValue("1");
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(driver.findElement(By.xpath(
            "//*[@id=\"dropdown\"]/option[2]")).isSelected(), true);
    driver.findElement(By.id("dropdown")).click();
    select.selectByValue("2");
    softAssert.assertEquals(driver.findElement(By.xpath(
            "//*[@id=\"dropdown\"]/option[3]")).isSelected(), true);
}

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
       driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckBoxesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        boolean box = driver.findElement(By.cssSelector("[type=checkbox]")).isEnabled();
        softAssert.assertTrue(box);
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        boolean box1 = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        softAssert.assertTrue(box1);
        boolean box2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected();
        softAssert.assertTrue(box2);
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        boolean box$ = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isEnabled();
        softAssert.assertTrue(box$);
        softAssert.assertAll();
   }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

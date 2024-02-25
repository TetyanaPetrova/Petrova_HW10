import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {
  @BeforeTest
          public void BeforeTest() {
      driver.get("https://the-internet.herokuapp.com/javascript_alerts");

  }
    @Test
    public void testJSAlert() {


        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You successfully clicked an alert");
    }

    @Test
    public void testJSConfirmYes() {

        WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You clicked: Ok");
    }

    @Test
    public void testJSConfirmNo() {

        WebElement confirmButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
       confirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You clicked: Cancel");
    }

    @Test
    public void testJSPromt() {

        String str = "Hello";
        WebElement promtButton = driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]"));
        promtButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(str);
        alert.accept();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "You entered: " + str);
    }
}

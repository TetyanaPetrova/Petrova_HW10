import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @BeforeTest
    public void BeforeTest() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {"LEFT", "frame-left"},
                {"MIDDLE", "frame-middle"},
                {"RIGHT", "frame-right"}

        };
    }

    @Test(dataProvider = "dataProvider")
    public void TestArray(String title, String frame) {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(frame);
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyText, title);
        driver.switchTo().defaultContent();
    }


}

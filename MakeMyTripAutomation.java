import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTripAutomation {
    public static void clickAtCoordinates(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.elementFromPoint(" + x + ", " + y + ").click();";
        js.executeScript(script);
    }

    public static void clickElementByXPath(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void clearAndSendKeysByXPath(WebDriver driver, String xpath, String value) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromWebDriver\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/railways/");
        driver.manage().window().fullscreen();

        try {
            Thread.sleep(2000); // 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageTitle = driver.getTitle();
        String pageURL = driver.getCurrentUrl();
        System.out.println("Page Title: " + pageTitle);
        System.out.println("Page URL: " + pageURL);
        
        clickAtCoordinates(driver, 1246, 275);

        clickElementByXPath(
            driver,
            "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]"
        );

        clearAndSendKeysByXPath(
            driver,
            "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input",
            "delhi"
        );

        clickElementByXPath(
            driver,
            "//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div"
        );

        clickElementByXPath(
            driver,
            "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]"
        );

        clearAndSendKeysByXPath(
            driver,
            "//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/input",
            "lucknow"
        );

        clickElementByXPath(
            driver,
            "//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div"
        );
        
       for (int i=0; i < 3; i++) {
            clickElementByXPath(
                driver,
                "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"
              // We can book reservation for May 20 as current month is september and we can't book a ticket
              // of a previous date may 20,2023 and advance ticket booking is only valid for next 4 months.
              // But May 2024 is more than 4 months. So we can't select this date.
            );
        }
         
        clickElementByXPath(
            driver,
            "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]"
        );
         
         clickElementByXPath(
            driver,
            "//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/ul/li[3]"
        );
        
         clickElementByXPath(
            driver,
            "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"
        );

        driver.manage().window().fullscreen();
        
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}

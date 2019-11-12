import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Twitter {
    public Twitter() {
    }

    public static void main(String[] args) {
        ChromeDriver twitDriver = new ChromeDriver();

        try {
            twitDriver.get("https://twitter.com/");
            twitDriver.manage().window().maximize();
            loginPage(twitDriver);
            loginDetails(twitDriver);
            loginButton(twitDriver);
            tweet(twitDriver);
        } finally {
            twitDriver.quit();
        }
    }

    //navigate to login page:

    public static void loginPage(WebDriver twitDriver) {
        WebElement login = twitDriver.findElement(By.cssSelector("[class='js-nav EdgeButton EdgeButton--medium EdgeButton--secondary StaticLoggedOutHomePage-buttonLogin']"));
        login.click();
    }

    //enter login details:

    public static void loginDetails(WebDriver twitDriver) {
        WebDriverWait wait = new WebDriverWait(twitDriver, 30L);
        WebElement username = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input")));
        username.sendKeys(new CharSequence[]{"leybot1"});
        WebElement password = twitDriver.findElement(By.cssSelector("#page-container > div > div.signin-wrapper > form > fieldset > div:nth-child(3) > input"));
        password.sendKeys(new CharSequence[]{"botgenerator1"});
    }

    //click the login button:

    public static void loginButton(WebDriver twitDriver) {
        WebElement button = twitDriver.findElement(By.cssSelector("[class='submit EdgeButton EdgeButton--primary EdgeButtom--medium']"));
        button.click();
    }

    //write the tweet and click enter:

    public static void tweet(WebDriver twitDriver) {
        //WebElement featherPen = twitDriver.findElement(By.cssSelector("[class = 'r-jwli3a r-4qtqp9 r-yyyyoo r-1q142lx r-50lct3 r-dnmrzs r-bnwqim r-1plcrui r-lrvibr']"));
        //featherPen.click();
        WebElement tweetBar = twitDriver.findElement(By.cssSelector("[class='css-1dbjc4n r-1awozwy r-sdzlij r-18u37iz r-1777fci r-dnmrzs r-1sp51qo r-o7ynqc r-6416eg']"));
        tweetBar.click();
        tweetBar.sendKeys(new CharSequence[]{"automato boto"});
        WebElement tweetButton = twitDriver.findElement(By.className("[class='css-901oao css-16my406 r-1qd0xha r-ad9z0x r-bcqeeo r-qvutc0']"));
        tweetButton.click();

        WebDriverWait wait = new WebDriverWait(twitDriver, 5L);
        WebElement clickButton = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("[class='css-901oao css-16my406 r-1qd0xha r-ad9z0x r-bcqeeo r-qvutc0']")));
        clickButton.click();
        new WebDriverWait(twitDriver, 5L);
    }

    //the 'write tweet and enter' is not working
}
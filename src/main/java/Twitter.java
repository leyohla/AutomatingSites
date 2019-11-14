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
        password.sendKeys(new CharSequence[]{"not a real password"});
    }

    //click the login button:

    public static void loginButton(WebDriver twitDriver) {
        WebElement button = twitDriver.findElement(By.cssSelector("[class='submit EdgeButton EdgeButton--primary EdgeButtom--medium']"));
        button.click();
    }

    //write the tweet and click enter:

    public static void tweet(WebDriver twitDriver) {

        WebDriverWait wait = new WebDriverWait(twitDriver, 10);
        WebElement tweetBar = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")));

        tweetBar.click();
        tweetBar.sendKeys(new CharSequence[]{"The guidance configures a based shoulder"});

        WebElement tweetButton = twitDriver.findElement(By.cssSelector("[data-testid='tweetButtonInline']"));
        tweetButton.click();

        //By.xpath("[id='[\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[4]/div/span/span']")));
        //class: css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-1n0xq6e r-1vuscfd r-1dhvaqw r-icoktb r-1fneopy r-o7ynqc r-6416eg r-lrvibr `` "[data-testid='tweetButtonInline']"
    }
}

//INFO: Detected dialect W3C - 0 exit code but does not send tweet for some reason.
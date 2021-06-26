package poeDownloader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PoeDownloaderMain {

    public static void main(String[] args) throws InterruptedException {


        String currentUsersHomeDir = System.getProperty("user.home");
        System.out.println("useruseruser            :" + currentUsersHomeDir);

        //define       C:\selenium\chromedriver.exe    C:\EoNetworks\pracaWłasna\SeleniumTests\src\main\resources\META-INF\chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        String downloadFilepath = currentUsersHomeDir + "\\Documents\\My Games\\Path of Exile";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(cap);

        // prompt do inputu danych usera
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String strictnessValue = (String) jse.executeScript(
                "window.promptResponse=prompt('to jest apka do pobierania filtrów ze strony. Apka automatycznie ściąga pliki do "
                        + "lokalizacji poe. Wybierz poziom filtra. Możliwe opcje : soft , regular , semi-strict , strict , very-strict , uber-strict.   MASZ 10 SEK NA WPISANIE')");

        Thread.sleep(10000);

        String strictness = (String) jse.executeScript("return window.promptResponse");
        System.out.println("wybór usera :" + strictnessValue);
        System.out.println("wybór usera :" + strictness);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.filterblade.xyz");


        //	driver.findElement(By.id("restart")).click();
        //*[@id="restart"]
        //napierw trzeba przeprowadzić konsolowy wywiad zbierający dne na temat filtra, tzn co bd wyszukiwane na stronie. Trzeba to zapisać do listy i jej użyć podczas wykonywania testu(będą 2 części programu)

        if (!strictness.equals(null) && !strictness.isEmpty() && strictness.equals("soft") || strictness.equals("regular") || strictness
                .equals("semi-strict") || strictness.equals("strict") || strictness.equals("very-strict") || strictness
                .equals("user-strict")) {
            if (strictness.equals("soft")) {
                driver.findElement(By.id("Overview_BaseStrictnessSelectionSlider")).click();
                driver.findElement(By.xpath("//*[@id=\"Overview_BaseStrictnessSelectionSliderHandle\"]")).click();
            }
            if (strictness.equals("regular")) {
                driver.findElement(By.id("FilterSelection_SubVersion")).click();
                driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[2]")).click();
            }
            if (strictness.equals("semi-strict")) {
                driver.findElement(By.id("FilterSelection_SubVersion")).click();
                driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[3]")).click();
            }

            if (strictness.equals("strict")) {
                driver.findElement(By.id("FilterSelection_SubVersion")).click();
                driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[4]")).click();
            }

            if (strictness.equals("very-strict")) {
                driver.findElement(By.id("FilterSelection_SubVersion")).click();
                driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[5]")).click();
            }

            if (strictness.equals("uber-strict")) {
                driver.findElement(By.id("FilterSelection_SubVersion")).click();
                driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[6]")).click();
            }
        } else {

            jse.executeScript("alert(' nie wybrano odpowiedniego filtra ')");
            Thread.sleep(3000);
            driver.close();
        }

        Thread.sleep(3000);

        //wybór strictnessa
        //		driver.findElement(By.id("FilterSelection_SubVersion")).click();
        //		driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[5]")).click();

        //wybór stylu (wygląd)
        //		driver.findElement(By.id("FilterSelection_SubVersion")).click();
        //		driver.findElement(By.xpath("//*[@id=\"FilterSelection_SubVersion\"]/option[5]")).click();

        //go to download page
        driver.findElement(By.id("SelectionButton6")).click();
        driver.findElement(By.id("downloadScreen_tabButton_1")).click();

        //download file to drive
        driver.findElement(By.id("DownloadButton")).click();
        Thread.sleep(3000);
        driver.close();
    }

}

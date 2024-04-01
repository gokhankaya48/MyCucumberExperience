package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;


public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>(); //her bir thread e özel driver
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>(); // o thread e özel browser name

    //  threadDriver.get() -> bulunduğu hat taki driverı ver
    //  threadDriver.set(driver) -> bulunduğu hata driver set et

    // Her bir sürecin kendine özel STATİC driverı olmalı : Local Static diyeceğiz
    // süreç = Thread
    // Thread.Sleep => ilgili süreci durduryor belli süre
    // her bir Thread in kendine özel STATİC i olmalı, yani LOCAL Static


    public static WebDriver getDriver(){
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");
        if (threadBrowserName.get()==null) //XML den çalışmayan durumlar için
            threadBrowserName.set("chrome"); //default chrome

        if (threadDriver.get() == null) { // hatta driver var mı, yok ise
            switch (threadBrowserName.get()){
                case "chrome":threadDriver.set(new ChromeDriver());break;
                case "safari":threadDriver.set(new SafariDriver());break;
                default:threadDriver.set(new ChromeDriver()); //bulunduğum hatta driver yok idi, ben bir tane set ettim
            }
            threadDriver.set(new ChromeDriver());  // bir tane oluştur hatta set et
            threadDriver.get().manage().window().maximize();
            threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
        return threadDriver.get();
    }
    public static void quitDriver(){
        //test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver kapat
        if (threadDriver.get() != null){ //driver var ise
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }
    }
}

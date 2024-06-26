package StepDefinitions;

import Utilities.ExelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Hooks {

    @Before// Cucumber ın Annotation ı
    public void before(){
        // System.out.println("Senaryo başladı");
    }
    @After
    public void after(Scenario scenario){
        ExelUtility.writeToExcel("src/test/java/ApachePOI/resource/CucumberTestSonuclari.xlsx",
                scenario.getName()+" "+(scenario.isFailed()? "Failed": "Passed") );

        if (scenario.isFailed()){
            TakesScreenshot ts=(TakesScreenshot) GWD.getDriver();  // aynı js gibi
            byte[] hafizadakiHali= ts.getScreenshotAs(OutputType.BYTES); // ekran kaydı aldı dosya
            scenario.attach(hafizadakiHali,"image/png","screenshot name");
        }
        GWD.quitDriver();
    }
}

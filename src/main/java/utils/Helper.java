package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static String getCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date date =new Date();
        return dateFormat.format(date);
    }

    public static String captureScreenshot(WebDriver driver){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir")+"/Screenshots/TopTalTest"+ getCurrentDateTime()+".png";
        File destination=new File(screenshotPath);

        try{
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return screenshotPath;
    }
}

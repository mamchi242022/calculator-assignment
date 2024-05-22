package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Actions {

    public static void enterNumber(WebDriver driver, int number){
       String num =  String.valueOf(number);
       for(char c : num.toCharArray()){
            driver.findElement(By.xpath("//input[@value='"+c+"']")).click();
       }
    }

    public static void enterNumber(WebDriver driver, String number){
        for(char c : number.toCharArray()){
            driver.findElement(By.xpath("//input[@value='"+c+"']")).click();
        }
    }
    public static int getResult(WebDriver driver){
        return Integer.parseInt(
                driver.findElement(By.xpath("//div[@id='display']/div")).getText());
    }

}

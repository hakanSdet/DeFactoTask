package com.defacto.POM;

import com.defacto.utilities.BrowserUtils;
import com.defacto.utilities.Driver;
import org.openqa.selenium.By;

import java.util.Random;

public class KadınCeket extends BasePage{
    Random random = new Random();

    public void selectRandomProduct(){

        int x = random.nextInt(50)+1;
        try{
            BrowserUtils.waitForVisibility(Driver.get().findElement(By.xpath("(//div[@class='product-card'])["+x+"]//div/h3/a")), 5);
            js.executeScript("arguments[0].click();", Driver.get().findElement(By.xpath("(//div[@class='product-card'])["+x+"]//div/h3/a")));
        }catch (Exception e){
            js.executeScript("window.scrollBy(0,450)");
            BrowserUtils.waitForVisibility(Driver.get().findElement(By.xpath("(//div[@class='product-card'])["+x+"]//div/h3/a")), 5);
            js.executeScript("arguments[0].click();", Driver.get().findElement(By.xpath("(//div[@class='product-card'])["+x+"]//div/h3/a")));
        }

    }
    public void selectRandomSize(){

        try{
            int x = random.nextInt(6)+1;
            BrowserUtils.waitForVisibility(Driver.get().findElement(By.xpath("(//div[@class='product-size-selector__buttons d-flex flex-wrap']/button)["+x+"]")),5);
            js.executeScript("arguments[0].click();",Driver.get().findElement(By.xpath("(//div[@class='product-size-selector__buttons d-flex flex-wrap']/button)["+x+"]")));
        }catch (Exception e){
            js.executeScript("arguments[0].click();",Driver.get().findElement(By.xpath("(//div[@class='product-size-selector__buttons d-flex flex-wrap']/button)[1]")));
        }

    }



}

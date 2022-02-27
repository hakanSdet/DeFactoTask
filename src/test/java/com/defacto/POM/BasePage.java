package com.defacto.POM;

import com.defacto.utilities.BrowserUtils;
import com.defacto.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();

    @FindBy(xpath = "//span[text()='Sepete Ekle']")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//span[text()='Sepetim']")
    public WebElement sepetim;

    @FindBy (xpath = "//button[contains(text(),'SEPETE GİT')]")
    public WebElement sepeteGitButton;

    @FindBy(xpath = "//span[text()='Sil']")
    public WebElement silButton1;

    @FindBy(xpath = "//button[text()='Sil']")
    public WebElement silButton2;


    public WebElement elementOfModule (String moduleName){
        return Driver.get().findElement(By.xpath("(//li/a[contains(text(),'"+moduleName+"')])[1]"));
    }
    public WebElement elementOfSideMenu (String sideMenu){
        return Driver.get().findElement(By.xpath("(//li[@class='menu__block menu__block--has-sub-super menu__block--has-sub']/a[contains(text(),'"+sideMenu+"')])[1]"));
    }
    public void selectElementsOfBeden (String beden){
        try {
            Driver.get().findElement(By.cssSelector("label[data-value='"+beden+"']")).click();
        }catch (Exception e){
            js.executeScript("arguments[0].click();", Driver.get().findElement(By.xpath("(//button[text()='+ Daha fazla göster'])[2]")));
            js.executeScript("arguments[0].click();", Driver.get().findElement(By.cssSelector("label[data-value='"+beden+"']")));
        }
    }

    public void deleteProduct(){
        BrowserUtils.waitForVisibility(silButton1,10);
        js.executeScript("arguments[0].click();",silButton1);

        BrowserUtils.waitForVisibility(silButton2,10);
        js.executeScript("arguments[0].click();",silButton2);

    }

    public void verifyEmptyCart(){
        BrowserUtils.waitForVisibility(Driver.get().findElement(By.cssSelector(".shopping__empty--title")),10);
        Assert.assertTrue(Driver.get().findElement(By.cssSelector(".shopping__empty--title")).isDisplayed());
    }


}

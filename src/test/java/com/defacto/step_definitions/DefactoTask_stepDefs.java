package com.defacto.step_definitions;

import com.defacto.POM.Anasayfa;
import com.defacto.POM.KadınCeket;
import com.defacto.utilities.BrowserUtils;
import com.defacto.utilities.ConfigurationReader;
import com.defacto.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class DefactoTask_stepDefs {

    Anasayfa anasayfa = new Anasayfa();
    KadınCeket kadınCeket = new KadınCeket();
    JavascriptExecutor js = (JavascriptExecutor) Driver.get();
    Logger logger = LogManager.getLogger(DefactoTask_stepDefs.class);

    @Given("I navigate to home page")
    public void i_navigate_to_home_page() {
        logger.info("www.defacto.com.tr adresine gidilir.");
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("I verify that page is loaded")
    public void i_verify_that_page_is_loaded() {
        logger.info("Ekranın yüklendiğine dair kontrol yapılır.");
        Assert.assertTrue(BrowserUtils.verifyToPageLoaded());
    }

    @When("I hover the mouse over {string} module")
    public void i_hover_the_mouse_over_module(String string) {
        logger.info("Ana sayfada üstte yer alan menülerden KADIN sekmesinin üzerine gelinir.");
        BrowserUtils.hover(anasayfa.elementOfModule(string));
    }

    @When("I click {string} side menu")
    public void i_click_side_menu(String string) {
        logger.info("Ekranın sol tarafında beliren hamburger menüden KADIN’a ait olan “Ceket” kategorisi seçilir");
        BrowserUtils.waitForVisibility(anasayfa.elementOfSideMenu(string),10);
        anasayfa.elementOfSideMenu(string).click();
    }
    @When("I select {string} size")
    public void i_select_size(String string) {
        logger.info("Ekranın sol tarafında yer alan filtrelerden Beden: S seçilir.");
        kadınCeket.selectElementsOfBeden(string);
    }

    @And("I select a random product in Mevsimlik Mont - Ceket side menu")
    public void iSelectARandomProductInMevsimlikMontCeketSideMenu() {
        logger.info("Ceket kategorisine ait S beden ürünler yüklendikten sonra listeden rasgele bir ürüne tıklanarak ürün detay ekranına gidilir.");
        kadınCeket.selectRandomProduct();
    }

    @When("I select a random size for selected product")
    public void andISelectARandomSizeForSelectedProduct() {
        logger.info("Rasgele bir beden seçimi yapılır.");
        kadınCeket.selectRandomSize();
    }

    @And("I click SEPETE EKLE button")
    public void iClickSEPETEEKLEButton() {
        logger.info("Sepete Ekle butonuna tıklanır.");
        BrowserUtils.waitForVisibility(kadınCeket.sepeteEkleButton,10);
        js.executeScript("arguments[0].click();",kadınCeket.sepeteEkleButton);
    }

    @And("I click Sepetim")
    public void iClickSepetim() {
        logger.info("Ekranın sağ üstünde yer alan Sepetim butonuna tıklanarak ekranın sağ tarafından Sepet Özet menüsünün gelmesi sağlanır.");
        BrowserUtils.waitFor(3);
        js.executeScript("arguments[0].click();",kadınCeket.sepetim);
    }

    @And("I click SEPETE GİT")
    public void iClickSEPETEGİT() {
        logger.info("SEPETE GİT butonuna tıklanır.");
        kadınCeket.sepeteGitButton.click();
    }

    @And("I delete selected product")
    public void iDeleteSelectedProduct() {
        logger.info("Ürün Sepetim ekranında Sil buton yardımı ile sepetten çıkartılır.");
        kadınCeket.deleteProduct();
    }


    @Then("I verify that the cart is empty")
    public void iVerifyThatTheCartIsEmpty() {
        logger.info("Sepetin boş olduğu kontrol edilir.");
        kadınCeket.verifyEmptyCart();
    }
}

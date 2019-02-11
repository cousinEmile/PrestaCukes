package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class Products {
    public Products(){
        PageFactory.initElements( Driver.getDriver(), this);

    }
    OnSaleException on1 = new OnSaleException();

    @FindBy (xpath = "//div[@class='header-container']/header/div[2]/div/div/nav/div")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='search_query_top']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default button-search']")
    public WebElement searchBoxButton;

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    public WebElement cart_Icon_Button; //can use to HOVER or CLICK

    @FindBy(xpath = "//div[@class='cart-info']/span")   //.getAttribute("innerText").trim();
    public WebElement hoverCart_nonSaleItemPrice;

    @FindBy(xpath = "(//div[@class='cart-info'])[2]/span")  //.getAttribute("innerText").trim();
    public WebElement hoverCart_onSaleItemPrice;

    @FindBy(xpath = "//div[@class='product-name']/span/span")   //.getAttribute("innerText").trim();
    public WebElement hoverCart_nonSaleItemQuantity;

    @FindBy(xpath = "(//div[@class='product-name'])[2]/span")   //.getAttribute("innerText").trim();
    public WebElement hoverCart_onsaleItemQuantity;

    @FindBy(xpath = "(//div[@class='cart-prices']/div/span)[1]")    //.getAttribute("innerText").trim();
    public WebElement hoverCart_shippingPrice;

    @FindBy(xpath = "(//div[@class='col-sm-4 clearfix']/div/a/span)[1]")    //.getAttribute("innerText").trim();
    public WebElement hoverCartHeader_displayedCartQuantity;

    @FindBy(xpath = "//div[@class='cart-prices-line last-line']/span")     //.getAttribute("innerText").trim();
    public WebElement hoverCart_totalPrice;

    @FindBy(xpath = "//div[@class='cart_block block exclusive']/div//a/img")      // getText() / getAttribute(innerText)
    public WebElement hoverCartProductName;

    @FindBy(css = "a.logout")
    public WebElement logout;

    @FindBy(css = "img.logo.img-responsive")
    public WebElement logoHome;

    @FindBy(css = "span.ajax_cart_no_product")
    public WebElement hoverCart_empty;

    @FindBy(css = "span.remove_link>a")
    public WebElement deleteFromHoverCart;

    @FindBy(xpath = "(//a[@title='Faded Short Sleeve T-shirts'])[1]")
    public WebElement Tshirt;   /** getAttribute("tittle") -> product name  **/

    @FindBy(xpath = "(//div[@class='content_price'])[2]/span")
    public WebElement TshirtPrice;

    @FindBy(xpath = "//a[@class='product_img_link']/img")
    public WebElement TshirtImgLink;

    @FindBy(xpath = "(//a[@class='quick-view-mobile'])[1]")
    public WebElement quickView;


    ///RANDOM NON_SALE PRODUCT//////
    public void random_NONSaleItem( WebDriver driver){
        OnSaleException on1 = new OnSaleException();
        driver=Driver.getDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions( driver);
        Random random = new Random();
        int min = 1;
        int max = 7;
        int r = random.nextInt(max-min+1)+min;
        String xPath = "//ul[@id='homefeatured']/li[" + r + "]/div/div[2]/div/span/../../..//a/img";
        actions.moveToElement(driver.findElement( By.xpath( xPath))).click().perform();
        WebElement iframe = driver.findElement(By.className("fancybox-iframe"));
        driver.switchTo().frame(iframe);
        try{
            boolean b = driver.findElement(By.cssSelector("#reduction_percent")).isDisplayed();
            if (b) {
                throw on1;
            }
        } catch (OnSaleException S) {
            driver.get("http://automationpractice.com/index.php");
            System.out.println("Sale Item Selected | Take Two");
            min = 1;
            max = 7;
            r = random.nextInt(max - min + 1) + min;
            xPath = "//ul[@id='homefeatured']/li[" + r + "]/div/div[2]/div/span/../../..//a/img";
            actions.moveToElement(driver.findElement(By.xpath(xPath))).click().perform();
            System.out.println("back to work");
            iframe = driver.findElement(By.className("fancybox-iframe"));
            driver.switchTo().frame(iframe);
        }
        try{
            boolean b = driver.findElement(By.cssSelector("#reduction_percent")).isDisplayed();
            if (b) {
                throw on1;
            }
        } catch (OnSaleException S) {
            driver.get("http://automationpractice.com/index.php");
            System.out.println("Sale Item Selected | Take three");
            min = 1;
            max = 7;
            r = random.nextInt(max - min + 1) + min;
            xPath = "//ul[@id='homefeatured']/li[" + r + "]/div/div[2]/div/span/../../..//a/img";
            actions.moveToElement(driver.findElement(By.xpath(xPath))).click().perform();
            System.out.println("back to work, again");
            iframe = driver.findElement(By.className("fancybox-iframe"));
            driver.switchTo().frame(iframe);
        }
    }


    ////////////Random On Sale Product /////
    public void random_SaleItem(WebDriver driver){
        int x = (Math.random() <= 0.5) ? 1 : 2;
        WebElement saleItemRandom = driver.findElement(By.xpath("( (//ul[@id='homefeatured']/li/div/div[2]/div/span[2]/../ ../h5/a)["+x+"]/../../..)//div/div/a/img"));
        saleItemRandom.click();
        WebElement iframe = driver.findElement(By.className("fancybox-iframe"));
        driver.switchTo().frame(iframe);
    }










}

class OnSaleException extends Exception{

}
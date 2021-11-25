package Mentoring.TestNG_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class pom {

    public pom(WebDriver driver) {
        PageFactory.initElements(driver, this); // FindBy bunun sayesinde çalışıyor
    }

    @FindBy(css = "ul.top-menu>:nth-of-type(2)")
    public WebElement computers;

    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    public WebElement desktops;

    @FindBy(xpath = "//div[@class='item-box'][1]")
    public WebElement product;

    @FindBy(xpath = "(//input[@value='Add to cart'])[1]")
    public WebElement addToCart;

    @FindBy(xpath = "//span[text()='Shopping cart']")
    public WebElement shoppingCart;

    @FindBy(css = "input[name='removefromcart']")
    public WebElement removeButton;

    @FindBy(css = "[name='updatecart']")
    public WebElement updateCart;

    @FindBy(css = ".order-summary-content")
    public WebElement emptyMessage;


    public void clickComputer(){
        computers.click();
    }

    public void setDesktops(){
        desktops.click();
    }

    public void setProduct(){
        product.click();
    }

    public void setAddToCart(){
        addToCart.click();
    }

    public void setShoppingCart(){
        shoppingCart.click();
    }

    public void setRemoveButton(){
        removeButton.click();
    }

    public void setUpdateCart(){
        updateCart.click();
    }

    public void assertEmptyMessage(){
        Assert.assertTrue(emptyMessage.getText().contains("empty"));
    }

}

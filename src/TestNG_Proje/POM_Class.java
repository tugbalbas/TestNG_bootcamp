package TestNG_Proje;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Class {

    public POM_Class(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (linkText = "Log in")
    public WebElement login;

    @FindBy (id = "Email")
    public WebElement email;

    @FindBy (id = "Password")
    public WebElement password;

    @FindBy (className = "login-button")
    public WebElement loginBtn;

    @FindBy(linkText = "Contact us")
    public WebElement contactUs;

    @FindBy(id = "Enquiry")
    public WebElement messageBx;

    @FindBy(name = "send-email")
    public WebElement messageSubmit;

    @FindBy(linkText = "Apparel & Shoes")
    public WebElement apperelShoes;

    @FindBy(linkText = "Blue and green Sneaker")
    public WebElement blueAndGreen;

    @FindBy(id = "add-to-wishlist-button-28")
    public WebElement addWishList;

    @FindBy(linkText = "50's Rockabilly Polka Dot Top JR Plus Size")
    public WebElement rockabilly;

    @FindBy (id = "add-to-wishlist-button-5")
    public WebElement rockAddWishList;

    @FindBy(className = "ico-wishlist")
    public WebElement wishList;




}

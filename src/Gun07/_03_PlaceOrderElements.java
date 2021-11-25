package Gun07;

// Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
// bunun için aşağıdaki consructor eklendi ve için PageFatory ile
// driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
// Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
// anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
// aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
// gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceOrderElements {

    //şu elemanların bağlantısını DRIVER ile yap; constructor ekle

    public _03_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Search']")
    public WebElement searchInput;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement searchBtn;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(css="a[title='Shopping Cart']")
    public WebElement shopingCart;

    @FindBy(linkText="Checkout")
    public WebElement checkOut;

    @FindBy(id="button-payment-address")
    public WebElement continue1;

    @FindBy(id="button-shipping-address")
    public WebElement continue2;

    @FindBy(id="button-shipping-method")
    public WebElement continue3;

    @FindBy(css="input[type='checkbox']")
    public WebElement agree;

    @FindBy(id="button-payment-method")
    public WebElement continue4;

    @FindBy(id="button-confirm")
    public WebElement confirm;

    @FindBy(css="div[id='content']>h1")
    public WebElement confirmTxt;
}
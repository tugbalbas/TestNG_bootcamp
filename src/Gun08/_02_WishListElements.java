package Gun08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _02_WishListElements {

    // aşağıdaki elemanların driverla bağlantısını sağlıyor
    public _02_WishListElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="div.caption>h4>a")
    List<WebElement> searchResults;

    @FindBy(css ="button[data-original-title='Add to Wish List']")
    List<WebElement> wishBtnList;

    @FindBy(id ="wishlist-total")
    WebElement btnWishList;

    @FindBy(css ="table[class='table table-bordered table-hover']>tbody>tr>td:nth-child(2)")
    List<WebElement> tableNames;

}
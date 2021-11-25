package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends GenelWebDriver {
     /* POM (Page Object Model) avantajları
   1- Bütün sayfalada isimleri aynı olan elemanlar için 1 tanımlama yeterli oluyor.
      Böylece tanımlanan elemanlar tekrar kullanılabilir yani Reusable oluyor.
   2- Kodun içerisinden HTML kodları ayrıldığından kod okunabilirliği artıyor.
   3- Developer locatorlarda bir değişiklik yaptığı zaman, asıl kodla hiç bir şekilde
      uğraşmak zorunda kalmıyoruz, sadece gidip locator ı değiştiriyoruz.
    */

     @Test
     void ProceedToCheckout() {
         // direkt kullanmka diye bir şey yok o yüzden ilk önce nesne oluşturuyoruz
         _03_PlaceOrderElements elements=new _03_PlaceOrderElements(driver);
         // constructordaki drive'ı parantez içindeki driver ile çağırarak buraya bağlıyoruz

         elements.searchInput.sendKeys("ipod");
         elements.searchBtn.click();
         elements.addToCart.click();
         elements.shopingCart.click();
         elements.checkOut.click();

         WebDriverWait wait=new WebDriverWait(driver, 10);

         wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.agree)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
         wait.until(ExpectedConditions.elementToBeClickable(elements.confirm)).click();

         wait.until(ExpectedConditions.urlContains("success"));
         Assert.assertEquals(elements.confirmTxt.getText(),"Your order has been placed!");
     }


}

// Constructor nesne oluşturma metodudur
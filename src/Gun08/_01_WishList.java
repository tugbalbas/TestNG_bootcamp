package Gun08;

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

   2.Test;
   1- WishList i boşaltınız.
 */

import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends ParameterDriver {

    @Test
    @Parameters("itemName")
    void addToWishList(String arananKelime)
    {
        WebElement searchInput=driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys(arananKelime);

        WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        // Arama sonucu ekrana çıkan ürünlerin listesini aldık
        List<WebElement> searchResults=driver.findElements(By.cssSelector("div.caption>h4>a"));
        int rndNumber= Tools.RandomNumberGenerator(searchResults.size());// random bir numara oluşturduk
        String wishItemName=searchResults.get(rndNumber).getText();// bu oluşan numaradaki ürünün adını aldık.

        List <WebElement> wishBtnList = driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
        wishBtnList.get(rndNumber).click();// çıkan bu listedekki WishListlerin aynı random numarakini tıklattım.
        // böylece wish liste attım.

        // WishList e tıklattım.
        WebElement btnWishList=driver.findElement(By.id("wishlist-total"));
        btnWishList.click();

        // Çıkan WishListi aldım.                      // xpath://table[@class='table table-bordered table-hover']//tbody//td[2]
        List <WebElement> tableNames=driver.findElements(By.cssSelector("table[class='table table-bordered table-hover']>tbody>tr>td:nth-child(2)"));

        // bu listedeki ürünlerin isimleri ile daha önce eklediğim ürünün ismi var mı diye karşılaştırdım
        Tools.listContainsString(tableNames, wishItemName);
    }
}


/*
XPath'in herhangi bir yerindeki tek bir eğik çizgi '/',
 öğeyi hemen ana öğesinin içinde aramak anlamına gelir. Çift eğik çizgi '//',
 ana öğenin içindeki herhangi bir alt öğeyi veya herhangi bir torun öğeyi aramayı belirtir.
 */
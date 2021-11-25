package Gun08;

import Gun07._03_PlaceOrderElements;
import Utils.ParameterDriver;
import Utils.Tools;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_WishListPOM extends ParameterDriver {

    @Test
    @Parameters("itemName")
    void addToWishList(String arananKelime)
    {
        Gun07._03_PlaceOrderElements poe=new _03_PlaceOrderElements(driver);
        poe.searchInput.sendKeys(arananKelime);
        poe.searchBtn.click();

        Gun08._02_WishListElements wle=new _02_WishListElements(driver);

        int rndNumber= Tools.RandomNumberGenerator(wle.searchResults.size());
        String wishItemName=wle.searchResults.get(rndNumber).getText();
        wle.wishBtnList.get(rndNumber).click();
        wle.btnWishList.click();

        Tools.listContainsString(wle.tableNames, wishItemName);
    }

// hatalı rapor için bu testi ekledik
//    @Test
//    void test2()
//    {
//        Assert.fail();
//    }

}
// Parametre bağladığımız için XML den çalıştırıyoruz
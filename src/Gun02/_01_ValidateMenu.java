package Gun02;

/*
        Senaryo;
        1- Siteyi açınız
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.
     */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_ValidateMenu extends GenelWebDriver {

    @Test
    void menuValidation(){

        List<String> menuExceptedList=new ArrayList<>();
        menuExceptedList.add("Desktops");
        menuExceptedList.add("Laptops & Notebooks");
        menuExceptedList.add("Components");
        menuExceptedList.add("Tablets");
        menuExceptedList.add("Software");
        menuExceptedList.add("Phones & PDAs");
        menuExceptedList.add("Cameras");
        menuExceptedList.add("MP3 Players");

        //List<WebElement> menuActualList=driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));
        // bunu böyle uzun uzun yazmak yerine aşağ. gibi yeni biri 'By' tanımlıyorum

        By menuFinder=By.cssSelector("ul[class='nav navbar-nav']>li");
        List<WebElement> menuActualList=driver.findElements(menuFinder);

//        // 1. Yöntem
//        for (int i = 0; i < menuActualList.size(); i++) {
//            Assert.assertEquals(menuExceptedList.get(i),menuActualList.get(i).getText());
//        }
//
//        // 2. Yöntem
//        int i=0;
//        for (WebElement listItem: menuActualList) {
//            Assert.assertEquals(menuExceptedList.get(i++),listItem.getText());
//        }

        // Bunu her sitede yapacağımız için tools klasörüne taşıyoruz bunları

        Tools.compareToList(menuExceptedList,menuActualList); // bu şekilde kolayca karşılaştırabiliriz artık


    }

}

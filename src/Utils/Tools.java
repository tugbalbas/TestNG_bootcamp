package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

// Çok kullanacağımız kodları burada topluyoruz. Kendi kütüphanemiz

public class Tools {

    //her yerden kullanabilmek için static
    public static void compareToList(List<String> menuExceptedList, List<WebElement> menuActualList) {

        // 1. Yöntem
        for (int i = 0; i < menuActualList.size(); i++) {
            Assert.assertEquals(menuExceptedList.get(i), menuActualList.get(i).getText());
        }

        // 2. Yöntem
        int i = 0;
        for (WebElement listItem : menuActualList) {
            Assert.assertEquals(menuExceptedList.get(i++), listItem.getText());
        }
        // şimdi karşılaştırmak için bunları 'ValidateMenu' classında çağırıyoruz
    }

    public static void successMessageValidation(WebDriver driver){
        WebElement msj= driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
        Assert.assertTrue(msj.getText().contains("successfully"));
    }

    public static void Bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void selectByRandomIndex(WebElement element) {

        Select select=new Select(element);
        select.selectByIndex(RandomNumberGenerator(select.getOptions().size()) );
    }

    public static int RandomNumberGenerator(int max)
    {
        return (int) (Math.random()*max)+1;     // -> 10  ->  0 1 2 3  .....  9
        // -> +1  ->  1 2 3 4  ..... 10

//        Random random=new Random();
//        return random.nextInt(num-1)+1;
    }

    public static void listContainsString(List<WebElement> list, String arananKelime)
    {
        Boolean bulundu = false;
        for (WebElement e: list) {
            if (e.getText().equalsIgnoreCase(arananKelime)){
                bulundu=true;
                break;
            }
        }
        if (!bulundu)
            Assert.fail();
    }

}

package Gun02;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız
 */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Subscribe extends GenelWebDriver {

    By link=By.linkText("Newsletter");
    By yes=By.cssSelector("input[value='1']");


    @Test (priority = 1)
    void subscribeFunctionYes(){

//        WebElement newsletter= driver.findElement(By.linkText("Newsletter"));         // bu satır da 3 kere tekrarlandığı için yukarıya tanımlıyoruz direkt
        WebElement newsletter= driver.findElement(link);

        newsletter.click();

//        WebElement yesRadioBtn= driver.findElement(By.cssSelector("input[value='1']")); // bunu da aynu şekilde yukarıda
        WebElement yesRadioBtn= driver.findElement(yes);
        yesRadioBtn.click();

        WebElement continueBtn=driver.findElement(By.cssSelector("input[value='Continue']"));
        continueBtn.click();

//        WebElement msj= driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
//        Assert.assertTrue(msj.getText().contains("successfully"));
        Tools.successMessageValidation(driver);

    }

    @Test (priority = 2)
    void subscribeFunctionNo(){
//        WebElement newsletter= driver.findElement(By.linkText("Newsletter"));
        WebElement newsletter= driver.findElement(link);
        newsletter.click();

        WebElement noRadioBtn= driver.findElement(By.cssSelector("input[value='0']"));
        noRadioBtn.click();

        WebElement continueBtn=driver.findElement(By.cssSelector("input[value='Continue']"));
        continueBtn.click();

//        WebElement msj= driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible"));
//        Assert.assertTrue(msj.getText().contains("successfully")); // bu tekrarladığı için toolsa taşıyoruz

        // taşıdığımız metodu çağırıyoruz direkt
        Tools.successMessageValidation(driver);

    }

    @Test (priority = 2)
    void subscribeFunctionForBoth(){ // yes mi no mu

//        WebElement newsletter= driver.findElement(By.linkText("Newsletter"));
        WebElement newsletter= driver.findElement(link);
        newsletter.click();

       // WebElement yesRadioBtn= driver.findElement(By.cssSelector("input[value='1']"));
        WebElement yesRadioBtn= driver.findElement(yes);
        WebElement noRadioBtn= driver.findElement(By.cssSelector("input[value='0']"));

        if (yesRadioBtn.isSelected())
            noRadioBtn.click();
        else
            yesRadioBtn.click();

        WebElement continueBtn=driver.findElement(By.cssSelector("input[value='Continue']"));
        continueBtn.click();

        Tools.successMessageValidation(driver);

    }

}

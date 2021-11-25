package Gun07;

import Utils.GenelWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.AbstractSet;

public class _01_SoftAssertVsHardAssert {

    /*


     */
    @Test
    void hardAssert(){
        String s1="Merhaba";

        System.out.println("Hard assert öncesi");
        Assert.assertEquals("Merhaba 123", s1); // burada fail
        System.out.println("Hard assert sonrası"); // hard assert sonrası program kırıldığı için çalışamıyor
        // yalnızca bu çalıştı -> Hard assert öncesi

    }

    @Test
    void  softAssert(){
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage);
        System.out.println("assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage); // fail
        System.out.println("assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount); // burada tekrar fail
        System.out.println("assert 3");

        _softAssert.assertAll(); // bütün assertleri işleme koyuyuor
        System.out.println("aktiflik sonrası"); // bu bölüm assertAll dan sonrat olduğu için ve
                                                // assertlerinde fail olduğundan yukarıda program kesilir

//        assert 1
//        assert 2
//        assert 3

    }

}

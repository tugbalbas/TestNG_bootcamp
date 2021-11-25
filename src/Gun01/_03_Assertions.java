package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {
    // JUnit  -> bu daha önce proje testlerimizde kullandığımız javanın kendi kütüphane testi
    //           paralel ve grup çalışmalarında yetersiz
    // testNG -> bu yeni nesil TEST -> test New Generation -> yani testlerimizi kontrol edip
    //           istediğimiz gibi çalıştırabileceğimiz Selenium Kullanma TOOL u

    // Yeşil tik : test te hata yok.
    // Sarı çarpi: test te hata çıktı.
    // Beyaz     : test çalıştırılmadı.

    @Test
    void EqualOrnek(){

        String s1="Merhaba";
        String s2="İyi akşamlar";

        // Assert.assertEquals(s1,s2,"Yapılan işlemin sonucu"); // 2 veriyi karşılaştırır
        Assert.assertNotEquals(s1,s2,"Yapılan işlemin sonucu"); // 2 veriyi karşılaştırır
        // Actual : Oluşan
        // Expect : Beklenen
    }

    @Test
    void TrueOrnek(){

        int s1=94;
        int s2=94;

        Assert.assertTrue(s1==s2); // 2 veriyi karşılaştırır
        // Actual : Oluşan
        // Expect : Beklenen
    }

    @Test
    void  nullOrnek(){

        String s1=null;

        Assert.assertNull(s1);
    }


}

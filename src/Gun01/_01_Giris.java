package Gun01;

import org.testng.annotations.Test;
// https://www.jetbrains.com/help/idea/testing.html
// org.testng:testng:6.14.3    --- TestNG inin kurulumu


public class _01_Giris {
//    public static void main(String[] args) {
//        webSitesiniAc();
//        loginTestİsleminiYap();
//        driveriKapat();
//    }
// eskiden böyle yapıyorduk şimdi ise;

    // Eğer test metodlarına sıralama verilmezse alfabetik sırasına göre çalışır
    // priority -> öncelik sırası

    @Test(priority = 1) // -> annotation denir(@test)
    void webSitesiniAc(){

        System.out.println("Driver tanımlandı ve web sitesi açıldı");
    }

    @Test (priority = 2)
    void loginTestİsleminiYap(){

        System.out.println("Login test işlemleri yapıldı");
    }

    @Test (priority = 3)
    void driveriKapat(){

        System.out.println("driver kapatıldı ve çıkıldı");
    }


}

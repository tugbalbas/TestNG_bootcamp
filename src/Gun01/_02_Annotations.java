package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    /*
     @BeforeClass -> // Her Classdan önce çalışacaklar buraya yazılıyor.
       @BeforeMethod -> //Her metod çalışmadan önce yapılacakları buraya yazıyoruz
           @Test -> // testimizin metodları
           @Test -> // testimizin metodları
       @AfterMethod  -> // Her metod çalıştıktan sonra yapılacakları buraya yazıyoruz.
     @AfterClass -> // Her class dan sonra yapıalcaklar buraya yazılıyor.
   */


    @BeforeClass
    void beforeClass(){

        System.out.println("HER classdan ÖNCE çalışacak : Before Class");
    }

    @AfterClass
    void afterClass(){

        System.out.println("HER classdan SONRA çalışacak : After Class");
    }

    @BeforeMethod
    void beforeMetod(){

        System.out.println("HER metoddan ÖNCE çalışacak : Before Metod");
    }

    @AfterMethod
    void afterMetod(){

        System.out.println("HER metoddan SONRA çalışacak : After Metod");
    }

    @Test
    void test1(){

        System.out.println("Test 1 çalıştı");
    }

    @Test
    void test2(){

        System.out.println("Test 2 çalıştı");
    }


}
/*

HER classdan ÖNCE çalışacak : Before Class
HER metoddan ÖNCE çalışacak : Before Metod
Test 1 çalıştı
HER metoddan SONRA çalışacak : After Metod
HER metoddan ÖNCE çalışacak : Before Metod
Test 2 çalıştı
HER metoddan SONRA çalışacak : After Metod
HER classdan SONRA çalışacak : After Class

 */
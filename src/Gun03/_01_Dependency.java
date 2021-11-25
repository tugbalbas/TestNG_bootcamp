package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    /*
         interviewlarda sorulan bir konu imis, test ederken nasil önceligin olmalidir seklinde.. depency,priority vs

         dependsOnMethods ve priority ile sağlarım, aksi hale alfabetik sıra ile çalışır.
         dependsOnMethods : bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.
         priority : bununla çalışma sırasını belirtirim.

         *** Metoddan run yapıldığında bağımlılık seviyesi 1 ise bağımlı olduğu metoduna çağırarak çalışır.
             fakat 2 adımlım bir bağımlılık var ise yani 2 metoda bağımlı ise geriye doğru , direk run yapılamaz.
        */

    @Test
    void startCar() {

        System.out.println("Car startCar");
        Assert.fail(); // hata oluştu o yüzden bu çalışamadığı için diğerleri ignored oldu
    }

    @Test(dependsOnMethods = {"startCar"}) // bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar() {

        System.out.println("Car driveCar");
    }

    @Test(dependsOnMethods = {"driveCar"}) // bu testin çalışması driveCar ın hatasız çalışmasına bağımlı
    void stopCar() {

        System.out.println("Car stopCar");
    }

    @Test(dependsOnMethods = {"stopCar", "driveCar"}, alwaysRun = true) // alwaysRun = true bağımlılıkları var ama hata çıkarsa da yine çalıştır
    void parkCar() {

        System.out.println("Car parkCar");
    }


}

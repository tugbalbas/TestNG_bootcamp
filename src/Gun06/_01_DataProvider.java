package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {
    /**
     * Aşağıdaki ikli ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılı, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     */


    @Test(dataProvider = "getData")
    void UsernameTest(String username) {
        System.out.println("username = " + username);
    }

    @DataProvider // bu metoda dataProvider görevi verildi
    public Object[] getData() { // DataProvider olarak kullanılacak metodun tipi. Object olmak zorunda

        // int [] dizi={1,2,3};
        Object[] data = {"ayşe", "mehmet", "esra", "ersin", "hilal"};

        return data;
    }

    /********************************************************/

    @Test(dataProvider = "userlar") // DataProviderın ismi burda metod adı yerine kullanıldı.
    void UsernameTest2(String username)
    {
        System.out.println("username = " + username);
    }

    @DataProvider(name="userlar") // DataProvider a isim verdim.
    public Object[] getData2() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        // int[] dizi={1,2,3,4}
        Object[] data={"ayşe2", "mehmet2","esra2","ersin2","hilal2"};

        return data;
    }

}
// username = ayşe
// username = mehmet
// username = esra
// username = ersin
// username = hilal burda 5 tane ayrı ayrı testmiş gibi çalıştı, tüm isimleri tek tek atadı
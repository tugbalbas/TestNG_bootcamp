package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {


    @Test(dataProvider = "getData")
    void UsernameTest(String username, String password) {
        System.out.println(username+" "+password);
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = {
                {"ayşe","123"},
                {"mehmet","abc"},
                {"ersin","123abc"},
        };

        return data;
    }

}
// ayşe 123
// mehmet abc
// ersin 123abc  burda 3 tane ayrı ayrı testmiş gibi çalıştı, tüm elemanları tek tek atadı
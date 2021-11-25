package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    @Test(dataProvider = "getData")
    void UsernameTest(String username) {
        System.out.println("username = " + username);
    }

    @DataProvider
    public Iterator<Object> getData() {


       List<Object> data=new ArrayList<>();
       data.add("ayşe");
       data.add("mehmet");
       data.add("kaya");
       data.add("ersin");

        return data.iterator();
    }


    /*************************************/


    @Test(dataProvider = "getData2")
    void UsernameTest2(String username, String password)
    {
        System.out.println(username+" "+password);
    }

    @DataProvider
    public Iterator<Object[]> getData2() {

        List<Object[]> data=new ArrayList<>();
        data.add(new Object[]{"ayşe","123"});
        data.add(new Object[]{"mehmet","123abc"});
        data.add(new Object[]{"hilal","123"});

        return data.iterator();
    }
}
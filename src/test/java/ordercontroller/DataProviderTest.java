package ordercontroller;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "DataProvider")
    public void dataProvider(String testName) {
        System.out.println(testName);
    }

    @Test
    public void forLogicalTest() {
        for (int i=0;i<=4;i++) {
            System.out.println("TEST"+i);
        }
    }

    @Test
    public void whileLogicalTest() {

    int i=0;

        while(i<=4){
            System.out.println("TEST"+i);
            i ++;
        }

    }

    @DataProvider(name = "DataProvider")
    private Object[] DataProvider() {
        return new Object[]{
                "TEST0",
                "TEST1",
                "TEST2",
                "TEST3",
                "TEST4"
        };

    }

}

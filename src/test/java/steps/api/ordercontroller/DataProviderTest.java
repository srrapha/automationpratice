package steps.api.ordercontroller;

import dataprovider.DataProviderFactory;
import org.testng.annotations.Test;

public class DataProviderTest {


    @Test(dataProvider = "DataProvider", dataProviderClass = DataProviderFactory.class)
    private void dataProvider(String testName) {


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

    @Test(dataProvider = "dataProviderCSVExecution", dataProviderClass = DataProviderFactory.class)
    public void dataProviderCSVExecution(String testsNames) {
        System.out.println(testsNames);
    }


}

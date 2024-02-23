package dataprovider;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class DataProviderFactory {

    static final String CSV_FILE = "src/test/resources/export.csv";
    static final String DELIMETER = ",";

    @DataProvider(name = "dataProviderCSVExecution")
    public Iterator<Object[]> dataProviderCSVExecution(){
        try {
           final Scanner scanner = new Scanner(new File(CSV_FILE)).useDelimiter(DELIMETER);
            return new Iterator<Object[]>() {
                @Override
                public boolean hasNext() {
                    return scanner.hasNext();
                }
                @Override
                public Object[] next() {
                    return new Object[]{scanner.next()};
                }
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DataProvider(name = "DataProvider")
    public Object[] dataProvider() {
        return new Object[]{
                "TEST0",
                "TEST1",
                "TEST2",
                "TEST3",
                "TEST4"
        };

    }


}

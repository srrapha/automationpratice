import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExtentITestListenerClassAdapter.class})
public class AcceptanceTest {

    @Test(groups="acceptance")
    public void acceptanceOrderTest(){



    }

}

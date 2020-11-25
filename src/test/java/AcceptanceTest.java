import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.product.RegisterProductDTO;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

@Listeners({ExtentITestListenerClassAdapter.class})
public class AcceptanceTest {

    private static final GeneralUtils utils = new GeneralUtils();

    @Test(groups="acceptance")
    public void mustReturn200_acceptanceEncapsulatedOrderTest(){

        utils.mustReturn200_getAllProducts();

        RegisterProductDTO registerProduct = utils.mustReturn200_registerGenericProduct();

        RegisterProductDTO getProduct = utils.mustReturn200_getGenericProductById(registerProduct.getId());

        RegisterProductDTO deleteProduct = utils.mustReturn200_deleteGenericProductById(getProduct.getId());

        System.out.println(deleteProduct);

    }


    @Test(groups="acceptance")
    public void mustReturn200_acceptanceSearchClientZipTest(){

        utils.mustReturn200_getAllProducts();

        RegisterProductDTO registerProduct = utils.mustReturn200_registerGenericProduct();

        RegisterProductDTO getProduct = utils.mustReturn200_getGenericProductById(registerProduct.getId());



        RegisterProductDTO deleteProduct = utils.mustReturn200_deleteGenericProductById(getProduct.getId());


    }

}

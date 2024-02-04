package steps.api;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;
import dto.product.RegisterProductDTO;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GeneralUtils;

import static constants.Constants.ID_FIVE;

@Listeners({ExtentITestListenerClassAdapter.class})
public class AcceptanceTest {

    @Test(groups="acceptance")
    public void mustReturn200_acceptanceEncapsulatedOrderTest(){

        GeneralUtils.mustReturn200_getAllProducts();

        RegisterProductDTO registerProduct = GeneralUtils.mustReturn200_registerGenericProduct();

        RegisterProductDTO getProduct = GeneralUtils.mustReturn200_getGenericProductById(registerProduct.getId());

        RegisterProductDTO deleteProduct = GeneralUtils.mustReturn200_deleteGenericProductById(getProduct.getId());

        System.out.println(deleteProduct);

    }


    @Test(groups="acceptance")
    public void mustReturn200_acceptanceSearchClientZipTest(){

        RegisterAdressDTO adress = GeneralUtils.mustReturn200_getGenericAdressById(ID_FIVE);

        SimulationZipJsonDTO zipJson = GeneralUtils.mustReturn200_getZipJsonWithParameter(adress.getZip());

        System.out.println(zipJson);
    }

}

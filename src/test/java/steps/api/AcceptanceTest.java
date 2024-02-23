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

        GeneralUtils.mustReturn200GetAllProducts();

        RegisterProductDTO registerProduct = GeneralUtils.mustReturn200RegisterGenericProduct();

        RegisterProductDTO getProduct = GeneralUtils.mustReturn200GetGenericProductById(registerProduct.getId());

        RegisterProductDTO deleteProduct = GeneralUtils.mustReturn200DeleteGenericProductById(getProduct.getId());

        System.out.println(deleteProduct);

    }


    @Test(groups="acceptance")
    public void mustReturn200_acceptanceSearchClientZipTest(){

        RegisterAdressDTO adress = GeneralUtils.mustReturn200GetGenericAdressById(ID_FIVE);

        SimulationZipJsonDTO zipJson = GeneralUtils.mustReturn200GetZipJsonWithParameter(adress.getZip());

        System.out.println(zipJson);
    }

}

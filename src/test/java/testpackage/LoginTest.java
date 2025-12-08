package testpackage;

import org.testng.annotations.Test;

import basepackage.BaseClass;
import pagepackage.CartPage;
import pagepackage.CustomCakePage;
import pagepackage.HomePage;
import pagepackage.LoginPage;
import pagepackage.ProductDetailPage;
import pagepackage.ProductPage;
import utilities.ExcelUtils;


public class LoginTest extends BaseClass{
	@Test
	public void verifyLoginWithValidCred () throws Exception

	{
	            HomePage h=new HomePage(driver);
	            h.clickSigninBtn();
	            LoginPage l = new LoginPage(driver);
	            ProductPage prod =new ProductPage(driver);
	            ProductDetailPage pdetail= new ProductDetailPage(driver);
	            CartPage cart=new CartPage(driver);
	            CustomCakePage cus=new CustomCakePage(driver);

	            String xl = "C:\\Users\\hp\\Documents\\Book_LetsBake.xlsx";

	            String Sheet = "Sheet1";

	            int rowCount = ExcelUtils.getRowCount(xl, Sheet);

	            for (int i=1;i<=rowCount;i++)

	            {

	                        String UserName=ExcelUtils.getCellValue(xl, Sheet, i, 0);
                               System.out.println("username---"+UserName);
	                        String Pwd=ExcelUtils.getCellValue(xl, Sheet, i, 1);
                               //System.out.println("password---"+Pwd);
	                        l.setvalues(UserName, Pwd);                
                             l.clickLoginBtn();
	                        
	                        
	                        
	                        String expectedurl="https://letsbake.ca/my-account/";
	          			  String actualurl= driver.getCurrentUrl();
	          			  
	          			     if(actualurl.equals(expectedurl))
	          			     {
	          			    	System.out.println("Passed");
	          			     }else
	          			     {
	          			    	System.out.println("Failed");
	          			     }
	                   	                        
	            }
	            
	            
	            l.clickHome();
	            h.closePopupIfPresent();
	            h.titleVerification();
	            h.logoVerification();
	            h.closePopupIfPresent();
	            h.clickCollections();
	            prod.clickDropDown();
	            prod.clickProduct();
	            pdetail.addProductDetails();
	            cart.cartPageScreenshot();
	            cart.clickBackToShop();
	            cus.clickCustomCakes();
	            cus.addCustomCakeDetails();
}
}

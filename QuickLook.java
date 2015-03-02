package teste.util;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class QuickLook extends BaseTest{
	@Test
	@Parameters({"selenium.product.name"})
	
	public void quickLook(String productName){

		
		
		selenium.open("/?cm_sp=tnav-_-williams-sonoma-_-tab");
		speedTest("slow");
		selenium.type("id=search-field", productName);
		selenium.click("id=btnSearch");
		selenium.waitForPageToLoad("30000");
		
		//TC 1 - Verify if search field takes to the results page
		assertTrue(selenium.isTextPresent("Search Results for:"));
		
		//Catch the price displayed at results page
		String preco = selenium.getText("xpath=/html/body/div[1]/div/div[2]/div[2]/div[2]/ul/li/span/span[2]/span[2]/span[2]/text()");

		//Quick Look
		//TC 2 - Confirm if the quick look button is displayed
		assertTrue(selenium.isElementPresent("xpath=/html/body/div[1]/div/div[2]/div[2]/div[2]/ul/li/div[1]/a[2]"));
		selenium.click("xpath=/html/body/div[1]/div/div[2]/div[2]/div[2]/ul/li/div[1]/a[2]");	
		
		// TC 3 - Verify if the product overlay is displayed after clicks on quick look button.
		assertTrue(selenium.isElementPresent("id=quicklookOverlay"));
		
		// TC 4 The product clicked should have the same name and price as the product in the overlay
		assertTrue(selenium.isTextPresent(preco));
		

		speedTest("slow");
		
	}
	
	


	public static void speedTest(String velocidade){

		if (velocidade.equals("slowx2")){
			selenium.setSpeed("10000");
		}else if (velocidade.equals("slow")){
				  selenium.setSpeed("5000");
			  }else if (velocidade.equals("fast")){
				    	selenium.setSpeed("100");
					}else {
							selenium.setSpeed("3000");
						  }
	}
	
}






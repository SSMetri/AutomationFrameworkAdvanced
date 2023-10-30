package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider= "getData")
	public void addProductToCart(String pName,int price,int qty,String model)
	{
		System.out.println("Phone name is : "+ pName +" \nprice : "+price+" \nquantity : "+qty+" \nmodel : "+model);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]=1000;
		data[0][2]=20;
		data[0][3]="A80";
		data[1][0]="Nokia";
		data[1][1]=2000;
		data[1][2]=15;
		data[0][3]="N18";
		data[2][0]="iPhone";
		data[2][1]=3000;
		data[2][2]=18;
		data[2][3]="I15";

		return data;
		
	}
}

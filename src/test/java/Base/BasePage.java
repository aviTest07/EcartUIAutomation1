

package Base;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{

	public WebDriver driver;
	
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
public	boolean checkSorting(ArrayList< Integer > arraylist)
{
	boolean isSorted=true;
    for(int i=1;i < arraylist.size();i++){
        if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
            isSorted= false;
            break;
        }
    }
    return isSorted;
}
}
	



package pages;

import org.openqa.selenium.JavascriptExecutor;

public class NavigateMethods extends Base {
	public  void scrollPage(String to) throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor)browser;
		if (to.equals("end"))
			executor.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
            executor.executeScript("window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}


}

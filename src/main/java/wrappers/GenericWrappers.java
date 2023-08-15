package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporting;


public class GenericWrappers extends Reporting implements Wrappers {
	
	public static Properties cProp;
	
	public void loadConfiProperties() {
		try {
			cProp=new Properties();
			cProp.load(new FileInputStream("./src/test/java/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static RemoteWebDriver driver;
	
	int i=1;
	
	public static Properties prop;
	
	public void loadObjects() {
		
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/java/object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void unloadObjects() {
		prop=null;
	}

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		
		
		try { 
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//System.out.println("The browser "+browser+" is successfully launched with the given url "+url);
			
			reportStep("The browser "+browser+" is successfully launched with the given url "+url , "pass");
	
			
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			
			//System.err.println("The browser "+browser+" is not launched with the given url "+url+" due to session not created error");
			
			reportStep("The browser "+browser+" is not launched with the given url "+url+" due to session not created error", "fail");
			
	
		}catch (InvalidArgumentException e) {
			// TODO: handle exception
			
			//System.err.println("The browser "+browser+" is not launched because the url "+url+" doesnt contain http/https");
			
			reportStep("The browser "+browser+" is not launched because the url "+url+" doesnt contain http/https", "fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			
		//System.err.println("The browser "+browser+" is not launched due to unknown error");	
		
		reportStep("The browser "+browser+" is not launched due to unknown error", "fail");
		
		}
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			
			driver.findElement(By.id(idValue)).sendKeys(data);
			//driver.findElementById(idValue).sendKeys(data);
			//driver.findElementById(idValue).sendKeys(data);
			//System.out.println("The element with id "+idValue+" is entered with data "+data);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with id "+idValue+" is entered with data "+data, "pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with id "+idValue+" is not found in the DOM");
			
			reportStep("The element with id "+idValue+" is not found in the DOM", "fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with id "+idValue+" is not interactable in the application");
			reportStep("The element with id "+idValue+" is not interactable in the application", "fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with id "+idValue+" is not stable in the applicaton");
			
			reportStep("The element with id "+idValue+" is not stable in the applicaton", "fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with id "+idValue+" is not entered with given data "+data+" due to unknown error");
			reportStep("The element with id "+idValue+" is not entered with given data "+data+" due to unknown error", "fail");
			
		}
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(nameValue)).sendKeys(data);
			//driver.findElementByName(nameValue).sendKeys(data);
			//System.out.println("The element with name "+nameValue+" is entered with data "+data);
			reportStep("The element with name "+nameValue+" is entered with data "+data, "pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with name "+nameValue+" is not found in the DOM");
			reportStep("The element with name "+nameValue+" is not found in the DOM", "fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the name "+nameValue+" is not interactable in the application");
			
			reportStep("The element with the name "+nameValue+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the name "+nameValue+" is not stable in the application");
			
			reportStep("The element with the name "+nameValue+" is not stable in the application","fail");
			
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the name "+nameValue+" is not entered with data "+data+" due to unknown error");
			
			reportStep("The element with the name "+nameValue+" is not entered with data "+data+" due to unknown error","fail");
			
		}
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathValue)).sendKeys(data, Keys.TAB);
			//System.out.println("The element with the xpath "+xpathValue+" is entered with data "+data);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+xpathValue+" is entered with data "+data,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the xpath "+xpathValue+" is not found in the DOM ");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+xpathValue+" is not found in the DOM ","fail");			
		}
		catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathValue+" is not interactable in the application");
			
			reportStep("The element with the xpath "+xpathValue+" is not interactable in the application","fail");
			
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathValue+" is not stable in the application");
			reportStep("The element with the xpath "+xpathValue+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
		//	System.err.println("The element with the xpath "+xpathValue+" is not entered with data "+data+" due to unknown error");
			
			reportStep("The element with the xpath "+xpathValue+" is not entered with data "+data+" due to unknown error","fail");
			
		}
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method s``tub
		
		 try {
			String atitle = driver.getTitle();
			 if(atitle.equals(title)) {
				 //System.out.println("The title "+atitle+" of the page is matched with expected title "+title);
				 
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 reportStep("The title "+atitle+" of the page is matched with expected title "+title,"pass");
				 
			 }else {
				// System.err.println("The title "+atitle+" of the page is not matched with expected title "+title);
				 reportStep("The title "+atitle+" of the page is not matched with expected title "+title,"fail");
				 
			 }
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The title of the page "+title+" is not verified due to unknown error");
			reportStep("The title of the page "+title+" is not verified due to unknown error","fail");
		
		}
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElement(By.id(id)).getText();
		
			if(actualtext.equals(text)) {
			//	System.out.println("The element with the id "+id+" is holding the text "+actualtext+" is mathched with expected text "+text);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				reportStep("The element with the id "+id+" is holding the text "+actualtext+" is mathched with expected text "+text,"pass");
				
			}else {
				//System.err.println("The element with the id "+id+" is holding the text "+actualtext+" is not matched with expected text "+text);
				reportStep("The element with the id "+id+" is holding the text "+actualtext+" is not matched with expected text "+text,"fail");
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the id "+id+" is not found in the DOM");
			reportStep("The element with the id "+id+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not interactable in the application");
			
			reportStep("The element with the id "+id+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application","fail");
			
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is holding the text "+text+" is not verified due to unknown error");
			
			reportStep("The element with the id "+id+" is holding the text "+text+" is not verified due to unknown error","fail");
			
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualtext = driver.findElement(By.xpath(xpath)).getText();
			if(actualtext.equals(text)) {
				//System.out.println("The element with the xpath "+xpath+" is holding the text "+actualtext+" is exactly matched with the expected text "+text);
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is exactly matched with the expected text "+text,"pass");
				
			}else {
				//System.err.println("The element with the xpath "+xpath+" is holding the text "+actualtext+" is not exactly matched with the expected text "+text);
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is not exactly matched with the expected text "+text,"fail");
			}
		
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not found in the DOM");
			
			reportStep("The element with the xpath "+xpath+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not interactable in the application");
			
			reportStep("The element with the xpath "+xpath+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not stable in the application");
			reportStep("The element with the xpath "+xpath+" is not stable in the application","fail");
			
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to some unknown error");
			
			reportStep("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to some unknown error","fail");
			
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String actualtext = driver.findElement(By.xpath(xpath)).getText();
		try {
			if (actualtext.contains(text)) {
				//System.out.println("The element with the xpath "+xpath+" is holding the text "+actualtext+" partially matched with the expected text "+text);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" partially matched with the expected text "+text,"pass");
				
			}else {
				//System.err.println("The element with the xpath "+xpath+" is holding the text "+actualtext+" partially not  matched with the expected text "+text);
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" partially not  matched with the expected text "+text,"fail");
				
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the xpath "+xpath+" is not found in the DOM");
			reportStep("The element with the xpath "+xpath+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not interactable in the appplication");
			reportStep("The element with the xpath "+xpath+" is not interactable in the appplication","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not stable in the application");
			reportStep("The element with the xpath "+xpath+" is not stable in the application","fail");
			
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to unknown error");
			reportStep("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to unknown error","fail");
			
		}
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.id(id)).click();
			//System.out.println("The element with the id "+id+" is successfully clicked" );
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the id "+id+" is successfully clicked","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the id "+id+" is not found in the DOM");
			reportStep("The element with the id "+id+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is disabled in the application");
			
			reportStep("The element with the id "+id+" is disabled in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not clickable due to unknown error");
			reportStep("The element with the id "+id+" is not clickable due to unknown error","fail");
		}
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.className(classVal)).click();
			
			//System.out.println("The element with the classname "+classVal+" is successfully clicked");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the classname "+classVal+" is successfully clicked","pass");
			
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the classname "+classVal+" is not found in the DOM");
			reportStep("The element with the classname "+classVal+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the classname "+classVal+" is disabled in the application");
			reportStep("The element with the classname "+classVal+" is disabled in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the classname "+classVal+" is not stable in the application");
			reportStep("The element with the classname "+classVal+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the classname "+classVal+" is not clickable due to unnown error");
			reportStep("The element with the classname "+classVal+" is not clickable due to unnown error","fail");
			
		}
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.name(name)).click();
			//System.out.println("The element with the name "+name+" is clicked successfully");			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the name "+name+" is clicked successfully","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with the name "+name+" is not found in the DOM","fail");
			//System.err.println("The element with the name "+name+" is not found in the DOM");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
            //System.err.println("The element with the name "+name+" is unable to click in the application");
			reportStep("The element with the name "+name+" is unable to click in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the name "+name+" is not stable in the application");
			reportStep("The element with the name "+name+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the name "+name+" is not clicked due to unknown error");
			reportStep("The element with the name "+name+" is not clicked due to unknown error","fail");
		
		}
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.linkText(name)).click();
			//System.out.println("The element with link name "+name+" is clicked successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with link name "+name+" is clicked successfully","pass");
		
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the link name "+name+" is not found in the DOM");
			reportStep("The element with the link name "+name+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the link name "+name+" is unable to click in the application");
			reportStep("The element with the link name "+name+" is unable to click in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the link name "+name+" is not stable in the application");
			reportStep("The element with the link name "+name+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the link name "+name+" is not clicked due to some unknown error");
			reportStep("The element with the link name "+name+" is not clicked due to some unknown error","fail");
			
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.linkText(name)).click();
			//System.out.println("The element with the link name "+name+" is clicked successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the link name "+name+" is clicked successfully","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the link name "+name+" is not found in the DOM");
			reportStep("The element with the link name "+name+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the link name "+name+" is unable to click in the application");
			reportStep("The element with the link name "+name+" is unable to click in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the link name "+name+" is not stable in the application");
			reportStep("The element with the link name "+name+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the link name "+name+" is not clicked due to unknown error");
			reportStep("The element with the link name "+name+" is not clicked due to unknown error","fail");
		}
	}

	public void clickByXpath(String xpathVal, String value) {
		
		
		try {
			if(xpathVal.contains("$")) {
				xpathVal= 	xpathVal.replace("$value$", value);
			}
		
		
		// TODO Auto-generated method stub
		
			driver.findElement(By.xpath(xpathVal)).click();
			//System.out.println("The element with the xpath "+xpathVal+" is clicked successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+xpathVal+" is clicked successfully","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the xpath "+xpathVal+" is not found in the DOM");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is unable to click in the application");
			reportStep("The element with the xpath "+xpathVal+" is unable to click in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not clicked due to unknown error");
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown error","fail");	
		}
	}
	
public void clickByXpath(String xpathVal) {
		
		
		try {
			
	
		// TODO Auto-generated method stub
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element with the xpath "+xpathVal+" is clicked successfully","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the xpath "+xpathVal+" is not found in the DOM");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is unable to click in the application");
			reportStep("The element with the xpath "+xpathVal+" is unable to click in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not clicked due to unknown error");
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown error","fail");	
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			//System.out.println("The element with the xpath "+xpathVal+" is clicked successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+xpathVal+" is clicked successfully","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//System.err.println("The element with the xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
			
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is unable to click in the application");
			reportStep("The element with the xpath "+xpathVal+" is unable to click in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not clicked due to unknown error");
		
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown error","fail");
		}
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		
			String atext=null;
			try {
				atext = driver.findElement(By.id(idVal)).getText();
				//System.out.println("The element with the id "+idVal+" is holding the text "+atext);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				reportStep("The element with the id "+idVal+" is holding the text "+atext,"pass");
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				//System.err.println("The element with the id "+idVal+" is not found in the DOM");
				reportStep("The element with the id "+idVal+" is not found in the DOM","fail");
				
			}catch (ElementNotInteractableException e) {
				// TODO: handle exception
				//System.err.println("The element with the id "+idVal+" is not interactable in the application");
				reportStep("The element with the id "+idVal+" is not interactable in the application","fail");
				
			}catch (StaleElementReferenceException e) {
				// TODO: handle exception
				//System.err.println("The element with the id "+idVal+" is not stable in the application");
				reportStep("The element with the id "+idVal+" is not stable in the application","fail");
				
			}catch (WebDriverException e) {
				// TODO: handle exception
				//System.err.println("The element with the id "+idVal+" is not holding the text "+atext+" due to unknown error");
				reportStep("The element with the id "+idVal+" is not holding the text "+atext+" due to unknown error","fail");
				
			
			}
			
			return atext;
			
		
	}

	public String getTextByXpath(String xpathVal) {
		 String text = null;
		
	
		// TODO Auto-generated method stub
		try {
		text = driver.findElement(By.xpath(xpathVal)).getText();
		System.out.println("The element with the xpath "+xpathVal+" is getting the text "+text);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		reportStep("The element with the xpath "+xpathVal+" is getting the text "+text,"pass");
		
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		//	System.err.println("The element with the xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with the xpath "+xpathVal+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not interactable in the application");
			reportStep("The element with the xpath "+xpathVal+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with the xpath "+xpathVal+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not getting the text "+text+" due to unknown error");
			reportStep("The element with the xpath "+xpathVal+" is not getting the text "+text+" due to unknown error","fail");
			
		}
		
		return text;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement se1 = driver.findElement(By.id(id));
			Select sel = new Select(se1);
			sel.selectByVisibleText(value);
			//System.out.println("The element with the id "+id+" is selected the dropdown visible text "+value);
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the id "+id+" is selected the dropdown visible text "+value,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the id "+id+" is not found in the DOM");
			reportStep("The element with the id "+id+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not interactable in the application");
			reportStep("The element with the id "+id+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not selected the dropdown visible text "+value+" due to unknown error");
			reportStep("The element with the id "+id+" is not selected the dropdown visible text "+value+" due to unknown error","fail");
			
		}
	}

	
		
	
	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement se2 =driver.findElement(By.id(id));
			Select sel1 = new Select(se2);
			sel1.selectByIndex(value);
			//System.out.println("The element with the id "+id+" is selected dropdown using index value "+value);
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the id "+id+" is selected dropdown using index value "+value,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the id "+id+" is not found in the DOM");
			reportStep("The element with the id "+id+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
           //System.err.println("The element with the id "+id+" is not interactable in the application");
			reportStep("The element with the id "+id+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not selected dropdown using index value "+value+" due to unknown error");
		
			reportStep("The element with the id "+id+" is not selected dropdown using index value "+value+" due to unknown error","fail");		
		}
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub

		try {
			Set<String> allwinidsafterclick = driver.getWindowHandles();
			for(String eachid:allwinidsafterclick) {
				driver.switchTo().window(eachid);
				break;
			}
			//System.out.println("Switched to the parent window from the current window");
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("Switched to the parent window from the current window","pass");
			
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
		//System.err.println("No window present in the webpage");
			reportStep("No window present in the webpage","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("Not switching to the parent window due to unknown error");
			reportStep("Not switching to the parent window due to unknown error","fail");
		
		}
		
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> allwinidsafterclick = driver.getWindowHandles();
			for(String eachid:allwinidsafterclick) {
				driver.switchTo().window(eachid);
				
			}
			//System.out.println("Moved to the last opened window ");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("Moved to the last opened window","pass");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			//System.err.println("No window present to switch in the web page");
		
			reportStep("No window present to switch in the web page","fail");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("Not moved to last window due to unknoewn error");
			reportStep("Not moved to last window due to unknoewn error","fail");
		
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			//System.out.println("The opened alert is accepted");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The opened alert is accepted","pass");
			
			
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("No alert present in the application");
			reportStep("No alert present in the application","fail");
			
		}catch (NoSuchFrameException e) {
			// TODO: handle exception
			
			//System.err.println("The Alert frame is not found in the Application");
			reportStep("The Alert frame is not found in the Application","fail");
		
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The alert is not accepted due to unknown error");
	
			reportStep("The alert is not accepted due to unknown error","fail");
		
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			//System.out.println("The opened alert is dismissed");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			reportStep("The opened alert is dismissed","pass");
			
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("No alert present in the application");
			reportStep("No alert present in the application","fail");
			
		}catch (NoSuchFrameException e) {
			// TODO: handle exception
			
			//System.err.println("The Alert frame is not found in the Application");
			reportStep("The Alert frame is not found in the Application","fail");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The alert is not dismissed due to unknown error");
			reportStep("The alert is not dismissed due to unknown error","fail");
		
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		
		String alerttext = null;
		try {
			alerttext = driver.switchTo().alert().getText();
			
			//System.out.println(" getting the text "+alerttext+" which is displayed in the alert box");
		
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep(" getting the text "+alerttext+" which is displayed in the alert box","pass",false);
		
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("No alert present in the application");
			reportStep("No alert present in the application","fail",false);
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The text "+alerttext+" which is displayed in the alert box is not getting due to unknown error");
			reportStep("The text "+alerttext+" which is displayed in the alert box is not getting due to unknown error","fail",false);
		
		}
		return alerttext;
		
		
		
			
			
			
	}

	public long takeSnap() {
		// TODO Auto-generated method stub
		
		long number=0;
		
		try {
			
			number= (long) (Math.floor(Math.random()*100000000)+100000);
			
			
			File input = driver.getScreenshotAs(OutputType.FILE);
			File output = new File("./reports/screenshots/"+number+".png");
			FileUtils.copyFile(input, output);
			
			//System.out.println("The screenshot taken successfully and copied to output "+output+" file");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//reportStep("The screenshot taken successfully and copied to output "+output+" file","pass");
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
		//System.err.println("The screenshot not taken due to unknown error");
			reportStep("The screenshot not taken due to unknown error","fail", false);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
		//System.err.println("The screenshot not taken and not copied due to some error");
		
			reportStep("The screenshot not taken and not copied due to some error","fail", false);
		
		} 
		
		return number;
	}
	
	
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			//System.out.println("The browser is closed successfully");
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The browser is closed successfully","pass", false);
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("due to unknown error the  browser is not closed");
			reportStep("due to unknown error the  browser is not closed","fail");
		
		}
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
	try {
		driver.quit();
		reportStep("All browsers closed successfully","pass", false);
	} catch (WebDriverException e) {
		reportStep("All browsers not closed successfully due to unknown error","fail", false);
	}	
	
	}

	
	public void waitProperty(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void selectValueById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement se3 =driver.findElement(By.id(id));
			Select sel2 = new Select(se3);
			sel2.selectByValue(value);
			reportStep("The element with id "+id+" is selected dropdown using value "+value,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The element with id "+id+" is not found in the DOM","fail");
		
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			
			//System.err.println("The element with the id "+id+" is not interactable in the application");
			reportStep("The element with the id "+id+" is not interactable in the application","fail");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//	System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception

			//System.err.println("The element with the id "+id+" is not selected dropdown using value "+value+" due to unknown error");
			reportStep("The element with the id "+id+" is not selected dropdown using value "+value+" due to unknown error","fail");
		
		}
		
		
	}

	public void selectValueByXpath(String xpathValue, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement se4 = driver.findElement(By.xpath(xpathValue));
			Select sel4 = new Select(se4);
			sel4.selectByValue(value);
//			System.out.println("The element with xpath "+xpathValue+" is selected dropdown using value "+value);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			reportStep("The element with xpath "+xpathValue+" is selected dropdown using value "+value,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpathValue+" is not found in the DOM");
			
			reportStep("The element with xpath "+xpathValue+" is not found in the DOM","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception

			//System.err.println("The element with xpath "+xpathValue+" is not interactable in the application");
			reportStep("The element with xpath "+xpathValue+" is not interactable in the application","fail");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//	System.err.println("The element with the xpath "+xpathValue+" is not stable in the application");
			reportStep("The element with the xpath "+xpathValue+" is not stable in the application","fail");
		
		
		}catch (WebDriverException e) {
			// TODO: handle exception

			//System.err.println("The element with the xpath "+xpathValue+" is not selected dropdown using value "+value+" due to unknown error");
			reportStep("The element with the xpath "+xpathValue+" is not selected dropdown using value "+value+" due to unknown error","fail");
		
		
		}
	
		
	}

	public void selectVisibleTextByXpath(String xpathValue, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement se5 = driver.findElement(By.xpath(xpathValue));
			Select sel5 = new Select(se5);
			sel5.selectByVisibleText(value);
			//System.out.println("The element with xpath "+xpathValue+" is selected dropdown visible text "+value);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with xpath "+xpathValue+" is selected dropdown visible text "+value,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpathValue+" is not found in the DOM");
			reportStep("The element with xpath "+xpathValue+" is not found in the DOM","fail");
		
		
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathValue+" is not interactable in the application");
			reportStep("The element with xpath "+xpathValue+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//	System.err.println("The element with the xpath "+xpathValue+" is not stable in the application");
			reportStep("The element with the xpath "+xpathValue+" is not stable in the application","fail");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
		//	System.err.println("The element with the xpath "+xpathValue+" is not selected dropdown visible text "+value+" due to unknown error");
			reportStep("The element with the xpath "+xpathValue+" is not selected dropdown visible text "+value+" due to unknown error","fail");
		
		}
		
	}

	public void selectIndexByXpath(String xpathVal, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement se6 = driver.findElement(By.xpath(xpathVal));
			Select sel6 = new Select(se6);
			sel6.selectByIndex(value);
			//System.out.println("The element with xpath "+xpathVal+" is selected dropdown using index value "+value);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with xpath "+xpathVal+" is selected dropdown using index value "+value,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in the DOM","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			
		//	System.err.println("The element with xpath "+xpathVal+" is not interactable in the application");
			reportStep("The element with xpath "+xpathVal+" is not interactable in the application","fail");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//	System.err.println("The element with xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with xpath "+xpathVal+" is not stable in the application","fail");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not selected dropdown using index value "+value);
			reportStep("The element with xpath "+xpathVal+" is not selected dropdown using index value "+value,"fail");
			
			
		}
	
		
		
	}


	public void scrollDown() {
		// TODO Auto-generated method stub
		
		try {
			driver.findElement(By.xpath("//html/body")).sendKeys(Keys.PAGE_DOWN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	public void selectIndexByName(String name, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement se7 = driver.findElement(By.name(name));
			Select sel7 = new Select(se7);
			sel7.selectByIndex(value);
			//System.out.println("The element with name "+name+" is selected dropdown using index value "+value);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with name "+name+" is selected dropdown using index value "+value,"pass");
			
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with name "+name+" is not found in the DOM");
			reportStep("The element with name "+name+" is not found in the DOM","fail");
		
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not interactable in the application");
			reportStep("The element with name "+name+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not stable in the application");
			reportStep("The element with name "+name+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not selected dropdown using index value "+value+" due to unknown error");
			reportStep("The element with name "+name+" is not selected dropdown using index value "+value+" due to unknown error","fail");
			
		}
	
		
	}

	public void selectValueByName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement se8 = driver.findElement(By.name(name));
			Select sec8 = new Select(se8);
			sec8.selectByValue(value);
			//System.out.println("The element with name "+name+" is selected dropdown using value "+value);
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			reportStep("The element with name "+name+" is selected dropdown using value "+value,"pass");
			
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with name "+name+" is not found in the DOM");
			reportStep("The element with name "+name+" is not found in the DOM","fail");
			
		
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not interactable in the application");
			reportStep("The element with name "+name+" is not interactable in the application","fail");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not stable in the application");
			reportStep("The element with name "+name+" is not stable in the application","fail");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not selected dropdown using value "+value+" due to unknown error");
			reportStep("The element with name "+name+" is not selected dropdown using value "+value+" due to unknown error","fail");
			
		}
		
	}

	public void selectVisibleTextByName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement se9 = driver.findElement(By.name(name));
			Select sec9 = new Select(se9);
			sec9.selectByVisibleText(value);
			//System.out.println("The element with name "+name+" is selected dropdown using visibletext "+value);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			reportStep("The element with name "+name+" is selected dropdown using visibletext "+value,"pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with name "+name+" is not found in the DOM");
			reportStep("The element with name "+name+" is not found in the DOM","fail");
		
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not interactable in the application");
			reportStep("The element with name "+name+" is not interactable in the application","fail");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not stable in the application");
			reportStep("The element with name "+name+" is not stable in the application","fail");
		
		}catch (WebDriverException e) {
			// TODO: handle exception
		//	System.err.println("The element with name "+name+" is not selected dropdown using visible text "+value+" due to unknown error");
			reportStep("The element with name "+name+" is not selected dropdown using visible text "+value+" due to unknown error","fail");
		
		}
	}

	public void switchToAlertFrame(String id) {
		// TODO Auto-generated method stub

		try {
			WebElement frame=driver.findElement(By.id(id));
			driver.switchTo().frame(frame);
		//	System.out.println("The element with id "+id+" Switched to alert frame");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with id "+id+" Switched to alert frame","pass");
		
		}catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with id "+id+" not Switched to alert frame due to unknown error");
		
			reportStep("The element with id "+id+" not Switched to alert frame due to unknown error","fail");
		}
	}

	public void switchToAlert(String xpath) {
		// TODO Auto-generated method stub
		try {
			WebElement frame=driver.findElement(By.xpath(xpath));
			driver.switchTo().frame(frame);
		//	System.out.println("The element with xpath "+xpath+" Switched to alert frame");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with xpath "+xpath+" Switched to alert frame","pass");
		
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
		//	System.err.println("No alert present in the application");
			reportStep("No alert present in the application","fail");
		
		}catch (WebDriverException e) {
			// TODO Auto-generated catch block
		//	System.err.println("The element with xpath "+xpath+" not Switched to alert framedue to unknown error");
			reportStep("The element with xpath "+xpath+" not Switched to alert frame due to unknown error","fail");
		
		}
		
		
	}

	public void refreshScreen() {
		// TODO Auto-generated method stub
		try {
			driver.navigate().refresh();
		//	System.out.println("The page is refreshed successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The page is refreshed successfully","pass");
		
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The page not refreshed due to unknown error");
			reportStep("The page not refreshed due to unknown error","fail");
		}
		
	}

	public void defaultContent() {
		// TODO Auto-generated method stub
		
		
		try {
			driver.switchTo().defaultContent();
			//System.out.println("Moved to defaultframe successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("Moved to defaultframe successfully","pass");
			
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("Not moved to default frame due to unknown error");
			reportStep("Not moved to default frame due to unknown error","fail");
		}  
	}

	

	public void verifyTextContainsById(String id, String text) {
		// TODO Auto-generated method stub
		
		try {
			String atext = driver.findElement(By.id(id)).getText();
			
			if(atext.contains(text)) {
			//	System.out.println("The element with the id "+id+" is holding the text "+atext+" is partially mathched with expected text "+text);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				reportStep("The element with the id "+id+" is holding the text "+atext+" is partially mathched with expected text "+text,"pass");
			
			}else {
			//	System.err.println("The element with the id "+id+" is holding the text "+atext+" is not matched with expected text "+text);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				reportStep("The element with the id "+id+" is holding the text "+atext+" is not matched with expected text "+text,"fail");
			
			}
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
		//	System.err.println("The element with the id "+id+" is not found in the DOM");
			reportStep("The element with the id "+id+" is not found in the DOM","fail");
		
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
		//	System.err.println("The element with the id "+id+" is not interactable in the application");
			reportStep("The element with the id "+id+" is not interactable in the application","fail");
		
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//	System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application","fail");
			
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is holding the text "+text+" is not verified due to unknown error");
	
			reportStep("The element with the id "+id+" is holding the text "+text+" is not verified due to unknown error","fail");
		}
		
	}

	public void enterInAlert(String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.switchTo().alert().sendKeys(data);
			
			//System.out.println("The element entered the given data "+data+" in the alert successfully");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element entered the given data "+data+" in the alert successfully","pass",false);
		
		
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
		//	System.err.println("The element not entered the data "+data+" in the alert due to unknown error");
			reportStep("The element not entered the data "+data+" in the alert due to unknown error","fail",false);
		
		}
		
		
	}

	



	public void mouseHoverByXpath(String data) {
		// TODO Auto-generated method stub
		WebElement Data = driver.findElement(By.xpath(data));
		Actions builder = new Actions(driver);
		builder.moveToElement(Data).perform();
	}
	
	
	
	public boolean verifyTextByXpathReturnsBoolean(String xpath, String text) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		try {
			String actualtext = driver.findElement(By.xpath(xpath)).getText();
			if(actualtext.equals(text)) {
				//System.out.println("The element with the xpath "+xpath+" is holding the text "+actualtext+" is exactly matched with the expected text "+text);
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is exactly matched with the expected text "+text,"pass");
				flag = true;
			}else {
				//System.err.println("The element with the xpath "+xpath+" is holding the text "+actualtext+" is not exactly matched with the expected text "+text);
				reportStep("The element with the xpath "+xpath+" is holding the text "+actualtext+" is not exactly matched with the expected text "+text,"fail");	
			}
		
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not found in the DOM");
			
			reportStep("The element with the xpath "+xpath+" is not found in the DOM","pass");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not interactable in the application");
			
			reportStep("The element with the xpath "+xpath+" is not interactable in the application","fail");
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is not stable in the application");
			reportStep("The element with the xpath "+xpath+" is not stable in the application","fail");
			
			
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to some unknown error");
			
			reportStep("The element with the xpath "+xpath+" is holding the text "+text+" is not verified due to some unknown error","fail");
			
		}
		
		
		return flag;
	}

	@Override
	public boolean verifyIsElementDisplayedByXpath(String Xpath) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			result=driver.findElement(By.xpath(Xpath)).isDisplayed();
			//System.out.println("The element with the xpath "+xpathValue+" is entered with data "+data);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+Xpath+ " is displayed ","pass");
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the xpath "+xpathValue+" is not found in the DOM ");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			reportStep("The element with the xpath "+Xpath+" is not found in the DOM ","fail");
			
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathValue+" is not interactable in the application");
			
			reportStep("The element with the xpath "+Xpath+" is not interactable in the application","fail");
			
			
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathValue+" is not stable in the application");
			reportStep("The element with the xpath "+Xpath+" is not stable in the application","fail");
			
		}catch (WebDriverException e) {
			// TODO: handle exception
		//	System.err.println("The element with the xpath "+xpathValue+" is not entered with data "+data+" due to unknown error");
			
			reportStep("The element with the xpath "+Xpath+ " is not displayed due to unknown error","fail");
			
		}
		return result;
	}

	@Override
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
			return (generatedString);
		}
		
	

	@Override
	public String randomeNumber() {		
			String generatedString2 = RandomStringUtils.randomNumeric(10);
			return (generatedString2);		
	}

	@Override
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);		
		return (st+"@"+num+".com");
	}	
	}

	
	
	
	
	
	
	
	
	
	
	



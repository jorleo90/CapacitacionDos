package DataDrivenExcel;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyWord {

	public void click(WebDriver driver, By by) {
		WebElement eleClic = driver.findElement(by);
		eleClic.click();
		tomarPantalla(driver);
	}
	
	public void escribir(WebDriver driver, By by, String valor) {
		WebElement eleEscribir = driver.findElement(by);
		eleEscribir.sendKeys(valor);
		tomarPantalla(driver);
	}
	
	public void tomarPantalla(WebDriver driver) {
		// Captura de Pantalla
		Date fechaActual = new Date();
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("imagen" + fechaActual.getTime() + ".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
	}
	
}

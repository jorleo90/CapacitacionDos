package DataDrivenExcel;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjecucionConExcel {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		KeyWord keyWord = new KeyWord();
		//
		Workbook workBook = new XSSFWorkbook("datos.xlsx");
		Sheet sheet = workBook.getSheet("data");
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			// Empieza una nueva ejecución
			driver.get("http://sahitest.com/demo/training/login.htm");
			Row row = iterator.next();
			Cell usuario = row.getCell(0);
			Cell password = row.getCell(1);
			try {
				keyWord.escribir(driver, By.name("user"), usuario.getStringCellValue());
				keyWord.escribir(driver, By.name("password"), password.getStringCellValue());
				keyWord.click(driver, By.xpath("//input[@type='submit']"));
				WebElement lblMensaje = driver.findElement(By.id("errorMessage"));
				if (lblMensaje.isDisplayed()) {
					System.out.println("Error de Usuario y Contraseña");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		workBook.close();
		driver.close();
	}

}

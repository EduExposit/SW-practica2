package es.codeurjc.ais.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
@RunWith(Parameterized.class)
public class WebDriverDraw {

	protected ChromeDriver driver1;
	protected ChromeDriver driver2;
	
	 @BeforeClass
	 public static void setupClass() {
		 WebDriverManager.chromedriver().setup();
		 WebApp.start();
	 }
	 @AfterClass
	 public static void teardownClass() {
		 WebApp.stop();
	 }
	 @Before
	 public void setupTest() {
		 driver1 = new ChromeDriver();
		 driver2 = new ChromeDriver();
	 }
	 @After
	 public void teardown() {
		 if (driver1 != null) {
			 driver1.quit();
		 }
		 if (driver2 != null) {
			 driver2.quit();
		 }
	 }
	 @Parameters
	 public static Collection<Object[]> data(){
			
		 Object[][] data = {
			    	{0, 1, 2, 4, 3, 6, 5, 8, 7},
			        {4, 2, 0, 8, 5, 3, 1, 7, 6},
					{3, 4, 2, 8, 0, 1, 7, 6, 5}
					
			    };
		    
		    return Arrays.asList(data);
		}
		
		@Parameter(0) public int pos0;
		@Parameter(1) public int pos1;
		@Parameter(2) public int pos2;
		@Parameter(3) public int pos3;
		@Parameter(4) public int pos4;
		@Parameter(5) public int pos5;
		@Parameter(6) public int pos6;
		@Parameter(7) public int pos7;
		@Parameter(8) public int pos8;
	 @Test
	 public void test () {
		//Given
		 driver1.get("http://localhost:8080/");
		 driver2.get("http://localhost:8080/");
		 WebDriverWait waitdriver1 = new WebDriverWait(driver1, 30);
		 WebDriverWait waitdriver2 = new WebDriverWait(driver2, 30);
		 //When
		 String player1 = "PeterWalls";
		 String player2 = "Maxi";
		 driver1.findElement(By.id("nickname")).sendKeys(player1);
		 driver1.findElement(By.id("startBtn")).click();
		 driver2.findElement(By.id("nickname")).sendKeys(player2);
		 driver2.findElement(By.id("startBtn")).click();
		 waitdriver1.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos0)));
		 driver1.findElement(By.id("cell-"+pos0)).click();
		 waitdriver2.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos1)));
		 driver2.findElement(By.id("cell-"+pos1)).click();
		 waitdriver1.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos2)));
		 driver1.findElement(By.id("cell-"+pos2)).click();
		 waitdriver2.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos3)));
		 driver2.findElement(By.id("cell-"+pos3)).click();
		 waitdriver1.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos4)));
		 driver1.findElement(By.id("cell-"+pos4)).click();
		 waitdriver2.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos5)));
		 driver2.findElement(By.id("cell-"+pos5)).click();
		 waitdriver1.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos6)));
		 driver1.findElement(By.id("cell-"+pos6)).click();
		 waitdriver2.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos7)));
		 driver2.findElement(By.id("cell-"+pos7)).click();
		 waitdriver1.until(ExpectedConditions.elementToBeClickable(By.id("cell-"+pos8)));
		 driver1.findElement(By.id("cell-"+pos8)).click();
		 waitdriver1.until(ExpectedConditions.alertIsPresent());
		 waitdriver2.until(ExpectedConditions.alertIsPresent());
		 //Then
		 String mensajealertadriver1 = driver1.switchTo().alert().getText();
		 String mensajealertadriver2 = driver2.switchTo().alert().getText();
		 assertThat(mensajealertadriver1).isEqualTo("Draw!");
		 assertThat(mensajealertadriver2).isEqualTo("Draw!");
	 }

}

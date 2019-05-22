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
public class WebDriverPrimeroPierde {

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
			    	{3,0, 8, 1, 7, 2},
			        {0, 3, 1, 4, 8, 5},
					{1, 6, 2, 7, 4, 8},
					{4, 0, 5, 3, 1, 6},
					{0, 1, 2, 4, 8, 7},
					{7, 2, 0, 5, 3, 8},
					{1, 0, 7, 4, 5, 8},
					{1, 6, 7, 4, 8, 2}
			    };
		    
		    return Arrays.asList(data);
		}
		
		@Parameter(0) public int pos0;
		@Parameter(1) public int pos1;
		@Parameter(2) public int pos2;
		@Parameter(3) public int pos3;
		@Parameter(4) public int pos4;
		@Parameter(5) public int pos5;
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
		 waitdriver1.until(ExpectedConditions.alertIsPresent());
		 waitdriver2.until(ExpectedConditions.alertIsPresent());
		 //Then
		 String mensajealertadriver1 = driver1.switchTo().alert().getText();
		 String mensajealertadriver2 = driver2.switchTo().alert().getText();
		 assertThat(mensajealertadriver1).isEqualTo("Maxi wins! PeterWalls loses.");
		 assertThat(mensajealertadriver2).isEqualTo("Maxi wins! PeterWalls loses.");
	 }

}


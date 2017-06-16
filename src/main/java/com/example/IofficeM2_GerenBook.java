package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by admin on 2017/6/13.
 */

public class IofficeM2_GerenBook {
    private AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "ioffcem2/src/main/java/apps");
        File app = new File(appDir, "iofficeM2.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion", "5.0");
        //if no need install don't add this
        //capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.hf.iOffice");
        //support Chinese
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
        capabilities.setCapability("noSign", "True");
        capabilities.setCapability("appActivity", "hf.iOffice.LoginActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("appium���ӳɹ���");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void PersonBook_Test() throws Exception{
        //��¼
        login();
        Thread.sleep(20000);
        //1���鿴ͨ�����ֻ����ϴ���ͨѶ¼
        PersonBook_MobileBooks();
        //2���鿴���˵�ͨѶ¼���Լ��ĸ��˵�ͨѶ¼
        PersonBook_personBooks();
        //3���鿴����ͨѶ¼�з��������Ա����ͨѶ¼
        PersonBook_FenxiangBooks();
        //4��ͨ��ʹ��������ť���ٲ����Լ���Ҫ��ͨѶ¼
        PersonBook_SearchBooks();
        //5�����ֻ��е�ͨѶ¼�ϴ�ͨѶ¼������ͨѶ¼������ֻ�ͨѶ¼��
        PersonBook_MobileBook_Upload();
        //6���Ѹ���ͨѶ¼�����ͨѶ¼���أ�Ȼ�󱣴浽�ֻ���ͨѶ¼��
        PersonBook_MobileBook_Download();
    }
    //��¼
    public void login() throws Exception{
        Thread.sleep(15000);
        List<WebElement> listviewList = driver.findElementsByClassName("android.widget.EditText");
        //listviewList.get(0).clear();
        listviewList.get(0).sendKeys("zyj");
        listviewList.get(1).sendKeys("58993245zyj");
        // driver.findElement(By.id("com.hf.iOffice:id/txtLoginID")).sendKeys("zyj");
        // driver.findElement(By.id("com.hf.iOffice:id/txtLoginPwd")).sendKeys("58993245zyj");
        driver.findElement(By.id("btnLogin")).click();
        //Thread.sleep(10000);
        return;
    }
    //1���鿴ͨ�����ֻ����ϴ���ͨѶ¼
    public void PersonBook_MobileBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("�ֻ�ͨѶ¼")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //2���鿴���˵�ͨѶ¼���Լ��ĸ��˵�ͨѶ¼
    public void PersonBook_personBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("����Ŀ¼")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //3���鿴����ͨѶ¼�з��������Ա����ͨѶ¼
    public void PersonBook_FenxiangBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("����Ŀ¼")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //4��ͨ��ʹ��������ť���ٲ����Լ���Ҫ��ͨѶ¼
    public void PersonBook_SearchBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("����")).click();
        //��������������ť
        driver.findElement(By.id("search_button")).click();
        //���������Ĺؼ���
        driver.findElement(By.id("search_src_text")).sendKeys("s");
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //5�����ֻ��е�ͨѶ¼�ϴ�ͨѶ¼������ͨѶ¼������ֻ�ͨѶ¼��
    public void PersonBook_MobileBook_Upload() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.id("action_upload")).click();
        //ѡ����Ҫ�ϴ���ͨѶ¼
        Thread.sleep(5000);
        List<WebElement> Upload_Books=driver.findElementsByClassName("android.widget.RelativeLayout");
        Upload_Books.get(0).click();
        Upload_Books.get(2).click();
        Upload_Books.get(5).click();
        driver.findElement(By.id("action_upload")).click();
        Thread.sleep(2000);
        //���ֻ�ͨѶ¼�в鿴
        driver.findElement(By.name("�ֻ�ͨѶ¼")).click();
        //����
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;

    }
    //6���Ѹ���ͨѶ¼�����ͨѶ¼���أ�Ȼ�󱣴浽�ֻ���ͨѶ¼��
    public void PersonBook_MobileBook_Download() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.id("action_download")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("����Ŀ¼")).click();
        driver.findElement(By.name("��С��")).click();
        driver.findElement(By.name("�к���")).click();
        driver.findElement(By.name("���")).click();
        Thread.sleep(2000);

        //����
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;

    }
}

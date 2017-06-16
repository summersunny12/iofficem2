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

public class IofficeM2_CompanyBook {
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
    public void CompanyBook_Test() throws Exception{
        //���ȵ�¼����
        login();
        Thread.sleep(20000);
        //1������ͨѶ¼���棬��ʾ��˾ͨѶ¼�Լ�����ͨѶ¼����˾ͨѶ¼����ÿһ���ŵĹ�˾Ա���ĵ绰���룬���ҿ���ͨ���ؼ��ֶԹ�˾��Ա���ĵ绰����,���ĳһ�����ſ��Բ鿴�ò��ŵ�Ա���ĵ绰����
        CompanyBook_quanbu_Test();
        //2������ͨѶ¼���棬�Ϳ���ͨ�����������ť��Ȼ������ؼ��֣��Ӷ���ʾĳһ�����ŵ�ͨѶ¼����ĳһ��Ա����ͨѶ¼
        CompanyBook_Search_Test();
        //3�����빫˾ͨѶ¼���棬Ȼ�󵥻������á��˵����Ϳ��Բ鿴����˾ͨѶ¼�г��õĹ�˾ͨѶ¼��Ա������Щ
        CompanyBook_changyong_Test();
        //4�����빫˾ͨѶ¼���棬Ȼ�������ذ�ť��Ȼ���Լ�ѡ���Լ�Ҫ���浽�Լ��ֻ���Ա����ͨѶ¼��Ȼ����"���"��ť���Ϳ��Խ���˾ͨѶ¼�е�ͨѶ¼���浽�ֻ���ͨѶ¼��ȥ
        CompanyBook_MoblieBook_Test();
        //5�����빫˾ͨѶ¼���棬Ȼ�������ذ�ť���ٵ�������������ť��Ȼ���Լ�ѡ���Լ�Ҫ���浽�Լ��ֻ���Ա����ͨѶ¼��Ȼ����"���"��ť���Ϳ��Խ���˾ͨѶ¼�е�ͨѶ¼���浽�ֻ���ͨѶ¼��ȥ
        CompanyBook_sMoblieBook_Test();
    }
    //��¼���Զ���ʵ��
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
    //1������ͨѶ¼���棬��ʾ��˾ͨѶ¼�Լ�����ͨѶ¼����˾ͨѶ¼����ÿһ���ŵĹ�˾Ա���ĵ绰���룬���ҿ���ͨ���ؼ��ֶԹ�˾��Ա���ĵ绰����,���ĳһ�����ſ��Բ鿴�ò��ŵ�Ա���ĵ绰����
    public void CompanyBook_quanbu_Test() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("�ۺϲ�")).click();
        driver.findElement(By.name("������")).click();

        return;
        //���Զ�ĳһ�����ŵ�ĳһ��Ա���Ľ���ͨѶ�Լ������š�

    }
    //2������ͨѶ¼���棬�Ϳ���ͨ�����������ť��Ȼ������ؼ��֣��Ӷ���ʾĳһ�����ŵ�ͨѶ¼����ĳһ��Ա����ͨѶ¼
    public void CompanyBook_Search_Test() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        //���������ť
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("��");
        //���Զ�ĳһ�����ŵ�ĳһ��Ա���Ľ���ͨѶ�Լ������š�
        return;
    }
    //3�����빫˾ͨѶ¼���棬Ȼ�󵥻������á��˵����Ϳ��Բ鿴����˾ͨѶ¼�г��õĹ�˾ͨѶ¼��Ա������Щ
    public void CompanyBook_changyong_Test() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        //���������ť
        driver.findElement(By.id("companyAddrBook_Often")).click();
        List<WebElement> fanhui=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        //���Զ�ĳһ�����ŵ�ĳһ��Ա���Ľ���ͨѶ�Լ������š�
        return;
    }
    //4�����빫˾ͨѶ¼���棬Ȼ�������ذ�ť��Ȼ���Լ�ѡ���Լ�Ҫ���浽�Լ��ֻ���Ա����ͨѶ¼��Ȼ����"���"��ť���Ϳ��Խ���˾ͨѶ¼�е�ͨѶ¼���浽�ֻ���ͨѶ¼��ȥ
    public void CompanyBook_MoblieBook_Test() throws Exception {
        driver.findElement(By.id("id_indicator_three")).click();
        //������ذ�ť
        driver.findElement(By.id("action_download")).click();
        //ѡ���ۺϲ�/������/�ֹ��١��ֺ���
        driver.findElement(By.name("�ۺϲ�")).click();
        driver.findElement(By.name("������")).click();
        driver.findElement(By.name("�ֹ���")).click();
        driver.findElement(By.name("�ֺ���")).click();
        driver.findElement(By.name("���")).click();
        return;
    }
    //5�����빫˾ͨѶ¼���棬Ȼ�������ذ�ť���ٵ�������������ť��Ȼ���Լ�ѡ���Լ�Ҫ���浽�Լ��ֻ���Ա����ͨѶ¼��Ȼ����"���"��ť���Ϳ��Խ���˾ͨѶ¼�е�ͨѶ¼���浽�ֻ���ͨѶ¼��ȥ
    public void CompanyBook_sMoblieBook_Test() throws Exception {
        driver.findElement(By.id("id_indicator_three")).click();
        //������ذ�ť
        driver.findElement(By.id("action_download")).click();
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("��");
        driver.findElement(By.name("�����")).click();
        driver.findElement(By.name("ȷ��")).click();
        return;
    }

}

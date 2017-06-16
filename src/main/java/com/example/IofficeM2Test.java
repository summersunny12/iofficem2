package com.example;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class IofficeM2Test {
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
        System.out.println("Appium���ӳɹ���");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }

    @Test
    public void ioffceM2() throws Exception{
        //����
        //setting();
        //��¼
       login();
        //��ҳ
        Thread.sleep(15000);
        shouye();

    }
    //�߼�����
    public  void setting() throws InterruptedException {

        driver.findElement(By.name("�߼�����")).click();
        driver.findElement(By.id("txtServerAddr")).sendKeys("oa.hongfan.cn:8080");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        return;
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
    //��ҳ
    public void shouye() throws Exception{
        //��ҳ�б�
        //List<WebElement> shouyexbLists =driver.findElementsByClassName("android.view.View");
        //shouyexbLists.get(2).click();
        //��Ϣ
        driver.findElement(By.id("id_indicator_one")).click();
        //shouyexbLists.get(2).click();
        Thread.sleep(1000);
        //views.get(0).click();


        //�칫
        //shouyexbLists.get(3).click();
       driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        //views.get(1).click();
        //�칫�б�
        //Thread.sleep(5000);
        //List<WebElement> bangongLists = driver.findElementsByClassName("android.widget.RelativeLayout");
        //֪ͨ����
        driver.findElement(By.name("֪ͨ����")).click();
        //bangongLists.get(0).click();
        Thread.sleep(10000);
        xiaoxintonggao();

        //���̹���
        //bangongLists.get(1).click();
        driver.findElement(By.name("���̹���")).click();
        List<WebElement> liuchengs = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //�����б�,����ͬ��
        liuchengs.get(0).click();
        //�����б�
        liuchengs.get(1).click();
        //������������б��е�����һ���鿴��������
        List<WebElement> shenqingLists =driver.findElementsByClassName("android.widget.RelativeLayout");
        shenqingLists.get(0).click();
        //������ݡ����衢����
        List<WebElement> shengqingneirong =driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        shengqingneirong.get(0).click();
        shengqingneirong.get(1).click();
        shengqingneirong.get(2).click();
        //��Ӹ���
        driver.findElement(By.id("fabAddUp")).click();
        List<WebElement> fjfanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fjfanhui.get(0).click();
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();

        //�������
       newshenqing();

        List<WebElement> sqnrfanhui1 =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui1.get(0).click();

        //ͨѶ¼
        driver.findElement(By.id("id_indicator_three")).click();
      // shouyexbLists.get(4).click();
        //views.get(2).click();
        //��
        //shouyexbLists.get(5).click();
        driver.findElement(By.id("id_indicator_four")).click();
        //views.get(3).click();

        return;
    }

    //��Ϣͨ��
    public void xiaoxintonggao() throws Exception{
        List<WebElement> xiaoxins =driver.findElementsByClassName("android.widget.LinearLayout");
        xiaoxins.get(0).click();
        Thread.sleep(8000);
        //����
        List<WebElement> fanhui1 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        //����
        List<WebElement> fanhui2 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui2.get(0).click();
        return;
    }
    //�������
    public  void  newshenqing() throws Exception{
        //������밴ť
        driver.findElement(By.id("fabAddUp")).click();
        //���������б�
        List<WebElement> newshenqings = driver.findElementsByClassName("android.widget.RelativeLayout");
        //���
        newshenqings.get(0).click();
        //��ٷ���
        qingjia();
        //��������
        newshenqings.get(1).click();
        newkaoqin();


    }
    public void qingjia() throws Exception{
        driver.findElement(By.id("com.hf.iOffice:id/btnStartDate")).click();
        driver.findElement(By.id("android:id/date_picker_year")).click();
        //scrollTo(driver.findElement(By.name("2017")));
        //����
        swipeToUp(driver,10);
        driver.findElement(By.name("2017")).click();
        driver.findElement(By.name("Ok")).click();
        List<WebElement> qjfanhui = driver.findElementsByClassName("android.widget.ImageButton");
        qjfanhui.get(0).click();

    }
    public void newkaoqin() throws Exception{
        //���뿼���쳣

        //�����жϿ����Ƿ����쳣
        String kaoqingyc=driver.findElementById("lblDefault").getText();
        //������ڰ�ť
        //�˳�
        if(kaoqingyc.equals("���쳣��¼")){
            List<WebElement> tuichu =driver.findElementsByClassName("android.widget.ImageButton");
            tuichu.get(0).click();
        }

        return;
        //���뿼����д����
    }

    public void swipeToUp(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }

}

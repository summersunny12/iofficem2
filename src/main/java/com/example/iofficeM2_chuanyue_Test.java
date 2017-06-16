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
 * Created by admin on 2017/5/12.
 */

public class iofficeM2_chuanyue_Test {
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
        System.out.println("appium登录成功！");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void zhucaidan_Test() throws Exception{
        //首先登录
        login();
        Thread.sleep(15000);
        //1、进入发送传阅->未/开始列表页面
        TestCase_SendMessage_List_Begin();
        //2、进入发送传阅->传阅中列表页面
        TestCase_SendMessage_List_Sending();
        //3、进入发送传阅->全部传阅列表页面
        TestCase_SendMessage_List_All();
        //4、收到传阅->未确认列表数据验证
        TestCase_ReceiveMessage_List_NotConfirm();
        //5、进入收到传阅->已确认列表页面

    }
    //登录
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
    //1、进入发送传阅->未/开始列表页面
    public void TestCase_SendMessage_List_Begin() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("未读")).click();
        Thread.sleep(2000);
        //返回
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

    //2、进入发送传阅->传阅中列表页面TestCase_SendMessage_List_Sending
    public void TestCase_SendMessage_List_Sending() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("传阅中")).click();
        Thread.sleep(2000);
        //返回
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

    //3、进入发送传阅->全部传阅列表页面
    public  void TestCase_SendMessage_List_All() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("全部")).click();
        Thread.sleep(2000);
        //返回
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

    //4、收到传阅->未确认列表数据验证
    public void TestCase_ReceiveMessage_List_NotConfirm() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("未确认")).click();
        Thread.sleep(2000);
        //返回
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
    }

    //5、进入收到传阅->已确认列表页面
    public void TestCase_ReceiveMessage_List_Confirm() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("已完成")).click();
        Thread.sleep(2000);
        //返回
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }


    public void chuangyue_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(5000);
        //点击添加传阅
        driver.findElement(By.name("收件箱")).click();

        List<WebElement> shoujianxiangs=  driver.findElementsByClassName("android.widget.RelativeLayout");
        //点击第一个传阅的收件箱的文件
        shoujianxiangs.get(0).click();
        Thread.sleep(5000);
        List<WebElement> fanhui0 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        //点击第二个传阅的收件箱的文件
        shoujianxiangs.get(1).click();
        Thread.sleep(5000);
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();

        return;

    }

    //保存需要保护的传阅内容
    public void  TestCase_SendMessage_baocun() throws Exception{
        driver.findElement(By.id("fabAddUp")).click();
        driver.findElement(By.id("txtMsgTitle")).sendKeys("关于妇女节的放假的安排");
        driver.findElement(By.id("txtMsgContent")).sendKeys("妇女节安排从3.8下午开始，即放一个下午的假！");
        driver.findElement(By.id("msg_emp")).click();
        //选择传阅给谁
        List<WebElement> caidans =driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        caidans.get(0).click();
        caidans.get(1).click();
        caidans.get(2).click();
        driver.findElement(By.id("btnSelectEmpBranchDep")).click();
        List<WebElement> receivers = driver.findElementsByClassName("android.widget.RelativeLayout");
        receivers.get(3).click();
        receivers.get(4).click();
        //caidans.get(3).click();
        caidans.get(4).click();
        driver.findElement(By.name("确定")).click();
        driver.findElement(By.name("保存")).click();
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

}

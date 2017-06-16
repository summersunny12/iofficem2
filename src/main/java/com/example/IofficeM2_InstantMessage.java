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

public class IofficeM2_InstantMessage {
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
        System.out.println("appium连接成功！");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void InMessaging_Test() throws Exception{
        //首先登录界面
        login();
        Thread.sleep(20000);
        // 1、进入即时消息界面,收消息列表
        Receive_Messages();
        //2、进入即时消息界面，点击“搜索”，输入关键字，查找与关键字相关的即时消息的列表以及文章，然后查看其具体的内容
        ReMessages_Search();
        //3、自己发送即时消息 ,选择收件人的方式是常用
        Fasongcy_InMessage();
        //4、自己发送即时消息 ,选择收件人的方式是自定义
        Fasongdy_InMessage();
        //5、自己发送即时消息 ,选择收件人的方式是机构
        Fasongjg_InMessage();
        //6、自己发送即时消息 ,选择收件人的方式是机构,采取搜索按钮
        Fasongjg_InMessage_Search();


    }
    //登录的自动化实现
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

    // 1、进入即时消息界面,收消息列表
    public void Receive_Messages() throws Exception{
        //进入办公
        driver.findElement(By.id("id_indicator_two")).click();
        //点击进入即时消息界面
        driver.findElement(By.name("即时消息")).click();
        //进入用户收到的即时消息列表
        //第一条消息
        List<WebElement> ReMessages=driver.findElementsByClassName("android.widget.RelativeLayout");
        ReMessages.get(1).click();
        List<WebElement> fanhui_ReMessage1=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui_ReMessage1.get(0).click();
        //第二条消息
        ReMessages.get(2).click();
        List<WebElement> fanhui_ReMessage2=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui_ReMessage2.get(0).click();
        //第三条消息
        ReMessages.get(3).click();
        List<WebElement> fanhui_ReMessage3=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui_ReMessage3.get(0).click();

        //退出即时消息界面
        List<WebElement> fanhui=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //2、进入即时消息界面，点击“搜索”，输入关键字，查找与关键字相关的即时消息的列表以及文章，然后查看其具体的内容
    public void ReMessages_Search() throws Exception{
        //进入办公
        driver.findElement(By.id("id_indicator_two")).click();
        //点击进入即时消息界面
        driver.findElement(By.name("即时消息")).click();
        //点击搜索按钮
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("f");
        List<WebElement> SInMessages=driver.findElementsByClassName("android.widget.RelativeLayout");
        //第一条即时消息
        SInMessages.get(1).click();
        Thread.sleep(3000);
        //返回
        List<WebElement> fanhui1=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        //第二条即时消息
        SInMessages.get(2).click();
        Thread.sleep(3000);
        //返回
        List<WebElement> fanhui2=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui2.get(0).click();
        //t退出即时消息界面

        List<WebElement> fanhui=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }

    //3、自己发送即时消息 ,选择收件人的方式是常用
    public void Fasongcy_InMessage() throws Exception{
        //进入办公
        driver.findElement(By.id("id_indicator_two")).click();
        //点击进入即时消息界面
        driver.findElement(By.name("即时消息")).click();
        //点击添加按钮
        driver.findElement(By.id("action_add")).click();
        //添加收件人
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //进入添加联系人的界面
        //1、在常用联系人中有用户需要的收件人
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //点击常用联件人
        receiverers.get(0).click();
        List<WebElement> cyReceiverers = driver.findElementsByClassName("android.widget.RelativeLayout");
        cyReceiverers.get(0).click();
        cyReceiverers.get(2).click();
        receiverers.get(4).click();
        driver.findElement(By.name("确定")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("你好！");
        driver.findElement(By.name("发送")).click();
        Thread.sleep(5000);
        //返回出发送的信息界面
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //退出即时消息界面
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }
    //4、自己发送即时消息 ,选择收件人的方式是自定义
    public void Fasongdy_InMessage() throws Exception{
        //进入办公
        driver.findElement(By.id("id_indicator_two")).click();
        //点击进入即时消息界面
        driver.findElement(By.name("即时消息")).click();
        //点击添加按钮
        driver.findElement(By.id("action_add")).click();
        //添加收件人
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //进入添加联系人的界面
        //1、在常用联系人中有用户需要的收件人
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //点击自定义收件人
        receiverers.get(1).click();
        List<WebElement> cyReceiverers = driver.findElementsByClassName("android.widget.RelativeLayout");
        cyReceiverers.get(0).click();
        cyReceiverers.get(2).click();
        receiverers.get(4).click();
        driver.findElement(By.name("确定")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("你好！");
        driver.findElement(By.name("发送")).click();
        Thread.sleep(5000);
        //返回出发送的信息界面
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //退出即时消息界面
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }

    //5、自己发送即时消息 ,选择收件人的方式是机构
    public void Fasongjg_InMessage() throws Exception{
        //进入办公
        driver.findElement(By.id("id_indicator_two")).click();
        //点击进入即时消息界面
        driver.findElement(By.name("即时消息")).click();
        //点击添加按钮
        driver.findElement(By.id("action_add")).click();
        //添加收件人
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //进入添加联系人的界面
        //1、在常用联系人中有用户需要的收件人
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //点击常用联件人
        receiverers.get(2).click();
        driver.findElement(By.name("红帆科技")).click();
        driver.findElement(By.name("互联网产品部")).click();
        driver.findElement(By.name("移动客户端组")).click();
        driver.findElement(By.name("张英金")).click();
        receiverers.get(4).click();

        driver.findElement(By.name("确定")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("你好！");
        driver.findElement(By.name("发送")).click();
        Thread.sleep(5000);
        //返回出发送的信息界面
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //退出即时消息界面
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }
    //6、自己发送即时消息 ,选择收件人的方式是机构,采取搜索按钮
    public void Fasongjg_InMessage_Search() throws Exception{
        //进入办公
        driver.findElement(By.id("id_indicator_two")).click();
        //点击进入即时消息界面
        driver.findElement(By.name("即时消息")).click();
        //点击添加按钮
        driver.findElement(By.id("action_add")).click();
        //添加收件人
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //进入添加联系人的界面
        //1、在常用联系人中有用户需要的收件人
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //点击常用联件人
        receiverers.get(2).click();
        //点击搜索按钮
        driver.findElement(By.id("search_button")).click();
        //在搜索框填写关键字
        driver.findElement(By.id("search_src_text")).sendKeys("移动客户端组");
        driver.findElement(By.id("btnSelectEmpBranchDep")).click();
        driver.findElement(By.name("张英金")).click();

        receiverers.get(4).click();


        driver.findElement(By.name("确定")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("你好！");
        driver.findElement(By.name("发送")).click();
        Thread.sleep(5000);
        //返回出发送的信息界面
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //退出即时消息界面
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }


}

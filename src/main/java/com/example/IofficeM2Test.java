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
        System.out.println("Appium连接成功！");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }

    @Test
    public void ioffceM2() throws Exception{
        //设置
        //setting();
        //登录
       login();
        //首页
        Thread.sleep(15000);
        shouye();

    }
    //高级设置
    public  void setting() throws InterruptedException {

        driver.findElement(By.name("高级设置")).click();
        driver.findElement(By.id("txtServerAddr")).sendKeys("oa.hongfan.cn:8080");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        return;
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
    //首页
    public void shouye() throws Exception{
        //首页列表
        //List<WebElement> shouyexbLists =driver.findElementsByClassName("android.view.View");
        //shouyexbLists.get(2).click();
        //消息
        driver.findElement(By.id("id_indicator_one")).click();
        //shouyexbLists.get(2).click();
        Thread.sleep(1000);
        //views.get(0).click();


        //办公
        //shouyexbLists.get(3).click();
       driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        //views.get(1).click();
        //办公列表
        //Thread.sleep(5000);
        //List<WebElement> bangongLists = driver.findElementsByClassName("android.widget.RelativeLayout");
        //通知公告
        driver.findElement(By.name("通知公告")).click();
        //bangongLists.get(0).click();
        Thread.sleep(10000);
        xiaoxintonggao();

        //流程管理
        //bangongLists.get(1).click();
        driver.findElement(By.name("流程管理")).click();
        List<WebElement> liuchengs = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //审批列表,有数同下
        liuchengs.get(0).click();
        //申请列表
        liuchengs.get(1).click();
        //点击进入申请列表中的其中一个查看具体内容
        List<WebElement> shenqingLists =driver.findElementsByClassName("android.widget.RelativeLayout");
        shenqingLists.get(0).click();
        //点击内容、步骤、附件
        List<WebElement> shengqingneirong =driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        shengqingneirong.get(0).click();
        shengqingneirong.get(1).click();
        shengqingneirong.get(2).click();
        //添加附件
        driver.findElement(By.id("fabAddUp")).click();
        List<WebElement> fjfanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fjfanhui.get(0).click();
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();

        //添加申请
       newshenqing();

        List<WebElement> sqnrfanhui1 =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui1.get(0).click();

        //通讯录
        driver.findElement(By.id("id_indicator_three")).click();
      // shouyexbLists.get(4).click();
        //views.get(2).click();
        //我
        //shouyexbLists.get(5).click();
        driver.findElement(By.id("id_indicator_four")).click();
        //views.get(3).click();

        return;
    }

    //消息通告
    public void xiaoxintonggao() throws Exception{
        List<WebElement> xiaoxins =driver.findElementsByClassName("android.widget.LinearLayout");
        xiaoxins.get(0).click();
        Thread.sleep(8000);
        //返回
        List<WebElement> fanhui1 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        //返回
        List<WebElement> fanhui2 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui2.get(0).click();
        return;
    }
    //添加申请
    public  void  newshenqing() throws Exception{
        //点击申请按钮
        driver.findElement(By.id("fabAddUp")).click();
        //进入申请列表
        List<WebElement> newshenqings = driver.findElementsByClassName("android.widget.RelativeLayout");
        //请假
        newshenqings.get(0).click();
        //请假方法
        qingjia();
        //考勤申请
        newshenqings.get(1).click();
        newkaoqin();


    }
    public void qingjia() throws Exception{
        driver.findElement(By.id("com.hf.iOffice:id/btnStartDate")).click();
        driver.findElement(By.id("android:id/date_picker_year")).click();
        //scrollTo(driver.findElement(By.name("2017")));
        //滑动
        swipeToUp(driver,10);
        driver.findElement(By.name("2017")).click();
        driver.findElement(By.name("Ok")).click();
        List<WebElement> qjfanhui = driver.findElementsByClassName("android.widget.ImageButton");
        qjfanhui.get(0).click();

    }
    public void newkaoqin() throws Exception{
        //申请考勤异常

        //首先判断考勤是否有异常
        String kaoqingyc=driver.findElementById("lblDefault").getText();
        //点击考勤按钮
        //退出
        if(kaoqingyc.equals("无异常记录")){
            List<WebElement> tuichu =driver.findElementsByClassName("android.widget.ImageButton");
            tuichu.get(0).click();
        }

        return;
        //进入考勤填写界面
    }

    public void swipeToUp(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }

}

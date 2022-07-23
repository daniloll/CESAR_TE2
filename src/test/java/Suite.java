import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

    public class Suite {

        private AndroidDriver driver;

        MobileElement teclaZero;
        MobileElement teclaUm;
        MobileElement teclaDois;
        MobileElement teclaTres;
        MobileElement teclaQuatro;
        MobileElement teclaCinco;
        MobileElement teclaSeis;
        MobileElement teclaSete;
        MobileElement teclaOito;
        MobileElement teclaNove;
        MobileElement teclaMultipliacacao;
        MobileElement teclaAdicao;
        MobileElement teclaSubtracao;
        MobileElement teclaDivisao;
        MobileElement teclaIgual;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "MyCell");
            desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
            desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);

            // TECLAS NUMERICAS
            teclaZero = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_0");
            teclaUm = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
            teclaDois = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
            teclaTres = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
            teclaQuatro = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
            teclaCinco = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_5");
            teclaSeis = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_6");
            teclaSete = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_7");
            teclaOito = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
            teclaNove = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");

            // OPERADORES
            teclaMultipliacacao = (MobileElement) driver.findElementByAccessibilityId("multiply");
            teclaAdicao = (MobileElement) driver.findElementByAccessibilityId("plus");
            teclaSubtracao = (MobileElement) driver.findElementByAccessibilityId("minus");
            teclaDivisao = (MobileElement) driver.findElementByAccessibilityId("divide");
            teclaIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        }

        @Test
        public void multiplicacaoDeDoisNumeroInteirosTest() {
            teclaSete.click();
            teclaMultipliacacao.click();
            teclaSete.click();
            teclaIgual.click();
            MobileElement telaDaCalculadora = (MobileElement) driver.findElementById("result_final");

            Assert.assertEquals(Integer.parseInt(teclaSete.getText()) * Integer.parseInt(teclaSete.getText()),
                                        Integer.parseInt(telaDaCalculadora.getText()));
        }

        @Test
        public void adicaoDeDoisNumeroInteirosTest() {
            teclaUm.click();
            teclaAdicao.click();
            teclaSete.click();
            teclaIgual.click();
            MobileElement telaDaCalculadora = (MobileElement) driver.findElementById("result_final");

            Assert.assertEquals(Integer.parseInt(teclaUm.getText()) + Integer.parseInt(teclaSete.getText()),
                    Integer.parseInt(telaDaCalculadora.getText()));
        }

        @Test
        public void subtracaoDeDoisNumeroInteirosTest() {
            teclaNove.click();
            teclaSubtracao.click();
            teclaCinco.click();
            teclaIgual.click();
            MobileElement telaDaCalculadora = (MobileElement) driver.findElementById("result_final");

            Assert.assertEquals(Integer.parseInt(teclaNove.getText()) - Integer.parseInt(teclaCinco.getText()),
                    Integer.parseInt(telaDaCalculadora.getText()));
        }

        @Test
        public void divisaoDeDoisNumeroInteirosTest() {
            teclaDois.click();
            teclaZero.click();
            teclaDivisao.click();
            teclaQuatro.click();
            teclaIgual.click();
            MobileElement telaDaCalculadora = (MobileElement) driver.findElementById("result_final");

            Assert.assertEquals(Integer.parseInt(teclaDois.getText() + teclaZero.getText()) / Integer.parseInt(teclaQuatro.getText()),
                    Integer.parseInt(telaDaCalculadora.getText()));
        }

        @After
        public void tearDown() {
            driver.quit();
        }
}


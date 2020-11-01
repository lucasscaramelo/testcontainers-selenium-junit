import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class CT01 {

    public RemoteWebDriver driver;

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_ALL, new File("./target/"));
    @Before
    public void setUp() {
        driver = chrome.getWebDriver();
    }

    @Test
    public void acessaPagina() {
        driver.manage().window().maximize();
        driver.get("https://www.google.com.br/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

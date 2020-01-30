package com.frameworkium.bdd;

import com.frameworkium.core.ui.UITestLifecycle;
import gherkin.events.PickleEvent;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features/"},
        plugin = {
                "pretty", // pretty console logging
                "json:cucumber-results.json" // json results file
        },
        monochrome = true,
        tags = {"not @ignore"},
        // NB: change these to match your glue packages.
        glue = {"com.cttest.stepDefs"})

public class TestRunner implements ITest {
    private static final Logger logger = LogManager.getLogger();

    private TestNGCucumberRunner testNGCucumberRunner;
    private ThreadLocal<String> scenarioName = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        UITestLifecycle.get().beforeSuite();
    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    public void setTestName(Method method, Object[] testData) {
        PickleEvent pickleEvent = ((PickleEventWrapper) testData[0]).getPickleEvent();
        String scenarioName = pickleEvent.pickle.getName();
        this.scenarioName.set(scenarioName);
        logger.info("START {}", scenarioName);
        UITestLifecycle.get().beforeTestMethod(scenarioName);
    }

    @Test(dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cfw) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        UITestLifecycle.get().afterTestMethod();
        logResult(result);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        try {
            testNGCucumberRunner.finish();
        } catch (Exception e) {

        } finally {
            UITestLifecycle.get().afterTestSuite();
        }
    }

    private void logResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                logger.error("FAIL  {}", scenarioName.get());
                break;
            case ITestResult.SKIP:
                logger.warn("SKIP  {}", scenarioName.get());
                break;
            case ITestResult.SUCCESS:
                logger.info("PASS  {}", scenarioName.get());
                break;
            default:
                logger.warn("Unexpected result status: {}", result.getStatus());
        }
    }

    @Override
    public String getTestName() {
        return "test";
    }
}

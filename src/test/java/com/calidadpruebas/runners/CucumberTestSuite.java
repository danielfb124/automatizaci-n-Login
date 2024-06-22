package com.calidadpruebas.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/java/com/calidadpruebas/features",
    glue = "com.calidadpruebas.steps",
    plugin = {"pretty"},
    tags = "@edge"
)
public class CucumberTestSuite {
}

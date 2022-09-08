package br.com.liandro.sempreit.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/evidencias/teste.json", "html:target/evidencias/evidence-html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        features = {"src/test/resources/features"},
        glue = {"br/com/liandro/sempreit/web/steps"},
        tags = {"@Regressivo"}
)
public class RunnerTest {

}

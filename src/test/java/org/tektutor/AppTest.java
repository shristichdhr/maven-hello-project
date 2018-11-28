package org.tektutor;

import static org.junit.Assert.*;
import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class AppTest {
	private App app;
	private String actualResponse;
@Given("The Hello class works fine")
public void the_Hello_class_works_fine() {
	app = new App();
}

@When("I invoke sayHello method")
public void i_invoke_sayHello_method() {
	actualResponse = app.sayHello();
}

@Then("I expect {string}")
public void i_expect(String expectedResponse) {
	assertEquals ( expectedResponse, actualResponse );
}
}

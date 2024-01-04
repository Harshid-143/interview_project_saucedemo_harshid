package com.saucedemo;

import com.saucedemo.propertyreader.PropertyReader;
import com.saucedemo.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Utility {

    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

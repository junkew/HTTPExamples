package properties.examples.example1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
//import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
//import static org.junit.matchers.JUnitMatchers.*;
//import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.List;
import java.util.Properties;


import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ConfigurationConverter;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * A very basic example to show the power of the apache configurations library
 * Run with -Dsettings.properties=<your file name without quotes>
 * example  -Dsettings.properties=test1.properties
 * Examples on 
 * user.file  = ${sys:user.home}/settings.xml
 * action.key = ${const:java.awt.event.KeyEvent.VK_CANCEL}
 * java.home  = ${env:JAVA_HOME}
 * test=aap
 * test=noot
 * propertyx=test(2)
 * To convert to a standard properties file use: ConfigurationConverter.getProperties(config);
 */			
public class App 
{
  //  public static void main( String[] args ) throws ConfigurationException
    @Test
    public void test1() throws ConfigurationException
    {
    	//Check if settings.properties is given
    	String configfile=System.getProperty("settings.properties");
    	if (configfile==null) {
    		fail();
    	}
		
    	FileBasedConfigurationBuilder<PropertiesConfiguration> builder =
    		    new FileBasedConfigurationBuilder<PropertiesConfiguration>(PropertiesConfiguration.class)
    		    .configure(new Parameters().properties()
    		        .setFileName(configfile)
    		        .setThrowExceptionOnMissing(true)
    		        .setListDelimiterHandler(new DefaultListDelimiterHandler(';'))
    		        .setIncludesAllowed(true));

    	PropertiesConfiguration config = builder.getConfiguration();
    	
    //	try
   // 	{
    		System.out.println( "Hello World!" );
    		System.out.println("Loading from given property file: " + System.getProperties().get("settings.properties") );
//  		Configuration config = configs.properties(new File("src\\resources\\test1.properties"));
    	//	File f = new File(System.getProperties().getProperty("settings.properties"));
    	//	Configuration config = configs.properties(f);
    	
    		// access configuration properties
    	//	System.out.println("Path information within java: " + f.getAbsolutePath() + ";" + f.getPath());

    	    System.out.println("Step 1: A filename containing property with 2nd file: " + config.getProperty("prop1.example").toString());
    	    System.out.println("Step 2: config **NOT** converted to properties actualValue getProperty   : " + config.getProperty("testfile2.property2"));
    	    System.out.println("Step 3: Propagated value getString: " + config.getString("testfile2.property2"));
    	    System.out.println("Step 4: Show a list of values     : " );
    	    
    	    List<String> choiceLists = config.getList(String.class, "choicelists");
    	    
    	    for (String choiceList : choiceLists) {
    	    	System.out.println("   " + choiceList.toString());       	    
    	    }
    	        	
    //  	}
    //	catch (ConfigurationException cex)
   // 	{
    	    // Something went wrong
   // 	}
    	 
    	   Properties props=ConfigurationConverter.getProperties(config);
    	   
//    	   System.out.println(props.getProperty("testfile2.property2"));
    	   System.out.println("See the difference with step2 where value is not replaced in config object");
      	   System.out.println("Step 5: config **IS ** converted to properties actualValue getProperty   : " + props.getProperty("testfile2.property2"));
      	   System.out.println("Step 6: Choicelists is now converted to a comma separated string  : " + props.getProperty("choicelists"));

      	   
      	 System.out.println("Test eds.url.types                              : " + props.getProperty("eds.url.types"));
      	 System.out.println("Test eds.url.types.expectedresult               : " + props.getProperty("eds.url.types.expectedresult"));
      	 System.out.println("Test eds.url.types.clientnumberSymbolicField    : " + props.getProperty("eds.url.types.clientnumberSymbolicField s"));
      	 System.out.println("Test eds.url.types.clientnumber                 : " + props.getProperty("eds.url.types.clientnumber"));
      	 System.out.println("Test eds.url.type                               : " + props.getProperty("eds.url.type"));
      	 System.out.println("Test eds.url.type.payload                       : " + props.getProperty("eds.url.type.payload"));
      	 System.out.println("Test cbt.gemini.choicelist.CBT_Locations.values : " + props.getProperty("cbt.gemini.choicelist.CBT_Locations.values"));
     	 

      	
      	   
    }
}

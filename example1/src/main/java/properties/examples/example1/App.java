package properties.examples.example1;

import java.io.File;
import java.util.List;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ConfigurationException
    {
    	Configurations configs = new Configurations();
    //	try
   // 	{
    		System.out.println( "Hello World!" );
    		System.out.println( System.getProperties().get("settings.properties") );
//  		Configuration config = configs.properties(new File("src\\resources\\test1.properties"));
    		File f = new File(System.getProperties().getProperty("settings.properties"));
    		Configuration config = configs.properties(f);
    	    // access configuration properties
    		System.out.println(f.getAbsolutePath() + f.getPath());

    	    System.out.println(config.getProperty("prop1.example").toString());
    	    System.out.println(config.getProperty("testfile2.property2"));
    	    System.out.println(config.getString("testfile2.property2"));
    	    List<String> choiceLists = config.getList(String.class, "choicelists");
    	    
    	    for (String choiceList : choiceLists) {
    	    	System.out.println(choiceList.toString());       	    
    	    }
    	    
    	
    //  	}
    //	catch (ConfigurationException cex)
   // 	{
    	    // Something went wrong
   // 	}
    }
}

/*
 * This code will print the compile time and date of a jar file from values
 * stored in the manifest file. It works if you execute from a jar file,
 * e.g. for example:
 * 
 * java -jar /path/to/jar/myjar.jar
 * 
 * It may not work if you try to run this from within an IDE
 * such as NetBeans, because classpaths that do not begin with
 * 'jar:' are skipped.
 * 
 * Other methods such as 
 * 
 * this.getClass().getResourceAsStream("/META-INF/MANIFEST.MF");
 * 
 * could be used, but they will process the first file found in the 
 * classpath that matches, and that will probably be the wrong 
 * MANIFEST.MF file.
 * 
 * This code is taken from a posting in stackoverflow.com:
 * 
 * http://stackoverflow.com/questions/1272648/reading-my-own-jars-manifest
 * 
 * 
 */
package biz.greenbeltcomputer.training.bobapp2;

import java.io.IOException;
//import java.io.InputStream;
import java.util.jar.*;
import java.net.*;

/**
 *
 * @author Bob Cochran
 * 
 */
public class packageVersion {
    
    void printVersion()
    {
       
        try
        {
        
            Class clazz = packageVersion.class;
            
            String className = clazz.getSimpleName() + ".class";
            
            String classPath = clazz.getResource(className).toString();

            if (!classPath.startsWith("jar")) {
                 // Class not from JAR; just return
            return;
            }
            
            String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + 
                "/META-INF/MANIFEST.MF";
            
            Manifest manifest = new Manifest(new URL(manifestPath).openStream());


//            InputStream is = this.getClass().getResourceAsStream("/META-INF/MANIFEST.MF");
           
//            Manifest mf = new Manifest(is);
            
            Attributes atts = manifest.getMainAttributes();
            
            String bname = atts.getValue("Bundle-Name");
            
            String bvers = atts.getValue("Bundle-Version");

            String bdt = atts.getValue("Bundle-Date");
            
            String tjv = atts.getValue("Created-By");
            
            String devnm = atts.getValue("Developer-Name");
            
            String devem = atts.getValue("Developer-Email");
            
            System.out.println("\n" + bname + " version " + bvers + " build date " + bdt);
            
            System.out.println("Developer name: " + devnm +", Developer email: " + devem);
            
            System.out.println("Tested against Java version " + tjv);
                        
        }
        
       
        catch (IOException e)
        {
            System.err.println("Could not read the manifest file");
        }
     
    }
}
    
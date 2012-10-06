/*
 * This application will try to print the compile time to standard output
 * using values embedded in the manifest file META-INF/MANIFEST.MF.
 * 
 */
package biz.greenbeltcomputer.training.bobapp2;

/**
 *
 * @author Bob Cochran
 * 
 */
public class Bobapp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PackageVersion version = new PackageVersion();
        version.printVersion();
        System.exit(0);
    }
}

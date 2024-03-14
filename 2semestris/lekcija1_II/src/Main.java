import  java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String dirname = System.getProperty("user.name");
        String fname = dirname + "/numbers.txt";
        File f = new File(fname);
        System.out.println(dirname);
    }
}

//String dirName =
//    System.getProperty("user.home");

// Ko var uzzināt: user.dir user.name user.home java.home os.name os.version java.runtime.version
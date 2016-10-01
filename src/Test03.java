
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test03 {

    public static void main(String[] args) {

        Path p6 = Paths.get("uno\\dos\\tres");        
        Path p7 = Paths.get("cuatro/cinco/seis");
        System.out.println("p7: " + p7);
        Path p8 = p6.relativize(p7);
        System.out.println("p8: " + p8.resolve("hola"));

        Path p1 = Paths.get("d:/temp/foo/bar");
        Path p2 = p1.subpath(0, 1);
        System.out.println("getNameCount: " + p1.getNameCount());
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        Path p3 = p1.resolve("hola");
        p3 = p1.resolve(p2);
        Path p4 = Paths.get("bar").resolve("/home/clarence").resolve("palomo").resolve(".\\uno\\dos");
        Path p5 = p4.toAbsolutePath();
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);
        System.out.println("p5: " + p5.normalize());

    }
}

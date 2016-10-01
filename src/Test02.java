
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test02 {

    public static void main(String[] args) throws IOException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM", Locale.UK);
        System.out.println(sdf.format(new Date()));
        
        
        Path file = new File("./resources/tmp/temp02.txt").toPath();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("path: " + file);
        System.out.println("getRoot: " + file.getRoot());
        System.out.println("getParent: " + file.getParent());
        System.out.println("toAbsolutePath: " + file.toAbsolutePath());
        System.out.println("isAbsolute: " + file.isAbsolute());
        System.out.println("getNameCount: " + file.getNameCount());
        for (int i = 0; i < file.getNameCount(); i++) {
            System.out.println("getName(" + i + ")" + file.getName(i));
        }

        Path fileRelativize = file.toAbsolutePath();
        file = fileRelativize;

        if (!Files.exists(file.getParent())) {
            Files.createDirectory(file.getParent());
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("path: " + file);
        System.out.println("getRoot: " + file.getRoot());
        System.out.println("getParent: " + file.getParent());
        System.out.println("toAbsolutePath: " + file.toAbsolutePath());
        System.out.println("isAbsolute: " + file.isAbsolute());
        System.out.println("getNameCount: " + file.getNameCount());
        for (int i = 0; i < file.getNameCount(); i++) {
            System.out.println("getName(" + i + ")" + file.getName(i));
        }
    }
}

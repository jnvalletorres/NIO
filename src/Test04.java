
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test04 extends SimpleFileVisitor<Path> {

    private final PathMatcher matcher;

    Test04() {
        this.matcher = FileSystems.getDefault().getPathMatcher("glob:*dat");
    }

    private void find(Path file) {
        Path name = file.getFileName();
        if (name != null && this.matcher.matches(name)) {
            System.out.println("name: " + file.toAbsolutePath().normalize());
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes atr) {
        find(file);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        Test04 t = new Test04();
        try {
            Files.walkFileTree(Paths.get("./resources/"), t);
        } catch (IOException ex) {
            Logger.getLogger(Test04.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class Test01 {

    public static void main(String[] args) {
        try {
            Path file = Paths.get("C:\\Users\\vallje02\\Documents\\NetBeansProjects\\NIO_TEST\\resources\\temp.txt");
            //Path file = Paths.get("..\\resources");
            createFile(file.toAbsolutePath().normalize());
            showFileStores();
            showPathComponents(file);
            showOperate(file);
        } catch (IOException ex) {
            Logger.getLogger(Test01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createFile(Path file) throws IOException {
        System.out.println("createFile:");
        if (!Files.exists(file.getParent())) {
            Files.createDirectory(file.getParent());
        }
        if (!Files.isDirectory(file)) {
            Files.deleteIfExists(file);
            try (OutputStream fos = new FileOutputStream(file.toFile(), true); OutputStreamWriter osw = new OutputStreamWriter(fos); BufferedWriter bw = new BufferedWriter(osw)) {
                for (int i = 0; i < 100;) {
                    bw.write(String.format("%.8f", Float.parseFloat(String.format("%d", i)) * 0.1414F));
                    bw.newLine();
                    i++;
                }
            }
            System.out.println("createFile succes full!, " + file);
        } else {
            System.out.println("createFile not create!");
        }
    }

    private static void showFileStores() throws IOException {
        Iterable<FileStore> i = FileSystems.getDefault().getFileStores();
        System.out.println("showFileStores: ");
        for (FileStore fs : i) {
            System.out.println("store: " + String.valueOf(fs));
            System.out.println("getTotalSpace: " + String.valueOf(fs.getTotalSpace()));
            System.out.println("getUnallocatedSpace: " + String.valueOf(fs.getUnallocatedSpace()));
            System.out.println("getUsableSpace: " + String.valueOf(fs.getUsableSpace()));
            System.out.println("getUsableSpace: " + fs.type());
        }
    }

    private static void showPathComponents(Path path) {
        System.out.println("showPathComponents of: " + path);
        if (!Files.isDirectory(path)) {
            System.out.println("getFileName: " + path.getFileName());
        }
        System.out.println("getParent: " + path.getParent());
        System.out.println("getRoot: " + path.getRoot());
        System.out.println("isAbsolute: " + path.isAbsolute());
        System.out.println("toAbsolutePath: " + path.toAbsolutePath());
        System.out.println("normalize: " + path.toAbsolutePath().normalize());
        System.out.println("getNameCount: " + path.getNameCount());
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("getName(" + String.valueOf(i) + "): " + path.getName(i));
        }
    }

    private static void showOperate(Path path) {
        System.out.println("normalize: " + path.normalize());
    }
}

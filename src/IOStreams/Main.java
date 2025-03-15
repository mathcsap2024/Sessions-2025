package IOStreams;

import University.Point;

import javax.print.attribute.standard.PrinterName;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        ps.print(10);
        ps.println(" The numer");
        byte[] result = byteArrayOutputStream.toByteArray();

        File file=new File("src/input.txt");
//        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);

//        FileInputStream fileInputStream = new FileInputStream("a.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

//        PrintStream printStream = new PrintStream(bufferedOutputStream);
//        printStream.println("This is a line in the file.");
//        printStream.println("second.");
//
//        RandomAccessFile randomAccessFile = new RandomAccessFile("data.dat","rw");
//        randomAccessFile.seek(10000);
//        randomAccessFile.getFilePointer();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        Point point = new Point(12,14);
        objectOutputStream.writeObject(point);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object input = objectInputStream.readObject();
        System.out.println(input.toString());
        System.out.println(input.getClass());
        fileInputStream.close();

        objectInputStream.readUnshared();
        objectOutputStream.writeUnshared(10);
    }
}

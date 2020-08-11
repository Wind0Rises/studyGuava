package com.liu.study.guava.file;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/9 14:56
 */
public class FilesTest {

    private static final String FROM_PATH = "D:\\myself\\idea_workspace\\studyGuava\\guava-basis\\src\\main\\resources\\files\\from.txt";

    private static final String TO_PATH = "D:\\myself\\idea_workspace\\studyGuava\\guava-basis\\src\\main\\resources\\files\\to.txt";

    public static void main(String[] args) throws Exception {
        /**
         * copy
         */
        // firstTestMethod();
        // secondTestMethodForNio();

        /**
         * hash
         */
        // hashCodeTestMethod();

        /**
         *
         */
        // overrideFile();

        fileAppend();
    }

    /**
     *
     * @throws InterruptedException
     */
    public static void firstTestMethod() throws IOException {
        Files.copy(new File(FROM_PATH), new File(TO_PATH));
    }

    public static void secondTestMethodForNio() throws Exception {
        java.nio.file.Files.copy(
                Paths.get(FROM_PATH),
                Paths.get(TO_PATH),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    public static void hashCodeTestMethod() throws IOException {
        File file = new File(FROM_PATH);
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hash.toString());

        File file1 = new File(TO_PATH);
        HashCode hash1 = Files.asByteSource(file1).hash(Hashing.sha256());
        System.out.println(hash1.toString());
    }

    public static void overrideFile() throws Exception {
        File file = new File(TO_PATH);
        String content1 = "content-1";
        Files.asCharSink(file, Charsets.UTF_8).write(content1);
        System.out.println(Files.readLines(file, Charsets.UTF_8));

        System.out.println("===============================");
        String content2 = "content-2";
        Files.asCharSink(file, Charsets.UTF_8).write(content2);
        System.out.println(Files.readLines(file, Charsets.UTF_8));
    }

    /**
     *
     *
     * @throws Exception
     */
    public static void fileAppend() throws Exception {
        File file = new File(TO_PATH);
        System.out.println(Files.readLines(file, Charsets.UTF_8));
        Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write("liu wei an");
        System.out.println(Files.readLines(file, Charsets.UTF_8));

    }
}
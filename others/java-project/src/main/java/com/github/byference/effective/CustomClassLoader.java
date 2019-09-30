package com.github.byference.effective;

import java.io.*;

/**
 * CustomClassLoader
 *
 * @author byference
 * @since 2019-09-30
 */
public class CustomClassLoader extends ClassLoader {

    private String classLoaderName;

    private String path = "E:/classLoader/";

    private String fileExtension = ".class";

    public CustomClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public CustomClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = this.loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }


    private byte[] loadClassData(String name) {

        byte[] data = null;
        String classPath = path + name + fileExtension;

        try (FileInputStream inputStream = new FileInputStream(new File(classPath));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
            data = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * -XX:+TraceClassLoading
     */
    public static void main(String[] args) throws Exception {

        CustomClassLoader classLoader = new CustomClassLoader("customClassLoader");
        Class<?> classLoaderTest = classLoader.loadClass("ClassLoaderTest");
        Object object = classLoaderTest.newInstance();
    }
}

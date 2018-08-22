package com.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name="countjavafile", defaultPhase = LifecyclePhase.PACKAGE)
public class CountJavaFile extends AbstractMojo {

    private long count = 0;

    @Parameter(property = "endClass")
    private String endClass;

    public void execute() throws MojoExecutionException, MojoFailureException {
        String filePath = System.getProperty("user.dir");
        if(endClass == null || "".equals(endClass)) {
            System.out.println("A total of 0 " + endClass + " files");
        } else {
            CountJavaFile temp = new CountJavaFile();
            count = temp.countFile(filePath, endClass);
            if(endClass.indexOf(".") >= 0 ) {
                endClass = endClass.replace(".", "");
            }
            System.out.println("A total of " + count + " " + endClass + " files");
        }
    }

    public  long countFile(String filePath, String endClass) {
        File file = new File(filePath);
        if(file.exists()) {
            File[] fileArray = file.listFiles();
            if(fileArray == null || fileArray.length == 0) {
                return count;
            } else {
                for(File file2 : fileArray) {
                    if(file2.isDirectory()) {
                        countFile(file2.getPath(), endClass);
                    } else {
                        if(file2.getName().endsWith(endClass)) {
                            count += 1;
                        }
                    }
                }
            }
        } else {
            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir");
        String endClass = ".java";
        if(endClass == null || "".equals(endClass)) {
            System.out.println("A total of 0 " + endClass + " files");
        } else {
            CountJavaFile temp = new CountJavaFile();
            long count = temp.countFile(filePath, endClass);
            if(endClass.indexOf(".") >= 0 ) {
                endClass = endClass.replace(".", "");
            }
            System.out.println("A total of " + count + " " +  endClass + " files");
        }
    }
}

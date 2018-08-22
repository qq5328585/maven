package com.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Mojo(name="plugins", defaultPhase = LifecyclePhase.PACKAGE)
public class pluginTest extends AbstractMojo {

    @Parameter
    private String msg;

    @Parameter
    private List<String> list;

    @Parameter
    private Map<String, Object> map;

    @Parameter(property = "ttt")
    private String text;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("This is plugin!" + msg);
        System.out.println("This is plugin!" + list);
        System.out.println("This is plugin!" + map);
        System.out.println("This is plugin!" + text);
    }
}

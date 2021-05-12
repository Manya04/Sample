/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.config;

import java.nio.file.FileSystems;
import javax.servlet.ServletContext;

/**
 *
 * @author manyaagarwal
 */
public class ServerConfig {
    public static final String RES_PATH = FileSystems.getDefault().getPath(".").toAbsolutePath().toString();
     public static final String PROJECT_NAME = "SAMPLE";
}

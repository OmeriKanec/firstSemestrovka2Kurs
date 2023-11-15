package com.semestr.firstsemestrovka2kurs;

import freemarker.template.Configuration;

import javax.servlet.ServletContext;
import java.io.IOException;

public class FreemarkerConfigSingleton {
    private static Configuration cfg;
    private static ServletContext sc;
    public static void setServletContext(ServletContext servletContext) {
        sc = servletContext;
    }
    public static Configuration getCfg() throws IOException {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setServletContextForTemplateLoading(
                    sc, "/WEB-INF/templates");
        }
        return cfg;
    }
}
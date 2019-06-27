package com.xmqiu.uigeneratesample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class Utils {
    static String REPLACE_PATTERN = "\\\\s*|\\t|\\r|\\n| ";

    public static String formatJsonStr(String jsonContent) {
        Pattern pattern = Pattern.compile(REPLACE_PATTERN);
        Matcher m = pattern.matcher(jsonContent);
        return m.replaceAll("");
    }

    public static final String PATH_PROJECT = "D:\\workspace\\generate\\GenerateDemo\\WanAndroid\\UIGenerateSample\\";
    private static final String TEMPLATE_PATH = "outputs/layout/";
    //    private static final String CLASS_PATH = "src/main/java/com/xmqiu/hello";
    private static final String CLASS_PATH = "outputs";

    public static void generate(String outputFilePathAbs, String type, Object dataMap) {
        generate(new File(PATH_PROJECT + CLASS_PATH, outputFilePathAbs), type, dataMap);
    }

    public static void generate(File outputFile, String type, Object dataMap) {
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public static void generate(OutputStream outputStream, String type, Object dataMap) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
//            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            configuration.setDirectoryForTemplateLoading(new File(PATH_PROJECT + TEMPLATE_PATH));
            // step3 创建数据模型
            // step4 加载模版文件
//            Template template = configuration.getTemplate( type + ".ftl");
            Template template = configuration.getTemplate("Build.ftl");
            // step5 生成数据
            // step6 输出文件
            template.process(dataMap, new OutputStreamWriter(outputStream));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static void generate(Writer outWirter, String type, Object dataMap) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
//            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            configuration.setDirectoryForTemplateLoading(new File(PATH_PROJECT + TEMPLATE_PATH));
            // step3 创建数据模型
            // step4 加载模版文件
//            Template template = configuration.getTemplate( type + ".ftl");
            Template template = configuration.getTemplate("Build.ftl");
            // step5 生成数据
            // step6 输出文件
            template.process(dataMap, outWirter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
//    public static void generate(File  outputFile, String type, Object dataMap) {
//        // step1 创建freeMarker配置实例
//        Configuration configuration = new Configuration();
//        Writer out = null;
//        try {
//            // step2 获取模版路径
////            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
//            configuration.setDirectoryForTemplateLoading(new File(PATH_PROJECT+TEMPLATE_PATH));
//            // step3 创建数据模型
//            // step4 加载模版文件
////            Template template = configuration.getTemplate( type + ".ftl");
//            Template template = configuration.getTemplate( "Build.ftl");
//            // step5 生成数据
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
//            // step6 输出文件
//            template.process(dataMap, out);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (null != out) {
//                    out.flush();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//    }
}
package org.spring.springboot.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties属性
 * @author jingruijie
 *
 */
public class ReadPropertiesUtil {
	public static Properties getProperties(String propertiesPath){
        Properties properties = new Properties();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiesPath));
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

package cn.agree.io;

import java.io.InputStream;

public class Resources {
    /*
    *  读取类路径下的文件,获取文件字节输入流
    *
    * */
    public static InputStream getResourceAsStream(String path) {
        InputStream is = Resources.class.getClassLoader().getResourceAsStream(path);
        return is;
    }

}

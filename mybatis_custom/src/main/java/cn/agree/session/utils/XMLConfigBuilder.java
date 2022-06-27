package cn.agree.session.utils;

import cn.agree.io.Resources;
import cn.agree.session.Configuration;
import cn.agree.session.mapper.Mapper;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
*
* */
public class XMLConfigBuilder {

    /*
    *  主配置文件
    *
    * */
    public static Configuration loadConfiguration(InputStream is) {
        try {
            Configuration cfg = new Configuration();
            SAXReader reader = new SAXReader();
            // 读取主配置文件并创建对应的文档对象
            Document document = reader.read(is);
            // 解析并获取所有property节点信息
            List<Element> propertyList = document.selectNodes("//property");

            for (Element element : propertyList) {
                // 获取name属性和value属性
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                // System.out.println(name+"---"+value);
                //根据name属性识别当前属性属于数据库信息中的哪个一个参数
                if(name.equals("driver")){
                    //数据库驱动
                    cfg.setDriver(value);
                }else if(name.equals("url")){
                    //数据库连接地址
                    cfg.setUrl(value);
                }else if(name.equals("username")){
                    //用户名
                    cfg.setUsername(value);
                }else if(name.equals("password")){
                    //数据库密码
                    cfg.setPassword(value);
                }
            }

            System.out.println("获取的连接:"+cfg.getConnection());

            // 解析完基础的部分, 要来解析包含的xxxMapper.xml
            List<Element> mapperList = document.selectNodes("//mapper");
            for (Element element : mapperList) {
                // 如果resource属性存在, 则解析xmls
                Attribute resourceAttribute = element.attribute("resource");
                // System.out.println(resource);

                // 如果有的话, 表示是xml的开发方式 如果没有的话 证明是注解的开发方式
                if (resourceAttribute != null) {
                    String resource = resourceAttribute.getValue();
                    Map<String, Mapper> mappers = loadMapper(resource);
                    cfg.setMappers(mappers);
                } else { // 解析注解

                }

            }

            return cfg;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    /*
    *  解析UserMapper.xml
    *
    * */
    public static Map<String, Mapper> loadMapper(String path) {
        try {
            // 定义一个Map存储所有Mapper
            Map<String, Mapper> mappers = new HashMap<String, Mapper>();

            InputStream is = Resources.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(is);

            // 解析根节点
            Element rootElement = document.getRootElement();
            String namespace = rootElement.attributeValue("namespace");

            // 获取所有select节点
            List<Element> selectList = document.selectNodes("//select");

            // 解析所有的select节点
            for (Element element : selectList) {
                String  id = element.attributeValue("id");
                String sql = element.getText();
                String resultType = element.attributeValue("resultType");
                System.out.println("解析具体的Map:"+id+"--"+sql+"--"+resultType);
                Mapper mapper = new Mapper(sql, resultType);
                // key = namespace+.+id
                mappers.put(namespace+"."+id, mapper);
            }

            return mappers;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // System.out.println(is);
        loadConfiguration(is);

    }
}

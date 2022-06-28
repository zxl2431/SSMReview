package cn.agree.session.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    /*
    *  解析ResultSet转换成List集合
    *
    * */
    public static <E> List<E> list(ResultSet set, Class clazz) {
        try {
            List<E> list = new ArrayList<E>();
            // 获取所有的属性名
            Field[] fields = clazz.getDeclaredFields();

            // 循环封装
            while (set.next()) {
                // 获取当前Class的实例
                Object instance = clazz.newInstance();
                // 如果属性名和列名一样
                for (Field field : fields) {
                    Object result = set.getObject(field.getName());
                    if (result!=null) {
                        field.setAccessible(true);
                        field.set(instance, result);
                    }
                }

                list.add((E) instance);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

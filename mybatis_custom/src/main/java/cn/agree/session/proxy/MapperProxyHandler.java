package cn.agree.session.proxy;

import cn.agree.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MapperProxyHandler implements InvocationHandler {

    // SqlSession对象, 用于实现数据增删改查
    private SqlSession sqlSession;

    // 给SqlSession赋值
    public MapperProxyHandler(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /*
    *  实现查询数据库
    *
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // key = namespace+.+id

        Class<?> declaringClass = method.getDeclaringClass();
        // 类的全限定名
        String className = declaringClass.getName();
        // 方法名
        String methodName = method.getName();
        // 拼接key
        String key = className + "." + methodName;
        // 获取当前方法返回类型
        Class<?> returnType = method.getReturnType();

        if (returnType== List.class) {
            return sqlSession.list(key);
        } else {
            return null;
        }


    }
}

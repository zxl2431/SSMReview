package cn.agree.session.mapper;

public class Mapper {

    // 执行的SQL语句
    private String sql;

    // 结果集需要转化的JavaBean的全限定名
    private String resultType;

    public Mapper() {
    }

    public Mapper(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "sql='" + sql + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }
}

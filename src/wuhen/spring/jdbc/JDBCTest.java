package wuhen.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 由于不够了解IDEA创建测试类的过程，一直没有找到实现测试的方法，
 * 查阅相关资料后发现是项目路径下后缀为.idea的文件配置出错，删除重新运行项目才恢复正常
 */
public class JDBCTest {
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    private ApplicationContext applicationContext = null;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        employeeDao = applicationContext.getBean(EmployeeDao.class);
        departmentDao = applicationContext.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = applicationContext.getBean(NamedParameterJdbcTemplate.class);
    }

    /**
     * 使用具名参数时，可以使用 update(String sql,SqlParameterSource paramSource)方法进行更新操作
     * 1.SQL语句中的参数名和类的属性一致！
     * 2.使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数。
     */
    @Test
    public void testNamedParamterJdbcTemplate2(){
        String sql = "INSERT INTO employees(last_name,email,dept_id) " +
                "VALUES(:lastName,:email,:dpetId)";

        Employee employee = new Employee();
        employee.setLastName("Xyz");
        employee.setEmail("xyz@sina.com");
        employee.setDpetId(3);

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    /**
     * 可以为参数起名字。
     * 1.好处：若有多个参数，则不用再去对应位置，直接对应参数名，便于维护
     * 2.缺点：较为麻烦。
     */
    @Test
    public void testNameParameterJdbaTemplate(){
        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(:ln,:email,:deptid)";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("ln", "FF");
        paramMap.put("email","ff@126.com");
        paramMap.put("deptid", 2);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @Test
    public void testDepartmentDao(){
        System.out.println(departmentDao.get(1));
    }

    @Test
    public void testEmployeeDao(){
        System.out.println(employeeDao.get(1));
    }

    /**
     *  获取单个列的值，或做统计查询
     *  使用 queryForObject(String sql,Class<Long> requiredType)方法
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT count(id) FROM employees";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /**
     * 查到实体类的集合
     * 注意调用的不是queryForList方法
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id,last_name lastName,email FROM employees where id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper,5);
        System.out.println(employees);
    }

    /**
     *  从数据库中获取一条记录，实际得到对应的一个对象
     *  注意不是调用.queryForObject(String sql,Class<T> requiredType,Object... args)方法！ 这是返回指定字段类型
     *  而是调用 queryForObject(String sql,@NotNull org.springframework.jdbc.core.RowMapper<T> rowMapper,
     *  Object... args)
     *  1.其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
     *  2.使用SQL中列的别名完成列名和类的属性名的映射，例如last_name lastName
     *  3.不支持级联属性，JdbcTemplate只是一个JDBC的小工具，而不是ORM框架
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id,last_name lastName,email,dept_id as  \"department.id\" FROM employees where id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
        System.out.println(employee);
    }

    /**
     * 执行批量更新：批量的Insert,Update，Delete都可以
     * 最后一个参数是Object[]的List类型：因为修改一条需要一个Object的数组，多条就需要多个Object数组
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO employees(last_name,email,dept_id) VALUES(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"AA","123@qq.com",1});
        batchArgs.add(new Object[]{"BB","DSD@qq.com",2});
        batchArgs.add(new Object[]{"CC","FXZV@qq.com",3});
        batchArgs.add(new Object[]{"DD","SFD3@qq.com",3});
        batchArgs.add(new Object[]{"EE","1SDF@qq.com",2});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    /**
     * 执行Insert,Update，Delete都可以
     */
    @Test
    public void testUpdate(){
        String sql = "UPDATE employees SET last_name = ? where id = ?";
        jdbcTemplate.update(sql,"Tom",5);
    }

}

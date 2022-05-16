# 内容

## JDBC
* 概念：Java DataBase Connectivity。Java数据库连接
* 快速入门：
    1. 导入jar包
    2. 注册驱动
    3. 获取数据库连接对象（Connection）
    4. 定义sql
    5. 获取执行sql语句的对象 (Statement)
    6. 执行sql，接收返回结果
    7. 处理结果
    8. 释放资源
    
* 详解各个对象
    1. DriverManager:驱动管理对象
        * 功能：
            1. 注册驱动
               * 注：mysql5.0之后的驱动jar包可以省略注册驱动的步骤
            2. 获取数据库连接 
    2. Connection:数据库连接对象
        * 功能：
            1. 获取执行sql的对象
                * Statement createStatement()
                * PrepareStatement PrepareCreateStatement(String sql)
            2. 管理事务：
                * 开启事务: setAutoCommitted(boolean autoCommit):参数设置为false,既开启事务
                * 提交事务: commit()
                * 回滚事务: rollback()
    3. Statement:执行sql对象
        * 功能
            1. int executeUpdate(String sql):执行DML（增删改）、DDL（）语句
                * 返回值：影响的行数，返回值大于0，则执行成功
            2. ResultSet executeQuery(String sql):执行DQL(查询)语句
                * 返回值：结果集对象
    4. ResultSet:结果集对象
       * 功能：封装查询结果
            1. boolean next(): 游标向下移动一行，判断当前行是否是最后一行末尾（是否有数据）
            2. getXxx(参数):获取数据
                * Xxx 代表数据类型，如 getInt()
                * 参数：
                    1. int:代表列的编号从1 开始。如getString(1)
                    2. string:代表列名称。如getInt("id")
       * 使用步骤：
            1. 游标向下移动一行
            2. 判断是否有数据
            3. 获取数据
    5. PrepareStatement:执行sql对象
        * SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接，会造成安全问题
        * 解决：使用PrepareStatement对象来解决，参数使用 ? 作为占位符
        * 后期都会使用PrepareStatement对象完成操作
            1. 可以防止sql注入
            2. 效率更高
    
## 抽取JDBC工具类
* 目的：简化书写
* 分析：
    1. 注册驱动
    2. 抽取一个方法获取连接对象
    3. 抽取一个方法释放资源
    
## JDBC控制事务
* 管理事务：
  * 开启事务: setAutoCommitted(boolean autoCommit):参数设置为false,既开启事务
  * 提交事务: commit()
  * 回滚事务: rollback()
    
## 数据库连接池
* 概念：存放数据库连接的容器
* 好处：
    1. 节约资源
    2. 高效
* 实现
    * 标准接口：DataSource
        * 方法：
            1. 获取连接：getConnection()
            2. 归还连接：如果连接对象Connection是从连接池中获取的，那么调用Connection.close()方法，则不会再关闭连接了。而是归还连接
### c3po

* 步骤：
    1. 导入jar包(两个)
    2. 定义配置文件
        * 名称：c3p0.properties 或 c3p0-config.xml
        * 路径：直接将文件放在src目录下即可
    3. 创建核心对象
    4. 获取连接对象

### Druid

* 步骤
    1. 导包
    2. 定义配置文件
        * 是properties形式的
        * 可以叫任意名称，可以放在任意目录下
    3. 加载配置文件   
    4. 获取连接池对象:通过工厂来获取 DruidDataSourceFactory
    5. 获取连接
    
* 定义工具类
    1. 定义一个类
    2. 提供静态代码块加载配置文件,初始化连接池对象   
    3. 提供方法
        1. 获取连接方法:通过数据库连接池获取连接
        2. 释放资源
        3. 获取连接池的方法

## Spring JDBC
* Spring框架对JDBC的简单封装.提供了一个JDBCTemplate对象简化JDBC的开发
* 步骤:
    1. 导入jar包
    2. 创建JDBCTemplate对象，依赖于数据源DataSource
        * JdbcTemplate jt = new JdbcTemplate(ds);
    3. 调用方法来完成操作
        * update():执行DML语句。增删改
        * queryForMap():查询结果将结果集封装为map集合
            * 结果集长度只能为1 
            * 列名作为key，值作为value
        * queryForList():查询结果将结果集封装为List集合  
            * 将每一条记录封装为一个Map集合，再将Map集合装载到List集合中。
        * query():查询结果，将结果封装为JAvaBean对象
            * query的参数:RowMapper
                * 一般使用BeanPropertyRowMapper实现类，可以完成相互据到JavaBean的自动封装
                * new BeanPropertyRowMapper<类型>(类.class)
        * queryForObject():查询结果，将结果封装为Object对象
            * 一般用于聚合函数的查询

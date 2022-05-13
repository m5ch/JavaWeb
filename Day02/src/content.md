# 主要内容

1. 数据库的基本概念
2. Mysql数据库软件  
3. SQL学习
   
## 数据库的基本概念
1. Database,简称DB,用于存储和管理数据的仓库。

2. 特点：
    * 持久化存储数据（文件系统）
    * 方便存储和管理数据
    * 使用了统一的方式操作数据库——SQL
   
## MySQL数据库软件
* 目录
   1. 安装目录
      * 配置文件 my.ini
   2. 数据目录
      * 几个概念
         * 数据库
         * 表
         * 数据
   

## SQL

1. 什么是SQL？
   structured Query Lanage:结构化查询语句  
   其实就是定义了操作所有关系型数据库的规则。  
   每一种数据库操作的方式存在不一样的地方，称为“方言”

2. SQL通用语法
   * SQL语句可以单行或多行书写，以分号结尾。
   * 可使用空格和缩进来增强语句的可读性。
   * MySQL数据库的sQL语句不区分大小写，关键字建议使用大写。
   * 3种注释
      * 单行注释: -- 注释内容 或 # 注释内容 (mysql特有)
      * 多行注释: /* 注释 */
3. SQL分类
      * DDL(Data Definition Language)数据定义语言  
         用来定义数据库对象∶数据库，表，列等。关键字: create，drop,alter 等
      * DML(Data Manipulation Language)数据操作语言  
         用来对数据库中表的数据进行增删改。关键字:insert，delete，update等
      * DQL(Data Query Language)数据查询语言  
         用来查询数据库中表的记录(数据)。关键字: select，where 等
      * DCL(Data control Language)数据控制语言(了解)  
         用来定义数据库的访问权限和安全级别，及创建用户。关键字:GRANT,REVOKE等

### DDL:操作数据库、表
   * 操作数据库：CRUD
        1. C(Create) :创建
        2. R(Retrieve):查询  
                show databases;
        3. U(Update):修改  
           修改数据库字符集  
            alter database 数据库名 character set 字符集;
        4. D(Delete):删除
            drop database 数据库名;
   * 操作数据表：
        1. C(Create) :创建  
           
                create table(
                    列名1 数据类型1,
                    列名2 数据类型2,
                    ...
                    列名n 数据类型n  /* 注：最后一列不需要加逗号  , 
                );
                复制
                create table 表名1 like 表名2;
           
        2. R(Retrieve):查询  
           
                show tables;
                desc 表名;
        3. U(Update):修改  
            * 修改表名  
                alter table 表名 rename 新的表名;
            * 修改字符集  
                alter table 表名 character set 字符集名称;
            * 添加一列  
                alter table 表名 add 列名 数据类型;
            * 修改列名称、类型  
                alter table 表名 change 列名 新列名 新数据类型;  
                alter table 表名 modify 新列名 新数据类型;
            * 删除列  
                alter table 表名 drop 列名; 
            
        4. D(Delete):删除
    

            drop database 表名;
            drop database if exists 表名;
           

### DML:增删改表中数据  

1. 添加数据  
   * 语法：  
    insert into 表名(列名1,列名n) values(值1,值n);
   * 注意：  
    1. 列名和值要一一对应
    2. 如果表名后不定义列名，则默认给所有列添加值
    3. 除了数字类型，其他类型需要使用引号（单双都行）
2. 删除数据
   * 语法：  
    delete from 表名 [where 条件];
   * 注意  
    1. 如果不加条件，则默认删除表中所有数据
    2. 删除所有数据：  
        1. delete from 表名;(不推荐使用，效率低)
        2. truncate table 表名;(删除改表，并创建一个一样的表，推荐使用)
3. 修改数据
    * 语法：  
        update 表名 set 列名1=新数据, 列名2=新数据,... where 条件;
    * 注意： 
        如果不加条件，则会把表中所有数据全部修改

### DQL:查询表中数据
    select * from 表名;
1. 语法：  
   select 字段列表  
   from 表名列表  
   where 条件列表  
   group by 分组字段  
   having 分组之后的条件
   order by 排序
   limit 分页限定
   
2. 基础查询：
   * 多个字段的查询  
        select 字段名1,字段名2,... from 表名;  
     **注意**：如果想查询所有字段，可以使用 * 代替字段列表
   * 去除重复  
        select distinct 字段名 from 表名;
   * 计算列  
        select 字段名1,字段名2,字段名1 + 字段名2 from 表名;(一般知进行数值型的计算)
        ifnull(需要判断的字段, 替换值)
   * 起别名  
        select 字段名1 [as] 别名1,字段名2 [as] 别名2,字段名1 + 字段名2 [as] 别名3 from 表名;
        
3. 条件查询
    * where 字句后跟条件
    * 运算符
        * <、>、 <= 、 >= 、= 、!=、<>
        * BETWEEN...AND
        * IN(集合)
        * LIKE
          * _ :单个任意字符
          * % :多个任意字符
        * IS NULL 
        * and 或 &&
        * or 或 || 
        * not 或 !

4. 排序查询
   * 语法：  
     order by 排序字段1 排序方式1,排序字段2 排序方式2,...
   * 排序方式:  
     asc : 升序（默认）  
     desc : 降序
   * 注意：  
     如果有多个排序条件时，则当前面的条件值一样时，才会判断第二条件
5. 聚合函数（将一列数据作为一个整体，进行纵向的计算）
   * 语法：  
    select 可添加的词(列名) from 表名;
   * 注意:  
    排除null值
6. 分组查询
   * 语法：  
        group by 分组字段;
   * 注意：
        * 分组之后查询的字段：分组字段、聚合函数
        * where 和 having 的区别：
            1. where 在分组之前,如果不满足，则不参与分组；  
               having 在分组之后，如果不满足则不会被查询出来。
            2. where 后不可以跟聚合函数；  
               having 可以进行聚合函数的判断
7. 分页查询
    * 语法：  
        limit 开始的索引, 每页查询的条数;
    * 公式：
        开始的索引 = (当前的页码 - 1) * 每页显示的条数
    * 注意：分页操作是MySQL“方言”；  

### DCL
* 管理用户
    * 添加用户
        1. create user '用户名'@'主机名' identified by '密码';
    * 删除用户
        1. drop user '用户名'@'主机名';
    * 修改用户(密码)
        1. update user set password = password('新密码') where user = '用户名';
        2. set password for '用户名'@'主机名' = password('新密码');
    * 查询用户
        1. 切换到MySQL数据库: use mysql
        2. 查询user表: select * from user;
    * mysql中忘记了root用户的密码?
        1. cmd -- > net stop mysql停止mysql服务  
            *需要管理员运行该cmd
        2. 使用无验证方式启动mysql服务: mysqld --skip-grant-tables  
        3. 打开新的cmd窗口,直接输人mysql命合，敲回车。就可以登录成功  
        4. use mysql;  
        5. update user set password = password('新密码') where user = 'root';  
        6. 关闭两个窗口  
        7. 打开任务管理器，手动结束mysqld.exe的进程  
        8. 启动mysql服务  
        9. 使用新密码登录。  

* 授权
    * 查询权限：show grants for '用户名'@'主机名';
    * 授予权限：grant 权限列表 on 数据库名.表名 to '用户名'@'主机名';
    * 撤销权限：revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名';

### 约束
1. 概念： 对表中的数据进行限定，保证数据的正确性，有效性，完整性；
2. 分类：
    * 主键约束：primary key
        1. 创建表时添加约束:  
        
                create table 表名(
                    id int primary key --给id添加主键约束
                );
        2. 创建表完后，添加约束
                
                alter table 表名 modify 列名 数据类型 primary key;
        3. 删除主键约束
        
                alter table 表名 drop primary key;
        * **注意**:
            1. 含义：非空且唯一
            2. 一张表只能有一个字段为主键
            3. 主键就是表中记录的唯一标识
        * 自动增长：如果某一列是数值类型的，使用 auto_increment 可以完成值的自动增长。
            1. 创建表时添加约束:  
        
                create table 表名(
                    id int primary key auto_increment--给id添加主键约束
                );
            2. 创建表完后，添加约束
                
                alter table 表名 modify 列名 数据类型 auto_increment;
            3. 删除主键约束
        
                alter table 表名 modify 列名 数据类型;
            
    * 非空约束：not null，某一列的值不能为null。
        1. 创建表时添加约束:  
           
                create table 表名(
                        id int,
                        name varchar(20) not null  -- name为非空
                );
        
        2. 创建表完后，添加约束
       
                alter table 表名 modify 列名 数据类型 not null;
        3. 删除name非空约束
       
                alter table 表名 modify 数据类型;
       
    * 唯一约束:unique,某一列的值不能为null
        * **注意**：唯一约束可以有null值，但只能有一条数据为null。
        1. 创建表时，添加约束：
           
                create table 表名(
                    id int,
                    phone_num varchar(20) unique --手机号唯一
                );
        2. 创建表完后，添加约束
    
                alter table 表名 modify 列名 数据类型 unique;
                  
        3. 删除约束
                alter table 表名 drop index 列名;   
    * 外键约束：foreign key,让表与表产生关系，从而保证数据的真确性。
        1. 在创建表时添加外键
            
                create table 表名(
                    ...
                    外键列 数据类型,
                    constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)
               );
        2. 添加外键
           
                alter table 表名 add constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)

        3. 删除外键
            
                alter table 表名 drop foreign key 外键名;
        * 级联操作
            * 语法：
    
                    alter table 表名 add constraint 外键名 foreign key (外键字段名称) references 主表名称(主表列名称) 
                        on update cascade on delete cascade
    
### 数据库的设计
* 多表之间的关系
    * 分类
        1. 一对一
        2. 一对多（多对一）
        3. 多对多
    * 实现关系
        1. 一对一：在任意一方添加 **唯―** 外键指向另一方的主键。 
        2. 一对多：“多”的一方的外键指向“一”的一方的主键  
        3. 多对多：多对多关系实现需要借助第三张中间表。
                中间表至少包含两个字段,这两个字段作为第三张表的外键，分别指向两张表的主键

* 数据库的范式
    * 概念：设计数据库时，需要注意的一些规范，要遵循后边的范式要求，必须先遵循前边的所有范式要求
* 分类：
    1. 第一范式（1NF）：每一列都是不可分割的原子数据项
    1. 第二范式（2NF）：在1NF的基础上，非码属性必须完全依赖于候选码（在1NF基础上消除非主属性对主码的部分函数依赖)
    1. 第三范式（3NF）：在2NF基础上，任何非主属性不依赖于其它非主属性(在2NF基础上消除传递依赖)
### 数据库的备份和还原
* 命令行
    * 备份：mysqldump -u用户名 -p密码 数据库名称 > 保存的路径
    * 还原：
        1. use 数据库
        2. source 文件路径
        
* 图形化工具

### 多表查询
* 内连接查询
    * 隐式内连接：使用where条件消除无用数据
        
    * 显式内连接：
        * 语法 
            select 字段 from 表名1 [inner] join 表名2 on 条件;
* 外连接查询
    * 左外连接:查询左表所有数据及其交集部分
        * 语法：select 字段列表 from 表名1 left [outer] join 表名2 on 条件;
    * 右外连接:查询右表所有数据及其交集部分
        * 语法：select 字段列表 from 表名1 right [outer] join 表名2 on 条件;
* 子查询:查询中嵌套查询
    * 子查询不同情况；
        1. 结果是单行单列的：子查询可以作为条件，使用运算符(< <= > >= = ...)来判断
        2. 结果是多行单列的：子查询可以作为条件，使用运算符 in 来判断
        3. 结果是多行多列的：子查询可以作为一张虚拟表
    
### 事务
* 基本介绍：
    * 概念：如果一个包含多个步骤的业务操作，被事务管理，那么这些操作要么同时成功，要么同时失败
    * 操作：
        1. 开启事务：start transsction
        2. 回滚： rollback
        3. 提交： commit
    * 事务默认自动提交
        * 自动提交：MySQL就是自动提交的
        * 手动提交：需要先开启事务，在手动提交
        * 查看默认提交方式：select @@autocommit; --1 代表自动 0 代表手动  
        * 修改方式：set @@autocommit = 0/1;
 * 四大特征：
    * 原子性：不可分割的最小操作单位，要么同时成功，要么同时失败
    * 持久性：当事务提交或回滚时，数据库会持久地保存数据
    * 隔离性：多个事务之间，相互独立
    * 一致性：数据操作前后，数据总量不变
 * 隔离级别：  
    * 问题：
        1. 脏读：一个事务，读取到另一个事务中没有提交的数据
        2. 不可重复读（虚读）：在同一个事务中，两次读取到的数据不一样
        3. 幻读：一个事务操作(DNL)数据表中所有记录，另一个事务添加了一条数据，则第一个事务查询不到自己的修改。
    * 分类：
        1. read uncommitted:未读提交。产生问题：脏读，不可重复读，幻读
        2. read committed:读已提交。产生问题：不可重复读，幻读
        3. repeatable read:可重复读。产生问题：幻读
        4. serializable:串行化。产生问题：无
    * 查询 ：select @@tx_isolation;
    * 设置 ：set global transaction isolation level 级别字符串;
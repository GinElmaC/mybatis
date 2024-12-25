第一个MyBatis程序
1.resources目录：放在这个目录下的一般是配置文件，直接放在该文件下的文件等同于放在类的根路径下

2.开发步骤
    1.设置打包方式
    2.引入MyBatis,MySQL依赖
    3.编写MyBatis核心配置文件：MyBatis-config.xml,通过这个对象创建SqlSessionFactory对象
        注意1.这个文件名不是必须的，但是大家都用它
           2.这个文件的存放位置不是一定的，但一般放在类的根路径下
    4.编写XxxxMapper配置文件
        在这个配置文件中写sql语句，暂时将他放在resource文件下
    5.在mybatis-config.xml配置文件中制定XxxxMapper文件的路径
        <mapper resource=".....">
        resource属性会自动从类的根路径下开始查找资源
    6.编写MyBatis程序
        在MyBatis中执行SQL语句的对象叫SqlSession
        SqlSession
            是专门用来执行SQL语句的，是java程序与数据库之中的一次会话
            要想获取这个对象，需要先获取SqlSessionFactory对象，通过这个对象生产SqlSession对象
            想要获取SqlSessionFactory对象，要先获取SqlSessionFactoryBuilder对象

        MyBatis核心对象包括：
            SqlSessionFactoryBuilder
            SqlSessionFactory
            SqlSession


3.从XML中构建SqlSessionFactory
    1.这个东西在MyBatis中一定很重要，这个对象是：SqlSessionFactory对象
    2.SqlSessionFactory对象的创建需要XML
    XML是什么？
        他是一个配置文件。
    3.创建SqlSessionFactory对象所需的输入流有三个方法：
        1. new InputStream("xml")，如果写的是绝对路径，则移植性差
        2. Resource.getResourceAsStream("xml") 利用apache包下的Resource类方法
        3. 利用类加载器，ClassLoader.getSystemClassLoader().getResourceAsStream("resource中的xml路径")
                       类加载器       获取系统的类加载器           方法
        其实2号方法的Resource方法的底层源码就是方法3



4.MyBatis中有两个主要的配置文件：
    其中一个是mybatis-config.xml，这是核心配置文件，主要配置连接数据库的信息（一个）
    另一个是Xxxxx.xml，这个文件是专门用来编写SQL语句。（一个表一个）
        t_user表对应一个UserMapper.xml

5.关于mybatis的事务管理机制
    1.在mybatis-congif.xml配置文件中可以通过一下的配置进行mybatis的事务管理
        <transactionManager type="JDBC"/>
    2.type属性的值包括两个，不区分大小写
        JDBC
        MANAGED
    3.在mybatis中有两种事务管理机制
        1.JDBC管理机制
            mybatis自己管理事务，自己采用原生的JDBC代码管理事务
            coon.setAutoCommit(false);
            开启事务
            ...业务处理...
            coon.commit();
        2.MANAGED管理机制
            mybatis不在负责事务管理，交给其他容器管理，比如spring
            如果我们只有mybatis框架时，不要写MANAGED，因为我们没有另外一个容器，事务不会开启
    如果执行下面的代码：
        SqlSession s = sf.openSession(true);
        就没有开启事务，因为这种方法不会执行coon.setAutoCommit(false)，在JDBC中，没有执行coon.setAutoCommit(false)则AutoCommit就是true
        如果AutoCommit是true，则表示没有开启事务，执行一次DML就提交一次

6.关于MyBatis常用的日志组件
    1.MyBatis常见的日志组件：
        SLF4J(沙拉风)
        LOG4J
        LOG4J2
        STDOUT_LOGGING
        ....
    2.其中STDOUT_LOGGING是标准日志，mybatis已经实现了这种标准日志。mybatis框架本身已经实现了这种标准，只需要在核心配置文件中开启即可：
        <setting>
            <setting name="logImpl" value="STDOUT_LOGGING">
        </setting>
    3.标签是有顺序的，顺序被dtd文件约束，顺序不需要记忆，总有一天会报错的
    4.集成logback日志框架
        logback日志框架实习拿了slf4j标准
        1.引入logback的依赖
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.12</version>
        </dependency>
        2.引入logback所必须的xml配置文件
            这个配置文件的名字必须叫做：logback.xml或者logback-text.xml，不能是其他名字
            这个配置文件必须放到类的根路径下

7.关于mybatis的环境标签
    <environments default="development">
            <environment id="development">
                <transactionManager type="JDBC"/>
                <dataSource type="POOLED">
                    <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                    <property name="url" value="jdbc:mysql://localhost:3306/mybatis"/>
                    <property name="username" value="root"/>
                    <property name="password" value="1998229wang"/>
                </dataSource>
            </environment>
    </environments>
    这就是一个环境标签，其中第一行的default就是默认情况下使用哪个环境
    在我们创建SqlSessionFactory时:
        使用默认环境：
        SqlSessionFactoryBuilder.build(Resources.getResourceAsStream("MyBatis-config.xml"))
        指定使用xxxx环境：
        SqlSessionFactoryBuilder.build(Resources.getResourceAsStream("MyBatis-config.xml"),"xxxxx")

8.数据源
    <dataSource type="POOLED">
    1.数据源实际上是一套规范，JDK中有这套规范：javax.sql.DataSource，指定数据源类型实际上就是指定使用什么连接池
    2.我们也可以自己写数据源组件，只要实现javax.sql.DataSource接口就行，实现接口的所有方法，这样就有了自己的数据源
    比如可以自己写一个数据库连接池
    3.常见的数据源组件：
        阿里巴巴的德鲁伊连接池：druid
    4.type属性有三个：
        POOLED使用mybatis自身带有的连接池
        UNPOOLED不适用连接池技术，每一次创建新的Connection对象
        JNDI集成其他第三方的连接池
    5.JNDI是一套规范，大部分的web容器都实现了这个规范
        例如：tomcat，jetty，weblogic，websphere
    6.JNDI是java命令目录接口，tomcat服务器实现了这个规范

9.#{}与${}的区别：
    #{}：底层使用PreparedStatement，特点：先进行sql语句的编译，然后给sql语句传值
    ${}：底层使用Statement，特点：先进行sql语句的拼接，再对sql语句进行编译，存在sql注入风险
    所以使用时优先使用#{}，避免sql注入风险
    但是需要排序使用asc或者desc时需要用${}
    1.当需要SQL语句的关键字时只能使用${}，因为#{}是以值的形式放到SQL语句中的
    2.向SQL语句中拼接表名需要${}
10.代理模式：
    代理对象 中介
    代理方法 找房子
    目标对象 我
    目标方法 找房子
    关于下面代码：
        SqlSession s = SqlSessionUtil.openSqlSession();
        StudentMapper studentMapper = s.getMapper(StudentMapper.class);
        实际上studentMapper是代理对象，由这个对象调用的是代理方法
        studentMapper.方法1()
        其中“方法1”就是代理方法
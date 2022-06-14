## web服务器软件
* 服务器：安装了服务器软件的计算机
* 服务器软件：接收用户的请求，处理请求，做出响应
* web服务器软件：接收用户的请求，处理请求，做出响应
    * 在服务器软件中，可以部署web项目，让用户通过浏览器里这些项目
    
* 常见的java相关的web服务器软件∶
    * webLogic : oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
    * websphere : IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
    * JBOSS : JBOss公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
    * Tomcat : Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的免费的

### Tomcat
* 启动时可能会遇到的问题：
  1. 黑窗口一闪而过:
     * 原因: 没有正确配置AVA_HOME环境变量
     * 解决方案: 正确配置JAVA_HOME环境变量
  2. 启动报错∶
     1. 暴力∶ 找到占用的端口号，并且找到对应的进程，杀死该进程
     netstat -ano
     2. 温柔∶ 修改自身的端口号
        * conf/ server.xml
        * <Connector port="8888"protocol="HTTP/1.1"
          connectionTimeout="20000"
          redirectPort="8445”/>
        * 一般会将tomcat的默认端口号修改为80。80端口号是http协议的默认端口号。
          * 好处: 在访问时，就不用输入端口号
    
* 关闭∶ 
    * 正常关闭∶
        1. bin/ shutdown.bat
        2. ctrl+c
    * 强制关闭∶ 点击启动窗口的 ×
* 配置
    * 部署项目的方式：
        1. 直接将项目放到webapps目录下即可
           * /hello: 项目的访问路径-->虚拟目录
           * 简化部署:将项目打成一个war包，再将war包放置到webapps目录下。
                * war包会自动解压缩
        2. 配置conf/ server.xml文件
           在<Host>标签体中配置
           <context docBase="D:\hello" path="/hehe” />
           * docBase:项目存放的路径
           * path :虚拟目录
        3. 在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写
           <context docBase="D:\hello" />
           * 虚拟目录∶ xml文件的名称
    * 静态项目和动态项目∶
      * 目录结构
        * java动态项目的目录结构︰
            * 项目的根目录
                * WEB-INF目录∶
                    * web.xml : web项目的核心配置文件
                    * classes目录: 放置字节码文件的目录
                    * lib目录: 放置依赖的jar包
    * 将Tomcat集成到IDEA中，并且创建]avaEE的项目，部署项目。

### Servlet: server applet
* 概念: 运行在服务器端的小程序
      * Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
      * 将来我们自定义一个类，实现servlet接口，复写方法。
* 快速入门
      1. 创建savaEE项目
      2. 定义一个类，实现servlet接口
            * 右键项目—打开模块设置—依赖—点击+—库—tomcat
      3. 实现接口中的抽象方法
      4. 配置servlet
* 执行原理
    1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
    2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
    3. 如果有，则在找到对应的<servlet-class>全类名
    4. tomcat会将字节码文件加载进内存，并且创建其对象
    5. 调用其方法
    
* Servlet中的生命周期
    1. 被创建: 执行init方法，只执行一次
       * servlet什么时候被创建?
            * 默认情况下，第一次被访问时，Servlet被创建
            * 可以配置执行servlet的创建时机。
              * 在<servlet>标签下配置
                1. 第一次被访问时，创建:
                    <load-on-startup>的值为负数
                2. 在服务器启动时，创建:
                    <load-on-startup>的值为0或正整数
       * Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
         * 多个用户同时访问时，可能存在线程安全问题。
         * 解决:尽量不要在servlet中定义成员变量。即使定义了成员变量，也不要对修改值

    2. 提供服务: 执行service方法，执行多次
        * 每次访问Servlet时. Service方法都会被调用一次。
    3. 被销毁: 执行destroy方法，只执行一次
        * Serviet被销毁时执行。服务器关闭时，Servlet被销毁
        * 只有服务器正常关闭时，才会执行destroy方法。
        * destroy方法在servlet被销毁之前执行，一般用于释放资源

* servlet3.0 及以上:
  * 好处:支持注解配置。可以不需要web.xml了。
  * 步骤︰
    1. 创建]avaEE项目，选择servlet的版本3.0以上，可以不创建web.xml
    2. 定义一个类，实现Servlet接口
    3. 复写方法
    4. 在类上使用@WebServlet注解，进行配置
        * @WebServlet("资源路径")

* Servlet的体系结构
    * Servlet(接口)
    * GenericServlet(抽象类):将servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象
        * 将来定义servlet类时，可以继承Genericservlet，实现service()方法即可
    * HTTPServlet(抽象类):对HTTP协议的一种封装，简化操作
        1. 定义类继承HTTPServlet
        2. 复写doGet/doPost方法
    
* Servlet相关配置
    * urlpartten:Servlet访问路径
        1. 一个Servlet可以定义多个访问路径
        2. 路径定义规则：
            * /xxx
            * /xxx/xxx: 多层路径，目录结构
            * *.do
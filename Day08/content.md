## HTTP
* Hyper Text Transfer Protocol 超文本传输协议
    * 传输协议：定义了客户端和服务端通信时，发送数据的格式
* 特点
    1. 基于TCP/IP的高级协议
    2. 默认端口号:80
    3. 基于请求/响应模型的:一次请求对应一次响应 
    4. 无状态的:每次请求之间相互独立，不能交互数据

* 请求消息数据格式
    1. 请求行   
        请求方式  请求url  请求协议/版本
         GET /login.html HTTP/1.1
       * 请求方式:
            * HTTP协议有7中请求方式，常用的有2种
                * GET:
                    1. 请求参数在请求行中，在url后。
                    2. 请求的url长度有限制的
                    3. 不太安全
                * POST :
                    1. 请求参数在请求体中
                    2. 请求的url长度没有限制的
                    3. 相对安全

    2. 请求头：客户端浏览器告诉服务器一些信息  
        请求头名称: 请求头值
       * 常见 的请求头︰
            1. User-Agent:浏览器告诉服务器，我访问你使用的浏览器版本信息
               * 可以在服务器端获取该头的信息，解决浏览器的兼容性问题
            2. Referer : http://localhost/login.html
               * 告诉服务器，我(当前请求)从哪里来?
               * 作用:
                    1. 防盗链
                    2. 统计工作
        
     3. 请求空行
        空行
    4. 请求体(正文)


## Request
* request对象和response对象的原理
    1. request和response对象是由服务器创建的。我们来使用它们
    2. request对象是来获取请求消息，response对象是来设置响应消息 
* request对象继承体系结构∶  
   servletRequest  --接口  
        │   继承  
   HttpServletRequest  --接口  
        |   实现  
   org.apache.catalina.connector.RequestFacade  类(tomcat)

* request功能
    * 获取请求消息数据
        1. 请求行
           * 例： GET /Day08/demo01?name=zhangsan HTTP/1.1
            * 方法:
                1. 获取请求方式(GET): String getMethod()
                2. **获取虚拟目录**(/Day08): String getContextPath()
                3. 获取Servlet路径(demo01): String getServletPath()
                4. 获取get方式请求参数(name=zhangsan): String getQueryString()
                5. **获取请求URI**(/Day08/demo01): 
                   * String getRequestURI() : /Day08/demo01
                   * StringBuffer getRequestURL(): http://localhost/Day08/demo01 
                6. 获取协议及版本(HTTP/1.1): String getProtocol()
                7. 获取客户机的IP地址: String grtRemoteAddr()
        2. 请求头
           * 方法：
                * **String getHeader(String name): 通过请求头的名称获取请求头的值**
                * Enumeration<String> getHeaderNames():获取所有请求头的名称
        3. 请求体: 只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
            * 步骤：
                1. 获取流对象
                    * BufferedReader getReader() ∶ 获取字符输入流，只能操作字符数据
                    * ServletInputStream getInputStream() : 获取字节输入流，可以操作所有类型数据

                  2. 从流对象中获取数据
    * 其他:
        * 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
            * string getParameter(string name):根据参数名称获取参数值  username=zs&password=123
            * string[] getParameterValues(string name): 根据参数名称获取参数值的数组  hobby=xx&hobby=game
            * Enumeration<string> getParameterNames():获取所有请求的参数名称
            * Map<string,string[]> getParameterMap():获取所有参数的map集合
            * 中文乱码问题:
              * get方式: tomcat 8已经将get方式乱码问题解决了
              * post方式: 会乱码
                * 解决∶ 在获取参数前，设置request的编码  request.setCharacterEncoding("utf-8");

        * 请求转发: 一种在服务器内部的资源跳转方式
          * 步骤
            1. 特哦那个过request对象获取请求转发器对象: RequestDispatcher getRequestDispatcher(String path)
            2. 使用RequestDispatcher对象来进行转发: forward(ServletRequest request,ServletResponse response)
          * **特点**:
            1. 浏览器地址栏路径不发生变化
            2. 只能转发到当前服务器内部资源中
            3. 转发是一次请求

        * 共享数据:
            * 域对象:一个有作用范围的对象，可以在范围内共享数据
            * request域:代表一次请求的范围，一般用于请求转发的多个资源中共享数据
            * 方法:
                1. void setAttribute(string name,object obj): 存储数据
                2. Object getAttitude(string name): 通过键获取值
                3. void removeAttribute(string name): 通过键移除键值对

        * 获取ServletContext


package wuhen.spring.struts2.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

// TODO: 2020/7/24 监听
public class SpringServletContextListener implements ServletContextListener {

    // 公共构造函数是servlet规范要求的
    public SpringServletContextListener() {

    }

    // ServletContextListener实现
    /*此方法在servlet上下文为时被调用，初始化(在部署Web应用程序时)。您可以在这里初始化servlet上下文相关的数据。*/
    public void contextInitialized(ServletContextEvent arg0) {
        //1.获取Spring配置文件的名称
        ServletContext servletContext = arg0.getServletContext();
        String config = servletContext.getInitParameter("configLocation");

        //1.创建IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        //2.把IOC容器放在ServletContext的一个属性中
        servletContext.setAttribute("ApplicationContext",applicationContext);

    }

    /*此方法在Servlet上下文时调用(Web应用程序)未部署或应用服务器关闭。*/
    public void contextDestroyed(ServletContextEvent sce) {

    }

    // HttpSessionListener实现
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */

    }

    // HttpSessionAttributeListener实现
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */


    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}

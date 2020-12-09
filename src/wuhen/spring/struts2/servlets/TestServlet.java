package wuhen.spring.struts2.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import wuhen.spring.struts2.beans.Person;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: 2020/7/24 tomcat疑似读取不到此文件，已直接写入index.jsp中
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse httpServletResponse){
        //1.从application域对象中的到IOC容器的引用
        ServletContext servletContext = getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("ApplicationContext");

        //2.从IOC容器中得到需要的bean
        Person person = applicationContext.getBean(Person.class);
        person.hello();

    }

}

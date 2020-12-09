<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="wuhen.spring.struts2.beans.Person" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>$Title$</title>
  </head>
  <body>
      <%

        //1.从application域对象中的到IOC容器的引用
        ServletContext servletContext = getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("ApplicationContext");

        //2.从IOC容器中得到需要的bean
        Person person = applicationContext.getBean(Person.class);
        person.hello();

      %>
  </body>
</html>

package com.jyc.crud

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import config.AppConfig

object Starter extends App {

  val server = new Server(8080)

  val servletHolder = new ServletHolder(new DispatcherServlet());
  servletHolder.setInitParameter("contextClass", classOf[AnnotationConfigWebApplicationContext].getName);
  servletHolder.setInitParameter("contextConfigLocation", classOf[AppConfig].getName());

  val context = new ServletContextHandler();
  context.setContextPath( "/" );
  context.addServlet(servletHolder, "/api/*");

  server.setHandler(context);
  server.start();
  server.join();
}

package com.jyc.crud

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import config.AppConfig

object Starter extends App {

  val server = new Server(8080)

  // Register and map the dispatcher servlet
  val servletHolder = new ServletHolder( new DispatcherServlet() );
  val context = new ServletContextHandler();
  context.setContextPath( "/" );
  context.addServlet(servletHolder, "/api/*");
  context.addEventListener(new ContextLoaderListener());

  context.setInitParameter("contextClass", classOf[AnnotationConfigWebApplicationContext].getName);
  context.setInitParameter("contextConfigLocation", classOf[AppConfig].getName());

  server.setHandler(context);
  server.start();
  server.join();


}

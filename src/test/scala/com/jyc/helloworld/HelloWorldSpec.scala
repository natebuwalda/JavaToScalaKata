package com.jyc.helloworld

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification

@RunWith(classOf[JUnitRunner])
class HelloWorldSpec extends Specification {

  "The Hello World Java Class" should {
    "say 'hello from java'" in {
      val javaHelloWorld = new JavaHelloWorld()
      javaHelloWorld.sayHello() must be("hello from java")
    }
  }

  "The Hello World Scala Class" should {
    "say 'hello from scala'" in {
      val scalaHelloWorld = new ScalaHelloWorld
      scalaHelloWorld.sayHello must be("hello from scala")
    }
  }

}

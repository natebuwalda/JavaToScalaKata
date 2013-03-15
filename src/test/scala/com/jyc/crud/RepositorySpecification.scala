package com.jyc.crud

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.{Before, Specification}
import java.util

@RunWith(classOf[JUnitRunner])
class RepositorySpecification extends Specification {

  "A data repository object" should {
    "handle inserting and reading data" in new context {
      val names = new util.ArrayList[String]()
      names.add("Nate")
      names.add("Jared")
      names.add("Charlie")
      names.add("Eric")

      repository.insert("employees", names) mustEqual 4

      val findResult = repository.find("employees")

      findResult must have size(4)
      findResult.get(0) mustEqual "Nate"
    }
    "handle updating and reading data" in new context {
      val names = new util.ArrayList[String]()
      names.add("Nate")

      repository.insert("employees", names) mustEqual 1

      val newNames = new util.ArrayList[String]()
      newNames.add("Jared")
      newNames.add("Charlie")

      repository.update("employees", newNames) mustEqual 2

      val findResult = repository.find("employees")

      findResult must have size(3)
      findResult.get(2) mustEqual "Charlie"
    }
    "handle removing data" in new context {
      val names = new util.ArrayList[String]()
      names.add("Nate")
      names.add("Jared")
      names.add("Eric")

      repository.insert("employees", names) mustEqual 3

      val namesToRemove = new util.ArrayList[String]()
      namesToRemove.add("Jared")
      repository.remove("employees", namesToRemove) mustEqual 1

      val findResult = repository.find("employees")

      findResult must have size(2)
      findResult.contains("Jared") must beFalse
    }
  }

  trait context extends Before {
    var repository: JavaRepository = null

    def before: Any = {
      repository = new JavaRepository
    }
  }
}

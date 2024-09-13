package funsets

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.annotation.tailrec

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1: Set = singletonSet(1)
    val s2: Set = singletonSet(2)
    val s3: Set = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s: Set = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect") {
    new TestSets {
      val s: Set = union(s1, s2) // == {1,2}
      val t: Set = intersect(s1, s) // == {1}
      assert(contains(t, 1), "Intersect 1")
      assert(!contains(t, 2), "Intersect 2")
      assert(!contains(t, 3), "Intersect 3")
    }
  }

  test("diff") {
    new TestSets {
      val s: Set = union(s1, s2) // == {1,2}
      val t: Set = diff(s, s1) // == {2}
      assert(!contains(t, 1), "Diff 1")
      assert(contains(t, 2), "Diff 2")
      assert(!contains(t, 3), "Diff 3")
    }
  }

  test("filter") {
    new TestSets {
      val s: Set = union(union(s1, s2), s3) // == {1,2,3}
      val t: Set = filter(s, (x: Int) => x >= 2) // == {2,3}
      assert(!contains(t, 1), "Filter 1")
      assert(contains(t, 2), "Filter 2")
      assert(contains(t, 3), "Filter 3")
    }
  }

  test("forall") {
    new TestSets {
      val a1: Set = singletonSet(-100)
      val a2: Set = singletonSet(0)
      val a3: Set = singletonSet(100)
      val a: Set = union(union(a1, a2), a3) // == {-100,0,100}
      assert(forall(a, (x: Int) => x > -101), "Forall > -101")
      assert(forall(a, (x: Int) => x < 101), "Forall < 101")
      assert(!forall(a, (x: Int) => x > 0), "Forall > 0")
    }
  }

  test("exists") {
    new TestSets {
      val a1: Set = singletonSet(-100)
      val a2: Set = singletonSet(0)
      val a3: Set = singletonSet(100)
      val a: Set = union(union(a1, a2), a3) // == {-100,0,100}
      assert(exists(a, (x: Int) => x > -101), "Exists > -101")
      assert(exists(a, (x: Int) => x > 0), "Exists > 0")
      assert(!exists(a, (x: Int) => x > 100), "Exists > 100")
    }
  }

  /**
   * Check if two sets are equal
   */
  def isSetEqual(s: Set, t: Set): Boolean = {
    @tailrec
    def iter(a: Int): Boolean = {
      if (a > 1000) true
      else if (contains(s, a) != contains(t, a)) false
      else iter(a + 1)
    }
    iter(-1000)
  }
  test("map") {
    new TestSets {
      val s: Set = union(union(s1, s2), s3) // == {1,2,3}
      val t: Set = (x: Int) => x == 2 || x == 4 || x == 6 // == {2,4,6}
      assert(isSetEqual(map(s, (x: Int) => 2 * x), t), "Map")
      printSet(map(s, (x: Int) => 2 * x))
      printSet(t)
    }
  }
}

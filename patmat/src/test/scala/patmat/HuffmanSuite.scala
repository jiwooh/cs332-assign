package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  // Part 1: Implementation
  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  // Part 2: Constructing Huffman Trees
  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("until() test") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val combinedTree = until(singleton, combine)(leaflist)

    assert(combinedTree === Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4), List('e', 't', 'x'), 7))
  }

  test("createCodeTree() for string 'text'") {
    val chars = string2Chars("text")
    val codeTree = createCodeTree(chars)

    // Expected Huffman tree structure
    val expectedTree = Fork(
      Fork(Leaf('e', 1), Leaf('x', 1), List('e', 'x'), 2),
      Leaf('t', 2),
      List('e', 'x', 't'),
      4
    )

    assert(codeTree === expectedTree)
  }

  // Part 3: Decoding
  test("decode frenchCode") {
    assert(decode(frenchCode, secret) === decodedSecret)
  }

  // Part 4a: Encoding using Huffman tree
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode a long text should be identity") {
    new TestTrees {
      val text: List[Char] = "abdabadaba".toList
      assert(decode(t2, encode(t2)(text)) === text)
    }
  }

  // Part 4b: Encoding using code table
  test("convert t2") {
    new TestTrees {
      val codeTable: CodeTable = convert(t2)
      assert(codeTable === List(('a', List(0, 0)), ('b', List(0, 1)), ('d', List(1))))
    }
  }

  test("mergeCodeTables") {
    val codeTable1: CodeTable = List(('a', List(0, 1)), ('b', List(1, 0)))
    val codeTable2: CodeTable = List(('c', List(1, 1)), ('d', List(0, 0)))
    assert(mergeCodeTables(codeTable1, codeTable2) === List(('a', List(0, 1)), ('b', List(1, 0)), ('c', List(1, 1)), ('d', List(0, 0))))
  }

  test("decode and quickEncode a long text should be identity") {
    new TestTrees {
      val text: List[Char] = "abdabadaba".toList
      assert(decode(t2, quickEncode(t2)(text)) === text)
    }
  }

  test("encode and quickEncode a long text should be identity") {
    new TestTrees {
      val text: List[Char] = "abdabadaba".toList
      assert(encode(t2)(text) === quickEncode(t2)(text))
    }
  }
}

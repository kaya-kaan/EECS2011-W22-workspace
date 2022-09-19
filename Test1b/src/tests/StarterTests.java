package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.ListUtilities;

/*
 * Study carefully the test methods below. They suggest:
 * 	- the required class(es) and method(s) to be implement in the `model` package
 * 	- how the required class(es) and method(s) should be implemented
 * 
 * Requirements:
 * 	+ Do not create any new class that is not required by the starter tests.
 *   
 * 	+ Any classes you create must reside in the `model` package and be imported properly.
 * 		For example, creating a new class `Foo` in the `model` package should result in:
 * 			import model.Foo;
 * 
 * 	+ For this test, you should not need to declare attributes. 
 * 		But if you really want to, all attributes you declare in the model classes must be private.
 * 
 * 	+ If necessary, you may define private helper methods. 
 */

public class StarterTests {
	/* 
	 * Programming Requirements:
	 * 
	 * 	- This test focuses on the manipulation of singly-linked nodes.
	 * 		Therefore, you are forbidden to use primitive arrays (e.g., Integer[], int[], String[]) 
	 * 		for declaring attributes or local variables.
	 * 	- In addition, any use of a Java library class or method is also forbidden 
	 * 		(that is, use selections and loops to build your solution from scratch instead):
	 * 	- Here are some examples of forbidden classes/methods: 
	 * 		- Arrays class (e.g., Arrays.copyOf)
	 * 		- System class (e.g., System.arrayCopy)
	 * 		- ArrayList class
	 * 		- String class (e.g., substring).
	 * 	- The use of some library classes does not require an import statement, 
	 * 		but these classes are also forbidden to be used.
	 * 	- Here are the exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format, length)
	 * 
	 * Violating the above programming requirements will result in a penalty (see the test guide for details). 
	 */  

	@Test
	public void test1() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("a", null);
		Node<String> n3 = new Node<>("c", n4);
		Node<String> n2 = new Node<>("a", n3);
		Node<String> n1 = new Node<>("b", n2);

		/*
		 * For this method, the inputs are:	 
		 *	- `n1`: the head of a non-empty chain of singly-linked nodes 
		 *	- `e`: an element value 
		 *
		 * Assumptions:
		 * 	- Input `n1` is not null.
		 * 	- Input `e` is not null.
		 *  
		 * What does the method do?
		 *  - Return the head node of a chain whose nodes are identical to those in the input chain, except that:
		 *  	+ All nodes storing values that are equal to element `e` are removed. 
		 *  	  This means that the head of the resulting chain may be null, if all nodes happen to be removed.
		 *  	+ Nodes preserve their order as in the input chain.
		 *  
		 * Requirements:
		 * 	- References of the returned chain of nodes should be the same as
		 * 		those contained in the input chain.
		 * 	  That is, your implemented algorithm should not create new nodes.   
		 */
		Node<String> output = util.task(n1, "a"); 
		assertTrue(output == n1);
		assertTrue(output.getNext() == n3);
		assertNull(output.getNext().getNext());

		assertTrue(output.getElement().equals("b"));
		assertTrue(output.getNext().getElement().equals("c"));
	}
	
	@Test
	public void test2() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("a", null);
		Node<String> n3 = new Node<>("c", n4);
		Node<String> n2 = new Node<>("a", n3);
		Node<String> n1 = new Node<>("b", n2);
		
		/*
		 * See the above description of the method. 
		 */
		
		Node<String> output = util.task(n1, "b"); 
		assertTrue(output == n2);
		assertTrue(output.getNext() == n3);
		assertTrue(output.getNext().getNext() == n4);
		assertNull(output.getNext().getNext().getNext());

		assertTrue(output.getElement().equals("a"));
		assertTrue(output.getNext().getElement().equals("c"));
		assertTrue(output.getNext().getNext().getElement().equals("a"));
	}
	
	@Test
	public void test3() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("a", null);
		Node<String> n3 = new Node<>("c", n4);
		Node<String> n2 = new Node<>("a", n3);
		Node<String> n1 = new Node<>("b", n2);
		
		/*
		 * See the above description of the method. 
		 */
		
		Node<String> output = util.task(n1, "c"); 
		assertTrue(output == n1);
		assertTrue(output.getNext() == n2);
		assertTrue(output.getNext().getNext() == n4);
		assertNull(output.getNext().getNext().getNext());

		assertTrue(output.getElement().equals("b"));
		assertTrue(output.getNext().getElement().equals("a"));
		assertTrue(output.getNext().getNext().getElement().equals("a"));
	}
	
	@Test
	public void test4() {
		ListUtilities<String> util = new ListUtilities<>();
		Node<String> n4 = new Node<>("a", null);
		Node<String> n3 = new Node<>("c", n4);
		Node<String> n2 = new Node<>("a", n3);
		Node<String> n1 = new Node<>("b", n2);
		
		/*
		 * See the above description of the method. 
		 */
		
		Node<String> output = util.task(n1, "d"); 
		assertTrue(output == n1);
		assertTrue(output.getNext() == n2);
		assertTrue(output.getNext().getNext() == n3);
		assertTrue(output.getNext().getNext().getNext() == n4);
		assertNull(output.getNext().getNext().getNext().getNext());

		assertTrue(output.getElement().equals("b"));
		assertTrue(output.getNext().getElement().equals("a"));
		assertTrue(output.getNext().getNext().getElement().equals("c"));
		assertTrue(output.getNext().getNext().getNext().getElement().equals("a"));
	}
	
	@Test
	public void test5() {
		ListUtilities<String> util = new ListUtilities<>(); 
		Node<String> n1 = new Node<>("d", null);
		
		/*
		 * See the above description of the method. 
		 */
		
		Node<String> output = util.task(n1, "d"); 
		assertNull(output);
	}
	
	/*
	 * Jackie's suggestions:
	 * 	+ Test more input values of your implemented methods, as they will be graded by additional tests.
	 * 	+ The given starter tests only test string values. Try integer values too.
	 */
}
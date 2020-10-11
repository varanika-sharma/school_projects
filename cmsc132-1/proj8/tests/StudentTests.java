//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor 
//received any unauthorized 
//assistance on this assignment or examination
package tests;

import org.junit.*;

import static org.junit.Assert.*;
import dirGraph.DirGraph;
import java.util.Arrays;
import java.util.List;

/**
 * @author varanikasharma
 *These are testing different methods in the Directed Graph class
 */
public class StudentTests {

	@Test
	public void testPublic1() {
		DirGraph<String> g = TestData.exampleDirGraph1();

		for (String v : Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o"))
			assertTrue(g.isVertex(v));

		// test the return value of createVertex() in the normal case
		assertTrue(g.createVertex("p"));
		assertTrue(g.isVertex("p"));

		assertFalse(g.createVertex("p"));
	}

	// Tests calling isVertex() on an empty graph and on a nonexistent vertex,
	// and calling getVertices() on a graph that contains vertices but no
	// edges.
	@Test
	public void testPublic2() {
		DirGraph<String> graph = new DirGraph<>();

		assertFalse(graph.isVertex("z"));
		graph = TestData.exampleDirGraph1();
		assertFalse(graph.isVertex("z"));

		assertTrue(TestData.compareCollection(
				Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i",
						"j", "k", "l", "m", "n", "o"),
				graph.getVertices()));
	}

	// Tests calling deleteVertexWithEdges()
	@Test
	public void testPublic3() {
		DirGraph<String> g = TestData.exampleDirGraph1();
		int p = 1;

		for (String v : Arrays.asList("a", "c", "e", "g", "i", "k", "m", "o"))
			assertTrue(g.deleteVertexWithEdges(v));

		for (String v : Arrays.asList("a", "b", "c", "d", "e", "f", "g", 
				"h", "i", "j", "k", "l", "m", "n", "o")) {

			if (p % 2 == 1)
				assertFalse(g.isVertex(v));
			else
				assertTrue(g.isVertex(v));

			p++;
		}
	}

	// Tests calling createEdge() and getEdge()

	@Test
	public void testPublic4() {
		DirGraph<Character> g = TestData.exampleDirGraph2(); //
		char[] v = { 'e', 'd', 'u', 'c', 'a', 't', 'i', 'o', 'n' };
		int p;

		for (p = 0; p < v.length - 1; p++)
			assertEquals(1, g.getEdge(v[p], v[p + 1]));
	}

	// Tests calling createEdge()
	@Test
	public void testPublic5() {

		DirGraph<Boolean> graph = new DirGraph<>();

		graph.createVertex(true);
		graph.createVertex(false);
		assertTrue(graph.createEdge(true, false, 131));
		assertFalse(graph.createEdge(false, true, 0));
		assertFalse(graph.createEdge(true, false, 131));
		assertEquals(132, graph.getEdge(true, false));
	}

	// Tests calling getEdge()
	@Test
	public void testPublic6() {
		DirGraph<String> g = TestData.exampleDirGraph3();
		String[] v = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "o" };
		int p, q;

		for (p = v.length - 1; p >= 0; p--)
			for (q = p; q >= 0; q--)
				assertEquals(-1, g.getEdge(v[p], v[q]));
	}

	// Tests calling deleteVertexWithEdges()
	@Test
	public void testPublic7() {
		DirGraph<Integer> g = TestData.exampleDirGraph4();

		assertTrue(g.deleteVertexWithEdges(8));
		assertFalse(g.isVertex(8));
	}

	// Tests calling deleteVertexWithEdges()
	@Test
	public void testPublic8() {
		DirGraph<Integer> graph = TestData.exampleDirGraph4();

		assertTrue(graph.deleteVertexWithEdges(6));
		assertFalse(graph.isVertex(6));
		assertEquals(-1, graph.getEdge(6, 3));
		assertEquals(-1, graph.getEdge(6, 4));
		assertEquals(-1, graph.getEdge(6, 5));
		assertEquals(-1, graph.getEdge(7, 6));
		assertEquals(-1, graph.getEdge(8, 6));
	}

	// Tests calling deleteVertexWithEdges()
	@Test
	public void testPublic9() {
		DirGraph<String> g = TestData.exampleDirGraph1();
		String[] v = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o" };
		String[] nV = { "p", "q", "r", "s", "t", "u", "v", "w", "b", "k" };

		for (String q : v)
			g.deleteVertexWithEdges(q);

		for (String q : v)
			assertFalse(g.isVertex(q));

		for (String q : nV)
			g.createVertex(q);

		for (String q : nV)
			assertTrue(g.isVertex(q));
	}

}
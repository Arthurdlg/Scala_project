package fr.efrei.graphslibrary.unittest.operations

import fr.efrei.graphslibrary.edges.{DirectedEdge, WeightedDirectedEdge, UndirectedEdge, WeightedUndirectedEdge}
import fr.efrei.graphslibrary.graphs.{DirectedGraph, WeightedDirectedGraph, UndirectedGraph, WeightedUndirectedGraph}
import fr.efrei.graphslibrary.operations.BreadthFirstSearch
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BFSUnitTest extends AnyFlatSpec with Matchers {

  "Breadth First Search" should "perform BFS correctly on DirectedGraph" in {
    val graph: DirectedGraph[Int, DirectedEdge[Int]] = new DirectedGraph(Set(1, 2, 3, 4), Set(DirectedEdge(1, 2),
      DirectedEdge(1, 3),
      DirectedEdge(2, 3),
      DirectedEdge(3, 1),
      DirectedEdge(3, 4),
      DirectedEdge(4, 4)))

    val bfsResult = BreadthFirstSearch.apply(graph, 2)
    bfsResult shouldEqual List(2, 3, 1, 4)
  }

  "Breadth First Search" should "perform BFS correctly on WeightedDirectedGraph" in {
    val graph: WeightedDirectedGraph[Int, WeightedDirectedEdge[Int]] = new WeightedDirectedGraph(Set(1, 2, 3, 4, 5, 6, 7), Set(
      WeightedDirectedEdge(1, 2, 1.5),
      WeightedDirectedEdge(2, 4, 3.0),
      WeightedDirectedEdge(2, 5, 0.5),
      WeightedDirectedEdge(4, 6, 8.0),
      WeightedDirectedEdge(4, 7, 2.5),
      WeightedDirectedEdge(1, 3, 5.0)))

    val bfsResult = BreadthFirstSearch.apply(graph, 1)
    bfsResult shouldEqual List(1,2,3,4,5,6,7)
  }

  "Breadth First Search" should "perform BFS correctly on UndirectedGraph" in {
    val graph: UndirectedGraph[Int, UndirectedEdge[Int]] = new UndirectedGraph(Set(1, 2, 3, 4, 5), Set(
      UndirectedEdge(1, 4),
      UndirectedEdge(4, 2),
      UndirectedEdge(5, 4),
      UndirectedEdge(5, 2),
      UndirectedEdge(3, 5)))

    val bfsResult = BreadthFirstSearch.apply(graph, 1)
    bfsResult shouldEqual List(1, 4, 2, 5, 3)
  }

  "Breadth First Search" should "perform BFS correctly on WeightedUndirectedGraph" in {
    val graph: WeightedUndirectedGraph[Int, WeightedUndirectedEdge[Int]] = new WeightedUndirectedGraph(Set(0, 2, 3, 4), Set(
      WeightedUndirectedEdge(0, 1, 1.5),
      WeightedUndirectedEdge(0, 2, 3.0),
      WeightedUndirectedEdge(0, 3, 0.5),
      WeightedUndirectedEdge(1, 2, 8.0),
      WeightedUndirectedEdge(2, 4, 2.5)))

    val bfsResult = BreadthFirstSearch.apply(graph, 0)
    bfsResult shouldEqual List(0,1,2,3,4)
  }
}

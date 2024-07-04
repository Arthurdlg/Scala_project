package fr.efrei.graphslibrary.edges

case class WeightedDirectedEdge[V](from: V, to: V, weight: Double) extends Edge[V] with Weight{
  override def node1: V = from
  override def node2: V = to
  override def toString: String = s"$from ($weight)-> $to"
}

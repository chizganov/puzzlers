package io.github.chizganov.puzzlers.leetcode.may;

import java.util.*;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/">Possible Bipartition problem</a>
 *
 * @author Ev Chizganov
 */
class PossibleBipartition {

    boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, GraphVertex> numToVertex = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            GraphVertex v = new GraphVertex(i);
            numToVertex.put(v.value, v);
        }

        for (int[] edge : dislikes) {
            GraphVertex v1 = numToVertex.get(edge[0]);
            GraphVertex v2 = numToVertex.get(edge[1]);
            v1.adjVertices.add(v2);
            v2.adjVertices.add(v1);
        }

        return isColorable(numToVertex.values());
    }

    private boolean isColorable(Collection<GraphVertex> vertices) {
        for (GraphVertex vertex : vertices) {
            if (vertex.color == Color.UNCOLORED && !dfsColorable(vertex, Color.WHITE)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean dfsColorable(GraphVertex vertex, Color currentColor) {
        if (vertex.color == Color.UNCOLORED) vertex.color = currentColor;
        else return vertex.color == currentColor;

        Color nextColor = currentColor == Color.WHITE ? Color.BLACK : Color.WHITE;
        for (GraphVertex adjV : vertex.adjVertices) {
            if (!dfsColorable(adjV, nextColor))
                return false;
        }
        return true;
    }

    private static final class GraphVertex {

        private final int value;
        private Color color = Color.UNCOLORED;
        private final List<GraphVertex> adjVertices = new LinkedList<>();

        GraphVertex(int value) {
            this.value = value;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GraphVertex graphVertex = (GraphVertex) o;
            return value == graphVertex.value;
        }

        @Override public int hashCode() {
            return Objects.hash(value);
        }

    }

    private enum Color {
        WHITE,
        BLACK,
        UNCOLORED
    }

}

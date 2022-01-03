package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfs(i, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int curNode, int[] color, int[][] graph) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(curNode);
        color[curNode] = 0;
        int curColor = 0;

        while (!que.isEmpty()) {
            int node = que.remove();
            curColor = color[node] == 0 ? 1 : 0;
            int[] adjNodes = graph[node];
            for (int adjNode : adjNodes) {
                if (color[adjNode] == -1) {
                    color[adjNode] = curColor;
                    que.add(adjNode);
                } else {
                    if (color[adjNode] != curColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsBipartite().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }
}

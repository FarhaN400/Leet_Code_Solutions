
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, parent, s, tree, newTree, last);

        int[] ans = new int[n];
        count(0, newTree, ans);

        return ans;
    }

    private void dfs(int node, int[] parent, String s,
                     List<Integer>[] tree,
                     List<Integer>[] newTree,
                     int[] last) {

        int ch = s.charAt(node) - 'a';
        int prev = last[ch];

        if (node != 0) {
            int p = (prev == -1) ? parent[node] : prev;
            newTree[p].add(node);
        }

        last[ch] = node;

        for (int child : tree[node]) {
            dfs(child, parent, s, tree, newTree, last);
        }

        last[ch] = prev;
    }

    private int count(int node,
                      List<Integer>[] tree, int[] ans) {
        int size = 1;

        for (int child : tree[node]) {
            size += count(child, tree, ans);
        }

        ans[node] = size;
        return size;
    }
}

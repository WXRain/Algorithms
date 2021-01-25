package medium;

public class RegionsBySlashes959 {
    private class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int index) {
            while (index != parent[index]) {
                index = parent[index];
            }
            return index;
        }

        public void merge(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            parent[pRoot] = qRoot;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        UnionFind uf = new UnionFind(4 * len * len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int start = (i * len + j) * 4;
                switch (grid[i].charAt(j)) {
                    case ' ':
                        uf.merge(start, start + 1);
                        uf.merge(start + 2, start + 3);
                        uf.merge(start, start + 2);
                        break;
                    case '/':
                        uf.merge(start, start + 3);
                        uf.merge(start + 2, start + 1);
                        break;
                    case '\\':
                        uf.merge(start, start + 1);
                        uf.merge(start + 3, start + 2);
                        break;
                }
                if (i > 0) {
                    uf.merge(start, start - 4 * len + 2);
                }
                if (j > 0) {
                    uf.merge(start + 3, start - 3);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < uf.parent.length; i++) {
            if (i == uf.parent[i]) {
                count++;
            }
        }
        return count;
    }
}

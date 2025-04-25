import java.util.Scanner;

public class J {
    public static class UnionFind {
        private int size;
        private int[] sz;
        private int[] id;
        private int numComponents;

        public UnionFind(int size) {
            this.size = numComponents = size;
            id = new int[size];
            sz = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
                sz[i] = i;
            }
        }

        public int find(int p) {
            int root = p;
            while (root != id[root]) root = id[root];
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }

        public int componentSize(int p) {
            return sz[find(p)];
        }

        public int getSize() {
            return size;
        }

        public int components() {
            return numComponents;
        }

        public void unify(int p, int q) {
            if (connected(p, q)) return;

            int root1 = find(p);
            int root2 = find(q);

            if (sz[root1] < sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
                sz[root1] = 0;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
                sz[root2] = 0;
            }
            numComponents--;
        }
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        int[][] islas;

        for (int i = 0; i < numCasos; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            islas = new int[n][m];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    islas[j][k] = sc.nextInt();
                }
            }

            UnionFind u = new UnionFind(n*m+1);

            for (int j = 0; j < n; j++) { // filas
                for (int k = 0; k < (m - 1); k++) {
                    if (islas[j][k] == 0) {
                        u.unify(0, j * m + k);
                    }
                    if (islas[j][k] == 1 && islas[j][k+1] == 1) {
                        u.unify(j * m + k, j * m + k + 1);

                    }
                }
            }

            //for (int j = 0; j < n; j++) {
            //    for (int k = 0; k < (m - 1); k++) {
            //        if (islas[k][j] == 1 && islas[k+1][j] == 1) {
            //            u.unify(j * m + k, j * m + k + 1);
            //        }
            //    }
            //}

            System.out.println(u.components());
        }
    }
}

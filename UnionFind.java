public class UnionFind {

    int[] set;
    int[] size;
    int count;
    int groupCount;

    public UnionFind(int count) {
        set = new int[count];
        size = new int[count];
        this.count = count;
        this.groupCount = count;
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        int root = set[p];
        while (root != set[root]) {
            root = set[root];
        }
        int tmp = set[p];
        while (tmp != set[tmp]) {
            int t = set[tmp];
            set[tmp] = root;
            tmp = t;
        }
        return root;
    }

    public void union(int p, int q) {
        if(p>=count||q>=count){
            throw new IllegalArgumentException();
        }
        int proot = find(p);
        int qroot = find(q);
        if(proot!=qroot){
            groupCount--;
        }
        if(proot==qroot){
            return;
        }
        if (size[proot] >= size[qroot]) {
            for (int i = 0; i < count; i++) {
                if (set[i] == qroot) {
                    set[i] = proot;
                    size[qroot]--;
                    size[proot]++;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (set[i] == proot) {
                    set[i] = qroot;
                    size[proot]--;
                    size[qroot]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        UnionFind x=new UnionFind(10);
        x.union(1,2);
        x.union(3,4);
        x.union(5,6);
        x.union(6,2);
        x.union(5,1);
        int group=x.find(1);
        for (int i:x.set
             ) {
            System.out.print(i+" ");
        }
        System.out.println("\n"+group+"\n"+x.groupCount);
    }

}

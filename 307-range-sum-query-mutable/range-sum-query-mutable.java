class NumArray {
int[] tree;
    int n;

    public NumArray(int[] arr) {
         n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    int query(int node, int start, int end, int l, int r) {
        // No overlap
        if (r < start || end < l) return 0;

        // Complete overlap
        if (l <= start && end <= r) return tree[node];

        // Partial overlap
        int mid = (start + end) / 2;

        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);

        return left + right;
    }
    void updatearr(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;

            if (idx <= mid)
                updatearr(2 * node + 1, start, mid, idx, val);
            else
                updatearr(2 * node + 2, mid + 1, end, idx, val);

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void update(int idx, int val) {
        updatearr(0,0,n-1,idx,val);
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n - 1, left, right);
    }
}
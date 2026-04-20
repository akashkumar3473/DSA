class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        build(nums,0,n-1,0);
    }
     private void build(int[] nums, int lo, int hi, int node) {
        if (lo == hi) {
            tree[node] = nums[lo];
            return;
        }
        int mid = (lo+hi)/2;
        build(nums,lo,mid,2*node+1);
        build(nums,mid+1,hi,2*node+2);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }

    
    public int sumRange(int left, int right) {
        return query(0,n-1,left,right,0);
    }
    public int query(int lo, int hi ,int L,int R, int node){
        if(hi<L || lo>R){
            return 0;
        }
        if(lo>=L && hi<=R){
            return tree[node];
        }
        int mid = (lo+hi)/2;
        int leftsum = query(lo,mid,L,R,2*node+1);
        int rightsum = query(mid+1,hi,L,R,2*node+2);
        return leftsum + rightsum;
    }
}

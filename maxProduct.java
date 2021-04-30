class Solution {
    public int maxProduct(int[] nums) {
        int[] pos=new int[nums.length];
        int[] neg=new int[nums.length];
        pos[0]=nums[0];
        neg[0]=nums[0];
        int ans=nums[0];
        for (int i=1;i<nums.length;i++) {
            if (nums[i]>0) {
                pos[i]=Math.max(nums[i],nums[i]*pos[i-1]);
                if (pos[i]>ans) ans=pos[i];
                neg[i]=nums[i]*neg[i-1];
            } else {
                pos[i]=nums[i]*neg[i-1];
                if (pos[i]>ans) ans=pos[i];
                neg[i]=Math.min(nums[i]*pos[i-1],nums[i]);
            }
            
        }
        return ans;
    }
}

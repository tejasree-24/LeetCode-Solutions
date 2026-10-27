class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       int m = nums1.length;
       int n = nums2.length;

       int[] nums = new int[m + n];

       System.arraycopy(nums1, 0, nums, 0, m);
       System.arraycopy(nums2, 0, nums, m, n);

       Arrays.sort(nums);


       int len = nums.length;
       int mid = len / 2;

         if (len % 2 == 1){
            return nums[mid];
         }

         return (nums[mid - 1] + (double) nums[mid]) / 2;
    }
}
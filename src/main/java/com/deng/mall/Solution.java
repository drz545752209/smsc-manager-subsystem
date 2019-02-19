package com.deng.mall;



public  class  Solution{
    static Boolean can=false;
    public static  void  jump(int[] nums,int step){
          if (step>=nums.length){
              can=true;
              return;
          }else if (nums[step]==0){
              return;
          }
          jump(nums,nums[step]+step);
    }

    public static   boolean canJump(int[] nums) {
         jump(nums,1);
          return can;
    }

    public static void main(String[] args) {
        int nums[]={3,2,1,0,4};
        canJump(nums);
        System.out.println(can);
    }
}
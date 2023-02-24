public class Leetcode540 {

    public static void main(String[] args) {
        int [] nums = {1,1,2,3,3,4,4,8,8};
        int [] nums2 = {3,3,7,7,10,11,11};

        System.out.println(singleNonDuplicate(nums));
    }
    // 540. Single Element in a Sorted Array
    // https://leetcode.com/problems/single-element-in-a-sorted-array/description/
    // 12233, 11233, 11223을 보고 규칙성을 찾자. 예외케이스로 원소1개 배열
        public static int singleNonDuplicate(int[] nums) {
            int left = 0;

            if(nums.length == 1) { // 1
                return nums[0];
            }


                while(left+1 < nums.length){

                    if(nums[left] == nums[left+1]) { // 5~
                        left = left+2;
                    }else {
                        return nums[left];
                    }
                }
            return nums[nums.length-1]; // 배열을 초과할때까지 못찾았다면 마지막 값이 정답. ex)11223
        }

}



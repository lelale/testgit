

public class SolutionLeetCode {
    public int peakFind(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] nums = {18,9};
        SolutionLeetCode solution = new SolutionLeetCode();
        int peak = solution.peakFind(nums);
        System.out.println(nums[peak]);

    }

}


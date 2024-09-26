package sep_26;

public class MoveZeros {
    static void fun1(int[] nums) {
        long starttime = System.nanoTime();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + " nanoseconds");

    }

    static void fun2(int[] nums) {
        long starttime = System.nanoTime();
        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }
        if (firstZeroIndex == -1) {
            return;
        }
        for (int i = firstZeroIndex + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[firstZeroIndex];
                nums[firstZeroIndex] = temp;
                firstZeroIndex++;
            }
        }
        long endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - starttime) + " nanoseconds");
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 1, 0, 0, 3, 12 };
        fun1(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        fun2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}

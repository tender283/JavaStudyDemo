package interview.practice;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ViewTest {
    //1)、给定⼀个整数数组 nums 和⼀个⽬标值 target;
    //2)、请你在该数组中找出和为⽬标值的那两个数，并返回他们数组下标;
    //3)、你可以假设每种输⼊只会对应⼀个答案;
    //4)、但是不能重复利⽤这个数组中同样的元素;
    //示例：
    //给定 nums = [2, 7, 11, 15], target = 9；
    //因为 nums[0] + nums[1] = 2 + 7 = 9；
    //所以返回 [0, 1]；


    //在数组环节的练习(Arrays);
    //方法一：最笨的方法(效率最低)；

    public int[] twoSum1(int[] nums, int target){
        int times = 0;
        for(int index = 0; index < nums.length - 1; index ++)
            for(int twoIndex = index + 1; twoIndex < nums.length; twoIndex ++) {
                times++;
                if (nums[index] + nums[twoIndex] == target) {
                    System.out.println("循环" + times + "次");
                    //为什么用new建立数组？
                    return new int[]{index, twoIndex};
                }
            }
            System.out.println("循环" + times + "次");
            return null;
    }
    //方法二：效率高一点；
    public int[] twoSum2(int[] nums, int target) {
        //运行前提是数组都是正数时，才可以如此的判断运行；
        System.out.println("传入数组" + Arrays.toString(nums));
        //Arrays.sort()是什么样的排序方式？
        Arrays.sort(nums);
        System.out.println("排序数组" + Arrays.toString(nums));
        int times = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] >= target) {
                System.out.println("第一个数(" + index + ")" + nums[index] + "已经大于目标值" + target + "，返回不存在");
                System.out.println("循环" + times + "次");
                return null;
            }
            for (int twoIndex = 0; twoIndex < nums.length; twoIndex++) {
                times++;
                //下一行代码，不是>=的原因是nums[index]可能为0；
                if (nums[twoIndex] > target) {
                    break;
                    //break到底是跳出哪里的循环？？(应该是大的for循环)；
                }
                if (nums[index] + nums[twoIndex] == target)
                    return new int[]{index, twoIndex};
            }
        }
        System.out.println("循环" + times + "次");
        return null;
    }

    @Test
    public void testTwoSum(){
        int[] intArray = {20, 7, 30, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(intArray, target)));
        System.out.println("==========================================");
        System.out.println(Arrays.toString(twoSum2(intArray, target)));
    }
}

package aed.analisecomplexidade.algoritmos;

import java.util.Arrays;

public class Maximo {

    public static int execute(int... nums) {

        if (nums.length == 0)
            throw new IllegalArgumentException("tem que haver pelo menos um valor para haver maximo");

        int maxindex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxindex])
                maxindex = i;
        }
        return nums[maxindex];
    }

    public static void show(int... nums) {
        try {
            int max = execute(nums);
            System.out.println("maximo(" + Arrays.toString(nums) + ") = " + max);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
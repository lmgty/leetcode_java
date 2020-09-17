/**
 * @author LiuYe
 * @date 2020/9/17 9:12 下午
 */
public class ContainerWithMostWater11 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = new ContainerWithMostWater11().maxArea(ints);
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int currWidth = 0;
        int currHeight = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            currWidth = j - i;
            currHeight = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, currHeight * currWidth);
            if (height[i] > height[j]){
                j--;
            }else {
                i++;
            }
        }
        return maxArea;
    }
}

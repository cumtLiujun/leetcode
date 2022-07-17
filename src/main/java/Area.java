import java.lang.reflect.Array;

public class Area {

    //    public int maxArea(int[] height) {
//        int begin = 0, end = height.length-1;
//        int res = area(height[begin],height[end], end - begin);
//        while (begin < end) {
//            int are1 = area(height[begin+1],height[end], end - begin -1);
//            int are2 = area(height[begin],height[end -1], end - begin -1);
//            int are = Math.max(are1,are2);
//            res = Math.max(are, res);
//            begin++;
//            end--;
//        }
//
//        return res;
//    }
//
//    public int area(int left, int right, int high){
//        int width = Math.min(left, right);
//        return width * high;
//    }
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }




    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Area area = new Area();
        System.out.println(area.maxArea(height));
    }
}

import java.util.ArrayList;

/**
 * @author LiuYe
 * @data 2020/9/10
 */
public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();






        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();

    }




    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        String newStr = new ZigZagConversion6().convert(s, numRows);
        assert "LCIRETOESIIGEDHN".equals(newStr);



        s = "LEETCODEISHIRING";
        numRows = 4;
        newStr = new ZigZagConversion6().convert(s, numRows);
        assert "LDREOEIIECIHNTSG".equals(newStr);
    }
}

import java.util.ArrayList;

/**
 * @author LiuYe
 * @data 2020/9/10
 */
public class ZigZagConversion6 {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        ArrayList<StringBuilder> rows = new ArrayList<>();
        int rowsCount = Math.min(s.length(), numRows);
        for (int i = 0; i < rowsCount; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows-1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }


        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String newStr = new ZigZagConversion6().convert(s, numRows);
        assert "AB".equals(newStr);

        s = "LEETCODEISHIRING";
        numRows = 3;
        newStr = new ZigZagConversion6().convert(s, numRows);
        assert "LCIRETOESIIGEDHN".equals(newStr);


        s = "LEETCODEISHIRING";
        numRows = 4;
        newStr = new ZigZagConversion6().convert(s, numRows);
        assert "LDREOEIIECIHNTSG".equals(newStr);
    }
}

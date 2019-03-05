/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (30.47%)
 * Total Accepted:    288.5K
 * Total Submissions: 939.8K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * TOP LINE IS 0 + 2(R-1)
 * 
 * SECOND LINE IS 1 + 2 4 6 8 10     STEPS = 2(R-1)-2 MOD 2(R-1)      &&         2-2(R-1) MOD 2(R-1)
 * 
 * LST 2 + (R-1)
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * TOP LINE IS 0 + 2(R-1)
 * SECOND LINE IS 1 + 0 4 6 10 12    STEPS = 2(R-1)-2 MOD 2(R-1)      &&         2-2(R-1) MOD 2(R-1)
 * 
 * 
 * THIRD LINE IS 2 + 0 2 6 8 12      
 * LAST 3 + 2(R-1)
 * 
 * P      H
 * A    S I
 * Y  I   R
 * P L    I G
 * A      N
 * 
 * TOP LINE IS 0 + 2(R-1)
 * SECOND LINE IS 1 + 0 6 8 14       STEPS = 2(R-1)-2 MOD 2(R-1)       &&         2-2(R-1) MOD 2(R-1)
 * 
 * THIRD LINE IS 2 + 4 8 12 16 20    STEPS = 2(R-1)-4 MOD 2(R-1)       &&         4-2(R-1) MOD 2(R-1)
 * 
 * 
 * FOURTH LINE IS INVERSE OF SECOND: 3 + 0 2 8 10 16
 * LASR 4 + 2(R-1)
 *
 * Math.ceil(R/2)
 *
 */

// For each line L => F(L) = L + 


class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int cycle = 2 * (numRows - 1);
        StringBuffer output = new StringBuffer();

        int row = 0;
        while(row < numRows) {
            boolean isEven = true;
            int firstStep = cycle - row * 2 % cycle;
            int secondStep = row * 2 - cycle % cycle;
            firstStep = firstStep == 0 ? cycle : firstStep;
            secondStep = secondStep == 0 ? cycle : secondStep;

            int i = 0;
            while (row + i < s.length()) {
                output.append(s.charAt(row + i));
                i += isEven ? firstStep : secondStep;
                isEven = !isEven;
            }

            row++;
        }
        
        return output.toString();
    }
}

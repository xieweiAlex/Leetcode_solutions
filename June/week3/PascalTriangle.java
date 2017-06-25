package June.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex_Xie on 12/06/2017.
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 https://leetcode.com/problems/pascals-triangle/#/description
 */
public class PascalTriangle {

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> allRows = new ArrayList();
        List<Integer> row = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            // add (index, ele) means insert
            row.add(0, 1);

            for(int j = 1; j < row.size() - 1; j++) {
                // set(index, ele) means replace
                row.set(j, row.get(j) + row.get(j+1) );
            }
            allRows.add(new ArrayList<>(row));
        }
        return allRows;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();
        if (numRows <= 0) return allRows;

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {

                    row.add(1);
                } else {
                    List<Integer> preRow = allRows.get(i-1);
                    row.add( preRow.get(j-1) + preRow.get(j) );
                }
            }
            allRows.add(row);
        }
        return allRows;
    }

}

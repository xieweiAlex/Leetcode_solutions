package November.week1;


/*
We have an organization and need to print an org chart in the terminal.

The input is a list of strings.

Each string is a management / direct report relationship Example: "A1,B2,C3,D4"
Explanation: A1 is the manager of B2, C3, D4, where A1, B2, C3, D4 are unique employee IDs separated by comma.

An org chart is a list of strings like above. Example of an org chart "B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"

The output is a terminal representation of the org chart, such as


A1
      B2
            E5
            F6
      C3
      D4
            G7
                   H8
           I9

B2, A1, D4, G7

INPUT: an array of strings "B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintOrganise {

    public static void printOrganise(String[] strings) {

        Map<String, List<String>> managerMap = new HashMap<>();
        for (String str: strings) {

            String[] list = str.split(",");
            String manager = list[0];
            List<String> eList = Arrays.asList(list);
            List<String> reporters = eList.subList(1, eList.size());

            managerMap.put(manager, reporters);
        }

        Map<String, Integer> employeMap = new HashMap<>();
        for (String str: strings) {
            String[] list = str.split(",");
            for (String employee: list) {
                employeMap.put(employee, employeMap.getOrDefault(employee, 0) + 1);
            }
        }

        String rootManager = null;
        for (Map.Entry<String, Integer> entry :employeMap.entrySet()) {
            if (entry.getValue() == 1 && managerMap.containsKey(entry.getKey())) {
                rootManager = entry.getKey();
            }
        }

        if (rootManager == null) {
            System.out.println("There isn't any root manager");
            return;
        }

        System.out.println(rootManager);
        printEmployee(managerMap.get(rootManager), managerMap, 1);
    }

    private static void printEmployee(List<String> employess, Map<String, List<String>> managerMap, int level) {

        for (String employee: employess) {
            myPrintSpaces(level);
            System.out.println(employee);

            if (managerMap.containsKey(employee)) {
                printEmployee(managerMap.get(employee), managerMap, level + 1);
            }

        }

    }

    private static void myPrintSpaces(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
    }

    public static void main(String[] args) {


        String[] strings = new String[]{"B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"};
        printOrganise(strings);

    }


}

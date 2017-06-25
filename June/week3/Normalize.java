package June.week3;

/**
 * Created by Alex_Xie on 14/06/2017.

 All single dot components of the path must be removed. For example, "foo/./bar" should be normalized to "foo/bar".
 All double dot components of the path must be removed, along with their parent directory. For example, "foo/bar/../baz" should be normalized to "foo/baz".
 For any paths starting with ".." string, assume you are in the root directory. For example, "../foo/bar" normalizes to "/foo/bar".
 That's it. Normally, a path normalization algorithm would do a lot of other stuff, but for this question, don't try any other kind of normalization or transformation of the path.
 */
public class Normalize {


    public String normalizeStr(String str) {
        if (str == null) {
            return "";
        }

        String forRootStr = "..";
        if (str.startsWith(forRootStr)) {
            str = str.substring(forRootStr.length(), str.length()-1);
        }

        String[] paths = str.split("/");
        StringBuilder sb = new StringBuilder();
        Boolean shouldSkip = false;

        for (int i = 0; i < paths.length; i++) {
            String ele = paths[i];
            if (ele.equals("..")) {
                if (i > 0) {
                    i--;
                    continue;
                }
            }

            if (ele.equals(".")) {
                continue;
            }
            if (shouldSkip) {
                continue;
            }
            if (ele.equals("..")) {
                i--;
                shouldSkip = true;
                continue;
            }

            sb.append("/" + ele);

        }



        return str;
    }

}

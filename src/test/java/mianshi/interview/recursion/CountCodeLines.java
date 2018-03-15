package mianshi.interview.recursion;

import java.io.*;

public class CountCodeLines {

    public static void main(String[] args) {
        CountCodeLines countCodeLines = new CountCodeLines();
        String path = "F:\\java\\sell\\src";
        System.out.println(path);
        int count = countCodeLines.getFiles(path, 0);
        System.out.print(count);
    }

    private int getFiles(String path, int count) {
        File file = new File(path);
        if (!file.exists() || file.listFiles().length == 0) {
            return count;
        }

        for (File file1 : file.listFiles()) {
            int s = 0;
            if (file1.isDirectory()) {
                count = getFiles(file1.getAbsolutePath(), count);
            } else {
                System.out.print(file1.getAbsolutePath());
                if (!file1.getName().endsWith(".java")) {
                    return count;
                }
                try {
                    LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file1)));
                    while (lineNumberReader.readLine() != null) {
                        count++;
                        s++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(" count：" + s);

            }
        }

        return count;
    }
}

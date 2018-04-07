package com.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToWebp {
  public static void main(String[] args) throws IOException, InterruptedException {
    String src = null;
    String dest = null;
    String quality = "80";
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-i")) {
        src = args[i + 1];
      }
      if (args[i].equals("-o")) {
        dest = args[i + 1];
      }
      if (args[i].equals("-q")) {
        quality = args[i + 1];
      }
    }
    File srcPath = new File(src);
    ProcessBuilder builder = new ProcessBuilder();
    builder.redirectErrorStream(true);
    Process p = null;
    for (final File fileEntry : srcPath.listFiles()) {
      if (fileEntry.isFile()) {
        if (fileEntry.getName().endsWith(".jpg") || fileEntry.getName().endsWith(".jpeg")
            || fileEntry.getName().endsWith(".png") || fileEntry.getName().endsWith(".gif")
            || fileEntry.getName().endsWith(".bmp") || fileEntry.getName().endsWith(".tif"))
          builder = new ProcessBuilder("cwebp", "-q", quality, fileEntry.getAbsolutePath(), "-o",
              dest + "/" + fileEntry.getName().substring(0, fileEntry.getName().lastIndexOf("."))
                  + ".webp");
        builder.redirectErrorStream(true);
        System.out.println(fileEntry.getName());
        p = builder.start();
        p.waitFor();
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        lineReader.lines().forEach(System.out::println);
      }
    }
  }
}

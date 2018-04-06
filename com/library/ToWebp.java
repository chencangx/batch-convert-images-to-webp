package com.library;

import java.io.File;
import java.io.IOException;

public class ToWebp {
  public static void main(String[] args) throws IOException {
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
    for (final File fileEntry : srcPath.listFiles()) {
      builder = new ProcessBuilder("cmd", "/c", "cwebp", "-q", quality, fileEntry.getAbsolutePath(),
          "-o", dest + "/" + fileEntry.getName().substring(0, fileEntry.getName().lastIndexOf("."))
              + ".webp");
      System.out.println(fileEntry.getName());
      builder.start();
    }
  }
}

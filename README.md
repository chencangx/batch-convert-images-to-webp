# batch-convert-images-to-webp
Batch convert images to webP in one directory  
- You should add cwebp's bin directory to environment variable path and install jre on your os.
- for linux you can also use the following command:
  ```bash
  $ for file in *
  do
  cwebp -q 80 "$file" -o "$file.webp"
  done
  ```
- -i: source directory.
- -o: output directory.
- -q: specify quality,default is 80.

Commandline:
`java -jar ToWebp.jar -q 90 -i /source -o /dest`

- 需要将cwebp的bin目录加入环境变量
- 需要在电脑上安装jre环境
- -i: 源文件夹
- -o: 目标文件夹
- -q: 设置质量值(0~100),默认为80
- 命令行示例:
  `java -jar ToWebp.jar -q 90 -i /source -o /dest`

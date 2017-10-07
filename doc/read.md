主机IP：120.77.83.207
用户： root  Jiying2016
       master 123456
mysql: root  123456
       进入mysql命令行模式指令  ->  mysql

项目打包：首先在idea中打开maven视图 然后找到Lifecycle 点击package。项目
自动打包，打包结构放在target目录下面。然后你将该后缀为.war包拷到服务器中

运行项目指令：nohup java -jar xxx.war > xxx.out &
xxx.out 是程序的输出文件

**建议了解 XShell和XFtp的 使用**

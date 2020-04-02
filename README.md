# tacos
sia5,练手迷你项目
本文档是对于在实际使用《Spring In Action 5》的过程中，针对基本的版本更新导致的操作不匹配，以及使用IntelliJ IDEA作为IDE开发时具体操作的修正。
我将以“P页码：说明”的方式，将我在书上的笔记在这里进行备份。

P21:
如何正确配置Tomcat
File->项目结构->Artifacts->+->修改out为Tomcat/webapps
build/rebuild
run->Edit配置->deployment->添加并配置Tomcat
备注：之前无法运行的一部分原因是没有“servlet注册器.java”文件，项目构建时选择war而不是jar即可解决。

P29：
IDEA有EditStarter插件
在pom.xml的dependencies中右键，
点击Generate，然后进行搜索即可。

P56:
spring-boot-starter-jdbc(JDBC API)
应该替换为
spring-boot-starter-data-jdbc(Spring.data.jdbc)

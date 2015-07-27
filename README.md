# WHAT

A very simple web application exercising Maven modules, Struts, [MyBatis](https://mybatis.github.io/mybatis-3/) and [Log4j2](http://logging.apache.org/log4j/2.x/).


## MyBatis 3.0
MyBatis is a very conveniant persistance mapper. The beauty of MyBatis is that it does not try to hide the SQL from you. All SQL statements are conveniently grouped in xml files and you have complete control on it. You can make as simple or as complex SQL statement as you like with MyBatis providing control structure like `if` and `loop`, and variables subtitutions.

For a quick sample of what MyBatis can do for you, see the following files: [mybatis-config.xml](TMS25/TMS25-core/src/main/resources/zc/study/struts1/persistance/mybatis-config.xml), [CadeauMapper.xml](TMS25/TMS25-core/src/main/resources/zc/study/struts1/persistance/CadeauMapper.xml), [CadeauMapper.java](TMS25/TMS25-core/src/main/java/zc/study/struts1/persistance/CadeauMapper.java)

## Log4j2
Log4j2 is right now the most powerfull and versatil logging api.
To quickly see what log4j can do, see: [log4j2.xml](TMS25/TMS25-web/src/main/resources/log4j2.xml)
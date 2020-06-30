# 1、什么是StudentCampusWebsite

### ①StudentCampusWebsite项目是一款在线访问的学生校园网站，提供了番禺职业技术学院在校学生们日常所关注的信息服务，为学生们构建一个互相交流的平台或节点。

![image-20200629093518351](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629093518351.png)

### ②StudentCampusWebsite项目平台致力于为学生提供最便利舒适的活动交流性站点

- 在这里，不仅记录了学生们日常生活中的光彩时刻。

![image-20200629094059013](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629094059013.png)![image-20200629094124514](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629094124514.png)



- 同时也记录了学生们努力的成果。



![image-20200629094211651](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629094211651.png)

- 更是向学生们展现了校方在背后为学生们默默努力的成果。

  ![image-20200629094544539](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629094544539.png)![image-20200629094639115](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629094639115.png)



### ③为师生提供最便利的生活方式

- 提供最近的二手站点服务，让学生们在校内零距离购物。

![image-20200629094915463](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629094915463.png)

- 提供最方便交流的社交平台

![image-20200630105240260](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200630105240260.png)

---

# 2、所使用的技术

### 前端技术

- HTML
  - 用于编写网页的基本骨架
- CSS
  - 用于为网页骨架添加样式
- JavaScript
  - 为网页骨架节点添加行为功能
- JQuery库
  - 提升开发效率
- AJAX技术
  - 异步地与后端进行交互、收发数据
- Vue框架
  - 分离网页行为的view层与model层，使网页的开发结构更为清晰



### 后端技术

- JAVA
  - 提供基本的代码编程语言
- Maven项目管理工具
  - 方便于开发人员对java包依赖及依赖版本的合理控制
- mysql 5.7
  - 存储整个站点所需的服务数据
- mybatis框架
  - 提供开发人员较为便利的半自动化持久层框架
- Spring框架
  - 为代码依赖的解耦提供了极大的帮助，使得后期的平台维护较为轻松
- SpringMVC框架
  - 为站点访问提供拦截或过滤等功能，可以迅速的阻止恶意的非法访问，使开发较为轻松的制定访问策略
- Apache Tomcat Server
  - Apache一款十分优秀且功能十分强大的开源服务器

---

# 3、架构

### 前后端分离

- 该项目采用的并非传统的JSP开发，由于这种开发模式要求开发人员拥有较强的前后端开发知识与经验，门槛较高，且前后端的代码耦合在一起，代码难以维护。
- 前后端分离的开发模式已成为主流的开发模式，开发团队应与时俱进。

### MVVM架构

- 前端的架构模式是直接照应Vue的设计理论来进行项目编写的，由于MVVM直接使得view与model很巧妙地分离了，且由于网页需要通过AJAX与后端交互，因为此处的交互行为可直接嵌入model层而不与view发生关系。因而巧妙地达成了解耦的效果。

### MVC架构

- 后端SSM框架直接采用的较为流行的MVC架构，对整个后端构建进行了系统的管理。
- 持久层由mybatis进行加持，不仅支持事务控制，而且由于本身是半自动化，不像Hibernate那样属于全自动化的持久层框架，所以对开发人员的可定制性大大增强。
- 业务层可用Spring来进行service与service之间的解耦，通过AOP与依赖注入，动态地对代码进行切割与装配，使得代码结构有条理，便于维护。
- 控制层采用Spring Framework下的一个子框架Spring MVC对整个web的url访问进行控制，通过SpringMVC，可由开发者定制web访问的servlet是服务器默认的还是SpringMVC默认的，甚至可以是自定义的第三方servlet控制器。极大程度地向开发者表示了友好。

### 前后端交互

- 前端采用AJAX对后端的数据进行收发，甚至前端可以不用知道后端是用哪种编程语言实现的，只需要通过异步地收发数据即可做到交互。
- 后端直接通过SpringMVC对前端的数据进行接收并处理，让转发、重定向、加工数据、返回数据等后台处理过程简单易用。

---

# 4、开发人员简介

## BinGCU							![image-20200629122138134](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/image-20200629122138134.png)

- 负责此次项目的整个后端以及AJAX交互的所有相关代码，同时提供整个站点中的几个小页面，以丰富整个站点的跳转。
- 个人**博客**：`https://bingcumao.github.io/`



## 颓废猫							![db0ba796c0036fba1459af2c1584a5b](https://github.com/BingCUMaO/StudentCampusWebsite/tree/master/README/db0ba796c0036fba1459af2c1584a5b.png)

- 负责此次项目的几乎整个站点的网页编写及UI设计，对实现与用户交互式的网页提供了许多细节，同时实现了较为成功的响应式网页开发模式，使得网页的收缩能够自适应。

---

# 5、存在的问题

### 1）目前的项目版本是StudentCampusWebsite version 1.0 ， 其中存在这很多bug急需修复，比如个别功能由于人手、时间的不足，而暂且未能实现相应的功能。

### 2）构建项目前期，未能够考虑到并发量高的状况，若出现多人同时访问该站点时，定会给用户带来较差的用户体验。

### 3）在团队开发对接时，由于开发人数较少，未考虑到前后端所互相对接的接口的重要性，导致后期开发时，糅余代码的普遍存在，导致代码分类时过于随意，而没有统一的团队开发标准。






















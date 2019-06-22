# 对话式教学微信小程序后端
## 陈雷远（撰），谢东方（改）

+ 后端ip地址: http://47.102.201.65:18081
+ 后端说明文档地址: https://www.showdoc.cc/379113643189792?page_id=2197030605969803

### 1. 项目组织及文件说明
```
│          
|——db
│     adweb_project.sql                                 数据库建表sql语句
│      
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com.adweb.adweb
│  │  │          │  AdWebApiApplication.java     入口类
│  │  │          │  
│  │  │          ├─controller
│  │  │          │      CollectionController.java       收藏相关的api
│  │  │          │      CourseController.java           课程相关的api
│  │  │          │      NoteController.java             笔记内容相关的api
│  │  │          │      SectionController.java          章节相关的api
│  │  │          │      StudentController.java          学习相关的api
│  │  │          │      
│  │  │          ├─dao
│  │  │          │      QuestionAnswerDao.java          答案的数据访问对象
│  │  │          │      ChapterDao.java                 章节的数据访问对象
│  │  │          │      KnowledgeDao.java               知识点的数据访问对象
│  │  │          │      CourseDao.java                  课程的数据访问对象
│  │  │          │      NoteDao.java                    笔记的数据访问对象
│  │  │          │      OptionDao.java                  问题选项的数据访问对象
│  │  │          │      CourseSelectionDao.java         选课的数据访问对象
│  │  │          │      StudentDao.java                 学生的数据访问对象
│  │  │          │      TeacherDao.java                 老师的数据访问对象
│  │  │          │      ThemeDao.java                   主题的数据访问对象
│  │  │          │      CollectionDao.java              收藏的数据访问对象
│  │  │          │      
│  │  │          ├─entity
│  │  │          │      QuestionAnswer.java             答案实体类
│  │  │          │      QuestionAnswerExample.java
│  │  │          │      Chapter.java                    章节实体类
│  │  │          │      ChapterExample.java
│  │  │          │      Content.java                    章节内容实体类
│  │  │          │      ContentExample.java
│  │  │          │      Course.java                     课程实体类
│  │  │          │      CourseExample.java
│  │  │          │      Note.java                       笔记实体类
│  │  │          │      NoteExample.java
│  │  │          │      Option.java                     问题选项实体类
│  │  │          │      OptionExample.java
│  │  │          │      Student.java                    学生实体类
│  │  │          │      StudentExample.java      
│  │  │          │      Teacher.java                    老师实体类
│  │  │          │      TeacherExample.java
│  │  │          │      Knowledge.java                  知识点实体类
│  │  │          │      KnowledgeExample.java
│  │  │          │      Homework.java                   作业实体类
│  │  │          │      HomeworkExample.java      
│  │  │          │      Theme.java                      主题实体类
│  │  │          │      ThemeExample.java
│  │  │          │      
│  │  │          ├─JSONBean.course
│  │  │          │     CourseThemeJSONBean              课程主题的jsonbean
│  │  │          │     CourseTypeJSONBean               课程分类的jsonbean
│  │  │          │     ThemeCourseBean                  课程主题
│  │  │          │      
│  │  │          ├─JsonUtil
│  │  │          │      JsonUti                         封装成功的返回信息
│  │  │          │      MyJson                          日期转换
│  │  │          │      
│  │  │          ├─service
│  │  │          │      CollectionService.java          收藏服务
│  │  │          │      CourseService.java              课程服务
│  │  │          │      HomeworkService.java            小测服务
│  │  │          │      KnowledgeService.java           知识点服务
│  │  │          │      NoteService.java                笔记服务
│  │  │          │      OpenIdService.java              注册服务
│  │  │          │      StudentService.java             学生服务
│  │  │          │      TeacherService.java             老师服务
│  │  │          │      
│  │  │          └─util
│  │  │                  PathUtil.java                  路径工具
│  │  │                  StringUtil.java                String类处理工具
│  │  │                  UrlBuilder.java                构造请求其他服务器的Url
│  │  │                  ErrorCode                      错误码
│  │  │                  ErrorCodeException.java        错误异常 
│  │  │                  ApiHttp.java                   Http请求
│  │  │                  ApiJson.java                   用于处理json
│  │  │                  ApiResult.java                 用于返回数据
│  │  │                  
│  │  └─resources
│  │      │  application.yml                            应用的配置文件
│  │      │  
│  │      ├─mapper
│  │      │      QuestionAnswerDao.xml                  答案的数据库操作文件
│  │      │      ChapterDao.xml                         章节的数据库操作文件
│  │      │      ContentDao.xml                         章节内容的数据库操作文件
│  │      │      CourseDao.xml                          课程的数据库操作文件
│  │      │      NoteDao.xml                            笔记的数据库操作文件
│  │      │      OptionDao.xml                          问题选项的数据库操作文件
│  │      │      CourseSelectionDao.xml                 选课的数据库操作文件
│  │      │      StudentDao.xml                         学生的数据库操作文件
│  │      │      TeacherDao.xml                         老师的数据库操作文件
│  │      │      KnowledgeDao.xml                       知识点的数据库操作文件
│  │      │      ThemeDao.xml                           主题的数据库操作文件
|  |
```

### 2. 关键功能实现细节
+ 登录、注册
    + 使用@RequestMapping注解login()函数，以响应微信小程序的登录请求
    + 在login()的参数部分使用注解@RequestBody获取登录请求体
    + 向教师Web应用后端发起http请求以登录/注册用户，并将获得的token返回给微信小程序
+ 后端访问微信公开api，获取OpenID
    + 采用了授权码模式
    + 微信发给用户端授权码，用户将授权码发给后端，后端再向微信发送请求，获取OpenID。
    + OpenID类似于token。
+ 数据库增、删、改、查
    + 使用插件better-mybatis-generator生成数据库相关操作的entity、dao、mapper。必要时，修改dao、mapper以满足需要
    + 在package com.adweb.adweb.controller下创建相应的controller以响应相关请求
    + 在package com.adweb.adweb.service下创建相应的service，调用dao中操纵数据库的具体函数
# AppiumUITest

#### 介绍
使用Appium自动化测试工具，做安卓端UI自动化测试，实现数据分离，与代码接耦，将测试用例数据，如定位类型（xpath、id、name、className、tagName）、元素定位路径（//android.view.View[@text='学习'][@index=1]）、元素显式等待时间、case描述、元素操作（click、sendKeys）、断言数据全部书写在properties。
通过读取properties文件到代码中，实现一个文件对应一个测试场景，一个测试场景对应一个测试类实例对象，若执行多个场景的用例，创建该类的多个实例，构造函数中传入文件
名称即可，详见代码及properties文件中说明注释

#### 软件架构
采用的appium测试框架


#### 安装教程

1.  安装Appium服务端，启动服务
2.  服务端安装安卓模拟器或真机
3.  安装Appium客户端，即引入Appium中java的类库jar包，借助IDE工具编写代码，实现与服务端的交互



#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)

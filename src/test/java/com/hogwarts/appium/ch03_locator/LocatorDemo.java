package com.hogwarts.appium.ch03_locator;

/**
 * Android基础知识：
 *      Android是通过容器的布局属性来管理子控件的位置关系，布局关系就是把界面上的所有的空间，根据他们的间距的大小，摆放在正确的位置
 *      Android七大布局：
 *          LinerLayout  线性布局
 *          RelativeLayout  相对布局
 *          FrameLayout  帧布局
 *          AboluteLayout  绝对布局
 *          TableLayout  表格布局
 *          GridLayout  网格布局
 *          ConstraintLayout  约束布局
 *      Android四大组件：
 *          activity与用户交互的可视化界面
 *          Service 实现程序后台运行的解决方案
 *          content Provider 内容提供者，提供程序所需要的数据
 *          broadcast receiver 广播接收器，监听外部事件的到来
 *      Android端常用的控件
 *          TextView（文本控制）、EditText(可编辑文本控件)
 *          Button(按钮)、ImageButton(图片按钮)、ToggleButton(开关按钮)
 *          ImageView(图片控件)
 *          CheckBox(复选框控件)、RadioButton(单选框控件)
 *      布局：
 *          是可用于放置很多控件的容器按照一定的规律调整内部控件的位置由此构成界面
 *      嵌套布局：
 *          布局内部放置布局，多层布局嵌套，可以完成复杂的界面结构
 * iOS基础知识：
 *      布局：iOS不使用布局的概念，用变量之间的相对关系完成位置的计算
 *
 *
 * 元素定位：
 *      概念：元素定位的含义就是定位控件
 *      注意：同一脚本同事支持Android/iOS的前提是元素属性一致
 * 控件基础知识：
 *      DOM：Document Object Model文档  对象模型
 *      dom应用：用于表示界面的控件层级，界面的结构化描述
 *          常见格式：HTML、XML
 *          核心元素：节点、属性
 *      xpath：xml路径语言，用于xml中的节点定位
 *      android应用的层级结构与HTML不一样，是一个定制的xml
 *      app source类似于dom,表示APP的层级，代表了界面里面所有的控件树的结构
 *      每个空间都有自己的属性(resourceid, xpath, aid)但是没有css属性
 *      定位方法：
 *          测试步骤三要素：定位、交互、断言
 *          定位方式：
 *              ID定位
 *              accessibility_id定位
 *              xpath定位
 *              className定位(不推荐)
 */
public class LocatorDemo {
}

package com.hogwarts.appium.ch05_toast;

/**
 * Toast:
 *      一种消息框类型
 *      永远不会获得焦点
 *          无法被点击
 *      Toast显示的时间有限，Toast会根据用户设置的显示时间后自动消息
 *      是系统级别的空间，属于系统settings
 *      Toast类的思想：
 *          就是尽可能不引人注意，同时还向用户显示信息，希望他们看到
 *      定位：
 *          appium用的是uiautomator底层来抓取toast
 *          再把toast放到控件树内，但是它本身不属于控件
 *          使用的是uiautomator2
 *          //*[@class="android.widget.Toast"]
 *          或者：//*[contains(@text, "xxx")] 其中 xxx为toast的文本内容
 *
 */
public class ToastTest {
}

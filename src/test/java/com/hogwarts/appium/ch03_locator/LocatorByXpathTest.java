package com.hogwarts.appium.ch03_locator;

/**
 * Xpath定位
 *      xpath表达式中的一个函数,contains()函数匹配属性值中包含的字符串 //*[contains(@属性,"属性值")]
 *      总结：
 *          contains()函数定位的元素很容易为list
 *          contains()函数内的属性名需要用@开始
 *      Xpath轴：
 *          父子 //*[@text="HK]/.. 或者 //*[@text="HK]/parent::*  儿子 //*[@text="HK]/child::*
 *          爷孙 //*[@text="HK]/../.. 或者 //*[@text="HK]/parent::* /parent::* 孙子 //*[@text="HK]/child::* /child::*
 *          祖先
 *              返回当前节点的所有祖先：//*[@text="HK"]/ancestor:: android.widget.RelativeLayout
 *              显示指定要返回的祖先：//*[@text="HK"]/ancestor:: android.widget.RelativeLayout[1]
 *          兄弟姐妹
 *              节点后的兄弟节点
 *                  节点后有一个兄弟节点 //*[@text="HK"]/following-sibling::*
 *                  节点后有多个兄弟节点：
 *              节点前的兄弟节点
 *                  节点后有一个兄弟节点 //*[@text="HK"]/preceding-sibling::*
 */
public class LocatorByXpathTest {
}

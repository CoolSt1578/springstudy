package com.study.spring.aop.aop2;

/**
 * Me关注于睡觉的逻辑，但是睡觉需要其他辅助功能，比如睡觉前要脱衣服，起床后穿衣服
 * 这里需要AOP替“Me”完成！
 * Created by guodd on 2018/1/29.
 */
public class Me implements Sleepable {

    public void sleep() {
        System.out.println("睡觉！");
    }
}

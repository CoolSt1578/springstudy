package com.study.spring.aop.aop5;

/**
 * Created by guodd on 2018/1/30.
 */
public interface TicketService {

    /**
     * 售票
     */
    void sellTicket();

    /**
     * 问询
     */
    void inquire();

    /**
     * 退票
     */
    void withdraw();
}

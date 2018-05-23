package com.study.aop.aop5;

/**
 * Created by guodd on 2018/1/30.
 */
public class RailwayStation implements TicketService {

    public void sellTicket() {
        System.out.println("售票。。。");
    }

    public void inquire() {
        System.out.println("问询。。。");
    }

    public void withdraw() {
        System.out.println("退票。。。");
    }
}

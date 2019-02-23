package com.demo.csv;

public class OrderStock {
    private String orderNo;
    private Integer orderStatus;
    private Long startTime;

    public OrderStock() {
    }
    public OrderStock(String orderNo, Integer orderStatus, Long startTime) {
        this.orderNo = orderNo;
        this.orderStatus = orderStatus;
        this.startTime = startTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}

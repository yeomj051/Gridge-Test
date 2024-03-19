package com.gridge.GridgeTest.entity;

import com.gridge.GridgeTest.dto.OrderStatus;

import javax.persistence.*;

public class PaymentHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscribe_history_id")
    private SubscribeHistory subscribeHistoryId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus orderStatus;
}

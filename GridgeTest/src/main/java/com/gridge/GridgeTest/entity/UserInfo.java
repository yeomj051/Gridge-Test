package com.gridge.GridgeTest.entity;

import javax.persistence.*;
import java.time.LocalDate;

public class UserInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private int id;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private User user_id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate birth;
    @Column(nullable = true)
    private String auth_provider_id;
    @Column(nullable = true)
    private String photo_path;
}

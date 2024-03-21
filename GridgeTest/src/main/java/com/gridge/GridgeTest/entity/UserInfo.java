package com.gridge.GridgeTest.entity;

import com.gridge.GridgeTest.dto.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
public class UserInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private int id;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private User userId;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 6)
    private AuthProvider authProvider;
    @Column(nullable = true)
    private String authProviderId;
    @Column(nullable = true)
    private String photoPath;

    @Builder
    public UserInfo(String name, AuthProvider provider, String providerId){
        this.name = name;
        this.authProvider = provider;
        this.authProviderId = providerId;
    }
}

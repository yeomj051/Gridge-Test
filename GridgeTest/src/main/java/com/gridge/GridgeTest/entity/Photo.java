package com.gridge.GridgeTest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;

@Entity @Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "photo")
public class Photo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feedId;
    @Column(nullable = false, length = 200)
    private String path;
    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private int sequence;
}

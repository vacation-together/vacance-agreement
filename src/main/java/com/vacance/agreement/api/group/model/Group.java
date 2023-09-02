package com.vacance.agreement.api.group.model;

import com.vacance.agreement.api.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Getter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PW")
    private String pw;

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Member> memberList;

    @Builder
    private Group(String pw, String title) {
        this.pw = pw;
        this.title = title;
    }
}

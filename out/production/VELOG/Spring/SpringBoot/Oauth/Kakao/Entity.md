package com.project.ds_helper.domain.user.entity;

import com.project.ds_helper.domain.base.entity.BaseTime;
import com.project.ds_helper.domain.post.entity.Image;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_user_kakao_oauth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class KakaoOauth extends BaseTime {

    @PrePersist
    private void perPersistGenerateId(){
        this.id = String.valueOf(UUID.randomUUID());
    }

    @Id
    @Column(name = "kakao_oauth_id")
    private String id;

    @OneToOne(optional = false, cascade = {})
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "social_oauth_id")
    private Long socialOauthId;

    @Column(name = "oauth_email")
    private String oauthEmail;





}

package com.project.reservation.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.reservation.domain.account.model.Account;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @Comment("최초 생성일")
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @Comment("마지막 수정일")
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    @Comment("생성자")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @CreatedBy
    @JoinColumn(name = "created_account_id", updatable = false)
    private Account createdByAccount;

    @Comment("수정자")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @LastModifiedBy
    @JoinColumn(name = "modified_account_id")
    private Account modifiedByAccount;

    @Comment("삭제 유무")
    @Column(nullable = false, length = 1)
    private String deletedYn = "N";

    public void markAsDeleted() {
        deletedYn = "Y";
    }
}

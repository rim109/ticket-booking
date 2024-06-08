package com.example.ticketing.common.model

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {
    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP(6)", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP(6)" , nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

    @Column(columnDefinition = "TIMESTAMP(6)", name = "deleted_at", nullable = true)
    var deletedAt: LocalDateTime? = null

}
package com.example.ticketing.common.model

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class SoftDeleteEntity : BaseTimeEntity() {
    @Column(name = "is_deleted")
    var isDeleted: Boolean = false
}
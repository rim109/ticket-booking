package com.example.ticketing.domain.category.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Table(name = "category")
class Category(

    @Column(name = "name")
    val name: String

) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
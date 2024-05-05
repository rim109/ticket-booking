package com.example.ticketing.domain.category.model

import com.example.ticketing.common.model.SoftDeleteEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE category SET is_deleted = true WHERE id = ?")
@Table(name = "category")
class Category(

    @Column(name = "name")
    val name: String

) : SoftDeleteEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
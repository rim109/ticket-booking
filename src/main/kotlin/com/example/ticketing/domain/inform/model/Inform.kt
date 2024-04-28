package com.example.ticketing.domain.inform.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE inform SET is_deleted = true WHERE id = ?")
@Table(name = "inform")
class Inform(

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "image_Url")
    var imageUrl: String,

    @Column(name = "price")
    var price: String,

    @Column(name = "address")
    var address: String,

    @Column(name = "period")
    var period: String,

    @Column(name = "totalTime")
    var totalTime: String,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false

): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

}
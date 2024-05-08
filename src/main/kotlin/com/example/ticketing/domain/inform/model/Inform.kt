package com.example.ticketing.domain.inform.model

import com.example.ticketing.common.model.BaseTimeEntity
import com.example.ticketing.domain.category.model.Category
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    var category: Category,
//
//    // 추후 유저 부분 추가후 이 Category를 User로 바꿀 예정
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    var user: Category,


    ) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

}
package com.example.ticketing.domain.inform.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Table(name = "inform")
class Inform(

    @Column(name = "title", nullable = false, length = 10)
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "image_Url", nullable = false)
    var imageUrl: String,

    @Column(name = "price", nullable = false)
    var price: String,

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    var address: String,

    @Column(name = "period", nullable = false)
    var period: String,

    @Column(name = "totalTime", nullable = false)
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
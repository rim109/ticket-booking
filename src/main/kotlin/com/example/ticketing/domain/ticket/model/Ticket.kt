package com.example.ticketing.domain.ticket.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Table(name = "ticket")
class Ticket(
    @Column(name = "date")
    var date: String,

    @Column(name = "times")
    var times: String,

    @Column(name = "seats")
    var seats: Int,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "inform_id")
//    var inform: Inform,
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
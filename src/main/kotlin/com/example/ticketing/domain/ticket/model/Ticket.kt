package com.example.ticketing.domain.ticket.model

import com.example.ticketing.common.model.BaseTimeEntity
import com.example.ticketing.domain.category.model.Category
import com.example.ticketing.domain.inform.model.Inform
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE ticket SET is_deleted = true WHERE id = ?")
@Table(name = "ticket")
class Ticket(
    @Column(name = "date")
    var date: String,

    @Column(name = "times")
    var times: String,

    @Column(name = "seats")
    var seats: Int,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inform_id")
    var inform: Inform,

    // 추후 유저 부분 추가후 이 Category를 User로 바꿀 예정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    var user: Category,

    ): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
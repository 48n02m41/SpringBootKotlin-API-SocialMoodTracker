package dev48n02m41.springkotlin.entities

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class DiaryEntryEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var socialNetworkChoice: String,
        var beforeMoodRating: Int,
        var afterMoodRating: Int,
        var dateCreated: LocalDateTime = LocalDateTime.now()

) {
    override fun toString(): String {
        return "DiaryEntryEntity(id=$id, socialNetworkChoice='$socialNetworkChoice', " +
                "beforeMoodRating=$beforeMoodRating, afterMoodRating=$afterMoodRating, dateCreated=$dateCreated)"
    }
}


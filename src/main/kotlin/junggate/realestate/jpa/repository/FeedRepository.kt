package junggate.realestate.jpa.repository

import junggate.realestate.jpa.model.Feed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface FeedRepository: JpaRepository<Feed, Int> {
}
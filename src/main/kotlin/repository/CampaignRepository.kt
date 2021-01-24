package repository

import model.entity.CampaignEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface CampaignRepository: JpaRepository<CampaignEntity, UUID> {

    /**
     * In general for basic CRUD operations using JPA a repository
     * already have most things built in and implementation of SQL is no needed
     * EX:
     * @code findById(), findAllById(), getOne() etc
     *
     * However To demonstrate that i do have a knowledge of querying i will implement my own
     */


    //adding this annotation tells spring to look at your custom query and not their built in one
    @Query(
        nativeQuery = true,
        value = "SELECT * FROM campaign WHERE name = :name AND descripton = :description"
    )
    fun findByNameAndDescription(name: String, description: String): Optional<CampaignEntity?>
}
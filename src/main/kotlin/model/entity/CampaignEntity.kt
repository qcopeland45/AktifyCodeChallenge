package model.entity



import model.dto.Active
import model.dto.CampaignRequest
import model.dto.CampaignResponse
import java.util.*
import javax.persistence.*


/**
 * Campaign entity to allow us to interact with the data layer in the project
 */

@Entity
@Table(name = "campaign")
class CampaignEntity(

    @Id
    @GeneratedValue
    @Column(name = "campaign_id")
    val id: UUID = UUID.randomUUID(),

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "active")
    @Enumerated(EnumType.STRING)
    var active: Active
)

fun CampaignEntity.toResponse(): CampaignResponse {
    return CampaignResponse(
        this.id,
        this.name,
        this.description,
        this.active
    )
}
package services

import javassist.NotFoundException
import model.dto.CampaignRequest
import model.dto.CampaignResponse
import model.dto.toEntity
import model.entity.toResponse
import org.springframework.stereotype.Service
import repository.CampaignRepository
import java.util.*


@Service
class CampaignService(val campaignRepository: CampaignRepository) {


    /**
     * This function allows a user to create a campaign
     */
    fun createCampaign(campaignRequest: CampaignRequest): CampaignResponse {
        //since user is creating new campaign we should take the request, store it in the db
        //then the UI should update with whatever the caller page references
        return campaignRepository.save(campaignRequest.toEntity()).toResponse()
    }

    /**
     * This functions allows user to query campaigns based on the ID's
     */
    fun getCampaignById(campaignId: UUID): CampaignResponse {
        // query your DB for the ID requested by the user
        val entity =
            campaignRepository.findById(campaignId)
                .orElseThrow { NotFoundException("Campaign with ID: $campaignId is was not found") }
        return entity.toResponse()
    }

    /**
     * This function allows a user to update a campaign
     */
    fun updateCampaign(campaignId: UUID, campaignRequest: CampaignRequest): CampaignResponse {
        val entity = campaignRepository.findById(campaignId)
        return if(entity.isPresent) {
            entity.map {
                it.name = campaignRequest.name
                it.description = campaignRequest.description
                it.active = campaignRequest.active
            }
            entity.get().toResponse()
        } else {
           throw NotFoundException("Unable to update Campaign for ID of: $campaignId")
        }
    }

    /**
     * This function allows a user to remove a campaign
     */
    fun removeCampaign(campaignId: UUID) {
        campaignRepository.deleteById(campaignId)
    }


}

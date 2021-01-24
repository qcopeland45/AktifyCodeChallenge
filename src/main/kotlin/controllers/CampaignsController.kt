package controllers

import model.dto.CampaignRequest
import model.dto.CampaignResponse
import org.springframework.web.bind.annotation.*
import services.CampaignService
import java.util.*
import javax.validation.Valid


/**
 * This controller class is for accesses anything related to campaigns.
 * Creation
 * Update
 * Delete
 * Etc
 * These are the API end points the front end would call
 *
 * This is a very very dumb version of an api implementation. For Ex:
 * There should be some sort of Security for allowing users to access these endpoints.
 * The type of security that could be set up might be through springs security roles and permissions.
 * All of these endpoints are fine for ANY user so long as they are authenticated to use them.
 * EG: I user with an account that is logged in should be able to access these endpoint
 */

@RestController(Routes.CREATE_CAMPAIGN_ROUTE)
class CampaignsController(val campaignService: CampaignService) {


    /**
     * Function to allow user to create a campaigns
     * When the Button labelled "Create" is clicked the FE should make a call to this end point
     * @Valid ensures that all required fields that are needed are there
     * @RequestBody binds body to the web request
     * Adding the valid check allows us to by pass building a check for
     * Name, Description, Is_Active.
     */
    @PostMapping("/create")
    fun create(@Valid @RequestBody campaignRequest: CampaignRequest): CampaignResponse {
        return campaignService.createCampaign(campaignRequest)
    }

    /**
     * Function to allow user to get a campaign. ON the FE this would probably look something like
     * having a list of previous, or active campaign buttons, which will make the FE call to the BE
     * and make the proper queries to receive the data to display in the UI
     */
    @GetMapping("/show-campaign/{id}")
    fun getCampaignById(@PathVariable("id") campaignId: UUID): CampaignResponse {
        return campaignService.getCampaignById(campaignId)
    }

    /**
     * Function for updating existing campaigns
     *
     */
    @PutMapping("/update/{id}")
    fun updateCampaign(
        @Valid
        @PathVariable("id") campaignId: UUID,
        @RequestBody campaignRequest: CampaignRequest
    ): CampaignResponse = campaignService.updateCampaign(campaignId, campaignRequest)

    /**
     * Function to delete existing campaigns
     */
    @DeleteMapping("/delete/{id}")
    fun deleteCampaign(@PathVariable("id") campaignId: UUID) = campaignService.removeCampaign(campaignId)


    /**
     * @SIDENOTE
     * I know i didn't complete this challenge in full. I unfortunately took an embarrassing amount of time trying to clone
     * the repo. When i was finally able to get that to work the docker compose was giving me issues.
     * I am also not super familiar with react and i have used python enough to be dangerous.
     *
     * With that said i decided to use spring and kotlin (also just as skilled with java) because i wanted to be able to
     * focus on the problem at hand and showcase my skills for BE API building (which is all i have ever done).
     *
     * I felt this was a fair test. Much better than the normal algorithmic questions asked in interviews. I
     * Understand the configuration and getting projects to run is part of being a software engineer and its something I will strive to
     * become better with in time. If given the chance, I know i can learn any language and any frame work and put those
     * skills to use.
     *
     * Hopefully my code is clear and easy to understand. I tried to code and keep the file structure as close to something
     * you might do on a real project as i could. THough i fully understand this is a very simplistic API service
     * I do understand how they work and how to build one.
     *
     * Ill make sure to brush up on front end ...haha Thanks for your time.
     *
     */


}
package com.example.ticketing.common.oauth.client.google

import com.example.ticketing.common.oauth.client.OAuth2Client
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class GoogleOAuth2Client(
    private val restClient: RestClient
) : OAuth2Client {
}
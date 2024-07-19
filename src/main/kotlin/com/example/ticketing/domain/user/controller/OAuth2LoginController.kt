package com.example.ticketing.domain.user.controller

import com.example.ticketing.common.oauth.client.OAuth2ClientService
import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.service.OAuth2LoginService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/auth")
class OAuth2LoginController(
    private val oAuth2LoginService: OAuth2LoginService,
    private val oAuth2Client: OAuth2ClientService
) {
    private val localHost = "http://localhost:8080/login"


    @GetMapping("/login/{provider}")
    @PreAuthorize("isAnonymous()")
    fun oAuth2Login(
        @PathVariable provider: OAuth2Provider,
        res: HttpServletResponse
    ) {
        val loginUrl = oAuth2Client.generateLoginPageUrl(provider)
        res.sendRedirect(loginUrl)
    }

    @GetMapping("/callback/{provider}")
    @PreAuthorize("isAnonymous()")
    fun callback(
        @PathVariable provider: OAuth2Provider, res: HttpServletResponse,
        @RequestParam(name = "code") authorizationCode: String
    ): ResponseEntity<Unit> {

        val accessToken = oAuth2LoginService.login(provider, authorizationCode)
        val cookie = ResponseCookie
            .from("accessToken", accessToken)
            .httpOnly(true)
            .path("/")
            .maxAge(3600)
            .build()

        val headers = HttpHeaders()
            .also { it.location = URI.create(localHost) }
            .also { it.add(HttpHeaders.SET_COOKIE, cookie.toString()) }


        return ResponseEntity(headers, HttpStatus.PERMANENT_REDIRECT)
    }
}
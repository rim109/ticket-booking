package com.example.ticketing.domain.user.controller

import org.springframework.web.bind.annotation.RestController
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping


@RestController
class LogoutController {
    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Unit> {
        val cookie = ResponseCookie
            .from("accessToken")
            .httpOnly(true) /* .secure(true) // https 사용할 경우 빌더에 추가 */
            .path("/")
            .maxAge(0) // accessToken 쿠키 만료시킴
            .build()

        val headers = HttpHeaders()
            .also {
                it.add(
                    HttpHeaders.SET_COOKIE,
                    cookie.toString()
                )
            } // 헤더에 SET COOKIE 헤더 추가, 내용은 위에서 만들어놓은 accessTokenInCookie 객체

        return ResponseEntity(headers, HttpStatus.OK)
    }
}
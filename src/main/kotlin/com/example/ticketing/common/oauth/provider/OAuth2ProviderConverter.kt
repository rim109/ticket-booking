package com.example.ticketing.common.oauth.provider

import org.springframework.core.convert.converter.Converter
import java.security.InvalidParameterException

class OAuth2ProviderConverter: Converter <String, OAuth2Provider>{
    override fun convert(source: String): OAuth2Provider {
        return kotlin.runCatching {
            OAuth2Provider.valueOf(source.uppercase())
        }.getOrElse {
            throw InvalidParameterException("$it")
        }
    }
}
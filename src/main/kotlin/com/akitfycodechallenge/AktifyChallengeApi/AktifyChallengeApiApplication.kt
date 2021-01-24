package com.akitfycodechallenge.AktifyChallengeApi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class AktifyChallengeApiApplication

fun main(args: Array<String>) {
	runApplication<AktifyChallengeApiApplication>(*args)
}

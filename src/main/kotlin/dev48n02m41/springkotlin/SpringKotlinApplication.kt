package dev48n02m41.springkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringKotlinApplication {
	companion object {
		@JvmStatic fun main(args: Array<String>) {
			SpringApplication.run(SpringKotlinApplication::class.java, *args)
		}
	}
}
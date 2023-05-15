package io.github.edsonzuchi.FinanceAPI

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = [
		"io.github.edsonzuchi.FinanceAPI",
		"org.jetbrains.exposed.spring",
	],
)
class FinanceApiApplication

fun main(args: Array<String>) {
	runApplication<FinanceApiApplication>(*args)
}

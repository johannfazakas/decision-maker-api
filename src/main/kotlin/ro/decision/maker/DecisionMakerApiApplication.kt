package ro.decision.maker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DecisionMakerApiApplication

fun main(args: Array<String>) {
	runApplication<DecisionMakerApiApplication>(*args)
}

package ro.decision.maker.api

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import ro.decision.maker.service.DecisionService
import ro.decision.maker.transfer.CollectionOutput
import ro.decision.maker.transfer.DecisionCreateInput
import ro.decision.maker.transfer.DecisionOutput
import java.util.*

@RestController
@RequestMapping("/dm-api/v1/decisions")
class DecisionController(
  val decisionService: DecisionService
) {

  val log: Logger = LoggerFactory.getLogger(DecisionController::class.java)

  @PostMapping
  @ResponseStatus(CREATED)
  fun createDecision(@RequestBody input: DecisionCreateInput): DecisionOutput {
    log.info("createDecision >> input = $input")
    return decisionService.createDecision(input)
  }

  @GetMapping("/{decisionId}")
  @ResponseStatus(OK)
  fun getDecision(@PathVariable("decisionId") id: UUID): DecisionOutput {
    log.info("getDecision >> id = $id")
    return decisionService.getDecision(id)
  }

  @GetMapping
  @ResponseStatus(OK)
  fun listDecisions(): CollectionOutput<DecisionOutput> {
    log.info("listDecisions")
    return decisionService.listDecisions()
  }

  @DeleteMapping("/{decisionId}")
  @ResponseStatus(NO_CONTENT)
  fun deleteDecision(@PathVariable("decisionId") id: UUID) {
    log.info("deleteDecision >> id = $id")
    decisionService.deleteDecision(id)
  }
}
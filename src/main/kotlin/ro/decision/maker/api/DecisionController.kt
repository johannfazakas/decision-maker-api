package ro.decision.maker.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import ro.decision.maker.transfer.CollectionOutput
import ro.decision.maker.transfer.DecisionCreateInput
import ro.decision.maker.transfer.DecisionOutput
import java.util.*

@RestController
@RequestMapping("/dm-api/v1/decisions")
class DecisionController {

  @PostMapping
  @ResponseStatus(CREATED)
  fun createDecision(@RequestBody input: DecisionCreateInput) = DecisionOutput(
    id = UUID.randomUUID(),
    name = input.name
  )

  @GetMapping("/{decisionId}")
  @ResponseStatus(OK)
  fun getDecision(@PathVariable("decisionId") id: UUID) = DecisionOutput(
    id = id,
    name = "decision"
  )

  @GetMapping
  @ResponseStatus(OK)
  fun listDecisions() = CollectionOutput(listOf(
    DecisionOutput(
      id = UUID.randomUUID(),
      name = "decision1"),
    DecisionOutput(
      id = UUID.randomUUID(),
      name = "decision2"))
  )

  @DeleteMapping("/{decisionId}")
  @ResponseStatus(NO_CONTENT)
  fun deleteDecision(@PathVariable("decisionId") id: UUID) { }
}
package ro.decision.maker.transfer

import ro.decision.maker.model.Decision

data class DecisionCreateInput(
  val name: String,
  val description: String?
) {

  fun toModel(): Decision = Decision(
    name = name,
    description = description
  )
}

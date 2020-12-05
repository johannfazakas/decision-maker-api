package ro.decision.maker.transfer

import ro.decision.maker.model.Decision
import java.util.*

data class DecisionOutput(
  val id: UUID,
  val name: String
) {
  constructor(decision: Decision): this(
    id = decision.id!!,
    name = decision.name
  )
}

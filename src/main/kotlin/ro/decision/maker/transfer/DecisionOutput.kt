package ro.decision.maker.transfer

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import ro.decision.maker.model.Decision
import java.util.*

@JsonInclude(NON_NULL)
data class DecisionOutput(
  val id: UUID,
  val name: String,
  val description: String?
) {
  constructor(decision: Decision): this(
    id = decision.id!!,
    name = decision.name,
    description = decision.description
  )
}

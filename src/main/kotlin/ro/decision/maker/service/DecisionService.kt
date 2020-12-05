package ro.decision.maker.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ro.decision.maker.repository.DecisionRepository
import ro.decision.maker.transfer.CollectionOutput
import ro.decision.maker.transfer.DecisionCreateInput
import ro.decision.maker.transfer.DecisionOutput
import java.util.*

@Service
class DecisionService(
  val decisionRepository: DecisionRepository
) {

  val log: Logger = LoggerFactory.getLogger(DecisionService::class.java)

  fun createDecision(input: DecisionCreateInput): DecisionOutput {
    log.info("createDecision >> input = $input")
    return decisionRepository.save(input.toModel())
      .let(::DecisionOutput)
  }

  fun getDecision(id: UUID): DecisionOutput {
    log.info("getDecision >> id = $id")
    return decisionRepository.findByIdOrNull(id)
      ?.let(::DecisionOutput)
      ?: throw RuntimeException("Decision not found")
  }

  fun listDecisions(): CollectionOutput<DecisionOutput> {
    log.info("listDecisions")
    return decisionRepository.findAll()
      .map(::DecisionOutput)
      .let(::CollectionOutput)
  }

  fun deleteDecision(id: UUID) {
    log.info("deleteDecision >> id = $id")
    decisionRepository.deleteById(id)
  }
}

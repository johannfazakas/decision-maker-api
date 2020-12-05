package ro.decision.maker.repository

import org.springframework.data.repository.CrudRepository
import ro.decision.maker.model.Decision
import java.util.*

interface DecisionRepository : CrudRepository<Decision, UUID>
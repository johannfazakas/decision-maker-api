package ro.decision.maker.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "decision")
data class Decision(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: UUID,

  @Column(nullable = false)
  val name: String
)

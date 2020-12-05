package ro.decision.maker.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "decision")
open class Decision(
  @Column(nullable = false)
  open var name: String,

  @Column
  open var description: String?
) {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  open var id: UUID? = null
}

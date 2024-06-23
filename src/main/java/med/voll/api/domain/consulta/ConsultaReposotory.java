package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaReposotory extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndDataBetween(Long indPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    /*boolean existsByMedicoIdAndData(Long aLong, LocalDateTime data);*/
    boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long aLong, LocalDateTime data);
}

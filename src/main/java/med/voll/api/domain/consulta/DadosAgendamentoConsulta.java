package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import med.voll.api.domain.medico.Especialidade;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,
        @NonNull
        Long idPaciente,

        @NonNull
        @Future
        LocalDateTime data,

        Especialidade especialidade
) {}

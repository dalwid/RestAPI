package med.voll.api.domain.consulta.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaReposotory;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecendencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaReposotory reposotory;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta  = reposotory.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras    = Duration.between(agora, consulta.getData()).toHours();

        if(diferencaEmHoras < 24){
            throw new ValidacaoException("Consultar somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}

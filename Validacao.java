import java.util.Scanner;

public class Validacao {
  public void calcularValidacaoFinal(Pessoa pessoa, Mensagem mensagem, boolean erroTentativas) {
    // Valido se imprimo a mensagem de erro
    if (erroTentativas == true) {
      mensagem.imprimirMensagemErro();
    } else {
      CalculoPorcentagem calculoPorcentagem = new CalculoPorcentagem();
      calculoPorcentagem.calculaPorcentagem(pessoa);

      // Verifico se a pessoa está retornando de viagem
      if (pessoa.estaRetornandoViagem.equals("SIM")) {
        mensagem.imprimirRelatorioFinal(pessoa);
      } else {

        // Verifico a porcentagem de infecção
        if (pessoa.porcentagemInfeccao >= 90) {
          pessoa.orientacaoFinal = "Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.";
          mensagem.imprimirRelatorioFinal(pessoa);
         } if (pessoa.porcentagemInfeccao <=89) {
            pessoa.orientacaoFinal = "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 05 dias para ser acompanhado.";
            mensagem.imprimirRelatorioFinal(pessoa);
          	}if (pessoa.porcentagemInfeccao <=60) {
              pessoa.orientacaoFinal = "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.";
              mensagem.imprimirRelatorioFinal(pessoa);
            }if (pessoa.porcentagemInfeccao <=30) {
                pessoa.orientacaoFinal = "Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica..";
                mensagem.imprimirRelatorioFinal(pessoa);
        }
      }
    }
  }
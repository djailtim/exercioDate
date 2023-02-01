import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
  /*
   *  Enunciado
      Para gestão dos períodos de vacinação, você é responsável por criar um programa que receba a data de vacina e imprima as próximas 3 doses baseado nas seguintes regras;

      - As doses devem ser ministradas de 3 em 3 meses
      - Como os postos de vacinação só abrem em dias da semana se a data da vacinação for sábado, deve ser antecipada para sexta, caso dê num domingo deve ser ministrada na segunda. (Resposta: via github, cole o link do projeto)
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.print("Insira a data da primeira dose da vacina (dd/MM/yyyy): ");
    LocalDate dataInformada = LocalDate.parse(input.nextLine(), formatoData);
    input.close();

    Integer quantidadeDoses = 3;
    Integer intervaloDosesEmMeses = 3;
    LocalDate proximaDose;

    System.out.println("As próximas doses serão nas datas: ");
    for (int i = 1; i <= quantidadeDoses; i++) {
      proximaDose = dataInformada.plusMonths(i * intervaloDosesEmMeses);
      if (proximaDose.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
        proximaDose = proximaDose.plusDays(1);
      } else if (proximaDose.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
        proximaDose = proximaDose.minusDays(1);
      }
      System.out.printf("%sª dose: %s%n", (i + 1), proximaDose.format(formatoData));
    }
  }

}
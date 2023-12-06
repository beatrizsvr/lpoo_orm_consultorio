package br.edu.ifsul.cstsi.lpoo_orm_consultorio;

import br.edu.ifsul.cstsi.lpoo_orm_consultorio.pacientes.PacienteController;

import java.util.Scanner;

public class HomeController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("antes do menu");
        int opcao;
            do {
                System.out.print("\n-------  Menu -------");
                System.out.print(
                        """
        
                            1. Cadastrar paciente
                            2. Atualizar dados do paciente
                            3. Listar pacientes
                            4. Consultar paciente pelo nome
                            5. Consultar paciente pelo código
                            Opção (Zero p/sair):\s""");
                opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1 -> PacienteController.main(null);
                    case 2 -> System.out.println("Em desenvolvimento");
                    case 3 -> System.out.println("Em desenvolvimento");
                    case 4 -> System.out.println("Em desenvolvimento"); //ItemController.main(null);
                    case 5 -> PacienteController.main(null);
                    default -> {
                        if (opcao != 0) System.out.println("Opção inválida.");
                    }
                }
            } while(opcao != 0) ;
            System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
            input.close(); //libera o recurso
    }
}

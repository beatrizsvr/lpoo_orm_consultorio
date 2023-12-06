package br.edu.ifsul.cstsi.lpoo_orm_consultorio.pacientes;

import org.springframework.stereotype.Controller;
import java.util.Scanner;
@Controller
public class PacienteController {

    private static final Scanner input = new Scanner(System.in);
    private static PacienteService pacienteService;

    //Injeção de dependência
    public PacienteController(PacienteService pacienteService) {
        PacienteController.pacienteService = pacienteService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  Menu -------\"");
            System.out.print(
                    """
                                
                            1. Cadastrar paciente
                            2. Atualizar dados do paciente
                            3. Excluir um paciente
                            4. Listar todos os pacientes
                            5. Consultar paciente pelo código
                            6. Consultar paciente pelo nome
                            Opção (Zero para sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> insert();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> selectPacientes();
                case 5 -> System.out.println("Em desenvolvimento");//selectclientes();
                case 6 -> System.out.println("Em desenvolvimento");//selectclientesById();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void insert() {
        Paciente paciente = new Paciente();
        System.out.println("\n++++++ Cadastro de novo Paciente ++++++");
        System.out.println("\nDigite o nome do paciente: ");
        paciente.setNomePaciente(input.nextLine());
        System.out.println("\nDigite o nome de usuário: ");
        paciente.setUsuario(input.nextLine());
        System.out.print("\nDigite a senha de usuário do paciente: ");
        paciente.setSenha(input.nextLine());
        System.out.println("\nCadastro realizado com sucesso" + pacienteService.insert(paciente));
    }
    //opção 2
    private static void update() {
        Paciente paciente = null;
        int opcao = 0;
        System.out.println("\n++++++ Atualizar um cliente ++++++");

        do {
            System.out.println("\nDigite o código do cliente que deseja atualizar ou digite zero para sair: ");
            long id = input.nextLong();
            input.nextLine();

            if (id == 0) {
                opcao = 0;
            } else {
                paciente = pacienteService.getPacientebyId(id);
                if (paciente == null || id != paciente.getId()) {
                    System.out.println("\nCódigo inválido!");
                } else {
                    System.out.println("\nNome atual do paciente: " + paciente.getNomePaciente());
                    System.out.println("\nAlterar nome do paciente? (1. Sim/2. Não ");
                    if (input.nextInt() == 1) {
                        input.nextLine();
                        System.out.println("\nDigite o novo nome do paciente: ");
                        paciente.setNomePaciente(input.nextLine());
                    }
                    System.out.println("\nNome de usuário atual do paciente " + paciente.getUsuario());
                    System.out.println("\nAlterar nome de usuário do paciente? (1. Sim/2. Não ");
                    if (input.nextInt() == 1) {
                        input.nextLine();
                        System.out.println("\nDigite o novo nome de usuário do paciente: ");
                        paciente.setUsuario(input.nextLine());
                    }
                    System.out.println("\nSenha atual do paciente " + paciente.getSenha());
                    System.out.println("\nAlterar senha do paciente? (1. Sim/2. Não ");
                    if (input.nextInt() == 1) {
                        input.nextLine();
                        System.out.println("\nDigite a nova senha do paciente: ");
                        paciente.setUsuario(input.nextLine());
                    }
                    System.out.println("\nCadastro atualizado com sucesso!\n");
                    System.out.println("\nNome: " + paciente.getNomePaciente());
                    System.out.println("\nNome de usuário: " + paciente.getUsuario());
                    System.out.println("\nSenha: " + paciente.getSenha());
                }
            }
        } while (opcao != 0);
    }

    //opção 3
    private static void delete() {
        System.out.println("\n++++++ Excluir paciente ++++++");
        Paciente paciente;
        int opcao = 0;
        do {
            System.out.println("\nDigite o código do paciente que deseja excluir ou zero para sair: ");
            long id = input.nextLong();
            input.nextLine();

            if (id == 0) {
                opcao = 0;
            } else {
                paciente = pacienteService.getPacientebyId(id);
                if (paciente == null || id != paciente.getId()) {
                    System.out.println("\nCódigo inválido!");
                } else {
                    System.out.println(paciente);
                    System.out.println("\nExcluir esse paciente? (1. Sim/2. Não");
                    if (input.nextInt() == 1) {
                        input.nextLine();
                        System.out.println("Paciente " + paciente.getNomePaciente() + "excluído com sucesso!");
                    }
                }
            }
        }while(opcao != 0);
    }

    private static void selectPacientes(){
        System.out.println("Lista de todos os pacientes:\n" + pacienteService.getPacientes());

    }
}
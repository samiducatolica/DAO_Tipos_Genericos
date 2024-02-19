import DaoFactory.DaoFactory;
import Daos.IDao;
import modelo.Actor;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Actor actor = new Actor();
        IDao dao = DaoFactory.getDao(DaoFactory.DaoType.ACTOR);

        List<Actor> actors = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opcion;
        UUID idActor;

        boolean redo =true;
        do{
            System.out.println("*# GESTINO DE ACTORES #*");
            System.out.println("Que accion quieres realizar?");
            System.out.println("[1] Crear registro\n"+
                    "[2] Actualziar registro\n"+
                    "[3] Eliminar registro\n"+
                    "[4] Buscar un registro\n"+
                    "[5] Mostrar todos los registros\n"+
                    "[0] Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("|REGISTRAR ACTOR|");
                    System.out.println("Inserta nombre:");
                    actor.setFirst_name(sc.next());
                    System.out.println("Inserta apellido:");
                    actor.setLast_name(sc.next());
                    System.out.println(dao.crearRegistro(actor));
                    break;

                case 2:
                    System.out.println("|ACTUALIZAR ACTOR|");
                    System.out.println("Id del actor: ");
                    idActor = UUID.fromString(sc.next());
                    System.out.println("Inserta nombre:");
                    actor.setFirst_name(sc.next());
                    System.out.println("Inserta apellido:");
                    actor.setLast_name(sc.next());
                    System.out.println(dao.actualizarRegistro(actor,idActor));
                    break;

                case 3:
                    System.out.println("|ELIMINA ACTOR|");
                    System.out.println("Id del actor: ");
                    idActor = UUID.fromString(sc.next());
                    System.out.println(dao.borrarRegistro(idActor));
                    break;

                case 4:
                    System.out.println("|BUSCAR ACTOR|");
                    System.out.println("Id del actor: ");
                    idActor = UUID.fromString(sc.next());
                    dao.leerRegistro(idActor);
                    System.out.println(dao.leerRegistro(idActor));
                    break;

                case  5:
                    System.out.println("|LISTA ACTORES|");
                    actors.clear();
                    actors = dao.leerRegistros();
                    for (Actor record:actors){
                        System.out.println(record.toString());
                    }
                    break;
                case 0:
                    System.out.println("|SALIENDO...|");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion== 0){
                System.out.println("Realizar otra accion? [1] SI/[2] NO");
                opcion= sc.nextInt();
                if (opcion!= 1){
                    redo = false;
                    System.out.println("|SALIENDO...|");
                }
            }

        }while (redo);
    }


}
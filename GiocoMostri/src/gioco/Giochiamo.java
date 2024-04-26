
package gioco;

import java.util.Random;
import java.util.Scanner;

public class Giochiamo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuaGioco = false;

        do {
            Eroe e = new Eroe();
            Licantropo l = new Licantropo();
            Vampiro v = new Vampiro();

            Personaggio[] avversari = {e, l, v}; // array dei papabili avversari che verranno selezionati con il metodo nextInt() di Random
            Random random = new Random(); // Crea oggetto Random
            Personaggio avversario; //variabile
            System.out.println("Choose your fighter. Press:\n---------------------------\n1 -> EROE\n2 -> VAMPIRO \n3 "
                    + "-> LICANTROPO\n---------------------------");
            int scelta = scanner.nextInt(); // personaggio selezionato
            
            boolean continuaDuello = false; //var per permettere di continuare a duellare fino alla sconfitta di uno dei due personaggi

            switch (scelta) { // switch per gestire l'iter rispetto ai vari personaggi selezionabili
                case 1:
                    System.out.println("Hai scelto di essere un eroe!");
                    avversario = avversari[random.nextInt(avversari.length)];
                    System.out.println("Il tuo avversario è " + avversario.toString() + "!");
                    do {
                        if (e.vita <= 0 || e.forza <= 0 || avversario.getVita() <= 0) { //se le vite non sono a zero si perde
                            if (e.vita <= 0 || e.forza <= 0) {
                                System.out.println("HAI PERSO");
                            } else {
                                System.out.println("HAI VINTO");
                            }
                            continuaDuello = false; // Termina il combattimento
                            break; // Si esce dal ciclo
                        }

                        e.attacca(avversario);
                        System.out.println("Stai attaccando " + avversario + "!");
                        if (avversario.getVita() > 0) { // Se vita dell'avversario >0 si può procedere al contrattacco
                            System.out.println("Attenzione al contrattacco!");
                            avversario.attacca(e);
                        } else {
                            System.out.println("Avversario morto");
                        }

                        System.out.println("Round finito. \n" + e.getForza() + "\nLa tua vita residua è: " + e.getVita());
                        System.out.println("L'avversario ha vita residua: " + avversario.getVita()); //recap dopo il duello
                        System.out.println("Vuoi attaccare ancora? (True/False)"); //Domanda pe capire se procedere con un nuovo duello
                        continuaDuello = scanner.nextBoolean();
                    } while (continuaDuello);

                    break;

                case 2:
                    System.out.println("Hai scelto di essere un vampiro!");
                    avversario = avversari[random.nextInt(avversari.length)];
                    System.out.println("Il tuo avversario è " + avversario.toString() + "!");
                    do {
                        if (v.forza <= 0 || v.vita <= 0 || avversario.getVita() <= 0) {
                            if (v.forza <= 0 || v.vita <= 0) {
                                System.out.println("HAI PERSO");
                            } else {
                                System.out.println("HAI VINTO");
                            }
                            continuaDuello = false; // Termina il combattimento
                            break; // Esci dal ciclo
                        }

                        v.attacca(avversario);
                        if (avversario.getVita() > 0) {
                            System.out.println("Attenzione al contrattacco!");
                            avversario.attacca(v);
                        } else {
                            System.out.println("Avversario morto");
                        }
                        System.out.println("Round finito. \n" + v.getForza() + "\nLa tua vita residua è: " + v.getVita());
                        System.out.println("L'avversario ha vita residua: " + avversario.getVita());
                        System.out.println("Vuoi attaccate ancora? (True/False)");
                        continuaDuello = scanner.nextBoolean();
                    } while (continuaDuello);

                    break;

                case 3:
                    System.out.println("Hai scelto di essere un licantropo!");
                    avversario = avversari[random.nextInt(avversari.length)];
                    System.out.println("Il tuo avversario è " + avversario.toString() + "!");
                    do {
                        if (l.vita <= 0 || l.forzaUmano <= 0 && l.forzaMostro <= 0 || avversario.getVita() <= 0) {
                            if (l.vita <= 0 || l.forzaUmano <= 0 && l.forzaMostro <= 0) {
                                System.out.println("HAI PERSO");
                            } else {
                                System.out.println("HAI VINTO");
                            }
                            continuaDuello = false; // Termina il combattimento
                            break; 
                        }

                        l.attacca(avversario);
                        if (avversario.getVita() > 0) {
                            System.out.println("Attenzione al contrattacco!");
                            avversario.attacca(l);
                        } else {
                            System.out.println("Avversario morto");
                        }
                        System.out.println("Round finito. \n" + l.getForza() + "\nLa tua vita residua è: " + l.getVita());
                        System.out.println("L'avversario ha vita residua: " + avversario.getVita());
                        System.out.println("Vuoi attaccate ancora? (True/False)");
                        continuaDuello = scanner.nextBoolean();
                    } while (continuaDuello);
                    break;

                default:
                    System.out.println("Non hai selezionato nessun personaggio, non puoi combattere.");
            }

            System.out.println("Vuoi riprovare? (True/False)");
            Boolean riprova = scanner.nextBoolean();
            continuaGioco = riprova;
        } while (continuaGioco); // Continua il ciclo principale finché il giocatore vuole riprovare

        System.out.println("ADDIOS!");
        scanner.close();
    }
}


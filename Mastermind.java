/*
*Feu un programa en Java que simule el joc del Mastermind. Teniu un exemple online a la següent adreça web. No es permetran colors repetits a la combinació secreta. Els colors a triar se representaran en una lletra d'entre les següents (i les respectives minúscules):

-R: roig,

-G: verd,

-Y: groc,

-N: negre,

-W: blanc,

-O: taronja,

-B: blau,

-M: marró.

Inicialment el programa calcularà una seqüència secreta de 4 colors no repetits.

A continuació l'usuari escriurà una línia d'un mínim de 4 caràcters indicant la posició de les 4 boles de colors. Si entre els 4 primers caràcters hi ha algun que no pertany als correctes, el programa sol·licitarà la introducció d'una nova línia i no comptarà com a intent la darrera. Farem el mateix si la línia té menys de 4 caràcters.

Per cada intent correcte el programa mostrarà la quantitat d'encerts de color, posant un número seguit de la 'C', i de color més posició, posant un número seguit de la 'P', i a continuació la seqüència d'intents efectuats en forma de taula (evidentment intenteu millorar l'aspecte de l'exemple que he fet, ja que a esta editor no es pot fer res mínimament xulo).

L'usuari té 10 intents per encertar la combinació. A cada intent se mostrarà el número d'intent i els que queden per perdre. En cas d'encertar la combinació abans del 10è intent mostrarem un missatge de felicitació, i si s'arriba sense trobar la solució un de derrota (per exemple: Ho sento, la combinació secreta era RGYN. A la próxima!!.

Nota: per comprovar que el programa funciona bé farem que si a un intent l'usuari escriu MOSTRAR (o qualsevol variant en majúscules/minúscules), se li mostrarà la combinació secreta i no es comptabilitzarà com a intent. A més, si a un intent l'usuari escriu COLORS (o qualsevol variant en majúscules/minúscules), se li mostrarà la llista d'inicials dels respectius colors i no es comptabilitzarà com a intent.

Exemple1:

Combinació secreta calculada... Tens 10 intents per endevinar-la.

Intent nº 1.

Introduix una línia de mínim 4 caràcters RGYNWOBM:

as

Ha de ser de mínim 4 caràcters

Introduix una línia de mínim 4 caràcters RGYNWOBM:

PGjYNMF

Hi ha caràcters de color incorrectes entre els 4 primers: PJ

Introduix una línia de mínim 4 caràcters RGYNWOBM:

Colors

-R: roig,

-G: verd,

-Y: groc,

-N: negre,

-W: blanc,

-O: taronja,

-B: blau,

-M: marró.


Introduix una línia de mínim 4 caràcters RGYNWOBM:

rRrR

0C, 1P

----------------------

| R | R | R | R |

----------------------


Intent nº 2.

Introduix una línia de mínim 4 caràcters RGYNWOBM:

Mostrar
La combinació secreta és: YORB

Introduix una línia de mínim 4 caràcters RGYNWOBM:

yorb

Enhorabona, has encertat la combinació secreta en 2 intents!!

----------------------

| Y | O | R | B |

----------------------

| R | R | R | R |

----------------------



* */


import java.util.Random;
import java.util.Scanner;

public class mimikatz {
    public static void main(String[] args) {

        // Declaració de variables
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        //Colors
        int key = 0, cont2=0;
        String secret_key="";
        String [] password ={"","","",""};
        String [] colors = {"R","G","Y","N","W","O","B","M"};
        String [] show_colors = {"-R:Roig","-G:Verd","-Y:Groc","-N:Negre","-W:Blanc","-O:Taronja","-B:Blau","-M:Marron"};
        String show = "";
        String usuari="";
        String [] pass_usuari = {"","","",""};
        //String [] usuari_colors = new String[3];
        char compare;
        //Creació de la variable mostra que ens servira per mostra els valors de les lletres.
        for(int i =0; i < show_colors.length; i++){
            show += show_colors[i] + "\n";
        }
        //Creació de la combinació secreta i guardada a una array
        for (int i = 0; i < 4 ; i++){
            key = r.nextInt(7);
            secret_key += colors[key];
            password[i] += colors[key];
        }
        //Bucle per a comparar la combinació del jugador amb la secreta.
        System.out.println("Welcome to Mastermind you have ten tries to win the game.");


        for (int i=0; i<10;i++){
            usuari = scan.nextLine().toUpperCase().trim();
            //Limpiar la array del usuario para que no se acomulen las conbinaciones.
            for (int j = 0; j < pass_usuari.length ; j++) {
                pass_usuari[j]="";
            }
            // Convertir la convinación del usuario a array.
            for (int j = 0,cont=0; j <4 ; j++) {
                compare = usuari.charAt(j);
                pass_usuari[j]+=compare;

            }

            //Comparacion de combinaciones
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j <3 ; j++) {
                    if(pass_usuari[k].equals(password[j])) cont2++;
                }

            }


            if (usuari.equals("SHOW")) System.out.println(secret_key);
            if (usuari.equals("COLORS")) System.out.println(show);

            else if(usuari.length()>4 || usuari.length()<4){
                System.out.println("Its just have to be 4 characters! ");
            }else{
                if (usuari.equals(secret_key)){
                    System.out.println("Congratulations you win the game!");
                    break;
                }

            }


        }
        //



    }
}

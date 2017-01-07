package js224eh_lab4;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-07.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 2
 * =========
 * Skriv ett program RaknaTecken.java som räknar tecken av olika typer i en
 * text som läses från en fil. Vi vill att ni skall ange hur många tecken som
 * kan hittas i texten av följande kategorier.
 *
 *     - Stora bokstäver
 *     - Små bokstäver
 *     - "Whitespace" (Dvs, mellanslag, tab och return)
 *     - Övriga tecken
 *
 * Sökvägen till den textfil som ni läser ifrån får vara hårdkodad i programmet.
 * (Vi kommer att testa programmet på en egen textfil.) Ett exempel på en
 * textfil är ChampagnenBlirDyrare. Det är en artikel om champagne hämtad från
 * tidningen Dagens Nyheter. Vi rekommenderar dock att ni börjar med en lite
 * mindre text.
 *
 * En körning med filen ChampagnenBlirDyrare som indata skall ge följande
 * resultat:
 *              Antal stora bokstäver: 52
 *              Antal små bokstäver: 2063
 *              Antal "whitespaces": 463
 *              Antal övriga: 83
 *
 * Om ditt resultat inte överensstämmer exakt med ovanstående ska en skriftlig
 * förklaring till skillnaderna inlämnas tillsammans med labben.
 */


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RaknaTecken
{
    final static String FILE_PATH = "/home/jonas/LNU/1DV506_Problemlosning/assignments/lab4/ChampagnenBlirDyrare_UTF8.txt";

    private static int countUpperCase  = 0;
    private static int countLowerCase  = 0;
    private static int countWhitespace = 0;
    private static int countOther      = 0;

    public static void main(String[] args)
    {
        StringBuilder text = new StringBuilder();

        try {
            File    file = new File(FILE_PATH);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String str = scan.nextLine();
                text.append(str + "\n");
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        runAnalysis(text.toString());
        System.out.println("Antal stora bokstäver: " + countUpperCase);
        System.out.println("Antal små bokstäver: " + countLowerCase);
        System.out.println("Antal \"whitespaces\": " + countWhitespace);
        System.out.println("Antal övriga: " + countOther);
    }

    private static void runAnalysis(String text)
    {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                countUpperCase++;
            } else if (Character.isLowerCase(c)) {
                countLowerCase++;
            } else {
                if (Character.isWhitespace(c)) {
                    countWhitespace++;
                } else {
                    countOther++;
                }
            }
        }
    }
}

/* Om jag laddar hem och använder exempelfilen "ChampagnenBlirDyrare.txt"
   direkt i befintligt skick så fungerar inte mitt program alls.
   Det beror på att jag använder använder teckenkodningen UTF-8 i dels
   filsystemet men också som standard i texteditorer. Eftersom att det är
   svårt att lista ut vilken teckenkodning som används så antar många
   program i mitt system att textfiler alltid är kodade i UTF-8 och det slår
   fel i det här fallet.

   Ibland kan min implementation räkna till 462 whitespaces istället för
   referensresultatets 463. Det kan också ha att göra med hur olika
   operativsystem hanterar whitespace, för ASCII-kodad text hanteras
   radbrytning olika för olika operativsystem.

                       Escape-sekvens   Förkortning   ASCII-värde
       Windows         \r \n            CR LF         0x0D 0x0A
       UNIX-liknande      \n               LF              0x0A

   Unicode gör det hela ännu krångligare. Jag är säker på att det enstaka
   whitespace-tecken som skiljer sig åt har att göra med teckenkodningen.
   Många gånger går det bra att läsa ASCII-filer under antagandet att de är
   UTF-8 pga hur Unicode fungerar, kodningen för ASCII-tecken är likadana
   i Unicode --- det kan gå att läsa in filer med skapligt resultat trots att
   fel teckenkodning använts. Ofta så länge inte för "krångliga" tecken använts.
   Originalfilen är kodad med ISO-8859-14 som är vanligt i Windows-världen.
   Utan någon slags konvertering till UTF-8 eller att teckenkodningen
   explicit specificeras vid inläsning så kan det hända att metoderna från
   standardbibliotekets Character-klass som används nedan inte beter sig precis
   rätt.
*/


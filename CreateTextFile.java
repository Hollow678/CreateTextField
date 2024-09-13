// começa danilo//
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.awt.*;
import  javax.swing.*;


public class CreateTextFile
{
    private Formatter output;
    int acct,i=0;
    String firtsname, finalname, acc, balanço;
    double bal;
//acaba danilo//
    //começa ana//
public void openFile()
    {
        try
        {
            output =new Formatter( "clients.txt");
        }

        catch ( SecurityException securityException )
        {
            System.err.println( "Você não tem acesso para escrever neste arquivo." );
            System.exit(1);
        }
        catch ( FileNotFoundException fileNotFoundException)
        {
            System.err.println( "Erro ao abrir ou criar o arquivo." );
            System.exit(1);
        }
    }
//acaba ana//
    //aluminio otaviano
    public void addRecords()
    {

        AccountRecord record = new AccountRecord();

        System.out.printf( "%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator", "when you are prompted to enter input.", "On UNIX/Linux/Mac OS X type <ctrl> d then press Enter", "On Windows type <ctrl> z then press Enter" );

        acc= JOptionPane.showInputDialog("Insira a conta");
        firtsname = JOptionPane.showInputDialog("insira o primeiro nome");
        finalname = JOptionPane.showInputDialog("insira o último nome");
        balanço= JOptionPane.showInputDialog("Insira o saldo da conta");
        acct= Integer.parseInt(acc);
        bal= Double.parseDouble(balanço);


        while ( i!=1 )
        {
            try
            {

                record.setAccount(acct);
                record.setFirstName( firtsname );
                record.setLastName( finalname );
                record.setBalance( bal );

                if (record.getAccount() > 0)
                {
                    output.format( "%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance() );
                    i=1;
                }
                else
                {
                    System.out.println( "Número da conta precisa ser maior do que 0." );
                }
            }
            catch ( FormatterClosedException formatterClosedException)
            {
                System.err.println( "Error writing to file." );
                return;
            }
            catch ( NoSuchElementException elementException )
            {
                System.err.println( "Entrada inválida. Por favor, tente novamente." );

            }
            System.out.printf( "%s %s\n%s", "Enter account number (> 0),", "first name, last name and balance.", "? " );
        }
    }

    public void closeFile()
    {
        if ( output != null )
        {
            output.close();
        }
    }
}
//fecha aluz e otaviano//
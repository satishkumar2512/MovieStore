package model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.String;
import java.util.Scanner;

public class Main
{
    static Store store=new Store();
    public static void main(String[] args)
    {
        System.out.println("***************** JAVA VIDEO STUDIO *****************");
        Store store=new Store();
        store.addMovie(new Movie("The Shawhank","Blue-Ray",9.2,550.00, true));
        store.addMovie(new Movie("The Godfather","Blue-Ray",9.1,450.00, true));
        store.addMovie(new Movie("The Harlie-coffee","DVD",9.0,650.00, true));
        System.out.println(store);
        try {
            loadMovies("movies.txt");
            System.out.println("MOVIES LOADED \n\n");
            manageMovies();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void loadMovies(String fileName) throws FileNotFoundException
    {
        FileInputStream fis=new FileInputStream(fileName);
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt())
        {
            String line=sc.nextLine();
            String[] words=line.split("__");
            store.addMovie(new Movie(words[0],words[1],Double.parseDouble(words[2]),Double.parseDouble(words[3]),Boolean.parseBoolean(words[4])));
        }
        sc.close();
    }
    public static void manageMovies()
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("\nWould You like to \n\ta)purchase\n\tb)rent \n\tc)return ");
            String response=sc.nextLine();
            if(!(response.equals("a") || response.equals("b") ||response.equals("c")))
            {
                sc.close();
                break;
            }
            System.out.print("Enter the name of th movie :");
            String name=sc.nextLine();
            if (store.getMovie(name)==null)
            {
                System.out.println("input you provided is not valid");
                continue;
            }
            switch(response)
            {
                case "a":
                    if(!(store.getMovie(name).isAvailable))
                    {
                         System.out.println("The movie is not available for purchase");
                         continue;
                    }
                    store.action(name,"sell");break;
                case "b":store.action(name,"rent");break;
                case "c":store.action(name,"return");break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\\n"+store);
        }
    }
}

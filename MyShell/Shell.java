import java.util.*;
import java.io.*; //File

public class Shell
{
    String directory = System.getProperty("user.dir");
    private String UserInput = " ";
    File folder = new File(directory);
    File[] listOfFiles = folder.listFiles();
    
   public static void main(String[] args)
    {
        Shell main = new Shell();
        main.go();
    }
    
    private void go()
    { 
        boolean running = true;
        Scanner key = new Scanner(System.in);
        System.out.println("Welcome to CoolShell");
        
        while(running)
        {
        folder = new File(directory);
        System.out.print("CoolShell>h");
        System.out.println("\n");
        UserInput = key.nextLine();
        
        if(UserInput.equals("l") || UserInput.equals("list"))
            list();

        if(UserInput.equals("h")||UserInput.equals("help"))
            pWelcome();
            
        if(UserInput.equals("e")|| UserInput.equals("exit"))
             {System.out.println("bye bye"); break;}
            
        if(UserInput.length() > 1 && UserInput.substring(0,2).equals("d ")|| (UserInput.length() > 5 && UserInput.substring(0,5).equals("down ")))
             {d(UserInput);}
            
        if(UserInput.equals("w")||UserInput.equals("wai"))
            w();
            
        if(UserInput.equals("u")||UserInput.equals("up"))
            up();
        //Check is file or is directory
            System.out.print("CoolShell>h");
            
        
        
    }
    
       }
    
    
      private void pWelcome()
    {
        System.out.println(" ");
        System.out.println("(l)ist: lists contents of current directory");
        System.out.println("(d)own [dir]: moves into the specified child directory");
        System.out.println("(u)p: moves to the parent directory");
        System.out.println("(w)ai: prints the current directory");
        System.out.println("(e)xit: exits the shell");
        System.out.println("(h)elp: prints a list of the supported commands\n");
    }
    
    public void list()
    {
        //File folder = new File(System.getProperty("user.dir"));
/*        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();*/

    for (int i = 0; i < listOfFiles.length; i++) 
    {
      if (listOfFiles[i].isFile()) 
      {
        System.out.println("(f)" + listOfFiles[i].getName());
      }
      else if (listOfFiles[i].isDirectory()) 
      {
        System.out.println("(d)" + listOfFiles[i].getName());
      }
     }
       System.out.println(" ");
    }
    
    private void up()
    {
        int charplace = directory.lastIndexOf("/");
        directory = directory.substring(0, charplace);
        Clean();
        System.out.println(directory);
    }
    
    public void w()
    {
               System.out.println(directory);
              /*  System.out.println(
              System.getProperty("user.dir"));*/
              System.out.println(" ");
    }
    
    public void d(String str)
    {
        boolean dirExists = false;
        String[] cd = str.split(" ");
        System.out.println(cd[1]);
        
        for(File file : listOfFiles)
        {
    
            if(file.getName().equals(cd[1]))
             {
                 directory = directory + "/" + file.getName();
                 folder = new File(directory);
                 listOfFiles = folder.listFiles();
                 dirExists = true;
             }
        }
        
        if(dirExists == false)
        {
            System.out.println("Sorry " + cd[1] + "is not a directory");
        }
        
        w();
    }

    public void Clean()
    {
        folder = new File(directory);
        listOfFiles = folder.listFiles();
    }
}

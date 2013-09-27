import java.net.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;

/**
 * This class uses the URL class to create a BufferedReader of the source
 * code of a page from Liquipedia. It then parses through this source to get
 * information about Players, Games, and Tournaments. 
 * <p>
 * The functionality of the parsing methods rely upon the URL being formed
 * correctly. If you call one of these methods without first checking the
 * parser for isValid() the output of the parsing methods is not guaranteed
 * and it may crash. Parse methods will check <code>isValid()</code> before 
 * executing, and will throw an Exception if it fails.
 * <p>
 * This class is immutable
 * <p>
 * Made for MHacks - Fall 2013
 * 
 * @author    packrat386
 * @version   %I%, %G%
 * @see       java.net.URL
 * @see       java.io.BufferedReader
 */

public class LPParser{
  //**CLASS VARIABLES**
  
  /**
   * This URL is the url site from which we will be getting information. How
   * it is formed depends on which constructor gets called.
   * 
   * @see #getURL()
   */
  private URL target;
  
  /**
   * This is the reader that reads from our target site.
   */
  private BufferedReader input;
  
  /**
   * This variable indicates whether or not the URL seems to have been formed
   * correctly. 
   * 
   * @see #isValid()
   */
  private boolean valid;
  
  /**
   * This ArrayList contains all of the information that we get from the players
   * liquipedia page. The format is <nationality, race, team, tlpdID>
   * 
   * @see #getInfo()
   */
  private ArrayList<String> info;
  
  private String redirect;
  
  /**
   * Default Constructor sets <code>target</code> to "http://wiki.teamliquid.net/" 
   * and opens <code>input</code>. Sets <code>valid</code> to false necessarily.
   */
  public LPParser(){
    try{
      valid = false;
      target = new URL("http://wiki.teamliquid.net/");
      input = new BufferedReader(new InputStreamReader(target.openStream()));
    }catch(Exception e){;}
  }
  
  /**
   * Initializes <code>target</code> based on the provided <code>nick</code>, and
   * opens <code>input</code> This Construcor also reads through <code>input</code> looking
   * for the landmarks used in the parse methods and populates <code>info</code>. If some
   * of the landmarks are not present then the parser is marked invalid. If the page gives 
   * another page to redirect to, that data is saved in <code>redirect</code>.
   * 
   * @param   nick  In game nickname used to search for a player on Liquipedia.
   */
  public LPParser(String nick) throws Exception{
    String mySearch = "http://wiki.teamliquid.net/starcraft2/api.php?format=xml&action=query&titles="
      + nick + "&prop=revisions&rvprop=content";
    target = new URL(mySearch);
    input = new BufferedReader(new InputStreamReader(target.openStream()));
    
    //We can go through the file once to see if the landmarks are there
    
    //initiating some booleans for checking
    boolean country = false;
    boolean race = false;
    boolean team = false;
    boolean tlpd = false;
    
    //filling info with empty strings
    info = new ArrayList<String>();
    for(int i = 0; i < 4; ++i)
      info.add("");
    String inputLine;
    
    //Checking to see that we have all of the landmarks and to see if there
    //is a redirect page
    while((inputLine = input.readLine()) != null){
      if(inputLine.length() >=9 && inputLine.substring(0,9).equals("|country=")){
        info.set(0, inputLine.substring(9));
        country = true;
      }
      if(inputLine.length() >=6 && inputLine.substring(0,6).equals("|race=")){
        info.set(1, inputLine.substring(6));
        race = true;
      }
      if(inputLine.length() >=6 && inputLine.substring(0,6).equals("|team=")){
        info.set(2, inputLine.substring(6));
        team = true;
      }
      if(inputLine.length() >= 10 && inputLine.substring(0, 10).equals("|tlpdhots=")){
        info.set(3, inputLine.substring(10));
        tlpd = true;
      }
      if(inputLine.length() >= 96 &&
         inputLine.contains("#REDIRECT")){
        for(int i = 0; i < inputLine.length(); ++i){
          if(inputLine.charAt(i) == '#')
            redirect = inputLine.substring(i+12, (i+12+nick.length()));
        }
      }
    }
    
      //Only valid if it fulfills all of our conditions
      if(country && race && team && tlpd)
        valid = true;
      else
        valid = false; 
  }
  
  
  /**
   * This function returns player information as an ArrayList of Strings. It 
   * returns data in the format <nationality, race, team, tlpdID>. 
   * 
   * @return   ArrayList<String> info: <name, race, team, tlpdID>
   */
  public ArrayList<String> getInfo(){
    return info;
  }
  
  /**
   * Returns true if the parser's search is well formed
   * 
   * @return   this.valid
   * @see      #valid
   */
  public boolean isValid(){
    return valid;
  }
  
  /**
   * Returns the redirect string given by the compiler. If no redirect 
   * string was found, its value will be <code>null</code>
   * 
   * @return   this.redirect
   * @see      #redirect
   */
  public String getRedirect(){
    return redirect;
  }
}
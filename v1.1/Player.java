import java.lang.String;
import java.util.ArrayList;
import java.lang.Integer;

/**
 * This is a class that holds information about a gven player of Starcraft 2
 * It will hold the following information about a player.
 * <ul>
 * <li>Nickname
 * <li>Team
 * <li>In game Race
 * <li>Nationality
 * <li>TLPD ID Number
 * </ul>
 * This information will mostly be drawn from Liquipedia using the LPParser class.
 * <p>
 * This class is immutable.
 * <p>
 * Made for MHacks - Fall 2013.
 * 
 * @author    packrat386
 * @version   %I%, %G%
 */

public class Player{
  //**CLASS VARIABLES**
  
  /**
   * The in game nickname of the Player.
   * 
   * @see   #getNick()
   */
  private String nick;
  
  /**
   * The ID number in the TLPD system for the Player.
   * 
   * @see   #getID()
   */
  private int tlpdID;
  
  /**
   * The nationality code of the Player
   * 
   * @see   #getNat()
   */
  private String nationality;
  
  /**
   * The Team of the Player.
   * 
   * @see   #getTeam()
   */
  private String team;
  
  /**
   * The in game Race of the Player. One of Terran, Zerg, Protoss, or Random
   * 
   * @see   #getRace()
   */
  private String race;
  
  /**
   * An LPParser that will be used to get information about the Player from
   * the online resource TLPD
   */
  private LPParser myLPParser;
  
  /**
   * This boolean is true if myLPParser was able to properly parse data from
   * the Liqupedia website based on the nickname provided.
   * 
   * @see   #isValid()
   */
  private boolean valid;
  
  //**CONSTRUCTORS**
  
  /**
   * Default constructor sets all values to their defaults. Necessarily sets
   * valid to false.
   */
  public Player() throws Exception{
    nick = "";
    myLPParser = new LPParser();
    tlpdID = 0;
    nationality = "";
    team = "";
    race = "";
    valid = false;
  }
  
  /**
   * takes in a nickname for a player and then uses the LPParser 
   * class to get other information about the player if possible.
   * 
   * @param   inNick  This String should uniquely identify a players name when
   *                  searched on Liqipedia. If not, the information will be set to 
   *                  default.
   */
  public Player(String inNick) throws Exception{
    boolean done = false;
    nick = inNick;
    while(!done){
      myLPParser = new LPParser(nick);
      ArrayList<String> playerData;
      if(myLPParser.isValid()){
        playerData = myLPParser.getInfo();
        nationality = playerData.get(0);
        race = playerData.get(1);
        team = playerData.get(2);
        tlpdID = Integer.parseInt(playerData.get(3));
        valid = true;
        done = true;
      }
      else if(myLPParser.getRedirect() != null){
        nick = myLPParser.getRedirect();
      }
      else{
        tlpdID = 0;
        nationality = "";
        team = "";
        race = "";
        valid = false;
        done = true;
      }
    }
  }
  
  //**ACCESSOR METHODS**
  
  /**
   * Returns the nickname of the Player
   * 
   * @return   this.nick
   * @see      #nick
   */
  public String getNick(){
    return nick;
  }
  
  /**
   * Returns the tlpd ID of the Player
   * 
   * @return   this.tlpdID
   * @see      #tlpdID
   */
  public int getID(){
    return tlpdID;
  }
  
  /**
   * Returns the nationality code of the Player
   * 
   * @return   this.nationality
   * @see      #nationality
   */
  public String getNat(){
    return nationality;
  }
  
  /**
   * Returns the race of the Player
   * 
   * @return   this.race
   * @see      #race
   */
  public String getRace(){
    return race;
  }
  
  /**
   * Returns true if the information about the player is sufficiently complete
   * to be used.
   * 
   * @return   this.valid
   * @see      #valid
   */
  public boolean isValid(){
    return valid;
  }
  
  /**
   * Converts the information about the Player to a String
   * 
   * @return   String representation of the Player
   */
  public String toString(){
    return "Nickname: " + nick + "\n"
      + "ID: " + tlpdID + "\n"
      + "Nationality: " + nationality + "\n"
      + "Team: " + team + "\n"
      + "Valid: " + valid;
  }
  
  /**
   * Returns a string that generates a TLPD link when using TL.net's BBcode
   * 
   * @return   BBcode to create a TLPD link
   */
  public String tlpdize(){
    if(this.getRace().length() > 0)
      return "[tlpd#players#" + this.getID() + "#" + this.getRace().substring(0,1)
      + "#hots]" + this.getNick() + "[/tlpd]";
    else
      return "[tlpd#players#" + this.getID() + "#" + "T"
      + "#hots]" + this.getNick() + "[/tlpd]";
  }
}
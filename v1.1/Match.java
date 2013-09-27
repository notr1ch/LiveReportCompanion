import java.lang.String;
import java.lang.Integer;

/**
 * This class is the core element of the Live Report package in that
 * it keeps track of 2 members of the Player class who are matched 
 * against each other as well as providing methods for formatting
 * output about particular matches. Note that this class does not
 * check for validity of the Player objects that it accepts, so setting
 * those up should be done outside of the constructor.
 * <p>
 * This class is immutable
 * <p>
 * Made for MHack - Fall 2013
 * 
 * @author   packrat386
 * @version  %I%, %G%
 */

public class Match{
  //**CLASS VARIABLES**
  
  /*
   * The first player in the Match.
   * 
   * @see   #getP1()
   */
  private Player p1;
  
  /*
   * The second player in the Match
   * 
   * @see   #getP2()
   */
  private Player p2;
  
  /*
   * The number of sets in the Match
   * 
   * @see   #getBestOf()
   */
  private int bestOf;
  
  //**CONSTRUCTORS**
  
  /*
   * Default Constructor, sets players equal to empty players and bestOf to 1
   */
  public Match() throws Exception{
    p1 = new Player();
    p2 = new Player();
    bestOf = 1;
  }
  
  /*
   * Takes in 2 Players and an integer number of games and assigns them to
   * fields
   * 
   * @param   inP1  The first Player to be input
   * @param   inP2  The second Player to be input
   * @param   boX   The number of sets. Should be positive and odd.
   */
  public Match(Player inP1, Player inP2, int boX) throws Exception{
    p1 = inP1;
    p2 = inP2;
    bestOf = boX;
  }
  
  //**ACCESSOR METHODS**
  
  /*
   * Returns Player 1
   * 
   * @return   this.p1
   * @see      #p1
   */
  public Player getP1(){
    return p1;
  }
  
  /*
   * Returns Player 2
   * 
   * @return   this.p2
   * @see      #p2
   */
  public Player getP2(){
    return p2;
  }
  
  /*
   * Returns the number of sets in the match
   * 
   * @return   this.bestOf
   * @see      #bestOf
   */
  public int getBestOf(){
    return bestOf;
  }
  
  /*
   * Returns the class information as a String. Returns the individual 
   * <code>toString</code> methods for p1 and p2 then converts bestOf to
   * a String afterward.
   */
  public String toString(){
    return p1.toString() + "\n"
      + p2.toString() + "\n"
      + Integer.toString(bestOf);
  }
  
  //**UTILITY METHODS**
  
  /**
   * Returns a String that shows the 2 players in the match as tlpd links
   * 
   * @return   Header String
   */
  public String toTLHeader(){
    String outstring = "[b]" + " " +  this.countryToCode(p1.getNat()) + " " + p1.tlpdize() 
      + " vs " + this.countryToCode(p2.getNat()) + " " + p2.tlpdize() + "[/b]\n";
    return outstring;
  }
  
  /**
   * Returns sets formatted for the overall results section of a live report.
   * The number of sets is equal to <code>bestOf</code> and they are in the 
   * format player1 <> player2. The player names are tlpdize.
   * 
   * @return   overall results string
   */
  public String toTLResult(){
    String outstring = "";
    for(int i = 0; i < this.bestOf; i++){
      outstring = outstring + p1.tlpdize() + " <> " + p2.tlpdize() + "\n";
    }
    return outstring;
  }
  
  /**
   * Returns sets formatted for the spoiler free results section of a live
   * report. The number of sets is equal to <code>bestOf</code> and they are in the
   * format player1 <> player 2. The player names are tlpdized. The match is placed
   * inside a spoiler tag, and each set is placed inside a separate, numbered 
   * spoiler tag.
   * 
   * @return   spoiler free results string
   */
  public String toTLSpoilerfree(){
    String outstring = "[spoiler=" + p1.getNick() + " vs " + p2.getNick() + "]\n";
    for(int i = 0; i < this.bestOf; i++){
      outstring = outstring + "[spoiler=Game " + (i+1) + "]"
        + p1.tlpdize() + " <> " + p2.tlpdize() + "[/spoiler]\n";
    }
    outstring = outstring + "[/spoiler]";
    return outstring;
  }
  
  /**
   * Returns sets formatted for the overall results section of a live report, for
   * a match in which the players are not yet determined. The number of sets is
   * equal to boX and they are in the format TBD <> TBD.
   * 
   * @return   Overall result for an empty match
   */
  public static String emptyTLResult(int boX){
    String outstring = "";
    for(int i = 0; i < boX; i++){
      outstring = outstring + "TBD <> TBD" + "\n";
    }
    return outstring;
  }
  
  /**
   * Returns sets formatted for the Spoilerfree results section of a live report
   * for a match in which the players are not yet determined. The number of sets is
   * equal to boX and they are in the format TBD <> TBD. The entire match is in 
   * a spoiler tag, and each set is in an individual spoiler tag.
   * 
   * @return   spoiler free results string
   * @param    boX  an integer for the number of sets in the match
   */
  public static String emptyTLSpoilerfree(int boX){
    String outstring = "[spoiler=TBD vs TBD]\n";
    for(int i = 0; i < boX; i++){
      outstring = outstring + "[spoiler=Game " + (i+1) + "]TBD <> TBD[/spoiler]\n";
    }
    outstring = outstring + "[/spoiler]";
    return outstring;
  }
   
  /**
   * Returns sets formatted for the Spoilerfree results section of a live report
   * for a match in which the players are not yet determined. The number of sets is
   * equal to boX and they are in the format TBD <> TBD. The entire match is in 
   * a spoiler tag titled with <code>title</code>, and each set is in an individual spoiler tag. 
   * 
   * @return   spoiler free results string
   * @param    boX  an integer for the number of sets in the match
   * @param    title  a String for the title of the empty match
   */
  public static String emptyTLSpoilerfree(int boX, String title){
    String outstring = "[spoiler=" + title + "]\n";
    for(int i = 0; i < boX; i++){
      outstring = outstring + "[spoiler=Game " + (i+1) + "]TBD <> TBD[/spoiler]\n";
    }
    outstring = outstring + "[/spoiler]";
    return outstring;
  }
  
  /**
   * Returns the 2 letter country code of the given country. Uses a large
   * switch block to decide with one to return. If the given name is not found
   * it returns ":??:".
   * 
   * @returns   2 letter country code
   * @param     country  a String that is the name of the given country
   */
  private String countryToCode(String country){
    switch(country){    
      case "Armenia":
        return ":am:";
      case "Australia":
        return ":au:";
      case "Austria":
        return ":at:";
      case "Azerbaijan":
        return ":az:";
      case "Bangladesh":
        return ":bd:";
      case "Belarus":
        return ":by:";
      case "Belgium":
        return ":be:";
      case "Bolivia":
        return ":bo:";
      case "Bosnia and Herzegovina":
        return ":ba:";
      case "Brazil":
        return ":br:";
      case "Bulgaria":
        return ":bg:";
      case "Canada":
        return ":ca:";
      case "Chile":
        return ":cl:";
      case "China":
        return ":cn:";
      case "Colombia":
        return ":co:";
      case "Costa Rica":
        return ":cr:";
      case "Croatia":
        return ":hr:";
      case "Czech Republic":
        return ":cz:";
      case "Denmark":
        return ":dk:";
      case "Dominican Republic":
        return ":do:";
      case "Egypt":
        return ":eg:";
      case "El Salvador":
        return ":sv:";
      case "Europe":
        return ":eu:";
      case "Estonia":
        return ":ee:";
      case "Ecuador":
        return ":ec:";
      case "Faroe Islands":
        return ":fo:";
      case "Finland":
        return ":fi:";
      case "France":
        return ":fr:";
      case "Germany":
        return ":de:";
      case "Greece":
        return ":gr:";
      case "Guatemala":
        return ":gt:";
      case "Hong Kong":
        return ":hk:";
      case "Honduras":
        return ":hn:";
      case "Hungary":
        return ":hu:";
      case "Iceland":
        return ":is:";
      case "India":
        return ":in:";
      case "Indonesia":
        return ":id:";
      case "Israel":
        return ":il:";
      case "Iran":
        return ":ir:";
      case "Ireland":
        return ":ie:";
      case "Italy":
        return ":it:";
      case "Japan":
        return ":jp:";
      case "Kazakhstan":
        return ":kz:";
      case "South Korea":
      case "Korea":
        return ":kr:";
      case "Kuwait":
        return ":kw:";
      case "Latvia":
        return ":lv:";
      case "Libya":
        return ":ly:";
      case "Liechtenstein":
        return ":li:";
      case "Lithuania":
        return ":lt:";
      case "Luxembourg":
        return ":lu:";
      case "Macedonia":
        return ":mk:";
      case "Malaysia":
        return ":my:";
      case "Maldives":
        return ":mv:";
      case "Malta":
        return ":mt:";
      case "Mexico":
        return ":mx:";
      case "Moldova":
        return ":md:";
      case "Morocco":
        return ":ma:";
      case "Namibia":
        return ":na:";
      case "Netherlands":
        return ":nl:";
      case "New Zealand":
        return ":nz:";
      case "Nigeria":
        return ":ng:";
      case "Norway":
        return ":no:";
      case "Panama":
        return ":pa:";
      case "Pakistan":
        return ":pk:";
      case "Paraguay":
        return ":py:";
      case "Peru":
        return ":pe:";
      case "Philippines":
        return ":ph:";
      case "Poland":
        return ":pl:";
      case "Portugal":
        return ":pt:";
      case "Puerto Rico":
        return ":pr:";
      case "Romania":
        return ":ro:";
      case "Russia":
        return ":ru:";
      case "Serbia":
        return ":rs:";
      case "Singapore":
        return ":sg:";
      case "Slovak Republic":
        return ":sk:";
      case "Slovenia":
        return ":si:";
      case "South Africa":
        return ":za:";
      case "Somalia":
        return ":so:";
      case "Spain":
        return ":es:";
      case "Sweden":
        return ":se:";
      case "Switzerland":
        return ":ch:";
      case "Taiwan":
        return ":tw:";
      case "Thailand":
        return ":th:";
      case "Trinidad And Tobago":
        return ":tt:";
      case "Turkey":
        return ":tr:";
      case "Tunisia":
        return ":tn:";
      case "Ukraine":
        return ":ua:";
      case "United Arab Emirates":
        return ":ae:";
      case "United Kingdom":
        return ":uk:";
      case "United Nations":
        return ":un:";
      case "USA":
      case "United States":
        return ":us:";
      case "Uzbekistan":
        return ":uz:";
      case "Venezuela":
        return ":ve:";
      case "Vietnam":
        return ":vn:";
      case "Zimbabwe":
        return ":zw:";
    }
    return ":??:";
  }
}
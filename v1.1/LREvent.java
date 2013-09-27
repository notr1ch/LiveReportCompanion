import java.lang.String;
import java.util.ArrayList;

/**
 * This class is used to consolidate information from one or more elements
 * of the <code>Match</code> class and to generate the text of a Live Report
 * Original Post. This class makes use of the methods in  <code>Match</code> 
 * to get data together.
 * <p>
 * This class is immutable.
 * <p>
 * Made for MHacks - Fall 2013
 * 
 * @author   packrat386
 * @version  %I%, %G%
 */

public class LREvent{
  //**FIELDS
  
  /**
   * This is an ArrayList that holds all of the matches that will be displayed in
   * our LR thread.
   * 
   * @see   #getMatches()
   */
  private ArrayList<Match> matches;
  
  /**
   * This is the date stored as a single integer. It should be in the form
   * yyyymmdd.
   * 
   * @see   #getDate()
   * @see   #convertToTLDate(int , int)
   */
  private int date;
  
  /**
   * This is a 24 hour time in the format hhmm. It should be the GMT time of 
   * the event.
   * 
   * @see   #getTime()
   * @see   #convertToTLDate(int , int)
   */
  private String time;
  
  /**
   * This is the title of the event that the LR thread is for
   * 
   * @see   #getTitle();
   */
  private String title;
  
  /**
   * This is the sting that gives the tournament that the event is part of 
   * on Liquipedia.
   * 
   * @see   #getTournament()
   */
  private String tournament;
  
  /**
   * This string indicates the format of the tournament. It will either be of the form
   * "DTx" which represents a dual tournament format in Best of X. If it is not in
   * that format then it will indicate that it is simply a list of matches.
   * 
   * @see   #getFormat()
   */
  private String format;
  
  //**CONSTRUCTORS**
  
  /**
   * The only constructor takes in a list of values and stores them in the class
   * fields. 
   */
  public LREvent(ArrayList<Match> inMatches, int inDate, String inTime, String inTitle, 
                 String inTournament, String inFormat){
    matches = inMatches;
    date = inDate;
    time = inTime;
    title =  inTitle;
    tournament = inTournament;
    format = inFormat;
  }
  
  //**ACCESSOR METHODS**
  
  /**
   * Returns the ArrayList<Match> matches.
   * 
   * @return   this.matches
   * @see      #matches
   */
  public ArrayList<Match> getMatches(){
    return matches;
  }
  
  /**
   * Returns the integer date
   * 
   * @return   this.date
   * @see      #date
   */
  public int getDate(){
    return date;
  }
  
  /**
   * Returns the String time
   * 
   * @return   this.time
   * @see      #time
   */
  public String getTime(){
    return time;
  }
  
  /**
   * Returns the title String
   * 
   * @return   this.title
   * @see      #title
   */
  public String getTitle(){
    return title;
  }
  
  /**
   * Returns the string corresponding to the tournament that the event is a part of
   *
   * @return   this.tournament
   * @see      #tournament
   */
  public String getTournament(){
    return tournament;
  }
  
  /**
   * Returns the format string for the tournament
   * 
   * @return    this.format
   * @see       #format
   */
  public String getFormat(){
    return format;
  }
  
  //**UTILITY FUNCTIONS**
  
  /**
   * Returns the Date in a format that is compatible with the Teamliquid.net
   * BBcode for dates. It is returned as a string with the date and time combined
   * 
   * @return   the date as a BBcode compatible string.
   * @param    date  an integer representing the date in yyyymmdd format
   * @param    time  an String representing the hhmm 24 hour time of the event
   *                 in the GMT timezone.
   */
  private String convertToTLDate(int date, String time){
    //get the months ArrayList
    ArrayList<String> months = new ArrayList<String>();
    months.add("January");
    months.add("February");
    months.add("March");
    months.add("April");
    months.add("May");
    months.add("June");
    months.add("July");
    months.add("August");
    months.add("September");
    months.add("November");
    months.add("December");
    
    //Start fomatting the output
    String output = "";
    
    //Add the Month
    if(((date - 10000 * (date/10000))/100) <=12 && ((date - 10000 * (date/10000))/100) > 0)
      output = output + months.get(((date - 10000 * (date/10000))/100) - 1);
    else
      output = output + "December";
    
    //Add the day
    output = output + " " + (date - 100 * (date/100));
    
    //Add the year
    output = output + " " + (date/10000);
    
    //Add the time
    String sTime;
    if(time.length() >= 2)
      sTime = time.substring(0, 2) + ":" + time.substring(2) + " GMT";
    else 
      sTime = time;
    
    output = output + " " + sTime;
    
    //return our string with the right tags
    return "[blue][big][b][date]" +  output + "[/date][/b][/big][/blue]";
  }
  
  /**
   * Returns a string that ought to general a functioning original post on teamliquid.net
   * using their BBcode. The string contains information about the tournament, the players
   * their teams, the matches and format, the streams, and an area to update the results.
   * 
   * @return    The <code>thread</code> String that contains the entire threads information
   */  
  public String genThread(){
    Match holder;
    
    String thread = "[center]\n";
    //Header
    thread = thread + "[red][big][big]" + title + "[/big][/big][/red]\n\n";
    thread = thread + "[img]***HEADER IMAGE GOES HERE***[/img]\n\n";
    thread = thread + convertToTLDate(date, time) + "\n";
    thread = thread + "[wiki2]" + tournament + "[/wiki2]\n\n[hr]";
    
    //Stream
    thread = thread + "[img]http://i.imgur.com/r9ZH0.png[/img]\n\n";
    thread = thread + "[b]Casters:[/b] ***CASTERS***\n\n";
    thread = thread + "[big][b][url=***STREAM_LINK***]***STREAM NAME***[/url][/big][/b]\n\n[hr]";
    
    //Players
    thread = thread + "[img]http://i.imgur.com/6wl40.png[/img]\n\n";
    for(int i =0; i < matches.size(); i++)
      thread = thread + matches.get(i).toTLHeader() + "\n";
    thread = thread + "\n\n[hr]";
    
    //Results
    thread = thread + "[img]http://i.imgur.com/bv8Kw.png[/img]\n\n";
    thread = thread + "[spoiler=Spoiler-Free]";
    for(int i = 0; i < matches.size(); i++)
      thread = thread + matches.get(i).toTLSpoilerfree() + "\n";
    if(format.substring(0,2).equals("DT")){
      thread = thread + Match.emptyTLSpoilerfree(Integer.parseInt(format.substring(2)), "Winners Match") + "\n";
      thread = thread + Match.emptyTLSpoilerfree(Integer.parseInt(format.substring(2)), "Losers Match")+ "\n";
      thread = thread + Match.emptyTLSpoilerfree(Integer.parseInt(format.substring(2)), "Consolidation Match") + "\n";
    }
    thread = thread + "[/spoiler]\n \n";
    thread = thread + "[spoiler=Overall Results]";
    for(int i = 0; i < matches.size(); i++){
      thread = thread + "[b][red]Match " + (i+1) + "[/red][/b]\n" + matches.get(i).toTLResult() + "\n";
      thread = thread + "[b][blue]X Wins 2-X![/blue][/b]\n\n";
    }
    if(format.substring(0,2).equals("DT")){
      thread = thread + "[b][red]Winners Match[/red][/b]\n";
      thread = thread + Match.emptyTLResult(Integer.parseInt(format.substring(2))) + "\n";
      thread = thread + "[b][blue]X Wins 2-X![/blue][/b]\n\n";
      thread = thread + "[b][red]Losers Match[/red][/b]\n";
      thread = thread + Match.emptyTLResult(Integer.parseInt(format.substring(2))) + "\n";
      thread = thread + "[b][blue]X Wins 2-X![/blue][/b]\n\n";
      thread = thread + "[b][red]Consolidation Match[/red][/b]\n";
      thread = thread + Match.emptyTLResult(Integer.parseInt(format.substring(2))) + "\n";
      thread = thread + "[b][blue]X Wins 2-X![/blue][/b]\n\n";
    }
    thread = thread + "[/spoiler]\n\n[hr]\n";
    
    //Live Reports
    thread = thread + "[img]http://i.imgur.com/l5YZ8.png[/img]\n\n";
    
    thread = thread + "[spoiler]";
    for(int i = 0; i < matches.size(); i++){
      holder = matches.get(i);
      for(int j = 0; j < holder.getBestOf(); j++){
        thread = thread + holder.getP1().getNick() + " vs "
          + holder.getP2().getNick() + " Game " + (j+1) + "\n";
      }
      thread = thread + "\n[hr]\n";
    }
    
    if(format.substring(0,2).equals("DT")){
      for(int i = 0; i < Integer.parseInt(format.substring(2)); i++){
        thread = thread + "Winners Match Game " + (i+1) + "\n";
      }
      thread = thread + "\n[hr]\n";
      for(int i = 0; i < Integer.parseInt(format.substring(2)); i++){
        thread = thread + "Losers Match Game " + (i+1) + "\n";
      }
      thread = thread + "\n[hr]\n";
      for(int i = 0; i < Integer.parseInt(format.substring(2)); i++){
        thread = thread + "Consolidation Match Game " + (i+1) + "\n";
      }
      thread = thread + "\n[hr]\n";
    }
    thread = thread + "[/spoiler]\n[hr]\n";
    
    //Recommended Games
    thread = thread + "[img]http://i.imgur.com/3wcCS.png[/img]\n\n";
    thread = thread + "[spoiler]";
    for(int i = 0; i < matches.size(); i++){
      holder = matches.get(i);
      thread = thread + "[spoiler=" + holder.getP1().getNick() 
        + " vs " + holder.getP2().getNick() + "]\n";
      thread = thread + "[/spoiler]\n";
     }
    if(format.substring(0,2).equals("DT")){
      thread = thread + "[spoiler=Winners Match]\n" + "[/spoiler]\n";
      thread = thread + "[spoiler=Losers Match]\n" + "[/spoiler]\n";
      thread = thread + "[spoiler=Consolidation Match]\n" + "[/spoiler]\n";
    }
    thread = thread + "[/spoiler]";
    
        
    return thread + "[/center]";
  }
}

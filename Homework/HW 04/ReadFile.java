/**
 * Auto Generated Java Class.
 */
public class ReadFile(String aFileName) {
    if(aFileName == null)
      return;
    try
    {
      Scanner fileScanner = new Scanner(new File(aFileName));
      //First pass count the elements
      int prizeCount = 0;
      while(fileScanner.hasNextLine())
      {
        prizeCount++;
        fileScanner.nextLine();
      }
      if(prizeCount <= 0)
        return;
      prizes = new Prize[prizeCount];
      //Second pass read the elements
      fileScanner = new Scanner(new File(aFileName));//Resets the scanner
      String fileLine;
      String[] splitLine;
      while(fileScanner.hasNextLine())
      {
        fileLine = fileScanner.nextLine();
        splitLine = fileLine.split(DELIM);
        if(splitLine.length== FIELD_AMT)
        {
          this.addPrize(new Prize(splitLine[0], Integer.parseInt(splitLine[1])));
        }
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
  
}

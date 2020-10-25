import java.util.*;

public class Anywhr {
  public static HashMap<Coordinate, String> hexMap = new HashMap();
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    hexMap.put(new Coordinate(0,0,0), "center");
    while (true) {
      System.out.println("What would you like to do?");
      System.out.println("Enter 1 to query hexagon");
      System.out.println("Enter 2 to add new hexagon");
      int answer = sc.nextInt();
      sc.nextLine();
      if (answer == 1) {
        System.out.println("Enter country name:");
        String countryName = sc.nextLine();
        queryHex(countryName);
      } else if (answer == 2) {
        System.out.println("Enter Country name to be created:");
        String newCountryName = sc.nextLine();
        System.out.println("Enter country it will be neighbour to:");
        String neighbourName = sc.nextLine();
        System.out.println("Enter border number:");
        if (!sc.hasNextInt()) {
          System.out.println("Error~ Invalid input type!");
          sc.nextLine();
        } else {
          int border = sc.nextInt();
          sc.nextLine();
          if (border > 6 || border < 1) {
           System.out.println("Error! Border has to be 1-6");
          } else {
            createHex(newCountryName, neighbourName, border);
          }
          
        }
        
      } else {
        System.out.println("Erroe! Invalid input!");

      }
    }
  }

  static void queryHex(String countryName) {
    Coordinate countryCord = null;
    for (Coordinate co : hexMap.keySet()){
      if(hexMap.get(co).equals(countryName)) {
        countryCord = co;
        System.out.println("Country Coordinate is at " + co);
      }
    }
    if (countryCord != null) {
      System.out.println("Country coordinate is " + countryCord);
      System.out.println(new Coordinate(countryCord.x + 1, countryCord.y, countryCord.z - 1));
      //check border 1
      if (hexMap.get(new Coordinate(countryCord.x + 1, countryCord.y, countryCord.z - 1)) != null) {
        System.out.println("Your neighbour at border 1 is " + hexMap.get(new Coordinate(countryCord.x + 1, countryCord.y, countryCord.z - 1)));
      } else {
        System.out.println("no neighbour at border 1");
      }
      //check border 2
      if (hexMap.get(new Coordinate(countryCord.x + 1, countryCord.y - 1, countryCord.z)) != null) {
        System.out.println("Your neighbour at border 2 is " + hexMap.get(new Coordinate(countryCord.x + 1, countryCord.y - 1, countryCord.z)));
      } else {
        System.out.println("no neighbour at border 2");
      }
      //check border 3
      if (hexMap.get(new Coordinate(countryCord.x, countryCord.y - 1, countryCord.z + 1)) != null) {
        System.out.println("Your neighbour at border 3 is " + hexMap.get(new Coordinate(countryCord.x, countryCord.y - 1, countryCord.z + 1)));
      } else {
        System.out.println("no neighbour at border 3");
      }
      //check border 4
      if (hexMap.get(new Coordinate(countryCord.x - 1, countryCord.y, countryCord.z + 1)) != null) {
        System.out.println("Your neighbour at border 4 is " + hexMap.get(new Coordinate(countryCord.x - 1, countryCord.y, countryCord.z + 1)));
      } else {
        System.out.println("no neighbour at border 4");
      }
      //check border 5
      if (hexMap.get(new Coordinate(countryCord.x - 1, countryCord.y + 1, countryCord.z)) != null) {
        System.out.println("Your neighbour at border 5 is " + hexMap.get(new Coordinate(countryCord.x - 1, countryCord.y + 1, countryCord.z)));
      } else {
        System.out.println("no neighbour at border 5"); 
      }
      //check border 6
      if (hexMap.get(new Coordinate(countryCord.x, countryCord.y + 1, countryCord.z - 1)) != null) {
        System.out.println("Your neighbour at border 6 is " + hexMap.get(new Coordinate(countryCord.x, countryCord.y + 1, countryCord.z - 1)));
      } else {
        System.out.println("no neighbour at border 6");
      }
    } else {
      System.out.println("No such country");
      
    }
    
  }

  static void createHex(String newCountryName, String neighbourName, int border) {
    Coordinate countryCord = null;
    for (Coordinate co : hexMap.keySet()){
      if(hexMap.get(co).equals(newCountryName)) {
        countryCord = co;
        System.out.println("Country with name '" + newCountryName + "' already exists!!");
        return;
      }
    }
    for (Coordinate co : hexMap.keySet()){
      if(hexMap.get(co).equals(neighbourName)) {
        countryCord = co;
        System.out.println("neighbour found at " + co);
      }
    }
    
    Coordinate newCoord = null;
    if (countryCord != null) {
      if (border == 1){
        newCoord = new Coordinate(countryCord.x + 1, countryCord.y, countryCord.z - 1);
      } else if (border == 2) {
        newCoord = new Coordinate(countryCord.x + 1, countryCord.y - 1, countryCord.z);
      } else if (border == 3) {
        newCoord = new Coordinate(countryCord.x, countryCord.y - 1, countryCord.z + 1);
      } else if (border == 4) {
        newCoord = new Coordinate(countryCord.x - 1, countryCord.y, countryCord.z + 1);
      } else if (border == 5) {
        newCoord = new Coordinate(countryCord.x - 1, countryCord.y + 1, countryCord.z);
      } else if (border == 6) {
        newCoord = new Coordinate(countryCord.x, countryCord.y + 1, countryCord.z - 1);
      }
      hexMap.put(newCoord, newCountryName);
      
      System.out.println(hexMap.get(newCoord) + " created at " + newCoord);
      
    } else {
      System.out.println("Please enter valid country as neighbour");  
    }
    
  }
}



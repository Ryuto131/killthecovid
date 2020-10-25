public class Coordinate {
  int x;
  int y;
  int z;

  public Coordinate(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  } 

  @Override
  public String toString() {
    return "(" + this.x + " , " + this.y + " , " + this.z + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinate coordinate = (Coordinate) o;
    return this.x == coordinate.x && this.y == coordinate.y && this.z == coordinate.z;
  }
  
  @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (new Integer(x)).hashCode();  
        result = prime * result + (new Integer(y)).hashCode(); 
        result = prime * result + (new Integer(z)).hashCode(); 
        return result;
    }
}

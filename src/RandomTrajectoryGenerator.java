import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class RandomTrajectoryGenerator{
  public static ArrayList<Double> lat,lon;
  public static final long BASE_TIME = 1256171117;
  public static void main(String[] args) throws IOException{
	 Double latStart = 39.77476475845273; 
	 Double lonStart = -84.11233123446523;
	 Double radius = 0.0005;
	 //Integer step = Integer.valueOf(args[3]);
	 Integer trajCount = 10;
	 File file = new File("randomTrajectory.txt");
	 FileWriter fr = new FileWriter(file);
	 for (int i = 0; i<trajCount; i++){
	 lat = new ArrayList<Double>();
	 lon = new ArrayList<Double>();
	 int n = randInt(1,50);
	 long time = BASE_TIME;
	 double r = radius*n;
	 Random random = new Random();
	 double radian = -Math.PI+2*Math.PI*random.nextDouble();
	 double lats = latStart + r* Math.cos(radian);
	 double lons = lonStart + r*Math.sin(radian);
	 lat.add(lats);
	 lon.add(lons);
	 fr.write(lats+","+lons+","+(i+100)+","+time+"\n");
	 time = time + 5;
	 int pointCount = randInt(50,100);
	 for (int j = 0; j<pointCount; j++){
		 n = randInt(1,5);
		 r = radius*n;
		 random = new Random();
		 radian = -Math.PI+2*Math.PI*random.nextDouble();
		 lats = lats + r* Math.cos(radian);
		 lons = lons + r*Math.sin(radian);
		 lat.add(lats);
		 lon.add(lons);
		 fr.write(lats+","+lons+","+(i+100)+","+time+"\n");
		 time = time + 5;
	 }
	 
	 }
	 fr.close();
	 System.out.println("done");
  }
  /**
   * Returns a psuedo-random number between min and max, inclusive.
   * The difference between min and max can be at most
   * <code>Integer.MAX_VALUE - 1</code>.
   *
   * @param min Minimim value
   * @param max Maximim value.  Must be greater than min.
   * @return Integer between min and max, inclusive.
   * @see java.util.Random#nextInt(int)
   */
  public static int randInt(int min, int max) {

      // Usually this can be a field rather than a method variable
      Random rand = new Random();

      // nextInt is normally exclusive of the top value,
      // so add 1 to make it inclusive
      int randomNum = rand.nextInt((max - min) + 1) + min;

      return randomNum;
  }
}
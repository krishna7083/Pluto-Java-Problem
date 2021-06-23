import java.util.*;
import java.lang.*;
import java.io.*;

/**
* @Author Krushna S. Oza
* @Description This is Corordinate POJO class to store the two points of co-ordinate.
 */
class Coordinate {

    Integer x,y;
    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }
     public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }
}

/**
* @Author Krushna S. Oza
* @Description This is the class response to store the details about the current coordinate and the result
* */
class Response {

        Coordinate coordinate; // pair datatype to store the co-ordinate (a,b) in the form of Key-Value
        String direction; // indicates the direction
        String message; // message to indicate any reason if any operations not got successfull.
        boolean operationalResult; // boolean varible to indicate whether operation is successfull or not.

        public Response() {

        }

        public void setCoordinate(Coordinate coordinate) {
                this.coordinate = coordinate;
        }
        public void setDirection(String direction) {
            this.direction = direction;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public void setOperationalResult(boolean operationalResult) {
            this.operationalResult = operationalResult;
        }

        
        public Coordinate getCoordinate() {
            return coordinate;
        }
        public String getDirection() {
            return direction;
        }
        public String getMessage() {
            return message;
        } 
        public boolean getOperationalResult() {
            return operationalResult;
        }       
}
/**
 * @Author Krushna S. Oza
 * This class containing the main method.
 */
public class Pluto {

    /**
    * @Method Description : This method doing the operation for instruction Left according to the direction specified.
    */
    public static Response operationLeft(Response responseCoordinate, Integer step, List<Coordinate> holes) {

        Response result = new Response();
        boolean operationalResult = true;
        Coordinate coordinate = responseCoordinate.getCoordinate();
        String direction = responseCoordinate.getDirection(); // get the direction
        for(int i=0; i<step; i++) {
            coordinate = responseCoordinate.getCoordinate();
            if(direction.equalsIgnoreCase("North")) {
                
                    Integer x = coordinate.getX();
                    Integer y = coordinate.getY()+1;
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "North";
                        }
                        else {
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "West"; 
                        }   
                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            } else if(direction.equalsIgnoreCase("South")) {
               
                    Integer x = coordinate.getX()-1;
                    Integer y = coordinate.getY();
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "North";
                        }
                        else {
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "East"; 
                        }
                        
                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            } else if(direction.equalsIgnoreCase("West")) {
               
                    Integer x = coordinate.getX();
                    Integer y = coordinate.getY()-1;
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "North";
                        }
                        else {
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "South";
                        }    

                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }
            } else {  // East
                
                    Integer x = coordinate.getX()+1;
                    Integer y = coordinate.getY();
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                        }
                        coordinate.setX(x);
                        coordinate.setY(y);
                        direction = "North";    
                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            }

        }
        result.setDirection(direction);
        result.setOperationalResult(operationalResult);
        result.setCoordinate(coordinate);
        return result;
    }

    /**
    * @Method Description : This method doing the operation for instruction Right according to the direction specified.
    */
    public static Response operationRight(Response responseCoordinate, Integer step, List< Coordinate> holes) {

        Response result = new Response();
        boolean operationalResult = true;
        Coordinate coordinate = responseCoordinate.getCoordinate();
        String direction = responseCoordinate.getDirection(); // get the direction
        for(int i=0; i<step; i++) {
            coordinate = responseCoordinate.getCoordinate();
            if(direction.equalsIgnoreCase("North")) {
                    
                    Integer x = coordinate.getX()-1;
                    Integer y = coordinate.getY();
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "North";
                        }
                        else {
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "East"; 
                        }   
                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            } else if(direction.equalsIgnoreCase("South")) {
                   
                    Integer x = coordinate.getX();
                    Integer y = coordinate.getY()+1;
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "North";
                        }
                        else {
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "West"; 
                        }
                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            } else if(direction.equalsIgnoreCase("West")) {
                    
                    Integer x = coordinate.getX()+1;
                    Integer y = coordinate.getY();
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                        }
                        coordinate.setX(x);
                        coordinate.setY(y);
                        direction = "North";    

                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }
            } else { // East
                    
                    Integer x = coordinate.getX();
                    Integer y = coordinate.getY()-1;
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "North";
                        }
                        else {
                            coordinate.setX(x);
                            coordinate.setY(y);
                            direction = "South"; 
                        }   
                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            }

        }
        result.setDirection(direction);
        result.setOperationalResult(operationalResult);
        result.setCoordinate(coordinate);
        return result;

    }

    /**
    * @Method Description : This method doing the operation for instruction Ahead according to the direction specified.
    */
    public static Response operationAhead(Response responseCoordinate, Integer step, List< Coordinate> holes) {

        Response result = new Response();
        String direction = responseCoordinate.getDirection(); // get the direction
        Coordinate coordinate = responseCoordinate.getCoordinate();
        boolean operationalResult = true;
        for(int i=0; i<step; i++) {
            if(direction.equalsIgnoreCase("North")) {
                   
                    Integer x = coordinate.getX()+1;
                    Integer y = coordinate.getY();
                    if(checkIsValidCoordinate(x,y)) {
                         
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                        }
                        coordinate.setX(x);
                        coordinate.setY(y);

                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }
                    
            }
            else if(direction.equalsIgnoreCase("South")) {
               
                    Integer x = coordinate.getX()-1;
                    Integer y = coordinate.getY();
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                        }
                        coordinate.setX(x);
                        coordinate.setY(y);

                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            }
            else if(direction.equalsIgnoreCase("West")) {
                
                    Integer x = coordinate.getX();
                    Integer y = coordinate.getY()+1;
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                        }
                        coordinate.setX(x);
                        coordinate.setY(y);

                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }

            }
            else {
                   
                    Integer x = coordinate.getX();
                    Integer y = coordinate.getY()-1;
                    if(checkIsValidCoordinate(x,y)) {
                        if(checkIsHolePresent(holes,x,y)) {
                            x+=1;
                        }
                        coordinate.setX(x);
                        coordinate.setY(y);

                    }
                    else {
                        result.setMessage("Being is not a smart to recognise a Invalid Corodinate");
                        operationalResult = false;
                        break;
                    }
            }
        }
        result.setDirection(direction);
        result.setOperationalResult(operationalResult);
        result.setCoordinate(coordinate);
        return result;

    }

    /**
    * @Author Krushna S. Oza
    * @Desciption This method check if current co-ordinates fall under a hole or not.
    * */
    public static boolean checkIsHolePresent(List< Coordinate> holes, Integer x, Integer y) {

        for(Coordinate pair: holes) {
            if(pair.getX()==x && pair.getY()==y) {
                return true;
            }
        }
        return false;
    }

    /**
    * @Method Desciption: this method check the coorinate which Being viting is Valid or not
    *  if co-ordinate is not valid then we can conclude that being is not a smart enough to 
    *  recognise the valid or invalid coordinate
    * */
    public static boolean checkIsValidCoordinate(Integer x,Integer y) {
        
        if(x < 1 || y < 1) {
            return false;
        }
        return true;
    }

    /**
    * @Author Krushna S. Oza
    * @Description This method take the file name as argument and fetch the lines add it to the
    * list of string and return the list of String.
     */
    public static List<String> readFile(String fileName) throws FileNotFoundException  {

        List<String> lines = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine()) {
            lines.add(input.nextLine());
        }
        return lines;
    }

    public static void main(String args[]) {

        /*calling a readFile function to read a file contens and store it to the
            list of String Data type. */
        List<String> lines = new ArrayList<>();
        try {
            lines = readFile(args[0]);
        } catch (FileNotFoundException e) {
           System.out.println(e);
        } 
       
        List<Coordinate> holes = new ArrayList<>(); // list of pair to store the cordinates of the holes.
        Coordinate coordinate = new Coordinate(-1,-1); // to store the co-ordinates while iterating

        Response responseCoordinate = new Response();
        
        for(String str: lines) {

            String[] arr = str.split(" ");

            if(arr[0].equalsIgnoreCase("HOLE")) {
                String[] cordinates = arr[1].split(","); 
                holes.add(new Coordinate(Integer.parseInt(cordinates[0]), Integer.parseInt(cordinates[1]) ));
            }
            else if(arr[0].equalsIgnoreCase("START")) {
                String[] cordinates = arr[1].split(","); 
                coordinate = new Coordinate(Integer.parseInt(cordinates[0]),Integer.parseInt(cordinates[1]));
                responseCoordinate.setCoordinate(coordinate);
                responseCoordinate.setDirection("North"); // initially the direction is North.
            }
            else if(arr[0].equalsIgnoreCase("LEFT")) {
                Integer step = Integer.parseInt(arr[1]);
                responseCoordinate = operationLeft(responseCoordinate, step, holes);
                if(!responseCoordinate.operationalResult) {
                    break;
                }

            }
            else if(arr[0].equalsIgnoreCase("RIGHT")) { // the instruction is right
                Integer step = Integer.parseInt(arr[1]);
                responseCoordinate = operationRight(responseCoordinate, step, holes);
                // if operation result is failed then we wil break it here and stop doing the operation.
                if(!responseCoordinate.operationalResult) {
                    break;
                }

            }
            else { // the instruction is AHEAD
                Integer step = Integer.parseInt(arr[1]);
                responseCoordinate = operationAhead(responseCoordinate, step, holes);
                if(!responseCoordinate.operationalResult) {
                    break;
                }


            }

        } 
        if(responseCoordinate.getOperationalResult()) {
            System.out.print("Final Co-ordinates are :");
            System.out.println(responseCoordinate.getCoordinate().getX()+" "+responseCoordinate.getCoordinate().getY());
        }
        else {
            System.out.println(responseCoordinate.getMessage());
        } 
    }
}




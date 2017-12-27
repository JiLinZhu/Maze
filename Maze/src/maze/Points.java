package maze;

//Points Class
public class Points {
    
    //Fields
    int x, y;
    Points originalPoint;
    
    //Points Constructor
    public Points( int x, int y, Points originalPoint ) {
        this.x = x;
        this.y = y;
        this.originalPoint = originalPoint;
    } //End of Points Constructor
    
    //Finds the Other/Opposite Point
    //For example, oin, o would be the original point, i would be the current point
    //and it would calculate that n is the other point 
    public Points other(){
        if ( (this.x - originalPoint.x) != 0 ) //If the point and its originalPoint are horizontally adjacent
            return new Points( this.x + (this.x - originalPoint.x), this.y, this );
        else if ( ( this.y - originalPoint.y ) != 0 ) //If  the point and its originalPoint are vertically adjacent
            return new Points( this.x, this.y + (this.y - originalPoint.y), this );
        else //Error case, should never occur
            return new Points( this.x, this.y , this );
    }//End of other Method
    
} //End of Points Class

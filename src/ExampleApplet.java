
import processing.core.* ;
import processing.sound.*;


public class ExampleApplet extends PApplet {

    public static void main(String args[]) {
        PApplet.main("ExampleApplet");
    }

    float corner_a_x = 500;
    float corner_a_y = 150;

    float corner_b_x = 150;
    float corner_b_y = 500;

    float corner_c_x = 500;
    float corner_c_y = 500;


    float cathete_A = corner_c_x - corner_b_x;
    float cathete_B = corner_c_y - corner_a_y;
    float cathete_C = pythagoras();

    @Override
    public void settings() {
        size(1000, 1000);

    }

    @Override
    public void setup() {

        pythagoras();
    }

    @Override
    public void draw() {
        background(196, 185, 165);
        strokeWeight(4);

        fill(139,0,0);
        stroke(139,0,0);
        line(corner_b_x, corner_b_y, corner_c_x, corner_c_y);
        text(cathete_A, corner_c_x - (corner_c_x - corner_b_x)/2, corner_b_y + 25);

        fill(0,0,139);
        stroke(0,0,139);
        line(corner_a_x, corner_a_y, corner_c_x, corner_c_y);
        text(cathete_B, corner_a_x + 20,corner_c_y - (corner_c_y - corner_a_y)/2 );


        fill(0,0,0);
        stroke(0,0,0);
        line(corner_a_x, corner_a_y, corner_b_x, corner_b_y);
        float textX = (corner_a_x + corner_b_x - 100) / 2;
        float textY = (corner_a_y + corner_b_y) / 2;
        text(cathete_C, textX, textY);

    }

    public float pythagoras() {

        float hypotenuse = (cathete_A * cathete_A) + (cathete_B * cathete_B);

        float wurzel = sqrt(hypotenuse);


        //Here I tried to get rid of the last digits, but it was not sucessfull.

        //String  wurzelRounded= String.format("%.2f", wurzel);
        //float wurzelRoundedFloat = Float.parseFloat(wurzelRounded);


        // Here I printed the values to check them at early stage of the code.
        print("              long:", hypotenuse);
        print("              wurzel:", sqrt(hypotenuse));

        return wurzel;
    }

    public void mouseDragged() {
        if (dist(corner_b_x, corner_b_y, mouseX, mouseY) < 35) {
            print("      pressed");
            if (mouseX<corner_c_x){
            corner_b_x = mouseX;
            cathete_A = corner_c_x - corner_b_x;
            cathete_C = pythagoras();
        }}
        if (dist(corner_a_x, corner_a_y, mouseX, mouseY) < 35) {
            print("      pressed");
            if (mouseY<corner_c_y){
            corner_a_y = mouseY;
            cathete_B = corner_c_y - corner_a_y;
            cathete_C = pythagoras();

        }}
    }
}


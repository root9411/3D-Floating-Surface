/* autogenerated by Processing revision 1286 on 2022-09-30 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class sketch_220930a extends PApplet {

int cols, rows;
int scl = 20;
int w = 2600;
int h = 1500;

float[][] terrain;
float flying = 0;

 public void setup() {
  /* size commented out by preprocessor */;
  
  cols = w/scl;
  rows = h/scl;
  
  terrain = new float[cols][rows];

}

 public void draw(){
  flying -=0.025f;
  
    float yoff = flying;
    for(int y = 0; y < rows;y++){
      float xoff =0;
      for(int x =0 ; x < cols; x++){
        terrain[x][y] = map(noise(xoff,yoff),0,1,-180,180);
        xoff += 0.05f;
      }
      yoff += 0.05f;
    }
  
  
    background(0);
    stroke(255);
    noFill();
    
    translate(width/2, height/2);
    rotateX(PI/3);
    
    translate(-w/2,-h/2);
    
    for(int y = 0 ; y < rows -1; y++){
      beginShape(TRIANGLE_STRIP);
        for(int x = 0 ; x < cols; x++){
          vertex(x * scl, y * scl, terrain[x][y]);         
          vertex(x * scl, (y+1) * scl, terrain[x][y+1]);
          //rect(x * scl, y * scl,scl,scl);
        }
        endShape();
    }
}


  public void settings() { size(1366, 768, P3D); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "sketch_220930a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

package com.ujian;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ujian.fungsi.rata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Tesfungsirata 
{
   rata function ;

    @Before
    public void setUp() throws Exception {
        function = new rata();
    }

    @After
    public void tearDown() throws Exception {
        
    }

  /*  @Test
    public void tescepat() {
        assertEquals(40, function.kecepatanrata(Double.parseDouble("") , Double.parseDouble("")),0.0);
    }
    */
   @Test
    public void tescepat() {
        for (String isi : readfile("cepatrata.csv")) {
            String [] data = isi.split(";");
            String jarak = data[0];
            String waktu = data[1];
            String hasil = data[2];
            assertEquals(Double.parseDouble(hasil), function.kecepatanrata(Double.parseDouble(jarak) , Double.parseDouble(waktu)),0.0);
        }
       
    }

   public List <String> readfile(String namefile) {
        List <String> temp = new  ArrayList<String>();

        try {
            InputStream myfile =getClass().getClassLoader().getResourceAsStream(namefile);
            Scanner baca = new Scanner(myfile);
            while (baca.hasNextLine()) {
                temp.add(baca.nextLine());
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return temp; 


    }
  
}

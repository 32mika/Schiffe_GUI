package mika32.Schiffe.Schiffeversenken;

import mika32.Schiffe.Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TestPlacing {
    private static HashSet<String> shipFields = new HashSet<String>();
    private static Random rand = new Random();
    private static int fieldSize = Main.getGUI().getFieldSize();
    private static int anzahlSchiffArten = 4;
    private static int[] schiffArten = {2, 3, 4, 5};
    private static ArrayList<String> alphabet = new ArrayList<>(Arrays.asList(Main.getGUI().alphabet));
    private static int count = 0;

    public static void setShips(){
        for(int i = 0; i < anzahlSchiffArten; i++){
            for(int d = 0; d < anzahlBerechnen(); d = d + schiffArten[i]){
                int direction;

                direction = rand.nextInt(2);
                count++;

                switch (direction) {
                    case 0: {
                        boolean valid = false;

                        while(!valid){
                            String letterPos;
                            String numberPos;
                            String pos;
                            String[] tempArr = new String[schiffArten[i]];

                            letterPos = alphabet.get(rand.nextInt(fieldSize));
                            numberPos = Integer.toString(rand.nextInt(fieldSize) +1);
                            pos = letterPos + numberPos;

                            if(!(alphabet.indexOf(letterPos) +1 - schiffArten[i] < 1) & !shipFields.contains(pos)){
                                valid = true;
                                tempArr[0] = pos;
                                shipFields.add(pos);

                                System.out.println(tempArr[0] + " Schiffart " + schiffArten[i]);

                                for (int c = 1; c < schiffArten[i]; c++){
                                    tempArr[c] = alphabet.get(alphabet.indexOf(letterPos) - c) + numberPos;

                                    if(!shipFields.contains(tempArr[c])){
                                        shipFields.add(tempArr[c]);
                                        System.out.println(tempArr[c] + " Schiffart " + schiffArten[i]);
                                    }
                                }
                            }
                        }
                        break;
                    }

                    case 1:{
                        boolean valid = false;

                        while(!valid){
                            String letterPos;
                            String numberPos;
                            String pos;
                            String[] tempArr = new String[schiffArten[i]];

                            letterPos = alphabet.get(rand.nextInt(fieldSize));
                            numberPos = Integer.toString(rand.nextInt(fieldSize) +1);
                            pos = letterPos + numberPos;

                            if(!(Integer.parseInt(numberPos) + schiffArten[i] > 9) & !shipFields.contains(pos)){
                                valid = true;
                                tempArr[0] = pos;
                                shipFields.add(pos);

                                System.out.println(tempArr[0] + " Schiffart " + schiffArten[i]);

                                for (int c = 1; c < schiffArten[i]; c++){
                                    tempArr[c] = letterPos + Integer.toString(Integer.parseInt(numberPos) +c);

                                    if(!shipFields.contains(tempArr[c])){
                                        shipFields.add(tempArr[c]);
                                        System.out.println(tempArr[c] + " Schiffart " + schiffArten[i]);
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                Main.setShipHash(shipFields);
            }
        }
    }

    private static int anzahlBerechnen(){
        return (int) ((int) Math.pow(fieldSize, 2) * 0.2 / 4);
    }
}
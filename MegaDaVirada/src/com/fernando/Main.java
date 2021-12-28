package com.fernando;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        OutputStream os = new FileOutputStream("JogosLoteria.txt");
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter br = new BufferedWriter(wr);

        br.write("Mega da Virada 2021");
        br.newLine();
        br.newLine();


        for( int i = 0; i < 20; i++){

            List numeros = new ArrayList();


            while (numeros.size() < 6) {
                int numero = new Random().nextInt(60) + 1;
                if (!numeros.contains(numero)) {
                    numeros.add(numero);
                }
            }

            Collections.sort(numeros);

            List<String> numerosFormatados = new ArrayList();

            for (int j = 0; j < 6; j++){
                if(numeros.get(j).toString().length() == 1){
                    String numeroComZero = String.format("%02d", numeros.get(j));
                    numerosFormatados.add(numeroComZero);
                } else {
                    numerosFormatados.add(numeros.get(j).toString());
                }
            }

            br.write(String.valueOf(numerosFormatados));
            br.newLine();

        }

        br.close();
    }
}

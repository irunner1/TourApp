package com.example.kr.helpers;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fles {
    final static String FILENAME = "file";

    public static void writeToFile (String countryName, String dates, String prices, Context context) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(context.openFileOutput(FILENAME, Context.MODE_APPEND)));
            bw.append(countryName);
            bw.append(dates);
            bw.append(prices);
            bw.append('\n');
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(Context context) { //возвращает весь файл
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.openFileInput(FILENAME)));
            String str = "";
            while ((str = br.readLine()) != null) {
//                countryName = str;
                text += str;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void deleteFromFile(Context context, String rep){
        try {
            String buf = readFromFile(context);
            buf = buf.replace(rep, "");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(context.openFileOutput(FILENAME, MODE_PRIVATE)));
            bw.write(buf);
            bw.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

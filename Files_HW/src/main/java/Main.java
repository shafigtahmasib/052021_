import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        /***
         * ilk once sample file'inda olan tiplere uyghun listler yaradilir.
         */


        BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.txt"));
        List<Integer> integerList = new ArrayList<>();
        List<Date> dateList = new ArrayList<>();
        List<String> carNums = new ArrayList<>();
        List<String> strings = new ArrayList<>();


        /**
         * burada her tipe uyghun regex var, uyghun gelen regex'ler muvafig listlere elave olunur
         */

        String line = "";
        while((line = bufferedReader.readLine()) !=null){
            if(line.matches("[0-9]+")) {
                integerList.add(Integer.parseInt(line));
            }
            if(line.matches("[0-9]{2}(.)[0-9]{2}(.)[0-9]{4}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
                dateList.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(line));
            }
            if(line.matches("[0-9]{2}[A-Z]{2}[0-9]{3}")) {
                carNums.add(line);
            }
            else
                strings.add(line);
        }
        bufferedReader.close();

        dateSort(dateList);
        integerSort(integerList);
        carNumSort(carNums);
        stringSort(strings);

    }


    /**
     * Burada ise, list'ler azalan (descending) sira ile sort olunur, daha sonra ise fayllara yazilir.
     * @param list
     * @throws IOException
     * @throws ParseException
     */

    static void dateSort(List<Date> list) throws IOException, ParseException {

        Collections.sort(list,Collections.reverseOrder());
        FileWriter writer = new FileWriter("dates.txt");
        for(Date x: list){
            //System.out.println(x);
            writer.write(x+"\n");
        }
        writer.close();
    }

    static void integerSort(List<Integer> list) throws IOException {

        Collections.sort(list,Collections.reverseOrder());
        FileWriter writer = new FileWriter("integers.txt");
        for(int x: list){
            //System.out.println(x);
            writer.write(x+"\n");
        }
        writer.close();
    }

    static void carNumSort(List<String> list) throws IOException {

        FileWriter writer = new FileWriter("carnums.txt");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {

                if(!s.substring(2,4).equals(t1.substring(2,4)))
                    return s.substring(2,4).compareTo(t1.substring(2,4));
                if(s.substring(2,4).equals(t1.substring(2,4)) && !(s.substring(0,2).equals(t1.substring(0,2))))
                    return (s.substring(0,2)).compareTo((t1.substring(0,2)));
                if((s.substring(2,4).equals(t1.substring(2,4))) && (s.substring(0,2).equals(t1.substring(0,2))) && !(s.substring(4,7).equals(t1.substring(4,7))));
                return (s.substring(4,7)).compareTo(t1.substring(4,7));

            }
        });

        Collections.reverse(list);
        for(String x: list){
            writer.write(x+"\n");
        }
        writer.close();
    }

    static void stringSort(List<String> list) throws IOException {
        Collections.sort(list,Collections.reverseOrder());
        FileWriter writer = new FileWriter("strings.txt");
        for(String x: list){
            //System.out.println(x);
            writer.write(x+"\n");
        }
        writer.close();
    }
}

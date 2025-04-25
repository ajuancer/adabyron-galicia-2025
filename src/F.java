import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class F {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();
        for(int i = 0; i < numCasos; i++){
            int n = sc.nextInt();
            int t = sc.nextInt();
            List<Actividad> listaActividad = new ArrayList<Actividad>();
            for (int j = 0; j < n; j++){
                listaActividad.add(new Actividad(sc.nextInt()));
            }
            for (int k = 0; k < n; k++){
                listaActividad.get(k).popularidad = sc.nextInt();
                listaActividad.get(k).ratio = (double) listaActividad.get(k).popularidad / listaActividad.get(k).tiempo;
            }
            Collections.sort(listaActividad);
            double sumatorioPopularidad = 0;

            for (Actividad actividad: listaActividad){
                if(actividad.tiempo <= t){
                    sumatorioPopularidad += actividad.popularidad;
                }
                else{
                    sumatorioPopularidad += ((double)t / actividad.tiempo) * actividad.popularidad;
                    break;
                }
                t -= actividad.tiempo;
            }
            String x = Long.toString(Math.round(sumatorioPopularidad*10000));
            String sub = x.substring(0, x.length() - 4)+ "."+x.substring(x.length()-4);

            System.out.println(sub);
        }

    }
    public static class Actividad implements Comparable<Actividad>{
        public int tiempo;
        public int popularidad;
        public double ratio;

        public Actividad(int tiempo){
            this.tiempo = tiempo;
        }

        @Override
        public int compareTo(Actividad o) {
            if (this.ratio == o.ratio) return 0;
            return this.ratio > o.ratio ? -1 : 1;
        }
    }
}


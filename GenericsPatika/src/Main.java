package src;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Dizideki Eleman Sayısı : " + liste.getCapacity());
        System.out.println("Dizinin Kapasitesi : " + liste.size());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizideki Eleman Sayısı : " + liste.getCapacity());
        System.out.println("Dizinin Kapasitesi : " + liste.size());
        liste.add(50);
        liste.add(60);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizideki Eleman Sayısı : " + liste.getCapacity());
        System.out.println("Dizinin Kapasitesi : " + liste.size());

        System.out.println((liste.get(2)==-1)?"null": liste.get(2));

       // System.out.println(liste.set(5,456));
        System.out.println(liste.set(45,456) + " kapasite aşıldı");
      //  liste.remove(4);
        //System.out.println(liste.get(5));
        System.out.println(liste.toString());
        System.out.println(liste.indexOf(20));
    }
}

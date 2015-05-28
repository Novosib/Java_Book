package Glava3Ex2;
class Hobbits {
    String name;
    public static void main(String[] args) {
        Hobbits[] h = new Hobbits[3];
        int z = - 1;
        while (z < 2) {
            z = z + 1;
            h[z] = new Hobbits();
            h[z].name = "Бильбо";
            if (z == 1) {
                h[z].name = "Фродо";
            }
            if (z == 2) {
                h[z].name = "Сэм";
            }
            System.out.println(h[z].name + " - имя хорошего хоббита");
        }//while (z < 4)
    }//method main
}//class Hobbits

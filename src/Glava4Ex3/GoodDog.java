package Glava4Ex3;
class GoodDog {
    private int size;
    private String name;
    
    public void SetName (String nm) {
        name = nm;
    }
    public String GetName (){
        return name;
    }
    
    public void SetSize (int sz) {
        size = sz;
    }
    public int GetSize (){
        return size;
    }
    
    void bark(){
    if (size > 60){
        System.out.println(name + " Злится: Рррррр... Гав! Гав!");
    } else if (size > 20){
        System.out.println(name + " Злится: Уф.. Уф.. Уф..");
    } else {
        System.out.println(name + " Злится: тяф! тяф! тяф!");
    }
    }   
}//class
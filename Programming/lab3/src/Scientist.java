public class Scientist extends Human{

    Scientist(String name, Talent talent, Temper temper) {
       super(name, talent, temper);
    }

    public boolean closeExperimentalProgram(Temper temper, Talent talent){
        boolean var1 = temper == Temper.CRAZY;
        boolean var2 = temper == Temper.EVIL;
        boolean var3 = talent == Talent.GENIUS;
        if(var1){
            if(var3){
                return false;
            }
        }
        else if(var2){
            if(var3){
                return false;
            }
        }
        return true;
    }

}

/**
 * Created by ccatana on 5/13/2014.
 */
public class LetterMapping {
    char s;
    int i;



    public LetterMapping(char s, int i){
        this.s = s;
        this.i = i;
    }


    @Override
    public String toString() {
        return "LetterMapping [s=" + s + ", i=" + i + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LetterMapping){
            if(s == (((LetterMapping) obj).s))
                return true;
        }
        return false;
    }
}

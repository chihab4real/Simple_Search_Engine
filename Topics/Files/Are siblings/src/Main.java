import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        // implement me
        try{
            if(f1.getParent().equals(f2.getParent())){
                return true;
            }
        }catch (Exception e){
            return false;
        }

        return false;
    }


}
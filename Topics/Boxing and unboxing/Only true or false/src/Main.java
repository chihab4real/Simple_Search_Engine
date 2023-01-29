class Primitive {
    public static boolean toPrimitive(Boolean b) {
        try {
            return b;
        }catch (Exception e){
            return false;
        }

    }
}
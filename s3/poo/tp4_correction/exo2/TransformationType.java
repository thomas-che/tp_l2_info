package tp4.exo2;

public class TransformationType {
    public static void main(String[] args) {
        Double[] tab = {1.1, 3.5, 2.6};
        EnsTransformable ens = new EnsTransformable(tab);
        ens.transformer(new Transformation() {
            @Override
            public Object transforme(Object x) {
                Double d = (Double)x;
                return String.valueOf(d) ;
            }
        });
        System.out.println(ens);
    }
}

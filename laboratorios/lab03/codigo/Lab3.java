
/**
 * Write a description of class lab3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab3
{
    public static Universidad Eafit;

    public static void main(String[] Args){
        Info i1= new Info("201802","susana","programacion",4);
        Info i2= new Info("201802","susana","datos",4.8);
        Info i3= new Info("201802","mariajose","datos",4.5);
        Info i4= new Info("201901","luisa","datos",4.3);
        Info i5= new Info("201901","susana","calculo",4.3);
        Eafit.informacion.add(i1);
        Eafit.informacion.add(i2);
        Eafit.informacion.add(i3);
        Eafit.informacion.add(i4);
        Eafit.informacion.add(i5);
        //consulta1("datos","201802");
        //consulta1("datos","201901");
        consulta2("susana","201802");
    }

    private static void consulta1(String curso, String semestre){
        for(int i=0; i<Eafit.informacion.size(); i++){
            Info i1 =Eafit.informacion.get(i);
            if (i1.curso==curso && i1.semestre==semestre){
                String nombre= i1.nombre;
                double nota= i1.nota;
                System.out.println("nombre:"+nombre+", nota:"+nota);
            }
        }
    }

    private static void consulta2(String nombreEstudiante, String semestre){
        for(int i=0; i<Eafit.informacion.size(); i++){
            Info i1 =Eafit.informacion.get(i);
            if (i1.nombre==nombreEstudiante&& i1.semestre==semestre){
                String curso= i1.curso;
                double nota= i1.nota;
                System.out.println("curso:"+curso+", nota:"+nota);
            }
        }
    }
}

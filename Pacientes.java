/*
 * clase Pacientes, que idintifica el nombre, sintoma y el tipo de emergencia.
 */

 class Pacientes implements java.lang.Comparable<Pacientes> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    public Pacientes(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    @Override
    public int compareTo(Pacientes otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
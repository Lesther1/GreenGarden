package com.example.greengarden;
import java.util.ArrayList;
import java.util.List;

public class Datos {
    public List<Object[]> datosArboles = new ArrayList<>();
    private final double co2xMes = 1.83;

    public void agregarDatosArbol(String mes, String fecha, String especie, String ubicacion, String salud) {
        Object[] datos = {mes, fecha, especie, ubicacion, salud};
        datosArboles.add(datos);
    }

    public int Total() {
        return datosArboles.size();
    }

    public List<Object[]> obtenerArbolesPorMes(String mes) {
        List<Object[]> arbolesPorMes = new ArrayList<>();
        for (Object[] datos : datosArboles) {
            if (datos[0].equals(mes)) {
                arbolesPorMes.add(datos);
            }
        }
        return arbolesPorMes;
    }

    public double calcularCO2PorMes(String mes) {
        int cantidadArboles = obtenerArbolesPorMes(mes).size();
        return cantidadArboles * co2xMes;
    }

}

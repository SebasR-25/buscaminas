package model;

public class Celda {
    private boolean esMina;
    private String letra;
    private int minasAdyacentes;

    public Celda(boolean esMina){
        this.esMina = esMina;
        this.minasAdyacentes = 0;
    }

    public void setEsMina(boolean esMina){
        this.esMina = esMina;    
    }
    public boolean getEsMina(){
        return esMina;
    }
    public void setMinasAdyacentes(int minasAdyacentes){
        this.minasAdyacentes = minasAdyacentes;
    }
    public int getMinasAdyacentes(){
        return minasAdyacentes;
    }
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}

package br.org.serratec.olamundo.model;

public class Veiculo {
    private Integer id;
    private String marca;
    private String modelo;

    public Veiculo() {
        super();
    }

    public Veiculo(Integer id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
    }

}

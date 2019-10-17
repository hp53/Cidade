/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Cidade {
    private Integer Nr_habitantes;
    private String nome;
    private Integer codigo;
    private Double area_total;
    private Integer distancia_da_capital;
    private String sigla_estado;
   private LocalDate data_emancipacao;

    public Integer getNr_habitantes() {
        return Nr_habitantes;
    }

    public void setNr_habitantes(Integer Nr_habitantes) {
        this.Nr_habitantes = Nr_habitantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getArea_total() {
        return area_total;
    }

    public void setArea_total(Double area_total) {
        this.area_total = area_total;
    }

    public Integer getDistancia_da_capital() {
        return distancia_da_capital;
    }

    public void setDistancia_da_capital(Integer distancia_da_capital) {
        this.distancia_da_capital = distancia_da_capital;
    }

    public String getSigla_estado() {
        return sigla_estado;
    }

    public void setSigla_estado(String sigla_estado) {
        this.sigla_estado = sigla_estado;
    }

    public LocalDate getData_emancipacao() {
        return data_emancipacao;
    }

    public void setData_emancipacao(LocalDate data_emancipacao) {
        this.data_emancipacao = data_emancipacao;
    }

    @Override
    public String toString() {
        return "Cidade{" + '}';
    }
   
}

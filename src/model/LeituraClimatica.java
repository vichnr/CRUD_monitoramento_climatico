package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LeituraClimatica{
    private int id;
    private String data;
    private String cidade;
    private double temperatura;
    private double umidade;
    private String condicao;
    private double vento;

    public LeituraClimatica(int id, String cidade, double temperatura, double umidade, String condicao, double vento){
        this.id= id;
        this.data= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.cidade = cidade;
        this.temperatura=temperatura;
        this.umidade= umidade;
        this.condicao =condicao;
        this.vento = vento;
    }

    public int getId() { return id; }
    public String getData() { return data; }
    public String getCidade() { return cidade; }
    public double getTemperatura() { return temperatura; }
    public double getUmidade() { return umidade; }
    public String getCondicao() { return condicao; }
    public double getVento() { return vento; }

    public void setCidade(String cidade){ this.cidade= cidade; }
    public void setTemperatura(double temperatura){ this.temperatura=temperatura;}
    public void setUmidade(double umidade){ this.umidade= umidade;}
    public void setCondicao(String condicao) { this.condicao= condicao; }
    public void setVento(double vento){ this.vento = vento;}
    public void atualizarData(){
        this.data=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
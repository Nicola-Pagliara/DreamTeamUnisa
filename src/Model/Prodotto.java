package Model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Prodotto {


    public Prodotto(String name) {
                nome=name;
    }

    public Prodotto(String name, int qty) {
                    quantprodotto=qty;
                    nome=name;
    }

    public Prodotto(String name, int qty, int id) {
                    idprod=Integer.toString(id);
                    quantprodotto=qty;
                    nome=name;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    private String idprod;
    private String desc;
    private String descrizione_dettagliata;
    private String pathimageprodotto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;
    private double prezzo, altezza, peso;
    private int quantprodotto;
    private double subTotale;

    public Prodotto(String nome , double prezzo, String descrizione, String pathimageprodotto, String descrizione_dettagliata, double altezza, double peso) {
        this.nome=nome;
        this.desc=descrizione;
        this.prezzo=prezzo;
        this.pathimageprodotto=pathimageprodotto;
        this.descrizione_dettagliata=descrizione_dettagliata;
        this.altezza=altezza;
        this.peso=peso;
    }

    public int getQuantprodotto() {
        return quantprodotto;
    }

    public void setQuantprodotto(int quantprodotto) {
        this.quantprodotto = quantprodotto;
    }

    public Prodotto(String id_prodotto, String nome, double prezzo, String descrizione, int quantProdotto) {
        this.idprod=id_prodotto;
        this.nome=nome;
        this.prezzo=prezzo;
        this.desc=descrizione;
        this.quantprodotto=quantProdotto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Prodotto(String id_prodotto, String nome, double price, String descrizione, String pathimg) {
                this.idprod=id_prodotto;
                this.desc=descrizione;
                this.pathimageprodotto=pathimg;
                this.nome=nome;
                this.prezzo=price;

    }

    public Prodotto() {

    }

    public Prodotto(int id, String name, String desc, String img, int qty, double price) {
        this.idprod=Integer.toString(id);
        this.nome=name;
        this.desc=desc;
        this.pathimageprodotto=img;
        this.quantprodotto=qty;
        this.prezzo=price;

    }



    public Prodotto(String id, String name, double price, String desc, String img, int qty) {
                    this.idprod=id;
                    this.nome=name;
                    this.prezzo=price;
                    this.desc=desc;
                    this.pathimageprodotto=img;
                    this.quantprodotto=qty;
    }




    public double getPrezzo(){
        return prezzo;
    }
    public void setPrezzo(double prize){
        this.prezzo=prize;
    }
    public String getPathimageprodotto(){
        return pathimageprodotto;
    }
    public void setPathimageprodotto(String path){
        this.pathimageprodotto=path;
    }
    public String getDescrizione_dettagliata(){
        return descrizione_dettagliata;
    }
    public void setDescrizione_dettagliata(String des_dett){
        this.descrizione_dettagliata=des_dett;
    }
    public double getAltezza(){
        return altezza;
    }
    public void setAltezza(double altezza){
        this.altezza=altezza;
    }
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso=peso;
    }



    public String getSubTotale(){
        Locale locale=new Locale("ITALIAN");
        String pattern = "###.##";

        DecimalFormat decimalFormat =(DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        String format = decimalFormat.format(subTotale);
        return format;
    }
    public void  setSubTotale(double subTotale){
        this.subTotale=subTotale;
    }

}

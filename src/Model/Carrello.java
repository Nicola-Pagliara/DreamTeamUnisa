package Model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Carrello {
    private int idcarrello, idprodotto, idutente;
    private ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
    private double totalPrice;

        public Carrello(){

        }
        // getters and setters of class Cart's attribute
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getIdcarrello() {
        return idcarrello;
    }


    public void setIdcarrello(int idcarrello) {
        this.idcarrello = idcarrello;
    }


    public int getIdprodotto(int id_cliente) {
        return idprodotto;
    }


    public void setIdprodotto(int idprodotto) {
        this.idprodotto = idprodotto;
    }


    public int getIdutente() {
        return idutente;
    }


    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }


    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }


    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

// methods of Cart

    public void addProd(Prodotto prod){
            if(!listaProdotti.contains(prod)) {
                this.totalPrice+=prod.getPrezzo();
                listaProdotti.add(prod);
            }
        }

        public void removeProd(Prodotto prod){
                        if(listaProdotti.contains(prod)){
                                        this.totalPrice-=prod.getPrezzo();
                                        listaProdotti.remove(prod);
                        }
        }



    public int getSize() {
        return listaProdotti.size();
    }


    @Override
    public String toString() {
        return "Carrello [idcarrello=" + idcarrello + ", idprodotto=" + idprodotto + ", idutente=" + idutente
                + ", listaProdotti=" + listaProdotti + "prezzototale=" +getSubTotale()+"]";
    }

    public String getSubTotale(){
        Locale locale=new Locale("ITALIAN");
        String pattern = "###.##";

        DecimalFormat decimalFormat =(DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        String format = decimalFormat.format(totalPrice);
        return format;
    }


}

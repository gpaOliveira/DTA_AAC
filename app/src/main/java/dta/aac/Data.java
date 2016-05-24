package dta.aac;

import android.util.TypedValue;

import java.util.ArrayList;

/**
 * Created by oliveiga on 5/23/2016.
 */
public class Data {
    private static final Data INSTANCE = new Data();
    ArrayList<Category> categories = new ArrayList<Category>();

    private Data(){
        InicializaCategorias();
    }

    public ArrayList<Category> getCategories(){
        return categories;
    }

    private void InicializaCategorias() {
        //AQUI PODE LER DE UM XML, DE UM JSON OU ATÉ DE UM WS...
        categories.add(new Category("Comer", R.drawable.x, ObterAcoesComida()));
        categories.add(new Category("Dor", R.drawable.bandera, ObterAcoesCorpo()));
        categories.add(new Category("Coceira", R.drawable.banos_2, ObterAcoesCorpo()));
        categories.add(new Category("Estudo", R.drawable.banar, ObterAcoesCorpo()));
        categories.add(new Category("Líquido", R.drawable.barco_1, ObterAcoesComida()));
    }

    private ArrayList<Action> ObterAcoesComida() {
        ArrayList<Action> acoes = new ArrayList<Action>();
        acoes.add(new Action(R.drawable.aperitivo, "Queijo"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo2"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo3"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        return acoes;
    }

    private ArrayList<Action> ObterAcoesCorpo() {
        ArrayList<Action> acoes = new ArrayList<Action>();
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo2"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo3"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo2"));
        acoes.add(new Action(R.drawable.aperitivo, "Queijo3"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste"));
        acoes.add(new Action(R.drawable.aperitivo_1, "Teste2"));
        return acoes;
    }

    public static Data getInstance() {
        return Data.INSTANCE;
    }

    public static int getDPI(int n, final AacActivity activityContext){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, activityContext.getResources().getDisplayMetrics());
    }
}

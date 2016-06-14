package dta.aac;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.ArrayList;

/**
 * Created by oliveiga on 5/23/2016.
 */
public class Data {
    ArrayList<Category> categories = new ArrayList<Category>();
    Context context;

    public Data(Context ctx){
        this.context = ctx;
        InicializaCategorias();
    }

    public ArrayList<Category> getCategories(){
        return categories;
    }

    private void InicializaCategorias() {
        categories.add(
                new Category("Acao", R.drawable.x,
                        ObterAcoes("acao",
                                new String[]{
                                        "apagar_a_luz_1",
                                        "comer_um_sanduiche_1",
                                        "deitar_se",
                                        "entrar_2",
                                        "examinar_1",
                                        "levantar_se_4",
                                        "ligar_a_luz",
                                        "nao_1",
                                        "sair_1",
                                        "segurar",
                                        "tomar_banho"
                                })));
        categories.add(
                new Category("Alimento", R.drawable.x,
                        ObterAcoes("alimento",
                                new String[]{
                                        "abdominais",
                                        "agua",
                                        "braco",
                                        "cabeca_de_perfil",
                                        "calcanhar",
                                        "comida",
                                        "costas_1",
                                        "costela_3",
                                        "cotovelo",
                                        "coxa",
                                        "doce",
                                        "fruta",
                                        "frutos_secos_2",
                                        "joelho",
                                        "mao",
                                        "nadegas",
                                        "nariz",
                                        "olhos",
                                        "orelha",
                                        "perna",
                                        "pes",
                                        "pescoco_1",
                                        "rosto",
                                        "salgado",
                                        "suco"
                                })));
        categories.add(
                new Category("Local", R.drawable.x,
                        ObterAcoes("local",
                                new String[]{
                                        "banheiro_feminino_2",
                                        "banheiro_masculino_2",
                                        "casa",
                                        "hospital",
                                        "quarto_6",
                                        "recepcionista_1",
                                        "refeitorio_1",
                                        "sala"
                                })));
        categories.add(
                new Category("Pessoa", R.drawable.x,
                        ObterAcoes("pessoa",
                                new String[]{
                                        "elas",
                                        "eles",
                                        "eu",
                                        "nos_2",
                                        "voce_2"
                                })));
        categories.add(
                new Category("Sentimento", R.drawable.x,
                        ObterAcoes("sentimento",
                                new String[]{
                                        "alergia",
                                        "calor",
                                        "cocar",
                                        "corte_3",
                                        "doente",
                                        "dor_4",
                                        "dor_de_cabeca_1",
                                        "eczema"//,
                                        /*"enjoar",
                                        "esgotado",
                                        "fome",
                                        "frio",
                                        "resfriado"*/
                                })));

    }

    private ArrayList<Action> ObterAcoes(String category, String[] str_actions) {
        ArrayList<Action> acoes = new ArrayList<Action>();
        for(int i = 0; i < str_actions.length; i++) {
            acoes.add(createAction(category, str_actions[i]));
        }
        return acoes;
    }

    public Action createAction(String category, String action){
        return new Action(getDrawableFromString(category + "_" + action), action.replace("_1", "").replace("_2", "").replace("_3", "").replace("_4", "").replace("_5", "").replace("_6", "").replace("_", " "));
    }

    public static int getDPI(int n, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, context.getResources().getDisplayMetrics());
    }

    public static int getDPI(int n, DisplayMetrics displayMetrics){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, displayMetrics);
    }

    private int getDrawableFromString(String s){
        return this.context.getResources().getIdentifier(s, "drawable", context.getPackageName());
    }

}

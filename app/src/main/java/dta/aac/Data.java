package dta.aac;

import android.content.Context;
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
        initializeCategories();
    }

    public ArrayList<Category> getCategories(){
        return categories;
    }

    private void initializeCategories() {
        categories.add(
                new Category("Acao", R.drawable.x,
                        createActions("acao",
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
                        createActions("alimento",
                                new String[]{
                                        "agua",
                                        "comida",
                                        "doce",
                                        "fruta",
                                        "frutos_secos_2",
                                        "salgado",
                                        "suco"
                                })));
        categories.add(
                new Category("Corpo", R.drawable.x,
                        createActions("corpo",
                                new String[]{
                                        "abdominais",
                                        "braco",
                                        "cabeca_de_perfil",
                                        "calcanhar",
                                        "costas_1",
                                        "costela_3",
                                        "cotovelo",
                                        "coxa",
                                        "joelho",
                                        "mao",
                                        "nadegas",
                                        "nariz",
                                        "olhos",
                                        "orelha",
                                        "perna",
                                        "pes",
                                        "pescoco_1",
                                        "rosto"
                                })));
        categories.add(
                new Category("Local", R.drawable.x,
                        createActions("local",
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
                        createActions("pessoa",
                                new String[]{
                                        "elas",
                                        "eles",
                                        "eu",
                                        "nos_2",
                                        "voce_2"
                                })));
        categories.add(
                new Category("Sentimento", R.drawable.x,
                        createActions("sentimento",
                                new String[]{
                                        "alergia",
                                        "calor",
                                        "cocar",
                                        "corte_3",
                                        "doente",
                                        "dor_4",
                                        "dor_de_cabeca_1",
                                        "eczema",
                                        "enjoar",
                                        "esgotado",
                                        "fome",
                                        "frio",
                                        "resfriado"
                                })));

    }

    private ArrayList<Action> createActions(String category, String[] str_actions) {
        ArrayList<Action> acoes = new ArrayList<Action>();
        for(int i = 0; i < str_actions.length; i++) {
            acoes.add(createAction(category, str_actions[i]));
        }
        return acoes;
    }

    private Action createAction(String category, String action){
        return new Action(getDrawableFromString(category + "_" + action), action.replace("_1", "").replace("_2", "").replace("_3", "").replace("_4", "").replace("_5", "").replace("_6", "").replace("_", " "));
    }

    private int getDrawableFromString(String s){
        return this.context.getResources().getIdentifier(s, "drawable", context.getPackageName());
    }

}

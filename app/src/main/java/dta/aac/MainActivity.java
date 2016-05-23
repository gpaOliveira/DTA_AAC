package dta.aac;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import dta.aac.Acao;
import dta.aac.Categoria;

public class MainActivity extends AppCompatActivity {

    ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    TableRow tblCategorias;
    TableLayout tblAcoes;
    TextView tvAcao;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tblCategorias = (TableRow) findViewById(R.id.tblCategorias);
        tblAcoes = (TableLayout) findViewById(R.id.tblAcoes);
        tvAcao = (TextView) findViewById(R.id.txtBuffer);
        btnShare = (Button) findViewById(R.id.btn_share);
        InicializaCategorias();
        RenderizaCategorias();
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = tvAcao.getText().toString();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }

    private void InicializaCategorias() {
        //AQUI PODE LER DE UM XML, DE UM JSON OU ATÉ DE UM WS...
        Categoria cat = MontaCategoria("Comer");
        cat.setAcoes(ObterAcoesComida());
        categorias.add(cat);

        cat = MontaCategoria("Dor");
        cat.setAcoes(ObterAcoesCorpo());
        categorias.add(cat);

        cat = MontaCategoria("Coceira");
        cat.setAcoes(ObterAcoesCorpo());
        categorias.add(cat);

        cat = MontaCategoria("Estudo");
        cat.setAcoes(ObterAcoesCorpo());
        categorias.add(cat);

        cat = MontaCategoria("Líquido");
        cat.setAcoes(ObterAcoesComida());
        categorias.add(cat);

    }

    private ArrayList<Acao> ObterAcoesComida() {
        ArrayList<Acao> acoes = new ArrayList<Acao>();
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo2"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        return acoes;
    }

    private ArrayList<Acao> ObterAcoesCorpo() {
        ArrayList<Acao> acoes = new ArrayList<Acao>();
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo2"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo2"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Queijo3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste3"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste"));
        acoes.add(MontaAcao(R.drawable.aperitivo_1, "Teste2"));
        return acoes;
    }


    private Acao MontaAcao(int imagem, String descricao) {
        Acao ac = new Acao(imagem, descricao);
        return ac;
    }

    private Categoria MontaCategoria(String nome) {
        Categoria cat = new Categoria();
        cat.setNome(nome);
        return cat;
    }

    private void RenderizaAcoes(ArrayList<Acao> acoes) {
        int i = 0;
        tblAcoes.removeAllViews();
        TableRow tr = null;
        for (Acao a : acoes) {
            if (i % 3 == 0) {
                if (i != 0) {
                    tblAcoes.addView(tr);
                }
                tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            }


            RelativeLayout rl = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.acoes_row, null);

            ImageView b = (ImageView) rl.findViewById(R.id.img_row);

            TextView tv = (TextView) rl.findViewById(R.id.txt_row);
            tv.setText(a.getNome());

            b.setTag(a);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Acao acao = (Acao) v.getTag();
                    tvAcao.setText(tvAcao.getText() + " " + acao.getNome());
                }
            });
            tr.addView(rl);
            i++;
        }
        tblAcoes.addView(tr);
    }

    private void RenderizaCategorias() {
        for (int i = 0; i < categorias.size(); i++) {
            Button bt = new Button(this);
            TableRow.LayoutParams params = new TableRow.LayoutParams(400, 200);
            params.setMargins(20, 20, 20, 20);
            bt.setLayoutParams(params);
            bt.setText(categorias.get(i).getNome());
            bt.setTag(categorias.get(i));
            bt.setGravity(Gravity.CENTER);
            bt.setPadding(20, 20, 20, 20);
            bt.setBackgroundColor(Color.DKGRAY);
            bt.setTextColor(Color.WHITE);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Categoria c = (Categoria) v.getTag();
                    RenderizaAcoes(c.getAcoes());
                }
            });
            tblCategorias.addView(bt);
        }
    }


}

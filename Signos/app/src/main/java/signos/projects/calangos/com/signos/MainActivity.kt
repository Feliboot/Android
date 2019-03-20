package signos.projects.calangos.com.signos

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listaSignos = findViewById<ListView>(R.id.listviewID)
        val signos = arrayListOf<String>("Áries","Touro","Gêmeos","Câncer","Leão","Virgem"
                                                            ,"Libra","Escorpião","Sagitário","Capricórnio","Aquário","Peixes")
        val perfis  = arrayListOf<String>("Primeiro signo do Zodíaco, Áries simboliza o começo de tudo. É o signo dos inícios, que projeta no tempo presente, com sua enorme pulsação de vida, a idéia ou o desejo. Áries simboliza o momento do nascimento e a luta pela vida. É lutando que se conquista algo e Áries gosta de uma boa briga, em que possa concentrar toda a sua fé e sua mente.",
                "]Segundo signo do Zodíaco, Touro tem a função de estabilizar as conquistas e os caminhos abertos por Áries, e por isso mantém os pés bem firmes na terra, agüentando com paciência o que muitos outros abandonam pela metade.",
                "Terceiro signo do Zodíaco, a função básica de Gêmeos é disseminar e difundir o que Touro criou e consolidou a partir do impulso de Áries. O movimento da criação de algo passa sempre, no Zodíaco, por um processo trifásico, ou seja: um signo manifesta um impulso, em seguida outro a estabiliza e concentra e em seguida um outro a distribui, dissemina para que outro processo tenha início.",
                "Em Câncer, é preciso digerir tudo o que foi feito anteriormente, assentar a criação em uma base firme, integrá-la no ambiente coletivo em que todos vivem para que ela possa ser incorporada, e também deixar suas sementes para um futuro que não se conhece ainda. E exatamente isso é que Câncer faz e assim irá agir na vida: interiorizando o que vive, assentando em sua vida o que aprendeu, criando um apoio para as pessoas que considera iguais – e daí criando o conceito de uma família, ou tribo – onde irá gestar e nutrir, acalentando sonhos, o futuro de toda a coletividade.",
                "O quinto signo do zodíaco tem como função básica a fixação da germinação que ocorreu no escuro silencioso e protegido de Câncer, o signo anterior. Leão significa o momento em que os primeiros frutos dão rebentos, uma vez que a semente foi bem plantada. O produto é bom e forte se a semente recebeu o ambiente propício para se fortalecer. Signo fixo, Leão simboliza a força da criação, os primeiros resultados que irrompem, a despeito de todas as dificuldades. Daí a analogia do signo com o desafio e com a auto-afirmação.",
                "Virgem assinala aquele momento em que o homem, depois de provar seu valor, sua capacidade e seu poder em Leão, percebe que é preciso colocar tudo isso às ordens de um sistema maior, pois vive em comunidade. E mais: que ainda é necessário aprimorar-se, aperfeiçoar o que criou, aceitando humildemente que não sabe nem pode tudo e que faz parte de um organismo maior.",
                "O sétimo signo do Zodíaco marca a fronteira entre o mundo individual e particular – que começa em Áries e termina em Virgem – e o início da vida na coletividade, a socialização, o momento em que, após ter se aprimorado, organizado o ritmo da vida, começa a troca com a comunidade maior em que vive.",
                "O sétimo signo do Zodíaco marca a fronteira entre o mundo individual e particular – que começa em Áries e termina em Virgem – e o início da vida na coletividade, a socialização, o momento em que, após ter se aprimorado, organizado o ritmo da vida, começa a troca com a comunidade maior em que vive.",
                "Chega a vez de mais um signo de estabilidade e fixação, desta vez voltado para o relacionamento e seus produtos: o filho, as posses em comum, a criatividade.",
                "Sagitário tem a função de espalhar e acomodar, adaptando as descobertas feitas em Escorpião a um mundo mais amplo, onde a força aglutinada possa ser posta a serviço de uma inspiração, de um rumo social maior.",
                "Décimo signo do zodíaco, o Capricórnio inaugura uma estação – o verão no hemisfério sul e o inverno no hemisfério norte. Cardinal, portanto movimentador, senhor do tempo e dos grandes projetos, surge o capricórnio, cujo maior objetivo é a construção de algo que almeje o bem maior.",
                "Depois de ter construído algo na sociedade, chega a vez de consolidar o conhecimento de tudo o que foi construído para um grande número de pessoas. E assim chegamos, outra vez, ao último signo fixo da seqüência zodiacal, o Aquário, cuja função é encontrar os meios mais racionais para que a maior quantidade possível de pessoas possa, igualmente, usufruir de tudo o que foi criado no Capricórnio.",
                "Último signo do Zodíaco, Peixes também é o último da série dos signos mutáveis, aquele que dispersa e distribui tudo o que todos os signos anteriores construíram e criaram no ciclo de manifestação. Assim como ele se dedica ao entendimento geral de tudo, porque sabe que tudo tem um fim, também sabe que está na fronteira de dois mundos. Um mundo que termina, outro que deve começar dentro em pouco. Nesse limiar, Peixes permanece, sentindo e pressentindo o que ainda virá, e o que já foi, tentando ensinar ao mundo a lição de todos somos partes de um mesmo organismo, que não há separação.")

        var adaptador = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,signos)//contexto da aplicacao, o layout, o id do texto e o texto a ser mostrado
        listaSignos.adapter = adaptador
        val dialogo = AlertDialog.Builder(this@MainActivity)
        /*listaSignos.setOnItemClickListener { parent, view, position, id ->
            var posicao = position
            if(posicao==1){
                dialogo.setTitle("Perfil Áries")
                dialogo.setMessage("Primeiro signo do Zodíaco, Áries simboliza o começo de tudo. É o signo dos inícios, que projeta no tempo presente, com sua enorme pulsação de vida, a idéia ou o desejo. Áries simboliza o momento do nascimento e a luta pela vida. É lutando que se conquista algo e Áries gosta de uma boa briga, em que possa concentrar toda a sua fé e sua mente.")
            }

        }*/
        listaSignos.onItemClickListener = AdapterView.OnItemClickListener { AdapterView, view, position, id ->
            var posicao = position
            Log.i("Posicao", position.toString())
            if(posicao==0){
                dialogo.setTitle("Perfil Áries")
                dialogo.setMessage("Primeiro signo do Zodíaco, Áries simboliza o começo de tudo. É o signo dos inícios, que projeta no tempo presente, com sua enorme pulsação de vida, a idéia ou o desejo. Áries simboliza o momento do nascimento e a luta pela vida. É lutando que se conquista algo e Áries gosta de uma boa briga, em que possa concentrar toda a sua fé e sua mente.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==1){
                dialogo.setTitle("Perfil Touro")
                dialogo.setMessage("Segundo signo do Zodíaco, Touro tem a função de estabilizar as conquistas e os caminhos abertos por Áries, e por isso mantém os pés bem firmes na terra, agüentando com paciência o que muitos outros abandonam pela metade.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==2){
                dialogo.setTitle("Perfil Gêmeos")
                dialogo.setMessage("Terceiro signo do Zodíaco, a função básica de Gêmeos é disseminar e difundir o que Touro criou e consolidou a partir do impulso de Áries. O movimento da criação de algo passa sempre, no Zodíaco, por um processo trifásico, ou seja: um signo manifesta um impulso, em seguida outro a estabiliza e concentra e em seguida um outro a distribui, dissemina para que outro processo tenha início.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==3){
                dialogo.setTitle("Perfil Câncer")
                dialogo.setMessage("Em Câncer, é preciso digerir tudo o que foi feito anteriormente, assentar a criação em uma base firme, integrá-la no ambiente coletivo em que todos vivem para que ela possa ser incorporada, e também deixar suas sementes para um futuro que não se conhece ainda. E exatamente isso é que Câncer faz e assim irá agir na vida: interiorizando o que vive, assentando em sua vida o que aprendeu, criando um apoio para as pessoas que considera iguais – e daí criando o conceito de uma família, ou tribo – onde irá gestar e nutrir, acalentando sonhos, o futuro de toda a coletividade.")

                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==4){
                dialogo.setTitle("Perfil Leão")
                dialogo.setMessage("O quinto signo do zodíaco tem como função básica a fixação da germinação que ocorreu no escuro silencioso e protegido de Câncer, o signo anterior. Leão significa o momento em que os primeiros frutos dão rebentos, uma vez que a semente foi bem plantada. O produto é bom e forte se a semente recebeu o ambiente propício para se fortalecer. Signo fixo, Leão simboliza a força da criação, os primeiros resultados que irrompem, a despeito de todas as dificuldades. Daí a analogia do signo com o desafio e com a auto-afirmação.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==5){
                dialogo.setTitle("Perfil Virgem")
                dialogo.setMessage("Virgem assinala aquele momento em que o homem, depois de provar seu valor, sua capacidade e seu poder em Leão, percebe que é preciso colocar tudo isso às ordens de um sistema maior, pois vive em comunidade. E mais: que ainda é necessário aprimorar-se, aperfeiçoar o que criou, aceitando humildemente que não sabe nem pode tudo e que faz parte de um organismo maior.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==6){
                dialogo.setTitle("Perfil Libra")
                dialogo.setMessage("O sétimo signo do Zodíaco marca a fronteira entre o mundo individual e particular – que começa em Áries e termina em Virgem – e o início da vida na coletividade, a socialização, o momento em que, após ter se aprimorado, organizado o ritmo da vida, começa a troca com a comunidade maior em que vive.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==7){
                dialogo.setTitle("Perfil Escorpião")
                dialogo.setMessage("Chega a vez de mais um signo de estabilidade e fixação, desta vez voltado para o relacionamento e seus produtos: o filho, as posses em comum, a criatividade.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==8){
                dialogo.setTitle("Perfil Sagitário")
                dialogo.setMessage("Sagitário tem a função de espalhar e acomodar, adaptando as descobertas feitas em Escorpião a um mundo mais amplo, onde a força aglutinada possa ser posta a serviço de uma inspiração, de um rumo social maior.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==9){
                dialogo.setTitle("Perfil Capricórnio")
                dialogo.setMessage("Décimo signo do zodíaco, o Capricórnio inaugura uma estação – o verão no hemisfério sul e o inverno no hemisfério norte. Cardinal, portanto movimentador, senhor do tempo e dos grandes projetos, surge o capricórnio, cujo maior objetivo é a construção de algo que almeje o bem maior.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==10){
                dialogo.setTitle("Perfil Aquário")
                dialogo.setMessage("Depois de ter construído algo na sociedade, chega a vez de consolidar o conhecimento de tudo o que foi construído para um grande número de pessoas. E assim chegamos, outra vez, ao último signo fixo da seqüência zodiacal, o Aquário, cuja função é encontrar os meios mais racionais para que a maior quantidade possível de pessoas possa, igualmente, usufruir de tudo o que foi criado no Capricórnio.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
            else if (posicao==11){
                dialogo.setTitle("Perfil Peixes")
                dialogo.setMessage("Último signo do Zodíaco, Peixes também é o último da série dos signos mutáveis, aquele que dispersa e distribui tudo o que todos os signos anteriores construíram e criaram no ciclo de manifestação. Assim como ele se dedica ao entendimento geral de tudo, porque sabe que tudo tem um fim, também sabe que está na fronteira de dois mundos. Um mundo que termina, outro que deve começar dentro em pouco. Nesse limiar, Peixes permanece, sentindo e pressentindo o que ainda virá, e o que já foi, tentando ensinar ao mundo a lição de todos somos partes de um mesmo organismo, que não há separação.")
                val dialog: AlertDialog = dialogo.create()
                dialog.show()
            }
        }

    }
}

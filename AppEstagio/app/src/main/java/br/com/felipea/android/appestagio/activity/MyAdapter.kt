package br.com.felipea.android.appestagio.activity

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.felipea.android.appestagio.R

class MyAdapter {
    //Class MyAdapter com as textViews do cardView
    class MyAdapter(private val myDataset: Array<br.com.felipea.android.appestagio.model.Person>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

//        foi criado as view's e associado a cada textView, o id do que nos queremos mostrar na tela

        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
            var textViewName: TextView? = null
            var textViewCompany: TextView? = null
            var textViewLocation: TextView? = null

            init {
                textViewName = itemView.findViewById(R.id.name)
                textViewCompany = itemView.findViewById(R.id.company)
                textViewLocation = itemView.findViewById(R.id.location)

            }
        }


        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MyAdapter.MyViewHolder {
            // Criando uma nova view
            val root = LayoutInflater.from(parent.context)
                .inflate(R.layout.person_cell, parent, false) as CardView
            // set the view's size, margins, paddings and layout parameters
            return MyViewHolder(root)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            holder.textViewName?.text = myDataset[position].nome
            holder.textViewCompany?.text = myDataset[position].empresa
            holder.textViewLocation?.text =
                localidadeFunc(myDataset[position].cidade, myDataset[position].estado, myDataset[position].pais)

        }

        private fun localidadeFunc(cidade: String, estado: String, pais: String): CharSequence? {
            return cidade + " - " + estado + ", " + pais
        }

        override fun getItemCount() = myDataset.size
    }



}
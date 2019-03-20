package br.com.felipea.android.appestagio.`interface`

import br.com.felipea.android.appestagio.model.Person

interface OnDeleteListener {
    fun deleteItem(person: Person)
}
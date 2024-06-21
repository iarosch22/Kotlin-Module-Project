data class Archive(val name: String, val content: MutableList<Note>) {

    fun addNote(note: Note) {
        content.add(note)
    }

    override fun toString(): String {
        return if (content.isEmpty()) {
            "Архив \"$name\". Заметок пока нет"
        } else {
            "Архив \"$name\". В архиве есть заметки"
        }
    }
}

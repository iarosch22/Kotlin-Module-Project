data class Archive(val name: String, val content: MutableSet<Note>) {

    override fun toString(): String {

        return if (content.isEmpty()) {
            "Архив \"$name\". Заметок пока нет"
        } else {
            "Архив \"$name\":\n ${content.forEach { note -> println(note.toString()) }}"
        }
    }

}

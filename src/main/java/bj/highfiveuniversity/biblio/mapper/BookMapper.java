package bj.highfiveuniversity.biblio.mapper;

import bj.highfiveuniversity.biblio.dto.BookDTO;
import bj.highfiveuniversity.biblio.model.Book;

public class BookMapper {
    
    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getIsbn(), book.getAuteurs());
    }
}

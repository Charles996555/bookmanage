package com.jincheng.bookmanage.dto;

import com.jincheng.bookmanage.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int currentPage;
    private int totalPage;
    private List<Book> books;

}

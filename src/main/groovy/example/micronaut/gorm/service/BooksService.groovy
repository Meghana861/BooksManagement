package example.micronaut.gorm.service

import example.micronaut.gorm.domain.BooksDomain
import example.micronaut.gorm.model.BooksModel
import grails.gorm.transactions.Transactional

@Singleton
class BooksService {
    @Transactional
    def saveBooks(BooksModel booksModel){
        BooksDomain booksDomain=new BooksDomain()
        booksDomain.title=booksModel.title
        booksDomain.author=booksModel.author
        booksDomain.price=booksModel.price
        booksDomain.pubDate=booksModel.pubDate
        booksDomain.save()
        return "Books Saved Successfully"
    }

    @Transactional
    def getAllBooks(){
        BooksDomain booksDomain=BookDomain.findAll()
        return booksDomain
    }

    @Transactional
    def getBookById(Long id){
        BooksDomain booksDomain=BooksDomain.findById(id)
        return booksDomain
    }

    @Transactional
    def updateById(Long id,BooksModel updateBookModel){
        BooksDomain booksDomain=new BooksDomain()
        booksDomain.title=updateBookModel.title
        booksDomain.author=updateBookModel.author
        booksDomain.price=updateBookModel.price
        booksDomain.pubDate=updateBookModel.pubDate
        booksDomain.save()
        return updateBookModel
    }
}

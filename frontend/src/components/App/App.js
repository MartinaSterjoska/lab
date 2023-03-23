import './App.css';
import React, {Component} from "react";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Books from "../Books/BookList/books";
import EShopService from "../../repository/eshopRepository";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";

class App extends Component{
  constructor(props) {
    super(props);
    this.deleteBook = this.deleteBook.bind(this);
    this.state = {
      books: [],
      categories: [],
      selectedBook: {}
    }
  }

  render() {
    return(
        <BrowserRouter>
            <Header />
            <main>
                <div className="container">
                    <Routes>
                        <Route path="/categories" element=
                            {<Categories categories={this.state.categories}/>} />
                        <Route path="/books/add" element=
                            {<BookAdd onAddBook={this.addBook}
                                      categories={this.state.categories}/>}/>
                        <Route path="/books/edit/:id" element=
                            {<BookEdit onEditBook={this.editBook}
                                       categories={this.state.categories}
                                       book={this.state.selectedBook}/>}/>
                        <Route path="/books" element=
                            {<Books books={this.state.books}
                                    onDelete={this.deleteBook}
                                    onEdit={this.getBook}
                                    onMarkAsTaken={this.markAsTaken}/>} />
                        <Route path={"/"} exact element=
                            {<Books books={this.state.books}
                                    onDelete={this.deleteBook}/>} />
                    </Routes>
                </div>
            </main>
        </BrowserRouter>
    );
  }

  loadBooks = () => {
    EShopService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    deleteBook = (id) => {
        EShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }
    markAsTaken = (id) =>{
        EShopService.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            });
    }
    addBook = (name, category, author, availableCopies) => {
        EShopService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }
    getBook = (id) => {
        EShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    editBook = (id, name, category, author, availableCopies) => {
        EShopService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }
    componentDidMount() {
    this.loadBooks();
    this.loadCategories();
  }
}

export default App;

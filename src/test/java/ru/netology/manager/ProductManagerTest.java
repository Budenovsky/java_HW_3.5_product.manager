package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Product first = new Book(1, "Antichrist", 800, "Nietzsche");
    private Product second = new Book(2, "Dubrovskii", 300, "Pushkin");
    private Product third = new Book(3, "Poltava", 250, "Pushkin");
    private Product fourth = new Smartphone(4, "Iphone11", 1990000, "Apple");
    private Product fifth = new Smartphone(5, "Galaxy", 899000, "Samsung");

    @Test
    public void shouldFindByAuthor() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Pushkin");
        Product[] expected = new Product[]{second, third};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindByBookName() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Dubrovskii");
        Product[] expected = new Product[]{second};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindBySmartphoneName() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Iphone11");
        Product[] expected = new Product[]{fourth};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNoExsist() {
        Product[] returned = new Product[] {first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Product[] actual = manager.searchBy("Freid");
        Product[] expected = new Product[]{};

        assertArrayEquals(actual, expected);

    }
}
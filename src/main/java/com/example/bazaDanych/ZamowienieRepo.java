package com.example.bazaDanych;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ZamowienieRepo extends JpaRepository<Zamowienie, Integer> {
    List<Zamowienie> findAllByemail(String wyszukaj);
}

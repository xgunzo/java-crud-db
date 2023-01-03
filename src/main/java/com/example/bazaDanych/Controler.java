package com.example.bazaDanych;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controler {
    private ZamowienieRepo zamowienieRepo;

    @Autowired
    public Controler(ZamowienieRepo zamowienieRepo) {
        this.zamowienieRepo = zamowienieRepo;
    }

    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("nr_zamowienia") Integer nr_zamowienia,
            @RequestParam("marka") String marka,
            @RequestParam("model_produktu") String model_produktu,
            @RequestParam("imie") String imie,
            @RequestParam("nazwisko") String nazwisko,
            @RequestParam("nr_telefonu") String nr_telefonu,
            @RequestParam("email") String email, Model model)
            throws Exception {
        Zamowienie zamowienie = new Zamowienie(nr_zamowienia, marka, model_produktu, imie, nazwisko, nr_telefonu, email, true);
        System.out.println(zamowienie);
        zamowienieRepo.save(zamowienie); // ZAPIS DO BAZY !!!!
        model.addAttribute("zamowienie", zamowienie);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz(Model model) {
        for (Zamowienie zamowienie : zamowienieRepo.findAll()) {
            System.out.println(zamowienie);
        }

        model.addAttribute("zamowienie", zamowienieRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        zamowienieRepo.deleteById(id);
        model.addAttribute("zamowienie", zamowienieRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("zamowienie", zamowienieRepo.findAllByemail(kryterium));
        return "pokaz";
    }

    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("nr_zamowienia") Integer nr_zamowienia,
            @RequestParam("marka") String marka,
            @RequestParam("model_produktu") String model_produktu,
            @RequestParam("imie") String imie,
            @RequestParam("nazwisko") String nazwisko,
            @RequestParam("nr_telefonu") String nr_telefonu,
            @RequestParam("email") String email, Model model)
            throws Exception {
        Zamowienie zamowienie = new Zamowienie(id, nr_zamowienia, marka, model_produktu, imie, nazwisko, nr_telefonu, email, true);
        System.out.println(zamowienie);
        zamowienieRepo.save(zamowienie);
        model.addAttribute("zamowienie", zamowienie);
        return "Widok";
    }

    @RequestMapping("/przekieruj")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(zamowienieRepo.findById(id));
        model.addAttribute("zamowienie", zamowienieRepo.findById(id));
        return "aktualizuj";
    }


}

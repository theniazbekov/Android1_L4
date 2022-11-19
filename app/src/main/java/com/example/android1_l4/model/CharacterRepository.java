package com.example.android1_l4.model;

import com.example.android1_l4.model.CharacterModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepository {
    private final List<CharacterModel> listOfCharacters = new ArrayList<>();


    public List<CharacterModel> getListOfCharacters() {

        listOfCharacters.add(new CharacterModel("https://toplists.ru/uploads/items/9430/fa5bd-ichigokurosaki-md.jpg", "Ичиго Куросаки", 27));
        listOfCharacters.add(new CharacterModel("https://static.wikia.nocookie.net/anime-characters-fight/images/c/ca/Kisuke_Urahara_%28Bleach%29_%2814%29.png/revision/latest?cb=20201207202116&path-prefix=ru", "Урахара Киске", 100));
        listOfCharacters.add(new CharacterModel("https://static.wikia.nocookie.net/anime-characters-fight/images/3/3f/Kenpachi_Zaraki_%28Bleach%29_%283%29.png/revision/latest?cb=20201124164204&path-prefix=ru", "Кенпачи Зараки", 1000));
        listOfCharacters.add(new CharacterModel("https://static.wikia.nocookie.net/anime-characters-fight/images/a/a2/Ikkaku_Madarame_%28Bleach%29_%282%29.png/revision/latest?cb=20201209175405&path-prefix=ru", "Иккаку Мадараме", 100));
        listOfCharacters.add(new CharacterModel("https://static.wikia.nocookie.net/bleachpedia/images/e/ea/Episode_362_Byakuya.png/revision/latest?cb=20121129005429&path-prefix=ru", "Кучики Бьякуя", 100));
        listOfCharacters.add(new CharacterModel("https://static.wikia.nocookie.net/bleachpedia/images/d/d4/E320_Renji_Mugshot.png/revision/latest?cb=20121006222737&path-prefix=ru", "Рэндзи Абараи", 150));
        listOfCharacters.add(new CharacterModel("https://upload.wikimedia.org/wikipedia/ru/c/c3/Bleach_-_%D0%A2%D0%BE%D1%81%D0%B8%D1%80%D0%BE_%D0%A5%D0%B8%D1%86%D1%83%D0%B3%D0%B0%D1%8F.jpg", "Тоширо Хицугая", 150));
        listOfCharacters.add(new CharacterModel("https://static.wikia.nocookie.net/anime-characters-fight/images/3/31/Sousuke_Aizen_%28Bleach%29_%284%29.png/revision/latest?cb=20220811160452&path-prefix=ru", "Айзен Соске", 2000));


        return listOfCharacters;
    }
}
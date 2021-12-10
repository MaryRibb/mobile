package com.example.fifthlab

typealias HumansListener = (humans: Human?) -> Unit

object HumanHolder {
    var humans = mutableListOf<Human>()
    private var listeners = mutableSetOf<HumansListener>()

    fun sendMessage() {
        for (listener in listeners)
            listener.invoke(humans.firstOrNull())
        if (humans.count() > 0)
            humans.removeAt(0)
    }
    fun addListener(listener: HumansListener) {
        listeners.add(listener)
    }

    init {
        humans.add(
            Human(
                "https://vokrug.tv/pic/news/3/8/f/3/38f3aae991201143c17b6f388eb3993f.jpg",
                "Эмилия Изобел Юфимия Роуз Кларк",
                "1986-ХХ",
                "британская актриса театра, кино и телевидения." +
                        " Наиболее известна по ролям Дейенерис Таргариен в телесериале" +
                        " «Игра престолов», Сары Коннор в фильме «Терминатор:" +
                        " Генезис» и Ки’ры рус. в фильме «Хан Соло. Звёздные войны: Истории»." +
                        " Журнал Time назвал её одной из «100 самых влиятельных людей в мире» в 2019 году",
                "женщина"
            )
        )
        humans.add(
            Human(
                "https://www.film.ru/sites/default/files/people/1842277-1098214.jpg",
                "Кристофер Кейтсби Харингтон",
                "1986-ХХ",
                "британский актёр театра, кино и телевидения. Харингтон наиболее известен" +
                        " по роли Джона Сноу в телесериале HBO «Игра престолов»; роль принесла" +
                        " ему номинацию на прайм-таймовую премию «Эмми». В 2017 году он стал одним" +
                        " из самых высокооплачиваемых актёров телевидения, получая 1,1 миллион" +
                        " долларов за один эпизод «Игры престолов». ",
                "мужчина"
            )
        )
        humans.add(
            Human(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Reuni%C3%A3o_com_o_ator_norte-americano_Keanu_Reeves_%2846806576944%29_%28cropped%29.jpg/800px-Reuni%C3%A3o_com_o_ator_norte-americano_Keanu_Reeves_%2846806576944%29_%28cropped%29.jpg",
                "Киану Чарльз Ривз",
                "1964-ХХ",
                "канадский актёр, кинорежиссёр, кинопродюсер и музыкант (бас-гитарист)." +
                        " Наиболее известен своими ролями в киносериях «Матрица» (1999—н. в.)," +
                        " «Билл и Тед»  (англ.)рус. (1989—2020) и «Джон Уик» (2014—н. в.)," +
                        " а также в фильмах «На гребне волны» (1991), «Мой личный штат Айдахо»" +
                        " (1991), «Дракула» (1992), «Скорость» (1994), «Джонни-мнемоник» (1995)," +
                        " «Адвокат дьявола» (1997), «Константин: Повелитель тьмы» (2005) и" +
                        " «Короли улиц» (2008). ",
                "мужчина"
            )
        )
        humans.add(
            Human(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Johnny_Depp-2757_%28cropped%29.jpg/800px-Johnny_Depp-2757_%28cropped%29.jpg",
                "Джон Кристофер Депп",
                "1963-ХХ",
                " американский актёр, кинорежиссёр, музыкант, сценарист и продюсер." +
                        "Наибольшую известность Джонни принесли роли в фильмах Тима Бёртона," +
                        " в таких известных картинах, как «Эдвард Руки-ножницы», «Сонная Лощина»," +
                        " «Чарли и шоколадная фабрика», «Эд Вуд», «Суини Тодд, демон-парикмахер" +
                        " с Флит-стрит» и «Алиса в Стране чудес», мультфильм «Труп невесты»," +
                        " а также образ капитана Джека Воробья в серии фильмов «Пираты Карибского" +
                        " моря», наиболее значимыми фильмами были признаны такие картины, как «Что" +
                        " гложет Гилберта Грэйпа», «Бенни и Джун», «Мертвец», «Донни Браско»," +
                        " «Страх и ненависть в Лас-Вегасе», «Кокаин», «Волшебная страна», «Турист». ",
                "мужчина"
            )
        )

        humans.add(
            Human(
                "https://upload.wikimedia.org/wikipedia/commons/c/ce/Robbie_at_2019_Cannes_%28cropped%29.jpg",
                "Марго Элис Робби",
                "1990-ХХ",
                "австралийская актриса и кинопродюсер. Двукратная номинантка на премию" +
                        " «Оскар» (2018, 2020) Начала карьеру в 2007 году в Австралии. Известность" +
                        " на родине ей принесла роль Донны Фридмен в телесериале «Соседи»" +
                        " (2008—2011). Переехав в США в 2011 году, она сыграла Лору Кэмерон" +
                        " в телесериале «Пан Американ», после чего последовало множество предложений" +
                        " крупных ролей в художественных фильмах. Наиболее примечательные из них" +
                        " — Шарлотта в «Бойфренд из будущего» (2013), Наоми Лапалья в «Волк с" +
                        " Уолл-стрит» (2013), за которую Робби получила премию «Империя», Джейн" +
                        " Портер в «Тарзан. Легенда» (2016), Харли Квинн в «Отряде самоубийц» (2016)," +
                        " за которую она получила премию «Critics’ Choice Movie Awards». ",
                "женщина"
            )
        )

        humans.add(
            Human(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/David_Duchovny_by_Gage_Skidmore.jpg/800px-David_Duchovny_by_Gage_Skidmore.jpg",
                "Дэвид Уильям Духовны",
                "1960-ХХ",
                "мериканский актёр, сценарист, продюсер, режиссёр, писатель и музыкант." +
                        " Двукратный обладатель премии «Золотой глобус» (1997, 2008) за роли агента" +
                        " Фокса Малдера в телесериале «Секретные материалы» и писателя-ловеласа" +
                        " Хэнка Муди в телесериале «Блудливая Калифорния». ",
                "мужчина"
            )
        )

        humans.add(
            Human(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/BCumberbatch_Comic-Con_2019.jpg/800px-BCumberbatch_Comic-Con_2019.jpg",
                "Бенедикт Тимоти Карлтон Камбербэтч",
                "1976-ХХ",
                " британский актёр театра, кино и телевидения." +
                        "Лауреат премии Лоренса Оливье (2012), «Эмми» (2014) и «BAFTA TV» (2019)," +
                        " трёхкратный номинант на премию «Золотой глобус», номинант на премию" +
                        " «Оскар». Командор Ордена Британской империи (2015). ",
                "мужчина"
            )
        )

        humans.add(
            Human(
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Joaquin_Phoenix_at_the_2018_Berlin_Film_Festival.jpg/800px-Joaquin_Phoenix_at_the_2018_Berlin_Film_Festival.jpg",
                "Хоакин Рафаэль Боттом",
                "1974-ХХ",
                "Американский актёр, продюсер, музыкант и клипмейкер. Младший брат актёра" +
                        " Ривера Феникса.Четырёхкратный номинант и двукратный лауреат премии «Золотой глобус»," +
                        " призёр Каннского кинофестиваля и обладатель кубка Вольпи Венецианского" +
                        " кинофестиваля за лучшую мужскую роль, лауреат музыкальной премии «Грэмми»," +
                        " трёхкратный номинант и обладатель премии «Оскар» за фильм «Джокер»," +
                        " лауреат премии Британской киноакадемии. ",
                "мужчина"
            )
        )
    }
}
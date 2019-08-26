/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botlik;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.gikk.twirk.*;
import com.gikk.twirk.TwirkBuilder;
import com.gikk.twirk.events.TwirkListener;
import com.gikk.twirk.events.TwirkListenerBaseImpl;
import com.gikk.twirk.types.TwitchUser;
import com.gikk.twirk.types.TwitchMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import botlikUI.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

/**
 *
 * @author Elelav
 */
public class botlikMind {
    
    private String accountName = "";
    private String oauthPass = "";
    
    private Twirk twirk;
    public BotlikUIFrame UI = new BotlikUIFrame();
    Scanner scanner = new Scanner(System.in);
    final Random random = new Random();

    class SendButtonListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
            twirk.channelMessage(UI.getMessageFromField());
            UI.clearMessageField();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    class ExitButtonListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
            System.exit(0);
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    class ConnectButtonListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
            UI.setButtonsDisabled();
            ConnectButtonTask task = new ConnectButtonTask();
            task.execute();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    class ConnectButtonTask extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            UI.hideConnectFrame();
            UI.setVisible(true);
            String channel = "#" + UI.getjTextField3().getText();
            twirk = new TwirkBuilder(channel, accountName, oauthPass)
                    .setVerboseMode(true)
                    .build();
            try {
                twirk.connect();	//Connect to Twitch
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Botlik.class.getName()).log(Level.SEVERE, null, ex);
            }
            twirk.channelMessage(
                    "Ботлик активейтед MrDestructoid ");
            startBot();
            return null;

        }

        @Override
        public void done() {
            UI.setButtonsEnabled();
        }
    }

    public void connect() {
        UI.setConnectButtonListener(new ConnectButtonListener());
        UI.setSendButtonListener(new SendButtonListener());
        UI.setExitButtonListener(new ExitButtonListener());
        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
                if ("Enter".equals(KeyEvent.getKeyText(keyEvent.getKeyCode()))) {
                    twirk.channelMessage(UI.getMessageFromField());
                    UI.clearMessageField();
                }
            }

            public void keyReleased(KeyEvent keyEvent) {
            }

            public void keyTyped(KeyEvent keyEvent) {
            }
        };
        UI.getjTextField1().addKeyListener(keyListener);
        UI.openConnectFrame();
    }

    public void startBot() {
        twirk.addIrcListener(new TwirkListenerBaseImpl() {

            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                UI.printChat(sender.getDisplayName(), message.getContent());
            }
        }
        );

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!ботлик")) {
                    twirk.channelMessage("Да, это я BCWarrior ");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("LUL")) {
                    twirk.channelMessage("LUL");
                }
            }
        });
        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("Kappa")) {
                    random.nextInt(2);
                    twirk.channelMessage("Kappa");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("MrDestructoid")) {
                    twirk.channelMessage("MrDestructoid недостойные людишки");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!вк")) {
                    twirk.channelMessage("https://vk.com/camille_waifu_cafe");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!создатель")) {
                    twirk.channelMessage("Год Лик KappaPride ");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!кем играть")) {
                    String champ = "Азир Акали Алистар Амуму Анивия Ари Атрокс АурелионСол Бард Блицкранк Браум Брэн Вай Варвик Варус Вейгар Вейн Вел'Коз Виктор Владимир Волибир Вуконг Галио Гангпланк Гарен Гекарим Гнар Грагас Грейвз Дариус Джакс ДжарванIV Джейс Джин Джинкс Диана Доктор Мундо Дрейвен Жанна Зайра Зак Зед Зерат Зиггс Зилеан Зои  Иверн Иллаой Ирелия Йорик Ка'Зикс Каин Кай'Са Калиста Камилла Карма  Картус Кассадин Кассиопея Катарина Квинн Кейл Кейтлин Кеннен Киндред Клед Ког'Мао Корки КсинЖао ЛеБлан Леона ЛиСин Лиссандра Лулу Люкс Люциан Мальзахар Мальфит Маокай МастерЙи МиссФортуна Моргана Мордекайзер Нами Насус Наутилус Нидали Ноктюрн Нуну Олаф Орианна Орн Пайк Пантеон Поппи Райз Рамбл Раммус Рек'Сай Ренгар Ренектон Ривен Рэйкан Свейн Седжуани Сивир Синджед Синдра Сион Скарнер Сона Сорака ТаамКенч Талия Талон Тарик ТвистедФэйт Твич Тимо Трандл Треш Триндамир Тристана Удир Ургот Фиддлстикс Физз Фиора Хеймердингер Чо'Гат Шако Шая Шен Шивана Эвелинн Эзреаль Экко Элиза Энни Эш Ясуо";
                    String[] chemp = champ.split("\\s");
                    Random rand2 = new Random();
                    twirk.channelMessage(chemp[rand2.nextInt(141)]);
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!команды")) {
                    twirk.channelMessage("Список команд: !ботлик, !вк, !iq, !создатель, !кем играть, !пледик, !какаву, !бар, !шанс, слово + слово.");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!бар")) {
                    String champ = "квас пиво вино брют портвейн мадера херес марсала малага токай кагор вермут мускат перри сидр шампанское саке сато кумыс хурэмгэ билк арак архи тарасун абсент аквавит арак бренди коньяк граппа кальвадос киршвассер сливовица метакса водка виски джин маотай узо ракы ром чача тутовка ханшина бамбузе цинар шнапс ягати кизлярка текила самогон старка ликёр мецкаль арцах крамбамбуля мамахуана";
                    String[] chemp = champ.split("\\s");
                    Random rand2 = new Random();
                    twirk.channelMessage("/me достал бутыль с красивой надписью " + chemp[rand2.nextInt(57)] + " и передал бокал " + sender.getDisplayName());
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!пледик")) {
                    twirk.channelMessage("Держи свой пледик :3 " + sender.getDisplayName());
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!какаву")) {
                    twirk.channelMessage("Держи свою какаву :3 " + sender.getDisplayName());
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!камиль")) {
                    twirk.channelMessage("Камиль в отпуске, чем я могу помочь тебе " + sender.getDisplayName() + " ?");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!шанс")) {
                    twirk.channelMessage("По моим подсчетам вероятность примерно " + random.nextInt(100) + "% ");
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!iq")) {
                    String mes = message.getContent();
                    String[] chemp = mes.split("\\s");
                    Random rand2 = new Random();
                    twirk.channelMessage("Показатель IQ для " + chemp[1] + " определен и равен:  " + random.nextInt(350));
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                if (message.getContent().contains("!random")) {
                    Set<String> userList = twirk.getUsersOnline();                    
                    int count = 0;
                    int randomUserNumber = random.nextInt(userList.size());
                    for (String user : userList) {
                        if (count == randomUserNumber) {       
                              twirk.channelMessage("Случайный пользователь выбран: @" + user);
                            break;
                        }
                        count++;
                    }
                }
            }
        });

        twirk.addIrcListener(new TwirkListenerBaseImpl() {
            public void onPrivMsg(TwitchUser sender, TwitchMessage message) {
                String mes = message.getContent();
                if ("сура + фистинг".equals(mes.toLowerCase())) {
                    twirk.channelMessage("Сура не любит фистинг DansGame");
                } else {
                    Pattern p = Pattern.compile("\\S*\\s\\+\\s.*");
                    Matcher m = p.matcher(mes);
                    if (m.matches()) {
                        String[] w = mes.split("\\s");
                        Random rand = new Random();
                        if (m.matches()) {
                            twirk.channelMessage(w[0] + " любит " + w[2] + " на " + rand.nextInt(100) + "% ");
                        }
                    }
                }
            }
        });

        String line;
        while (!(line = scanner.nextLine()).matches(".quit")) {
            System.out.println("kek");
        }

        twirk.channelMessage("Ботлик диактивейтед MrDestructoid");

        scanner.close();
        twirk.close();

    }

    private static TwirkListener getOnDisconnectListener(final Twirk twirk) {

        return new TwirkListenerBaseImpl() {
            @Override
            public void onDisconnect() {
                try {
                    if (!twirk.connect()) {
                        twirk.close();
                    }
                } catch (IOException e) {
                    twirk.close();
                } catch (InterruptedException e) {
                }
            }
        };
    }

    public Twirk getTwirk() {
        return twirk;
    }

}

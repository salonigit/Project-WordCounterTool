import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WordCounterTool implements KeyListener {
    static int ch=0,words=0,sen=0,para=0;
    static JLabel textField1=new JLabel();
    static JLabel textField2=new JLabel();
    static JLabel textField3=new JLabel();
    static JLabel textField4=new JLabel();
    ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args)
    {
        WordCounterTool wordCounterTool = new WordCounterTool();
        JFrame obj=new JFrame();
        JTextArea textArea=new JTextArea();
        JLabel label1 =new JLabel();
        JLabel label2=new JLabel();
        JLabel label3=new JLabel();
        JLabel label4=new JLabel();
        obj.setBounds(10,10,1000,700);
        obj.setLayout(null);
        obj.setVisible(true);
        obj.setBackground(Color.black);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(textArea);
        obj.setResizable(false);
        textArea.setBounds(13,13,968,400);
        textArea.setBackground(Color.WHITE);
        textArea.setVisible(true);
        obj.add(label1);
        obj.add(label2);
        obj.add(label3);
        obj.add(label4);
        label1.setBounds(13,500,968,20);
        label1.setText("Characters :");
        label1.setFont(new Font("Serif",Font.PLAIN,18));
        label2.setBounds(13,530,968,20);
        label2.setText("Words:");
        label2.setFont(new Font("Serif",Font.PLAIN,18));
        label3.setBounds(13,560,968,20);
        label3.setText("Sentence:");
        label3.setFont(new Font("Serif",Font.PLAIN,18));
        label4.setBounds(13,590,968,20);
        label4.setText("Paragraph:");
        label4.setFont(new Font("Serif",Font.PLAIN,18));
        obj.add(textField1);
        obj.add(textField2);
        obj.add(textField3);
        obj.add(textField4);
        textField1.setBounds(100,500,850,20);
        textField1.setText("0");
        textField2.setBounds(100,530,850,20);
        textField2.setText("0");
        textField3.setBounds(100,560,850,20);
        textField3.setText("0");
        textField4.setBounds(100,590,850,20);
        textField4.setText("0");
        textArea.addKeyListener(wordCounterTool);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
            int ch1 = 0, words1 = 0, sen1 = 0, para1 = 0;
            int x = list.size();
            if (x <= 1) {
                if(x==1)
                {list.remove(0);
                words1 = 0;
                sen1 = 0;
                textField3.setText(String.valueOf(sen1));
                textField2.setText(String.valueOf(words1));
                ch1 = 0;
                textField1.setText(String.valueOf(ch1));
                para1 = 0;
                textField4.setText(String.valueOf(para1));
            }}

            else {
                list.remove(x - 1);
                for (int i = 0; i < list.size(); i++) {
                    x = list.size();
                    if ( (list.get(i) >= 33 && list.get(i)<= 126)&&i >= 1) {
                        if ((list.get(i - 1) == ' ')&&((list.get(i)>=48&&list.get(i)<=57)||(list.get(i)>=65 &&list.get(i)<=90)||(list.get(i)>=97&&list.get(i)<=122))) {
                            words1++;
                            textField2.setText(String.valueOf(words1));
                            ch1++;
                            textField1.setText(String.valueOf(ch1));
                        }
                    else if ((list.get(i - 1) == '+'||list.get(i - 1) == '-'||list.get(i - 1) == '*'||list.get(i - 1) == '/'||list.get(i - 1) == '='||list.get(i - 1) == '.')&&((list.get(i)>=48&&list.get(i)<=57)||(list.get(i)>=65 &&list.get(i)<=90)||(list.get(i)>=97&&list.get(i)<=122))) {
                            if(list.get(i - 1) == '.')
                            {words1++;
                            textField2.setText(String.valueOf(words1));
                            ch1++;
                            textField1.setText(String.valueOf(ch1));
                                sen1++;
                                textField3.setText(String.valueOf(sen1));
                        }
                            else{
                                words1++;
                                textField2.setText(String.valueOf(words1));
                                ch1++;
                                textField1.setText(String.valueOf(ch1));
                            }}
                        else if ((list.get(i - 1) == ';'||list.get(i - 1) == ','||list.get(i - 1) == 92)&&(list.get(i) == 92&&list.get(i)!='/'&&list.get(i)!=';'&&list.get(i)!=',')) {
                            words1++;
                            textField2.setText(String.valueOf(words1));
                            ch1++;
                            textField1.setText(String.valueOf(ch1));
                        }
                       else if (list.get(i - 1) == KeyEvent.VK_ENTER&&list.get(i)!=KeyEvent.VK_ENTER) {
                            para1++;
                            textField4.setText(String.valueOf(para1));
                            words1++;
                            textField2.setText(String.valueOf(words1));
                            sen1++;
                            textField3.setText(String.valueOf(sen1));
                            ch1++;
                            textField1.setText(String.valueOf(ch1));
                        }
                        else if(list.get(i)==KeyEvent.VK_ENTER||list.get(i)==' ')
                        {

                        }else {
                            ch1++;
                            textField1.setText(String.valueOf(ch1));
                        }
                    }
                    else if (i == 0) {
                        ch1=1;
                        textField1.setText(String.valueOf(ch1));
                        words1=1;
                        textField2.setText(String.valueOf(words1));
                        para1=1;
                        textField4.setText(String.valueOf(para1));
                        sen1=1;
                        textField3.setText(String.valueOf(sen1));
                    }
                }
            }
            words = words1;
            ch = ch1;
            sen = sen1;
            para = para1;
        } else {
            if ((e.getKeyChar() >= 33 && e.getKeyChar() <= 126)||e.getKeyChar()==' '||e.getKeyChar()==10) {
                int c = e.getKeyChar();
                list.add(c);
                int x = list.size();
                if (x >= 2) {
                    if ((list.get(x - 2) == ' ')&&((list.get(x-1)>=48&&list.get(x-1)<=57)||(list.get(x-1)>=65 &&list.get(x-1)<=90)||(list.get(x-1)>=97&&list.get(x-1)<=122))) {
                        words++;
                        textField2.setText(String.valueOf(words));
                        ch++;
                        textField1.setText(String.valueOf(ch));
                    }
                    else if (list.get(x - 2) == '.'&&((list.get(x-1)>=48&&list.get(x-1)<=57)||(list.get(x-1)>=65 &&list.get(x-1)<=90)||(list.get(x-1)>=97&&list.get(x-1)<=122))) {
                        words++;
                        textField2.setText(String.valueOf(words));
                        ch++;
                        textField1.setText(String.valueOf(ch));
                        sen++;
                        textField3.setText(String.valueOf(sen));
                    }
                    else if ((list.get(x - 2) == '+'||list.get(x - 2) == '/'||list.get(x - 2) == '*'||list.get(x - 2) == '-'||list.get(x - 2) == '=')&&((list.get(x-1)>=48&&list.get(x-1)<=57)||(list.get(x-1)>=65 &&list.get(x-1)<=90)||(list.get(x-1)>=97&&list.get(x-1)<=122))) {
                        words++;
                        textField2.setText(String.valueOf(words));
                        ch++;
                        textField1.setText(String.valueOf(ch));
                    }else if ((list.get(x - 2) == 92||list.get(x - 2) == ';'||list.get(x - 2) == ',')&&(list.get(x-1)!=92&&list.get(x-1)!='/'&&list.get(x-1)!=';'&&list.get(x-1)!=',')) {
                        words++;
                        textField2.setText(String.valueOf(words));
                        ch++;
                        textField1.setText(String.valueOf(ch));
                    }
                else if (list.get(x - 2) == KeyEvent.VK_ENTER&&list.get(x-1)!=KeyEvent.VK_ENTER) {
                        para++;
                        textField4.setText(String.valueOf(para));
                        words++;
                        textField2.setText(String.valueOf(words));
                        sen++;
                        textField3.setText(String.valueOf(sen));
                        ch++;
                        textField1.setText(String.valueOf(ch));
                    }else if(list.get(x-1)==KeyEvent.VK_ENTER||list.get(x-1)==' ')
                    {
                    }
                    else {
                        ch++;
                        textField1.setText(String.valueOf(ch));
                    }
                } else if (x == 1) {
                    ch=1;
                    textField1.setText(String.valueOf(ch));
                    words=1;
                    textField2.setText(String.valueOf(words));
                    para=1;
                    textField4.setText(String.valueOf(para));
                    sen=1;
                    textField3.setText(String.valueOf(sen));
                }
            }
        }
    }
        @Override
    public void keyReleased(KeyEvent e) {

    }
}

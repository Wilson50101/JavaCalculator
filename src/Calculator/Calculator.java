package Calculator;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener
{
	   static Calculator frm = new Calculator();
	   static Panel pnl = new Panel(new GridLayout(4,3));
	   static Label lab = new Label("0. ", Label.RIGHT);
      static Panel pnl2 = new Panel(new GridLayout(4,1));
      static Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20;

	   public static void main(String args[])
	   {
	      frm.setTitle("�p���");
	      frm.setLayout(null);
	      frm.setSize(300, 200);
		   frm.setLocation(100, 100);
		   frm.setBackground(Color.white);
		   frm.setResizable(false);

		   lab.setBounds(20, 30, 200, 20);
		   lab.setBackground(new Color(240, 220, 190));

		   pnl.setBounds(20, 60, 120, 80);
         pnl2.setBounds(150, 50, 90, 180);

           //�]�w���s
            btn1=new Button("1");
            btn2=new Button("2");
            btn3=new Button("3");
            btn4=new Button("4");
            btn5=new Button("5");
            btn6=new Button("6");
            btn7=new Button("7");
            btn8=new Button("8");
            btn9=new Button("9");
            btn0=new Button("0");
            btn10=new Button("=");
            btn11=new Button("+");
            btn12=new Button("-");
            btn13=new Button("*");
            btn14=new Button("/");
            btn15=new Button("clear");
            btn16=new Button("n!");
            btn17=new Button("^2");
            btn18=new Button("sqrt");
            btn19=new Button(".");//�p���I�ڦ�show�X�Ӥ��L�{�����|�g
            btn20=new Button("1/x");
          //�[��panel
            pnl.add(btn1);
            pnl.add(btn2);
            pnl.add(btn3);
            pnl.add(btn4);
            pnl.add(btn5);
            pnl.add(btn6);
            pnl.add(btn7);
            pnl.add(btn8);
            pnl.add(btn9);
            pnl.add(btn15);
            pnl.add(btn0);
            pnl.add(btn10);
            pnl2.add(btn11);
            pnl2.add(btn12);
            pnl2.add(btn13);
            pnl2.add(btn14);
            pnl2.add(btn16);
            pnl2.add(btn17);
            pnl2.add(btn18);
            pnl2.add(btn19);
            pnl2.add(btn20);
         //���U
         btn1.addActionListener(frm);
         btn2.addActionListener(frm);
         btn3.addActionListener(frm);
         btn4.addActionListener(frm);
         btn5.addActionListener(frm);
         btn6.addActionListener(frm);
         btn7.addActionListener(frm);
         btn8.addActionListener(frm);
         btn9.addActionListener(frm);
         btn0.addActionListener(frm);
         btn10.addActionListener(frm);
         btn11.addActionListener(frm);
         btn12.addActionListener(frm);
         btn13.addActionListener(frm);
         btn14.addActionListener(frm);
         btn15.addActionListener(frm);
         btn16.addActionListener(frm);
         btn17.addActionListener(frm);
         btn18.addActionListener(frm);
         btn19.addActionListener(frm);
         btn20.addActionListener(frm);
         //�[��frm
		   frm.add(lab);
		   frm.add(pnl);
         frm.add(pnl2);
		   frm.setVisible(true);
		   frm.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e) {System.exit(0);}});

      }
   public int i=1;
   public double operandl=0;  //�O�d�ǳƹB�⪺��
   public String str="";   //��J���� �N��J�Φr���_
   public String op="";    //�O���B��l
   public void actionPerformed(ActionEvent e)
   {
      Button btn=(Button) e.getSource();  //Ū����J��button
      //�B��
      if(btn==btn10||btn==btn11||btn==btn12||btn==btn13||btn==btn14||btn==btn16||btn==btn17||btn==btn18||btn==btn20)//���U+-*/=��
      {
         double number=Double.parseDouble(lab.getText());
         switch(op)  //�Y���e���O�d�B�⪺���B�� op!=0
         {
             case "+":   // �[
                number = operandl+number;
                break;
             case "-":   // ��
                number = operandl-number;
                break;
             case "*":   // ��
                number = operandl*number;
                break;
             case "/":   // ��
                if(number!=0)    // �קK /0
                number = operandl/number;
                break;
         }
          if(btn==btn16)//����
               if(number!=0)    // �קK /0
              {
                int sum=1;
                for(i=1;i<=number;i++)
                  sum=sum*i;
                number=sum;
              }
          if(btn==btn17)//����
          {
           double a=number;
           a*=a;
           number=a;
          }
          if(btn==btn18)//�����
        {
           number=(Math.sqrt(number));
        }
          if(btn==btn20)
            number=1/number;

         lab.setText(Double.toString(number));//�N�Ʀr�令�r���X
         op=btn.getLabel();
         if(op!="=")
         {
            operandl = number;
            str = "";
         }
      }

      //�M��
      else if(btn==btn15)//���Uc��
      {
         str="";
         operandl=0;
         op="";
         lab.setText("0");
      }

      //�Ʀr
      else//���U0~9
      {
         double  num=Double.parseDouble(btn.getLabel());
         if(num!=0 || str.length()!=0)//�קK��J���Ĥ@�Ӧr�ꬰ0
         {
            str+=btn.getLabel();
            lab.setText(str);
         }

      }
   }
}

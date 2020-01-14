package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calculator extends Frame implements ActionListener
{	  
		private Panel pnlNumber = new Panel(new GridLayout(4,3));
		static Label lab = new Label("0. ", Label.RIGHT);
		static Panel pnlOperator = new Panel(new GridLayout(4,1));
		static private LinkedList buttons = new LinkedList<Button>();
		static private LinkedList buttonType = new LinkedList<Integer>();
	   public Calculator()
	   {
		   
	      this.setTitle("�p���");
	      this.setLayout(null);
	      this.setSize(300, 200);
	      this.setLocation(100, 100);
	      this.setBackground(Color.white);
	      this.setResizable(false);

		   lab.setBounds(20, 30, 200, 20);
		   lab.setBackground(new Color(240, 220, 190));

		   pnlNumber.setBounds(20, 60, 120, 80);
         pnlOperator.setBounds(150, 50, 90, 180);
         
       //�]�w���s
         initialButtons();
         
         for(int i = 0; i<buttons.size(); i++)
         {
        	 Button btn;
        	 btn = (Button) buttons.get(i);
        	 switch((int)buttonType.get(i))
        	 {
        	 case 0:
        		 pnlNumber.add(btn);
        		 break;
        	 case 1:
        		 pnlOperator.add(btn);
        		 break;
        	 default:
        		 pnlNumber.add(btn);
        		 break;
        	 }
        	 btn.addActionListener(this);
         }
           
         //�[��frm
         this.add(lab);
         this.add(pnlNumber);
         this.add(pnlOperator);
         this.setVisible(true);
         this.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e) {System.exit(0);}});

      }
	   
   public int i=1;
   public double operandl=0;  //�O�d�ǳƹB�⪺��
   public String str="";   //��J���� �N��J�Φr���_
   public String op="";    //�O���B��l
   public void actionPerformed(ActionEvent e)
   {
      String btnPress = e.getActionCommand();  //Ū����J��button
      //�B��
      if(btnPress == "+"||btnPress == "-"||btnPress == "*"||btnPress == "/"||btnPress == "="||btnPress == "n!"||btnPress == "^2"||btnPress == "sqrt"||btnPress == "1/x")//���U+-*/=��
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
          if(btnPress=="n!")//����
               if(number!=0)    // �קK /0
              {
                int sum=1;
                for(i=1;i<=number;i++)
                  sum=sum*i;
                number=sum;
              }
          if(btnPress=="^2")//����
          {
           double a=number;
           a*=a;
           number=a;
          }
          if(btnPress=="sqrt")//�����
        {
           number=(Math.sqrt(number));
        }
          if(btnPress=="1/x")
            number=1/number;

         lab.setText(Double.toString(number));//�N�Ʀr�令�r���X
         op=btnPress;
         if(op!="=")
         {
            operandl = number;
            str = "";
         }
      }

      //�M��
      else if(btnPress=="clear")//���Uc��
      {
         str="";
         operandl=0;
         op="";
         lab.setText("0");
      }

      //�Ʀr
      else//���U0~9
      {
         double  num=Double.parseDouble(btnPress);
         if(num!=0 || str.length()!=0)//�קK��J���Ĥ@�Ӧr�ꬰ0
         {
            str+=btnPress;
            lab.setText(str);
         }

      }
   }
   
   private static void initialButtons()
   {
	   buttons.add(new Button("1"));
	   buttonType.add(0);
	   buttons.add(new Button("2"));
	   buttonType.add(0);
	   buttons.add(new Button("3"));
	   buttonType.add(0);
	   buttons.add(new Button("4"));
	   buttonType.add(0);
	   buttons.add(new Button("5"));
	   buttonType.add(0);
	   buttons.add(new Button("6"));
	   buttonType.add(0);
	   buttons.add(new Button("7"));
	   buttonType.add(0);
	   buttons.add(new Button("8"));
	   buttonType.add(0);
	   buttons.add(new Button("9"));
	   buttonType.add(0);
	   buttons.add(new Button("0"));
	   buttonType.add(0);
	   buttons.add(new Button("="));
	   buttonType.add(0);
	   buttons.add(new Button("+"));
	   buttonType.add(1);
	   buttons.add(new Button("-"));
	   buttonType.add(1);
	   buttons.add(new Button("*"));
	   buttonType.add(1);
	   buttons.add(new Button("/"));
	   buttonType.add(1);
	   buttons.add(new Button("clear"));
	   buttonType.add(0);
	   buttons.add(new Button("n!"));
	   buttonType.add(1);
	   buttons.add(new Button("^2"));
	   buttonType.add(1);
	   buttons.add(new Button("sqrt"));
	   buttonType.add(1);
	   buttons.add(new Button("."));
	   buttonType.add(1);
	   buttons.add(new Button("1/x"));
	   buttonType.add(1);
   }
   public static void main(String[] args) 
	{
		Calculator calculatorAPP=new Calculator();
	}
}

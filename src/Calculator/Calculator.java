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
		   
	      this.setTitle("計算機");
	      this.setLayout(null);
	      this.setSize(300, 200);
	      this.setLocation(100, 100);
	      this.setBackground(Color.white);
	      this.setResizable(false);

		   lab.setBounds(20, 30, 200, 20);
		   lab.setBackground(new Color(240, 220, 190));

		   pnlNumber.setBounds(20, 60, 120, 80);
         pnlOperator.setBounds(150, 50, 90, 180);
         
       //設定按鈕
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
           
         //加到frm
         this.add(lab);
         this.add(pnlNumber);
         this.add(pnlOperator);
         this.setVisible(true);
         this.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e) {System.exit(0);}});

      }
	   
   public int i=1;
   public double operandl=0;  //保留準備運算的值
   public String str="";   //輸入控制 將輸入用字串串起
   public String op="";    //記錄運算子
   public void actionPerformed(ActionEvent e)
   {
      String btnPress = e.getActionCommand();  //讀取輸入的button
      //運算
      if(btnPress == "+"||btnPress == "-"||btnPress == "*"||btnPress == "/"||btnPress == "="||btnPress == "n!"||btnPress == "^2"||btnPress == "sqrt"||btnPress == "1/x")//按下+-*/=時
      {
         double number=Double.parseDouble(lab.getText());
         switch(op)  //若之前有保留運算的先運算 op!=0
         {
             case "+":   // 加
                number = operandl+number;
                break;
             case "-":   // 減
                number = operandl-number;
                break;
             case "*":   // 乘
                number = operandl*number;
                break;
             case "/":   // 除
                if(number!=0)    // 避免 /0
                number = operandl/number;
                break;
         }
          if(btnPress=="n!")//階乘
               if(number!=0)    // 避免 /0
              {
                int sum=1;
                for(i=1;i<=number;i++)
                  sum=sum*i;
                number=sum;
              }
          if(btnPress=="^2")//平方
          {
           double a=number;
           a*=a;
           number=a;
          }
          if(btnPress=="sqrt")//平方根
        {
           number=(Math.sqrt(number));
        }
          if(btnPress=="1/x")
            number=1/number;

         lab.setText(Double.toString(number));//將數字改成字串輸出
         op=btnPress;
         if(op!="=")
         {
            operandl = number;
            str = "";
         }
      }

      //清除
      else if(btnPress=="clear")//按下c時
      {
         str="";
         operandl=0;
         op="";
         lab.setText("0");
      }

      //數字
      else//按下0~9
      {
         double  num=Double.parseDouble(btnPress);
         if(num!=0 || str.length()!=0)//避免輸入的第一個字串為0
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
}
